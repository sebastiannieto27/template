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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "RolePermission.findByRolePermissionId", query = "SELECT r FROM RolePermission r WHERE r.rolePermissionId = :rolePermissionId")})
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_permission_id")
    private Integer rolePermissionId;
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    @ManyToOne(optional = false)
    private Permission permissionId;
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

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
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
