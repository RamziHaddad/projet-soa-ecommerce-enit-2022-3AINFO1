package enit.group.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.annotations.Param;

import enit.group.service.ProduitService;
import enit.group.domain.Order;
import enit.group.domain.Produit;
import enit.group.domain.Quantity;
import enit.group.exceptions.EntityAlreadyExistsException;
import enit.group.exceptions.EntityNotFoundException;


@Path("/api/Produits")
public class ProduitResource {

    @Inject
    ProduitService ProduitService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    public List<Produit> findall() {
        return  ProduitService.findAll();
    }

    @GET
    @Path("/{id}")
    public Produit findById(@PathParam("id") UUID id) throws EntityNotFoundException {
        return  ProduitService.findById(id);
    }

    @POST
    public Produit create(Produit p) throws EntityAlreadyExistsException {
        return  ProduitService.create(p);
    }
    @Path("/addQuantity/{quantity}")
    @PUT
    public void addQuantity(@Param  Quantity q) throws EntityNotFoundException{
          ProduitService.addQuantity(q);
    }
    @Path("/removeQuantity/{quantity}")
    @PUT
    public void removeQuantity(@Param  Quantity q) throws EntityNotFoundException{
          ProduitService.removeQuantity(q);
    }
    @Path("/reserveProducts/{order}")
    @PUT
    public void reserveProducts(@Param Order o) throws EntityNotFoundException{
          ProduitService.reserveProducts(o);
    }
    @Path("/prepareOrders/{listeOrder}")
    @PUT
    public void prepareOrders(@Param ArrayList<Order> orders) throws EntityNotFoundException{
          ProduitService.prepareAllOrders(orders);
    }
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") UUID id){
        ProduitService.remove(id);
    }

}