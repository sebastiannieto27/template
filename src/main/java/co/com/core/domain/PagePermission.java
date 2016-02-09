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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "page_permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagePermission.findAll", query = "SELECT p FROM PagePermission p"),
    @NamedQuery(name = "PagePermission.findByIdPagePermission", query = "SELECT p FROM PagePermission p WHERE p.idPagePermission = :idPagePermission")})
public class PagePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_page_permission")
    private Integer idPagePermission;
    @JoinColumn(name = "page_id", referencedColumnName = "page_id")
    @ManyToOne(optional = false)
    private Page pageId;
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    @ManyToOne(optional = false)
    private Permission permissionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagePermissionId")
    private Collection<RolePermission> rolePermissionCollection;

    public PagePermission() {
    }

    public PagePermission(Integer idPagePermission) {
        this.idPagePermission = idPagePermission;
    }

    public Integer getIdPagePermission() {
        return idPagePermission;
    }

    public void setIdPagePermission(Integer idPagePermission) {
        this.idPagePermission = idPagePermission;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
    }

    @XmlTransient
    public Collection<RolePermission> getRolePermissionCollection() {
        return rolePermissionCollection;
    }

    public void setRolePermissionCollection(Collection<RolePermission> rolePermissionCollection) {
        this.rolePermissionCollection = rolePermissionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagePermission != null ? idPagePermission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagePermission)) {
            return false;
        }
        PagePermission other = (PagePermission) object;
        if ((this.idPagePermission == null && other.idPagePermission != null) || (this.idPagePermission != null && !this.idPagePermission.equals(other.idPagePermission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.PagePermission[ idPagePermission=" + idPagePermission + " ]";
    }
    
}
