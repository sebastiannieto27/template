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
@Table(name = "role_menu")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "RoleMenu.findAll", query = "SELECT r FROM RoleMenu r"),
    @NamedQuery(name = "RoleMenu.findByRoleId", query = "SELECT r FROM RoleMenu r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "RoleMenu.findByRoleMenuId", query = "SELECT r FROM RoleMenu r WHERE r.roleMenuId = :roleMenuId")})
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_menu_id")
    private Integer roleMenuId;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne(optional = false)
    private Menu menuId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;

    public RoleMenu() {
    }

    public RoleMenu(Integer roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Integer getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(Integer roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
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
        hash += (roleMenuId != null ? roleMenuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleMenu)) {
            return false;
        }
        RoleMenu other = (RoleMenu) object;
        if ((this.roleMenuId == null && other.roleMenuId != null) || (this.roleMenuId != null && !this.roleMenuId.equals(other.roleMenuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.RoleMenu[ rolePageId=" + roleMenuId + " ]";
    }
    
}
