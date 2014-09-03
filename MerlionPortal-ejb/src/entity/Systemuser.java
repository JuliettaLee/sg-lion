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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "systemuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Systemuser.findAll", query = "SELECT s FROM Systemuser s"),
    @NamedQuery(name = "Systemuser.findBySystemUserId", query = "SELECT s FROM Systemuser s WHERE s.systemUserId = :systemUserId"),
    @NamedQuery(name = "Systemuser.findByEmailAddress", query = "SELECT s FROM Systemuser s WHERE s.emailAddress = :emailAddress"),
    @NamedQuery(name = "Systemuser.findByPostalAddress", query = "SELECT s FROM Systemuser s WHERE s.postalAddress = :postalAddress"),
    @NamedQuery(name = "Systemuser.findByContactNumber", query = "SELECT s FROM Systemuser s WHERE s.contactNumber = :contactNumber"),
    @NamedQuery(name = "Systemuser.findBySalution", query = "SELECT s FROM Systemuser s WHERE s.salution = :salution"),
    @NamedQuery(name = "Systemuser.findByPassword", query = "SELECT s FROM Systemuser s WHERE s.password = :password"),
    @NamedQuery(name = "Systemuser.findByLocked", query = "SELECT s FROM Systemuser s WHERE s.locked = :locked"),
    @NamedQuery(name = "Systemuser.findByResetPasswordUponLogin", query = "SELECT s FROM Systemuser s WHERE s.resetPasswordUponLogin = :resetPasswordUponLogin"),
    @NamedQuery(name = "Systemuser.findByCreatedDate", query = "SELECT s FROM Systemuser s WHERE s.createdDate = :createdDate"),
    @NamedQuery(name = "Systemuser.findByUserType", query = "SELECT s FROM Systemuser s WHERE s.userType = :userType"),
    @NamedQuery(name = "Systemuser.findByActivated", query = "SELECT s FROM Systemuser s WHERE s.activated = :activated")})
public class Systemuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "systemUserId")
    private Integer systemUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emailAddress")
    private String emailAddress;
    @Size(max = 45)
    @Column(name = "postalAddress")
    private String postalAddress;
    @Size(max = 45)
    @Column(name = "contactNumber")
    private String contactNumber;
    @Size(max = 45)
    @Column(name = "salution")
    private String salution;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Column(name = "locked")
    private Boolean locked;
    @Column(name = "resetPasswordUponLogin")
    private Boolean resetPasswordUponLogin;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userType")
    private String userType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activated")
    private boolean activated;
    @JoinColumn(name = "Company_companyId", referencedColumnName = "companyId")
    @ManyToOne(optional = false)
    private Company companycompanyId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "systemuser")
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUsersystemUserId")
    private Collection<Systemlog> systemlogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUsersystemUserId")
    private Collection<Message> messageCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "systemuser")
    private Staff staff;

    public Systemuser() {
    }

    public Systemuser(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Systemuser(Integer systemUserId, String emailAddress, String userType, boolean activated) {
        this.systemUserId = systemUserId;
        this.emailAddress = emailAddress;
        this.userType = userType;
        this.activated = activated;
    }

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSalution() {
        return salution;
    }

    public void setSalution(String salution) {
        this.salution = salution;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getResetPasswordUponLogin() {
        return resetPasswordUponLogin;
    }

    public void setResetPasswordUponLogin(Boolean resetPasswordUponLogin) {
        this.resetPasswordUponLogin = resetPasswordUponLogin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Company getCompanycompanyId() {
        return companycompanyId;
    }

    public void setCompanycompanyId(Company companycompanyId) {
        this.companycompanyId = companycompanyId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @XmlTransient
    public Collection<Systemlog> getSystemlogCollection() {
        return systemlogCollection;
    }

    public void setSystemlogCollection(Collection<Systemlog> systemlogCollection) {
        this.systemlogCollection = systemlogCollection;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemUserId != null ? systemUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Systemuser)) {
            return false;
        }
        Systemuser other = (Systemuser) object;
        if ((this.systemUserId == null && other.systemUserId != null) || (this.systemUserId != null && !this.systemUserId.equals(other.systemUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Systemuser[ systemUserId=" + systemUserId + " ]";
    }
    
}
