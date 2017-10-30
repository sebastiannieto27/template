package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.ArchivoPruebaProcesadoUtil;
import co.com.core.commons.converter.psaber.RespuestaExamenUtil;
import co.com.core.commons.converter.psaber.ResultadoExamenUsuarioUtil;
import co.com.core.dao.psaber.ResultadoExamenUsuarioDAO;
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
		List<ResultadoExamenUsuarioDTO> ResultadoExamenUsuarios = new ArrayList<ResultadoExamenUsuarioDTO>();
		List<ResultadoExamenUsuario> entityList = resultadoExamenUsuarioDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(ResultadoExamenUsuario ResultadoExamenUsuario : entityList) {
				ResultadoExamenUsuarios.add(ResultadoExamenUsuarioUtil.getDtoFromEntity(ResultadoExamenUsuario));
			}
		}
		return ResultadoExamenUsuarios;
	}
	

	@Override
	public List<ResultadoExamenUsuarioDTO> getByUserNRespuestaExamenResultado(RespuestaExamenDTO dto) {
		List<ResultadoExamenUsuarioDTO> dtoList = new ArrayList<>();
		List<ResultadoExamenUsuario> entityList = resultadoExamenUsuarioDAO.getByUserNRespuestaExamenResultado(RespuestaExamenUtil.getEntityFromDto(dto));
		if(entityList!=null && entityList.size() > 0) {
			for(ResultadoExamenUsuario entity : entityList) {
				dtoList.add(ResultadoExamenUsuarioUtil.getDtoFromEntity(entity));
			}
		}
		return dtoList;
	}
	
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
