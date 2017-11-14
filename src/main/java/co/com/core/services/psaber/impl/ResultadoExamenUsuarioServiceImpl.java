package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.RespuestaExamenUtil;
import co.com.core.commons.converter.psaber.ResultadoExamenUsuarioUtil;
import co.com.core.dao.psaber.ResultadoExamenUsuarioDAO;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.domain.psaber.ResultadoExamenUsuario;
import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.dto.psaber.ResultadoExamenUsuarioDTO;
import co.com.core.services.psaber.IResultadoExamenUsuarioService;

public class ResultadoExamenUsuarioServiceImpl implements IResultadoExamenUsuarioService {

	private static final Logger logger = Logger.getLogger(ResultadoExamenUsuarioServiceImpl.class);
	ResultadoExamenUsuarioDAO resultadoExamenUsuarioDAO;
	
	@Override
	public List<ResultadoExamenUsuarioDTO> getAll() {
		List<ResultadoExamenUsuarioDTO> ResultadoExamenUsuarios = new ArrayList<ResultadoExamenUsuarioDTO>();
		List<ResultadoExamenUsuario> entityList = resultadoExamenUsuarioDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(ResultadoExamenUsuario ResultadoExamenUsuario : entityList) {
				ResultadoExamenUsuarios.add(ResultadoExamenUsuarioUtil.getDtoFromEntity(ResultadoExamenUsuario));
			}
		}
		return ResultadoExamenUsuarios;
	}

	@Override
	public List<ResultadoExamenUsuarioDTO> getAllFilter(Map<String, Object> filter) {
		List<ResultadoExamenUsuarioDTO> dtoList = new ArrayList<ResultadoExamenUsuarioDTO>();
		List<ResultadoExamenUsuario> entityList = resultadoExamenUsuarioDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(ResultadoExamenUsuario ResultadoExamenUsuario : entityList) {
				dtoList.add(ResultadoExamenUsuarioUtil.getDtoFromEntity(ResultadoExamenUsuario));
			}
		}
		return dtoList;
	}
	
	@Override
	public List<ResultadoExamenUsuarioDTO> getByRespuestaExamen(RespuestaExamenDTO dto) {
		List<ResultadoExamenUsuarioDTO> dtoList = new ArrayList<>();
		List<ResultadoExamenUsuario> entityList = resultadoExamenUsuarioDAO.getByRespuestaExamen(RespuestaExamenUtil.getEntityFromDto(dto));
		if(entityList!=null && entityList.size() > 0) {
			for(ResultadoExamenUsuario entity : entityList) {
				dtoList.add(ResultadoExamenUsuarioUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
	@Override
	public void updatePromedioArea(double promedio, List<ResultadoExamenUsuario> entityList) {
		if(entityList != null && entityList.size() > 0) {
			List<Integer> idList = getResultadoExamenUsuarioIds(entityList);
			resultadoExamenUsuarioDAO.updatePromedioArea(promedio, idList);
		}
	}
	
	@Override
	public List<ResultadoExamenUsuarioDTO> getByAreaRespuestaExamenList(List<RespuestaExamenDTO> paramDtoList, Area area) {
		
		List<ResultadoExamenUsuarioDTO> dtoList = new ArrayList<>();
		
		List<RespuestaExamen> paramList = new ArrayList<>();
		if(paramDtoList!=null && paramDtoList.size() > 0) {
			for(RespuestaExamenDTO item : paramDtoList) {
				paramList.add(RespuestaExamenUtil.getEntityFromDto(item));
			}
			
			List<ResultadoExamenUsuario> entityList = resultadoExamenUsuarioDAO.getByAreaRespuestaExamenList(paramList, area);
			if(entityList!=null && entityList.size() > 0) {
				for(ResultadoExamenUsuario entity : entityList) {
					dtoList.add(ResultadoExamenUsuarioUtil.getDtoFromEntity(entity));
				}
			}
		}
	
		return dtoList;
	}
	
	
	private List<Integer> getResultadoExamenUsuarioIds(List<ResultadoExamenUsuario> entityList) {
		
		List<Integer> idList = new ArrayList<>();
		if(entityList!=null && entityList.size() > 0) {
			for(ResultadoExamenUsuario entity:  entityList) {
				idList.add(entity.getResultadoExamenUsuarioId());
			}
		}
		return idList;
	}
	
	/*private String getResultadoExamenUsuarioIds(List<ResultadoExamenUsuario> entityList) {
		int counter = 0;
		StringBuilder ids = new StringBuilder();
		if(entityList!=null && entityList.size() > 0) {
			for(ResultadoExamenUsuario entity:  entityList) {
				if(counter > 0) {
					ids.append(",");
				}
				ids.append(entity.getResultadoExamenUsuarioId());
				counter++;
			}
		}
		return ids.toString();
	}*/
	
	@Override
	public ResultadoExamenUsuario create(ResultadoExamenUsuarioDTO dto) {
		return resultadoExamenUsuarioDAO.create(ResultadoExamenUsuarioUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(ResultadoExamenUsuarioDTO dto) {
		resultadoExamenUsuarioDAO.delete(ResultadoExamenUsuarioUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(ResultadoExamenUsuarioDTO dto) {
		resultadoExamenUsuarioDAO.update(ResultadoExamenUsuarioUtil.getEntityFromDto(dto));
	}

	public ResultadoExamenUsuarioDAO getResultadoExamenUsuarioDAO() {
		return resultadoExamenUsuarioDAO;
	}

	public void setResultadoExamenUsuarioDAO(ResultadoExamenUsuarioDAO ResultadoExamenUsuarioDAO) {
		this.resultadoExamenUsuarioDAO = ResultadoExamenUsuarioDAO;
	}
}
