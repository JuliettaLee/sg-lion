/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manliqi
 */
@Entity
@Table(name = "Staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByFirstName", query = "SELECT s FROM Staff s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Staff.findByLastName", query = "SELECT s FROM Staff s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Staff.findBySystemUsersystemUserId", query = "SELECT s FROM Staff s WHERE s.systemUsersystemUserId = :systemUsersystemUserId")})
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SystemUser_systemUserId")
    private Integer systemUsersystemUserId;
    @JoinColumn(name = "SystemUser_systemUserId", referencedColumnName = "systemUserId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SystemUser systemUser;
    @JoinColumn(name = "Group_groupId", referencedColumnName = "groupId")
    @ManyToOne(optional = false)
    private Group1 groupgroupId;

    public Staff() {
    }

    public Staff(Integer systemUsersystemUserId) {
        this.systemUsersystemUserId = systemUsersystemUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSystemUsersystemUserId() {
        return systemUsersystemUserId;
    }

    public void setSystemUsersystemUserId(Integer systemUsersystemUserId) {
        this.systemUsersystemUserId = systemUsersystemUserId;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public Group1 getGroupgroupId() {
        return groupgroupId;
    }

    public void setGroupgroupId(Group1 groupgroupId) {
        this.groupgroupId = groupgroupId;
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
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.systemUsersystemUserId == null && other.systemUsersystemUserId != null) || (this.systemUsersystemUserId != null && !this.systemUsersystemUserId.equals(other.systemUsersystemUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Staff[ systemUsersystemUserId=" + systemUsersystemUserId + " ]";
    }
    
}