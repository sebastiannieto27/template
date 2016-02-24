/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "message_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageStatus.findAll", query = "SELECT m FROM MessageStatus m"),
    @NamedQuery(name = "MessageStatus.findByMessageStatusId", query = "SELECT m FROM MessageStatus m WHERE m.messageStatusId = :messageStatusId"),
    @NamedQuery(name = "MessageStatus.findByName", query = "SELECT m FROM MessageStatus m WHERE m.name = :name")})
public class MessageStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "message_status_id")
    private Integer messageStatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageStatusId")
    private Collection<Message> messageCollection;

    public MessageStatus() {
    }

    public MessageStatus(Integer messageStatusId) {
        this.messageStatusId = messageStatusId;
    }

    public MessageStatus(Integer messageStatusId, String name) {
        this.messageStatusId = messageStatusId;
        this.name = name;
    }

    public Integer getMessageStatusId() {
        return messageStatusId;
    }

    public void setMessageStatusId(Integer messageStatusId) {
        this.messageStatusId = messageStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageStatusId != null ? messageStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageStatus)) {
            return false;
        }
        MessageStatus other = (MessageStatus) object;
        if ((this.messageStatusId == null && other.messageStatusId != null) || (this.messageStatusId != null && !this.messageStatusId.equals(other.messageStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.MessageStatus[ messageStatusId=" + messageStatusId + " ]";
    }
    
}
