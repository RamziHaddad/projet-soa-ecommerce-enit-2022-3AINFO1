package enit.group.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import enit.group.domain.*;
import enit.group.exceptions.*;

@ApplicationScoped
public class ProduitRepository {
    

    @Inject
    EntityManager em;
    public List<Produit> findAll(){
        return em.createQuery("from Produit",Produit.class).getResultList();
    }
    public Produit findById(UUID id) throws EntityNotFoundException{
        Produit p = em.find(Produit.class, id);
        if(p!=null){
            return p;
        }
        throw new EntityNotFoundException("cannot find Produit");
    }
    @Transactional
    public Produit insert(Produit p) throws EntityAlreadyExistsException{
        if(p.getId() == null){
            p.setId(UUID.randomUUID());
            try{
                em.persist(p);
                return p;
            }catch(EntityExistsException e){
                throw new EntityAlreadyExistsException("Produit already exists");
            }
        }
        throw new EntityAlreadyExistsException("Produit has already an id");
    }
    @Transactional
    public void addQuantity(Quantity q) {
        
         Produit p = em.find(Produit.class, q.getId());
         
         if(p!=null){
            p.setresevedQuantity(q.getQt());
            p.setinitialQuantity(p.getinitialQuantity()-q.getQt());
         }
            
      
    }
   
    @Transactional
    public Produit update(Produit p) throws EntityNotFoundException{
        try{
            return em.merge(p);
        }catch(IllegalArgumentException e){

        }
        throw new EntityNotFoundException("cannot find Produit");
    }
    @Transactional
    public void removeQuantity(Quantity q) throws EntityNotFoundException{
        
         Produit p = em.find(Produit.class, q.getId());
         
         if(p!=null){
            p.setresevedQuantity(p.getresevedQuantity()-q.getQt());
            p.setinitialQuantity(p.getinitialQuantity()+q.getQt());
            try{
                 em.merge(p);
            }catch(IllegalArgumentException e){
    
            }
            throw new EntityNotFoundException("cannot find Produit");
         }
        }
    @Transactional
    public void prepareProduct(Quantity q) throws EntityNotFoundException{
        Produit p = em.find(Produit.class, q.getId());
         
        if(p!=null){
           p.setresevedQuantity(p.getresevedQuantity()-q.getQt());
           p.setinitialQuantity(p.getinitialQuantity()-q.getQt());
           try{
                em.merge(p);
           }catch(IllegalArgumentException e){
   
           }
           throw new EntityNotFoundException("cannot find Produit");
        }
    }

    @Transactional
     // cammande['idC',{[idP1,qt1],[idP2,qt2],.....},'etat']
    public void reserveProducts(Order o)throws EntityNotFoundException{
        String etat="";
       
        ArrayList<Quantity> ar =new ArrayList<Quantity>();
        if(etat=="en attente de paiement"){
          for (Quantity q : ar) {
            addQuantity(q);
          }
            
        }
        else if(etat=="annulé"){
            for (Quantity q : ar) {
                removeQuantity(q);
              }
        }
        else if(etat=="payé"){
            for (Quantity q : ar) {
                prepareProduct(q);
              }
        }
    } 
    @Transactional
    public void prepareAllOrders(ArrayList<Order> orders) throws EntityNotFoundException{
        for(Order o : orders){
            reserveProducts(o);
        }

    }
    @Transactional
    public void delete(UUID id){
        Produit p = em.find(Produit.class, id);
        if(p!=null){
            em.remove(p);
        }
    }

}
