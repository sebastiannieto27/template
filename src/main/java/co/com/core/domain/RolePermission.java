/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.core.domain;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "role_permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolePermission.findAll", query = "SELECT r FROM RolePermission r"),
    @NamedQuery(name = "RolePermission.findByRoleId", query = "SELECT r FROM RolePermission r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "RolePermission.findByRolePagePermissionId", query = "SELECT r FROM RolePermission r WHERE r.roleId = :roleId and r.pagePermissionId = :pagePermissionId"),
    @NamedQuery(name = "RolePermission.findByPagePermissionId", query = "SELECT r FROM RolePermission r WHERE r.rolePermissionId = :rolePermissionId")})
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_permission_id")
    private Integer rolePermissionId;
    @JoinColumn(name = "page_permission_id", referencedColumnName = "id_page_permission")
    @ManyToOne(optional = false)
    private PagePermission pagePermissionId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;

    public RolePermission() {
    }

    public RolePermission(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public PagePermission getPagePermissionId() {
        return pagePermissionId;
    }

    public void setPagePermissionId(PagePermission pagePermissionId) {
        this.pagePermissionId = pagePermissionId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolePermissionId != null ? rolePermissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePermission)) {
            return false;
        }
        RolePermission other = (RolePermission) object;
        if ((this.rolePermissionId == null && other.rolePermissionId != null) || (this.rolePermissionId != null && !this.rolePermissionId.equals(other.rolePermissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.RolePermission[ rolePermissionId=" + rolePermissionId + " ]";
    }
    
}


