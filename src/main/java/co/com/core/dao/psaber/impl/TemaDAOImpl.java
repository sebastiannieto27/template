package co.com.core.dao.psaber.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.TemaDAO;
import co.com.core.domain.psaber.Pregunta;
import co.com.core.domain.psaber.PreguntaTema;
import co.com.core.domain.psaber.Tema;

public class TemaDAOImpl implements TemaDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(TemaDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<Tema> getAll() {
			List<Tema> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Tema.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TemaDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Tema> getAllFilter(Map<String, Object> filters) {
			List<Tema> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM Tema b ");

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
				logger.error("Throwed Exception [TemaDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public Tema create(Tema entity) {
			Tema newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (Tema) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TemaDAOImpl.createTema]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(Tema entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TemaDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Tema entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TemaDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public List<PreguntaTema> findTemaByPregunta(Pregunta entity) {
			List<PreguntaTema> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("PreguntaTema.findByPreguntaId");
		        query.setParameter("preguntaId", entity);
		        entityList = query.list();
		        
			} catch(Exception ex) {
				logger.error("Throwed Exception [TemaDAOImpl.findTemaByPregunta]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public List<Tema> getNotAssignedTema(String ids) {
			List<Tema> entityList = null;
			
			if(ids== null || ids.isEmpty()) {
				ids = "0";
			}
			
			try {
				session = this.sessionFactory.openSession();
				StringBuilder hql = new StringBuilder();
				hql.append("SELECT m FROM Tema m WHERE m.temaId NOT IN(").append(ids).append(")");
				Query query = session.createQuery(hql.toString());
				entityList = query.list();
				
			} catch(Exception ex) {
				logger.error("Throwed Exception [TemaDAOImpl.getNotAssignedTema]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public PreguntaTema createPreguntaTema(PreguntaTema entity) {
			PreguntaTema newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (PreguntaTema) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TemaDAOImpl.createPreguntaTema]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}
		
		@Override
		public void deletePreguntaTema(PreguntaTema entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [TemaDAOImpl.deletePreguntaTema]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
}
