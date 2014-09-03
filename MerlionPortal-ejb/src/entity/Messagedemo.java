/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "messagedemo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messagedemo.findAll", query = "SELECT m FROM Messagedemo m"),
    @NamedQuery(name = "Messagedemo.findById", query = "SELECT m FROM Messagedemo m WHERE m.id = :id"),
    @NamedQuery(name = "Messagedemo.findByTitle", query = "SELECT m FROM Messagedemo m WHERE m.title = :title"),
    @NamedQuery(name = "Messagedemo.findByReceipent", query = "SELECT m FROM Messagedemo m WHERE m.receipent = :receipent"),
    @NamedQuery(name = "Messagedemo.findByContent", query = "SELECT m FROM Messagedemo m WHERE m.content = :content")})
public class Messagedemo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "receipent")
    private String receipent;
    @Size(max = 200)
    @Column(name = "content")
    private String content;

    public Messagedemo() {
    }

    public Messagedemo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReceipent() {
        return receipent;
    }

    public void setReceipent(String receipent) {
        this.receipent = receipent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messagedemo)) {
            return false;
        }
        Messagedemo other = (Messagedemo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Messagedemo[ id=" + id + " ]";
    }
    
}
