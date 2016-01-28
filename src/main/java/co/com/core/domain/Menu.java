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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dienieto
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuId", query = "SELECT m FROM Menu m WHERE m.menuId = :menuId"),
    @NamedQuery(name = "Menu.findByMenuName", query = "SELECT m FROM Menu m WHERE m.menuName = :menuName"),
    @NamedQuery(name = "Menu.findBySubmenu", query = "SELECT m FROM Menu m WHERE m.submenu = :submenu")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id")
    private Integer menuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "submenu")
    private Boolean submenu;
    @Column(name = "general")
    private Boolean general;
    @OneToMany(mappedBy = "parentMenuId")
    private Collection<Menu> menuCollection;
    @JoinColumn(name = "parent_menu_id", referencedColumnName = "menu_id")
    @ManyToOne
    private Menu parentMenuId;
    @JoinColumn(name = "page_id", referencedColumnName = "page_id")
    @ManyToOne
    private Page pageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuId")
    private Collection<RoleMenu> roleMenuCollection;

    public Menu() {
    }

    public Menu(Integer menuId) {
        this.menuId = menuId;
    }

    public Menu(Integer menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Boolean getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Boolean submenu) {
        this.submenu = submenu;
    }

    public Boolean getGeneral() {
		return general;
	}

	public void setGeneral(Boolean general) {
		this.general = general;
	}

	@XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    public Menu getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Menu parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
    }

    @XmlTransient
    public Collection<RoleMenu> getRoleMenuCollection() {
        return roleMenuCollection;
    }

    public void setRoleMenuCollection(Collection<RoleMenu> roleMenuCollection) {
        this.roleMenuCollection = roleMenuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.Menu[ menuId=" + menuId + " ]";
    }
    
}

