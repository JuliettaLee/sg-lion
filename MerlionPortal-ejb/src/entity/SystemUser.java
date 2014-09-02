/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
 * @author manliqi
 */
@Entity
@Table(name = "SystemUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemUser.findAll", query = "SELECT s FROM SystemUser s"),
    @NamedQuery(name = "SystemUser.findBySystemUserId", query = "SELECT s FROM SystemUser s WHERE s.systemUserId = :systemUserId"),
    @NamedQuery(name = "SystemUser.findByEmailAddress", query = "SELECT s FROM SystemUser s WHERE s.emailAddress = :emailAddress"),
    @NamedQuery(name = "SystemUser.findByPostalAddress", query = "SELECT s FROM SystemUser s WHERE s.postalAddress = :postalAddress"),
    @NamedQuery(name = "SystemUser.findByContactNumber", query = "SELECT s FROM SystemUser s WHERE s.contactNumber = :contactNumber"),
    @NamedQuery(name = "SystemUser.findBySalution", query = "SELECT s FROM SystemUser s WHERE s.salution = :salution"),
    @NamedQuery(name = "SystemUser.findByPassword", query = "SELECT s FROM SystemUser s WHERE s.password = :password"),
    @NamedQuery(name = "SystemUser.findByLocked", query = "SELECT s FROM SystemUser s WHERE s.locked = :locked"),
    @NamedQuery(name = "SystemUser.findByFirstTimeLogin", query = "SELECT s FROM SystemUser s WHERE s.firstTimeLogin = :firstTimeLogin"),
    @NamedQuery(name = "SystemUser.findByCreatedDate", query = "SELECT s FROM SystemUser s WHERE s.createdDate = :createdDate"),
    @NamedQuery(name = "SystemUser.findByUserType", query = "SELECT s FROM SystemUser s WHERE s.userType = :userType")})
public class SystemUser implements Serializable {
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
    @Size(max = 45)
    @Column(name = "firstTimeLogin")
    private String firstTimeLogin;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userType")
    private String userType;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private Staff staff;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUsersystemUserId")
    private List<Message> messageList;
    @JoinColumn(name = "Company_companyId", referencedColumnName = "companyId")
    @ManyToOne(optional = false)
    private Company companycompanyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUsersystemUserId")
    private List<SystemLog> systemLogList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private Client client;

    public SystemUser() {
    }

    public SystemUser(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public SystemUser(Integer systemUserId, String emailAddress, String userType) {
        this.systemUserId = systemUserId;
        this.emailAddress = emailAddress;
        this.userType = userType;
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

    public String getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(String firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Company getCompanycompanyId() {
        return companycompanyId;
    }

    public void setCompanycompanyId(Company companycompanyId) {
        this.companycompanyId = companycompanyId;
    }

    @XmlTransient
    public List<SystemLog> getSystemLogList() {
        return systemLogList;
    }

    public void setSystemLogList(List<SystemLog> systemLogList) {
        this.systemLogList = systemLogList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof SystemUser)) {
            return false;
        }
        SystemUser other = (SystemUser) object;
        if ((this.systemUserId == null && other.systemUserId != null) || (this.systemUserId != null && !this.systemUserId.equals(other.systemUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SystemUser[ systemUserId=" + systemUserId + " ]";
    }
    
}
