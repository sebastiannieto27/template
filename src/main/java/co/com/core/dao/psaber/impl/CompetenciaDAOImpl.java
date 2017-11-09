package co.com.core.dao.psaber.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.com.core.dao.psaber.CompetenciaDAO;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.Competencia;
import co.com.core.domain.psaber.Contenido;

public class CompetenciaDAOImpl implements CompetenciaDAO {

	 	private SessionFactory sessionFactory;
	    private Session session;
	    private static final Logger logger = Logger.getLogger(CompetenciaDAOImpl.class);
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
		
		@Override
		public List<Competencia> getAll() {
			List<Competencia> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        Query query = session.getNamedQuery("Competencia.findAll");
		        entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CompetenciaDAOImpl.getAll]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}

		@Override
		public List<Competencia> getAllFilter(Map<String, Object> filters) {
			List<Competencia> entityList = null;
			try {
				session = this.sessionFactory.openSession();
		        StringBuilder hql = new StringBuilder();
		        hql.append("SELECT b FROM Competencia b ");

		        String name = null;
		        Contenido contenidoId = null;
		        boolean where = false;
				if(filters.size() > 0) {
					 
					name = (String) filters.get("nombre");
					contenidoId = (Contenido) filters.get("contenidoId");
					
					if(name!=null && !name.isEmpty()) {
						where = true;
						hql.append("WHERE ");
						hql.append(" lower(b.nombre) LIKE :nombre ");
					}
					
					if(contenidoId!=null) {
						if(!where) {
							where = true;
							hql.append("WHERE ");
						}
						
						if(contenidoId!=null) {
							hql.append(" AND ");
						}
						
						
						hql.append(" b.competenciaId = :competenciaId ");
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
				logger.error("Throwed Exception [CompetenciaDAOImpl.getAllFilter]: " +ex.getMessage());
			} finally {
				session.close();
			}
			return entityList;
		}
		
		@Override
		public Competencia create(Competencia entity) {
			Competencia newEntity = null;
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				newEntity = (Competencia) session.merge(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CompetenciaDAOImpl.createCompetencia]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
			return newEntity;
		}

		@Override
		public void update(Competencia entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		        session.update(entity);
		        tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CompetenciaDAOImpl.update]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}
		
		@Override
		public void delete(Competencia entity) {
			try {
				session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(entity);
				tx.commit();
			} catch(Exception ex) {
				logger.error("Throwed Exception [CompetenciaDAOImpl.delete]: " +ex.getMessage());
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		}

		@Override
		public List<Competencia> getByArea(Area area) {
			List<Competencia> entityList = new ArrayList<Competencia>();
			try {
				session = this.sessionFactory.openSession();
				Query query = session.createQuery("SELECT c FROM Competencia c WHERE c.areaId = :areaId");
				query.setParameter("areaId", area);
				entityList = query.list();
			} catch(Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioDAOImpl.updatePromedioArea]: " +ex.getMessage());
			}
			return entityList;
		}
}
