package co.com.core.dao.psaber.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.ArchivoPruebaDAO;
import co.com.core.domain.User;
import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.AreaArchivoPrueba;
import co.com.core.domain.psaber.ResultadoExamenUsuario;

public class ArchivoPruebaDAOImpl implements ArchivoPruebaDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(ArchivoPruebaDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<ArchivoPrueba> getAll() {
			List<ArchivoPrueba> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("ArchivoPrueba.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<ArchivoPrueba> getAllFilter(Map<String, Object> filters) {
			List<ArchivoPrueba> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM ArchivoPrueba b ");

		        String name = null;
				if(filters.size() > 0) {
					 
					name = (String) filters.get("nombre");
					
					if(name!=null && !name.isEmpty()) {
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
				logger.error("Throwed Exception [ArchivoPruebaDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public ArchivoPrueba create(ArchivoPrueba entity) {
			ArchivoPrueba newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (ArchivoPrueba) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaDAOImpl.createArchivoPrueba]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(ArchivoPrueba entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(ArchivoPrueba entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public ArchivoPrueba getByArchivoPruebaId(Integer id) {
			ArchivoPrueba entity = null;
			try {
				session = this.sessionFactory.openSession();
				entity = (ArchivoPrueba) session.get(ArchivoPrueba.class, id);
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaDAOImpl.getAllByArchivoPruebaId]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entity;
		}

		@Override
		public List<AreaArchivoPrueba> getAreasByArchivoPrueba(ArchivoPrueba entity) {
			List<AreaArchivoPrueba> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("AreaArchivoPrueba.findByArchivoPruebaId");
		        query.setParameter("archivoPruebaId", entity);
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ArchivoPruebaDAOImpl.getAreasByArchivoPrueba]: " +ex.getMessage());
			} finally {
				session.close();
			}
			
			return entityList;
		}
}
