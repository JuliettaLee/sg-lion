/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MelodyPond_2
 */
@Entity
@Table(name = "productsolineitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productsolineitem.findAll", query = "SELECT p FROM Productsolineitem p"),
    @NamedQuery(name = "Productsolineitem.findByProductproductId", query = "SELECT p FROM Productsolineitem p WHERE p.productsolineitemPK.productproductId = :productproductId"),
    @NamedQuery(name = "Productsolineitem.findByProductSOHeaderproductSOId", query = "SELECT p FROM Productsolineitem p WHERE p.productsolineitemPK.productSOHeaderproductSOId = :productSOHeaderproductSOId"),
    @NamedQuery(name = "Productsolineitem.findByStatus", query = "SELECT p FROM Productsolineitem p WHERE p.status = :status"),
    @NamedQuery(name = "Productsolineitem.findByQuantity", query = "SELECT p FROM Productsolineitem p WHERE p.quantity = :quantity")})
public class Productsolineitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductsolineitemPK productsolineitemPK;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "ProductSOHeader_productSOId", referencedColumnName = "productSOId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productsoheader productsoheader;
    @JoinColumn(name = "Product_productId", referencedColumnName = "productId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public Productsolineitem() {
    }

    public Productsolineitem(ProductsolineitemPK productsolineitemPK) {
        this.productsolineitemPK = productsolineitemPK;
    }

    public Productsolineitem(int productproductId, int productSOHeaderproductSOId) {
        this.productsolineitemPK = new ProductsolineitemPK(productproductId, productSOHeaderproductSOId);
    }

    public ProductsolineitemPK getProductsolineitemPK() {
        return productsolineitemPK;
    }

    public void setProductsolineitemPK(ProductsolineitemPK productsolineitemPK) {
        this.productsolineitemPK = productsolineitemPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Productsoheader getProductsoheader() {
        return productsoheader;
    }

    public void setProductsoheader(Productsoheader productsoheader) {
        this.productsoheader = productsoheader;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productsolineitemPK != null ? productsolineitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productsolineitem)) {
            return false;
        }
        Productsolineitem other = (Productsolineitem) object;
        if ((this.productsolineitemPK == null && other.productsolineitemPK != null) || (this.productsolineitemPK != null && !this.productsolineitemPK.equals(other.productsolineitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productsolineitem[ productsolineitemPK=" + productsolineitemPK + " ]";
    }
    
}
