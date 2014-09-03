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
@Table(name = "productpoheader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productpoheader.findAll", query = "SELECT p FROM Productpoheader p"),
    @NamedQuery(name = "Productpoheader.findByProductPOId", query = "SELECT p FROM Productpoheader p WHERE p.productPOId = :productPOId"),
    @NamedQuery(name = "Productpoheader.findByCreatedDate", query = "SELECT p FROM Productpoheader p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "Productpoheader.findBySalesPersonId", query = "SELECT p FROM Productpoheader p WHERE p.salesPersonId = :salesPersonId"),
    @NamedQuery(name = "Productpoheader.findByPrice", query = "SELECT p FROM Productpoheader p WHERE p.price = :price"),
    @NamedQuery(name = "Productpoheader.findByStatus", query = "SELECT p FROM Productpoheader p WHERE p.status = :status"),
    @NamedQuery(name = "Productpoheader.findByShipTo", query = "SELECT p FROM Productpoheader p WHERE p.shipTo = :shipTo"),
    @NamedQuery(name = "Productpoheader.findByBillTo", query = "SELECT p FROM Productpoheader p WHERE p.billTo = :billTo"),
    @NamedQuery(name = "Productpoheader.findByContactPersonPhoneNumber", query = "SELECT p FROM Productpoheader p WHERE p.contactPersonPhoneNumber = :contactPersonPhoneNumber"),
    @NamedQuery(name = "Productpoheader.findByContactPersonName", query = "SELECT p FROM Productpoheader p WHERE p.contactPersonName = :contactPersonName")})
public class Productpoheader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "productPOId")
    private Integer productPOId;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 45)
    @Column(name = "salesPersonId")
    private String salesPersonId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productPOHeaderproductPOId")
    private Collection<Productsoheader> productsoheaderCollection;
    @JoinColumn(name = "Client_SystemUser_systemUserId", referencedColumnName = "SystemUser_systemUserId")
    @ManyToOne(optional = false)
    private Client clientSystemUsersystemUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productpoheader")
    private Collection<Productpolineitem> productpolineitemCollection;

    public Productpoheader() {
    }

    public Productpoheader(Integer productPOId) {
        this.productPOId = productPOId;
    }

    public Integer getProductPOId() {
        return productPOId;
    }

    public void setProductPOId(Integer productPOId) {
        this.productPOId = productPOId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(String salesPersonId) {
        this.salesPersonId = salesPersonId;
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

    @XmlTransient
    public Collection<Productsoheader> getProductsoheaderCollection() {
        return productsoheaderCollection;
    }

    public void setProductsoheaderCollection(Collection<Productsoheader> productsoheaderCollection) {
        this.productsoheaderCollection = productsoheaderCollection;
    }

    public Client getClientSystemUsersystemUserId() {
        return clientSystemUsersystemUserId;
    }

    public void setClientSystemUsersystemUserId(Client clientSystemUsersystemUserId) {
        this.clientSystemUsersystemUserId = clientSystemUsersystemUserId;
    }

    @XmlTransient
    public Collection<Productpolineitem> getProductpolineitemCollection() {
        return productpolineitemCollection;
    }

    public void setProductpolineitemCollection(Collection<Productpolineitem> productpolineitemCollection) {
        this.productpolineitemCollection = productpolineitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productPOId != null ? productPOId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productpoheader)) {
            return false;
        }
        Productpoheader other = (Productpoheader) object;
        if ((this.productPOId == null && other.productPOId != null) || (this.productPOId != null && !this.productPOId.equals(other.productPOId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productpoheader[ productPOId=" + productPOId + " ]";
    }
    
}
