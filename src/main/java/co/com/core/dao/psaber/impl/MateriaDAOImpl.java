package co.com.core.dao.psaber.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.MateriaDAO;
import co.com.core.domain.psaber.Componente;
import co.com.core.domain.psaber.Materia;

public class MateriaDAOImpl implements MateriaDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(MateriaDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<Materia> getAll() {
			List<Materia> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Materia.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MateriaDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Materia> getAllFilter(Map<String, Object> filters) {
			List<Materia> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM Materia b ");

		        String name = null;
		        Componente componenteId = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					name = (String) filters.get("nombre");
					componenteId = (Componente) filters.get("componenteId");
					
					if(name!=null && !name.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(b.nombre) LIKE :nombre ");
					}
					
					if(componenteId!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(componenteId!=null) {
							hql.append(" AND ");
						}
						
						
						hql.append(" b.componenteId = :componenteId ");
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
				logger.error("Throwed Exception [MateriaDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public Materia create(Materia entity) {
			Materia newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (Materia) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MateriaDAOImpl.createMateria]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(Materia entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MateriaDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Materia entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [MateriaDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
