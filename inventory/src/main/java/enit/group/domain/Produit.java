package enit.group.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Produit")
public class Produit {
     
    @Id
    private UUID id;
    private String name;
    private String category;
    private Long initialQuantity;
    private Long reservedQuantity;

    
    public Produit() {
    }


    public Produit( UUID id , String name , String category , int quantity ,Long initialquantity,Long reservedquantity ,boolean disponibility) {
        this.id=id;
        this.name=name;
        this.category=category;
        this.initialQuantity=initialquantity;
        this.reservedQuantity=reservedquantity;
        

    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produit other = (Produit) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


  
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public Long getinitialQuantity() {
        return initialQuantity;
    }
    public void setinitialQuantity(Long initialQuantity) {
        this.initialQuantity = initialQuantity;
    }



    public Long getresevedQuantity() {
        return reservedQuantity;
    }
    public void setresevedQuantity(Long reservedQuantity) {
        this.reservedQuantity=reservedQuantity;
    }

    
    
}
