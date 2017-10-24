package co.com.core.dao.psaber.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.AreaDAO;
import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.AreaArchivoPrueba;

public class AreaDAOImpl implements AreaDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(AreaDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<Area> getAll() {
			List<Area> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Area.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Area> getAllFilter(Map<String, Object> filters) {
			List<Area> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM Area b ");

		        String name = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					name = (String) filters.get("nombre");
					
					if(name!=null && !name.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(b.nombre) LIKE :nombre ");
					}
				}
				
				Query query = session.createQuery(hql.toString());
				 
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty).toString();
                    query.setParameter(filterProperty, "%"+filterValue.toLowerCase()+"%");
				}   
                    
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public Area create(Area entity) {
			Area newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (Area) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.createArea]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(Area entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Area entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public List<AreaArchivoPrueba> findAreaByArchivoPrueba(ArchivoPrueba entity) {
			List<AreaArchivoPrueba> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("AreaArchivoPrueba.findByArchivoPruebaId");
		        query.setParameter("archivoPruebaId", entity);
		        entityList = query.list();
		        
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.findAreaByArchivoPrueba]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public List<Area> getNotAssignedArea(String ids) {
			List<Area> entityList = null;
			
			if(ids== null || ids.isEmpty()) {
				ids = "0";
			}
			
			try {
				session = this.sessionFactory.openSession();
				StringBuilder hql = new StringBuilder();
				hql.append("SELECT m FROM Area m WHERE m.areaId NOT IN(").append(ids).append(")");
				Query query = session.createQuery(hql.toString());
				entityList = query.list();
				
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.getNotAssignedArea]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public AreaArchivoPrueba createAreaArchivoPrueba(AreaArchivoPrueba entity) {
			AreaArchivoPrueba newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (AreaArchivoPrueba) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.createAreaArchivoPrueba]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}
		
		@Override
		public void deleteAreaArchivoPrueba(AreaArchivoPrueba entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [AreaDAOImpl.deleteAreaArchivoPrueba]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
