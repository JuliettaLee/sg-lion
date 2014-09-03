/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MelodyPond_2
 */
@Entity
@Table(name = "productsoheader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productsoheader.findAll", query = "SELECT p FROM Productsoheader p"),
    @NamedQuery(name = "Productsoheader.findByProductSOId", query = "SELECT p FROM Productsoheader p WHERE p.productSOId = :productSOId"),
    @NamedQuery(name = "Productsoheader.findByCreatedDate", query = "SELECT p FROM Productsoheader p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "Productsoheader.findByPrice", query = "SELECT p FROM Productsoheader p WHERE p.price = :price"),
    @NamedQuery(name = "Productsoheader.findByStatus", query = "SELECT p FROM Productsoheader p WHERE p.status = :status"),
    @NamedQuery(name = "Productsoheader.findByShipTo", query = "SELECT p FROM Productsoheader p WHERE p.shipTo = :shipTo"),
    @NamedQuery(name = "Productsoheader.findByBillTo", query = "SELECT p FROM Productsoheader p WHERE p.billTo = :billTo"),
    @NamedQuery(name = "Productsoheader.findByContactPersonPhoneNumber", query = "SELECT p FROM Productsoheader p WHERE p.contactPersonPhoneNumber = :contactPersonPhoneNumber"),
    @NamedQuery(name = "Productsoheader.findByContactPersonName", query = "SELECT p FROM Productsoheader p WHERE p.contactPersonName = :contactPersonName"),
    @NamedQuery(name = "Productsoheader.findByText", query = "SELECT p FROM Productsoheader p WHERE p.text = :text"),
    @NamedQuery(name = "Productsoheader.findByStaffId", query = "SELECT p FROM Productsoheader p WHERE p.staffId = :staffId")})
public class Productsoheader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "productSOId")
    private Integer productSOId;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "shipTo")
    private String shipTo;
    @Size(max = 45)
    @Column(name = "billTo")
    private String billTo;
    @Size(max = 45)
    @Column(name = "contactPersonPhoneNumber")
    private String contactPersonPhoneNumber;
    @Size(max = 45)
    @Column(name = "contactPersonName")
    private String contactPersonName;
    @Size(max = 45)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "staffId")
    private String staffId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productsoheader")
    private Collection<Productsolineitem> productsolineitemCollection;
    @JoinColumn(name = "ProductPOHeader_productPOId", referencedColumnName = "productPOId")
    @ManyToOne(optional = false)
    private Productpoheader productPOHeaderproductPOId;

    public Productsoheader() {
    }

    public Productsoheader(Integer productSOId) {
        this.productSOId = productSOId;
    }

    public Productsoheader(Integer productSOId, String staffId) {
        this.productSOId = productSOId;
        this.staffId = staffId;
    }

    public Integer getProductSOId() {
        return productSOId;
    }

    public void setProductSOId(Integer productSOId) {
        this.productSOId = productSOId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @XmlTransient
    public Collection<Productsolineitem> getProductsolineitemCollection() {
        return productsolineitemCollection;
    }

    public void setProductsolineitemCollection(Collection<Productsolineitem> productsolineitemCollection) {
        this.productsolineitemCollection = productsolineitemCollection;
    }

    public Productpoheader getProductPOHeaderproductPOId() {
        return productPOHeaderproductPOId;
    }

    public void setProductPOHeaderproductPOId(Productpoheader productPOHeaderproductPOId) {
        this.productPOHeaderproductPOId = productPOHeaderproductPOId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productSOId != null ? productSOId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productsoheader)) {
            return false;
        }
        Productsoheader other = (Productsoheader) object;
        if ((this.productSOId == null && other.productSOId != null) || (this.productSOId != null && !this.productSOId.equals(other.productSOId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productsoheader[ productSOId=" + productSOId + " ]";
    }
    
}
