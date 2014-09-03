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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MelodyPond_2
 */
@Entity
@Table(name = "productpolineitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productpolineitem.findAll", query = "SELECT p FROM Productpolineitem p"),
    @NamedQuery(name = "Productpolineitem.findByProductproductId", query = "SELECT p FROM Productpolineitem p WHERE p.productpolineitemPK.productproductId = :productproductId"),
    @NamedQuery(name = "Productpolineitem.findByProductPOHeaderproductPOId", query = "SELECT p FROM Productpolineitem p WHERE p.productpolineitemPK.productPOHeaderproductPOId = :productPOHeaderproductPOId"),
    @NamedQuery(name = "Productpolineitem.findByQuantity", query = "SELECT p FROM Productpolineitem p WHERE p.quantity = :quantity")})
public class Productpolineitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductpolineitemPK productpolineitemPK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "ProductPOHeader_productPOId", referencedColumnName = "productPOId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productpoheader productpoheader;
    @JoinColumn(name = "Product_productId", referencedColumnName = "productId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public Productpolineitem() {
    }

    public Productpolineitem(ProductpolineitemPK productpolineitemPK) {
        this.productpolineitemPK = productpolineitemPK;
    }

    public Productpolineitem(int productproductId, int productPOHeaderproductPOId) {
        this.productpolineitemPK = new ProductpolineitemPK(productproductId, productPOHeaderproductPOId);
    }

    public ProductpolineitemPK getProductpolineitemPK() {
        return productpolineitemPK;
    }

    public void setProductpolineitemPK(ProductpolineitemPK productpolineitemPK) {
        this.productpolineitemPK = productpolineitemPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Productpoheader getProductpoheader() {
        return productpoheader;
    }

    public void setProductpoheader(Productpoheader productpoheader) {
        this.productpoheader = productpoheader;
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
        hash += (productpolineitemPK != null ? productpolineitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productpolineitem)) {
            return false;
        }
        Productpolineitem other = (Productpolineitem) object;
        if ((this.productpolineitemPK == null && other.productpolineitemPK != null) || (this.productpolineitemPK != null && !this.productpolineitemPK.equals(other.productpolineitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productpolineitem[ productpolineitemPK=" + productpolineitemPK + " ]";
    }
    
}
