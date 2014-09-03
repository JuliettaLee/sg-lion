/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MelodyPond_2
 */
@Entity
@Table(name = "systemlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Systemlog.findAll", query = "SELECT s FROM Systemlog s"),
    @NamedQuery(name = "Systemlog.findByLogId", query = "SELECT s FROM Systemlog s WHERE s.logId = :logId"),
    @NamedQuery(name = "Systemlog.findByLogTime", query = "SELECT s FROM Systemlog s WHERE s.logTime = :logTime"),
    @NamedQuery(name = "Systemlog.findByAction", query = "SELECT s FROM Systemlog s WHERE s.action = :action")})
public class Systemlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "logId")
    private Integer logId;
    @Column(name = "logTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logTime;
    @Size(max = 255)
    @Column(name = "action")
    private String action;
    @JoinColumn(name = "SystemUser_systemUserId", referencedColumnName = "systemUserId")
    @ManyToOne(optional = false)
    private Systemuser systemUsersystemUserId;

    public Systemlog() {
    }

    public Systemlog(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Systemuser getSystemUsersystemUserId() {
        return systemUsersystemUserId;
    }

    public void setSystemUsersystemUserId(Systemuser systemUsersystemUserId) {
        this.systemUsersystemUserId = systemUsersystemUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Systemlog)) {
            return false;
        }
        Systemlog other = (Systemlog) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Systemlog[ logId=" + logId + " ]";
    }
    
}
