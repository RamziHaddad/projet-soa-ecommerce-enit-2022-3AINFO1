package enit.group.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import enit.group.domain.Order;
import enit.group.domain.Produit;
import enit.group.domain.Quantity;
import enit.group.exceptions.EntityAlreadyExistsException;
import enit.group.exceptions.EntityNotFoundException;
import enit.group.repository.ProduitRepository;

@ApplicationScoped
public class ProduitService {
    

    @Inject
    ProduitRepository ProduitsRepo;

    public List<Produit> findAll(){
        return ProduitsRepo.findAll();
    }
    public Produit findById(UUID id) throws EntityNotFoundException{
        return ProduitsRepo.findById(id);
    }

    public Produit create(Produit p) throws EntityAlreadyExistsException{
        return ProduitsRepo.insert(p);
    }
    public void addQuantity(Quantity q) throws EntityNotFoundException{
         ProduitsRepo.addQuantity(q);      
    }
    public void removeQuantity(Quantity q) throws EntityNotFoundException{
        ProduitsRepo.removeQuantity(q);      
   }
   public void prepareProduct(Quantity q) throws EntityNotFoundException{
    ProduitsRepo.prepareProduct(q);      
}
    public void reserveProducts(Order o)throws EntityNotFoundException{
        ProduitsRepo.reserveProducts(o);

    }
    public void remove(UUID id){
        ProduitsRepo.delete(id);
    }
    public void prepareAllOrders(ArrayList<Order> orders) throws EntityNotFoundException{
        ProduitsRepo.prepareAllOrders(orders);
        }


}
