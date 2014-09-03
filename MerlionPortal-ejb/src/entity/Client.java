/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MelodyPond_2
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByContactPersonFirstName", query = "SELECT c FROM Client c WHERE c.contactPersonFirstName = :contactPersonFirstName"),
    @NamedQuery(name = "Client.findByContactPersonLastName", query = "SELECT c FROM Client c WHERE c.contactPersonLastName = :contactPersonLastName"),
    @NamedQuery(name = "Client.findByCompanyName", query = "SELECT c FROM Client c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Client.findByCredit", query = "SELECT c FROM Client c WHERE c.credit = :credit"),
    @NamedQuery(name = "Client.findBySystemUsersystemUserId", query = "SELECT c FROM Client c WHERE c.systemUsersystemUserId = :systemUsersystemUserId")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "contactPersonFirstName")
    private String contactPersonFirstName;
    @Size(max = 45)
    @Column(name = "contactPersonLastName")
    private String contactPersonLastName;
    @Size(max = 45)
    @Column(name = "companyName")
    private String companyName;
    @Size(max = 45)
    @Column(name = "credit")
    private String credit;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SystemUser_systemUserId")
    private Integer systemUsersystemUserId;
    @JoinColumn(name = "SystemUser_systemUserId", referencedColumnName = "systemUserId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Systemuser systemuser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientSystemUsersystemUserId")
    private Collection<Productpoheader> productpoheaderCollection;

    public Client() {
    }

    public Client(Integer systemUsersystemUserId) {
        this.systemUsersystemUserId = systemUsersystemUserId;
    }

    public String getContactPersonFirstName() {
        return contactPersonFirstName;
    }

    public void setContactPersonFirstName(String contactPersonFirstName) {
        this.contactPersonFirstName = contactPersonFirstName;
    }

    public String getContactPersonLastName() {
        return contactPersonLastName;
    }

    public void setContactPersonLastName(String contactPersonLastName) {
        this.contactPersonLastName = contactPersonLastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Integer getSystemUsersystemUserId() {
        return systemUsersystemUserId;
    }

    public void setSystemUsersystemUserId(Integer systemUsersystemUserId) {
        this.systemUsersystemUserId = systemUsersystemUserId;
    }

    public Systemuser getSystemuser() {
        return systemuser;
    }

    public void setSystemuser(Systemuser systemuser) {
        this.systemuser = systemuser;
    }

    @XmlTransient
    public Collection<Productpoheader> getProductpoheaderCollection() {
        return productpoheaderCollection;
    }

    public void setProductpoheaderCollection(Collection<Productpoheader> productpoheaderCollection) {
        this.productpoheaderCollection = productpoheaderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemUsersystemUserId != null ? systemUsersystemUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.systemUsersystemUserId == null && other.systemUsersystemUserId != null) || (this.systemUsersystemUserId != null && !this.systemUsersystemUserId.equals(other.systemUsersystemUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Client[ systemUsersystemUserId=" + systemUsersystemUserId + " ]";
    }
    
}
