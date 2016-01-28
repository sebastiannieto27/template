package co.com.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.MenuDAO;
import co.com.core.domain.Menu;
import co.com.core.domain.RoleMenu;
import co.com.core.domain.User;
import co.com.core.domain.UserRole;

public class MenuDAOImpl implements MenuDAO {

    private SessionFactory sessionFactory;
    private Session session;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public List<UserRole> getUserRoles(User user) {
		List<UserRole> userRoles = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT u FROM UserRole u WHERE u.userId = ?");
			SQLQuery query = session.createSQLQuery("SELECT * from user_role ur where ur.user_id = :userId");
			query.addEntity(UserRole.class);
			query.setParameter("userId", user.getUserId());
			userRoles = query.list();
		} catch(Exception ex) {
			//TODO
		} finally {
			session.close();
		}
		return userRoles;
	}

	@Override
	public List<RoleMenu> getUserRoleMenu(List<UserRole> userRoles) {
		int counter = 0;
		StringBuilder rolIds = new StringBuilder();
		if(userRoles != null && userRoles.size() > 0) {
			for(UserRole userRol : userRoles) {
				if(counter > 0) {
					rolIds.append(",");
				}
				rolIds.append(userRol.getRoleId().getRoleId());
				counter++;
			}
		}
		List<RoleMenu> menuRoles = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT u FROM RoleMenu u WHERE u.roleId in(").append(rolIds).append(")");
			Query query = session.createQuery(hql.toString());
			menuRoles = query.list();
			
		} catch(Exception ex) {
			System.out.println("ERROR Getting rolesMenu: " + ex.getMessage());
			//TODO
		} finally {
			session.close();
		}
		return menuRoles;
	}
	
	@Override
	public List<Menu> getUserMenuOptions(List<RoleMenu> roleMenuList) {
		int counter = 0;
		StringBuilder menuIds = new StringBuilder();
		if(roleMenuList != null && roleMenuList.size() > 0) {
			for(RoleMenu roleMenu : roleMenuList) {
				if(counter > 0) {
					menuIds.append(",");
				}
				menuIds.append(roleMenu.getMenuId().getMenuId());
				counter++;
			}
		}
		List<Menu> menuList = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT m FROM Menu m WHERE m.menuId in(").append(menuIds).append(")");
			Query query = session.createQuery(hql.toString());
			menuList = query.list();
			
		} catch(Exception ex) {
			ex.printStackTrace();
			//TODO
		} finally {
			session.close();
		}
		return menuList;
	}

	@Override
	public List<Menu> getMenuGeneral() {
		List<Menu> menuList = null;
		try {
			session = this.sessionFactory.openSession();
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT m FROM Menu m WHERE m.general = 1");
			Query query = session.createQuery(hql.toString());
			menuList = query.list();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return menuList;
	}
	
	/**********************ADMIN*********************************/
	@Override
	public List<Menu> getAll() {
		List<Menu> menuList = null;
		try {
			session = this.sessionFactory.openSession();
			Query query = session.getNamedQuery("Menu.findAll");
			menuList = query.list();
		} catch(Exception ex) {
			//TODO
		} finally {
			session.close();
		}
		return menuList;
	}

	@Override
	public void createMenu(Menu menu) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(menu);
			tx.commit();
		} catch(Exception ex) {
			//TODO
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Menu menu) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete Menu m where m.menuId = :menuId");
			query.setParameter("menuId", menu.getMenuId());
			query.executeUpdate();
			tx.commit();
		} catch(Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Menu menu) {
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
	        session.merge(menu);
	        tx.commit();
		} catch(Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
}
