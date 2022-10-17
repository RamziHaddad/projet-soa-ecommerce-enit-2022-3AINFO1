package enit.group.classDto;
import java.util.UUID;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "Dto_Type")
public class ProduitDto {
     
    @Id
    private UUID id;
  
    private String name;
    private String category;
    private Long initialQuantity;
    private Long reservedQuantity;

    public ProduitDto(UUID id, String name, String category, Long initialQuantity, Long reservedQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.initialQuantity = initialQuantity;
        this.reservedQuantity = reservedQuantity;
    }
    public ProduitDto() {
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
        ProduitDto other = (ProduitDto) obj;
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
