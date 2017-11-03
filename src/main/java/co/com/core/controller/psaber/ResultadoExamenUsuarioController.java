package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.primefaces.model.LazyDataModel;

import com.google.gson.Gson;

import co.com.core.commons.EsquemaRespuesta;
import co.com.core.commons.ItemRespuesta;
import co.com.core.commons.RespuestaExamenProcesado;
import co.com.core.commons.converter.psaber.RespuestaExamenUtil;
import co.com.core.domain.User;
import co.com.core.domain.psaber.ArchivoPrueba;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.RespuestaExamen;
import co.com.core.domain.psaber.ResultadoExamenUsuario;
import co.com.core.dto.psaber.ArchivoPruebaProcesadoDTO;
import co.com.core.dto.psaber.CompetenciaDTO;
import co.com.core.dto.psaber.RespuestaDTO;
import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.dto.psaber.ResultadoExamenUsuarioDTO;
import co.com.core.services.psaber.IArchivoPruebaProcesadoService;
import co.com.core.services.psaber.ICompetenciaService;
import co.com.core.services.psaber.IPreguntaService;
import co.com.core.services.psaber.IRespuestaExamenService;
import co.com.core.services.psaber.IResultadoExamenUsuarioService;


public class ResultadoExamenUsuarioController {

	private static final Logger logger = Logger.getLogger(ResultadoExamenUsuarioController.class);
	
	private IResultadoExamenUsuarioService resultadoExamenUsuarioService;
	private IArchivoPruebaProcesadoService archivoPruebaProcesadoService;
	private IRespuestaExamenService respuestaExamenService;
	private IPreguntaService preguntaService;
	
	private List<ResultadoExamenUsuarioDTO> items;
	private ResultadoExamenUsuarioDTO selected;
	
	
	private String searchName;
	
	private LazyDataModel<ResultadoExamenUsuarioDTO> lazyModel;
	
	public void init() {
		//lazyModel = new ResultadoExamenUsuarioLazyLoader(resultadoExamenUsuarioService);
		Log.error(lazyModel);
	}
	
	
	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			resultadoExamenUsuarioService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [ResultadoExamenUsuarioController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			init();
		}
		return true;
	}

	public boolean save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				resultadoExamenUsuarioService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				init();
			}
		}
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				resultadoExamenUsuarioService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [ResultadoExamenUsuarioController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

/**
 * Procesar respuestas usuario ** Procesar respuestas usuario ** Procesar respuestas usuario ** 
 * Procesar respuestas usuario ** Procesar respuestas usuario ** Procesar respuestas usuario ** 
 * Procesar respuestas usuario ** Procesar respuestas usuario ** Procesar respuestas usuario ** 	
 */
	public void procesarRespuestaArchivo(ArchivoPruebaProcesadoDTO archivoPruebaProcesadoDTO) {
		
		List<RespuestaExamenDTO> respuestaExamenList = respuestaExamenService.getByArchivoPruebaProcesado(archivoPruebaProcesadoDTO);
		
		if(respuestaExamenList !=null && respuestaExamenList.size() > 0) {
			for(RespuestaExamenDTO dto : respuestaExamenList) {
				procesarRespuestaUsuario(dto);
			}
		}
	}
	
	private void procesarRespuestaUsuario(RespuestaExamenDTO respuestaExamenDTO) {
		
		try {
			Gson gson = new Gson();
			
			RespuestaExamenProcesado respuestas = gson.fromJson(respuestaExamenDTO.getRespuesta(), RespuestaExamenProcesado.class);
			
			List<ResultadoExamenUsuario> createdEntryList = new ArrayList<>();
			double sumAreaValue = 0;
			
			for(EsquemaRespuesta respuestaArea : respuestas.getRespuestaExamen()) {
				
				ResultadoExamenUsuarioDTO resultadoExamenUsuarioDTO = new ResultadoExamenUsuarioDTO();

				Area area = new Area(respuestaArea.getAreaId());
				resultadoExamenUsuarioDTO.setAreaId(area);
				
				RespuestaExamen respuestaExamen = RespuestaExamenUtil.getEntityFromDto(respuestaExamenDTO);
				resultadoExamenUsuarioDTO.setRespuestaExamenId(respuestaExamen);
				
				User user = respuestaExamenDTO.getUserId();
				resultadoExamenUsuarioDTO.setUserId(user);
				
				ArchivoPrueba archivoPrueba = respuestaExamenDTO.getArchivoPruebaProcesadoId().getArchivoPruebaId();
				resultadoExamenUsuarioDTO.setArchivoPruebaId(archivoPrueba);
				
				List<ItemRespuesta> itemList = respuestaArea.getItem();
				
				int contadorCorrectas = 0;
				int contadorIncorrectas = 0;
				int contadorVacias = 0;
				if(itemList != null && itemList.size() > 0) {
					for(ItemRespuesta item : itemList) {
						if(item.getRespuesta() == null || item.getRespuesta().isEmpty()) {
							contadorVacias ++;
						} else {
							if(validarRespuestaUsuario(item.getPregunta(), item.getRespuesta())) {
								contadorCorrectas ++;
							} else {
								contadorIncorrectas++;
							}
						}
					}
				}
				
				resultadoExamenUsuarioDTO.setRespuestasCorrectas(contadorCorrectas);
				resultadoExamenUsuarioDTO.setRespuestasErradas(contadorIncorrectas);
				resultadoExamenUsuarioDTO.setSinContestar(contadorVacias);
				resultadoExamenUsuarioDTO.setNroPreguntasArea(itemList.size());
				double porcentajeAcierto = 0;
				if(contadorCorrectas > 0 && itemList.size() > 0) {
					porcentajeAcierto = ((double)contadorCorrectas / itemList.size()) * 100;
				}
				 
				resultadoExamenUsuarioDTO.setPorcentajeAcierto(porcentajeAcierto);
				createdEntryList.add(resultadoExamenUsuarioService.create(resultadoExamenUsuarioDTO));
				
				sumAreaValue = sumAreaValue + porcentajeAcierto;
			}
			
			setPromedioArea(sumAreaValue, createdEntryList);
			
		} catch(Exception e) {
			logger.error("Exception at: ResultadoExamenUsuarioController.procesarRespuestaUsuario: " +e.getMessage());
		}
	}
	
	private void setPromedioArea(double sumAreaValue, List<ResultadoExamenUsuario> entityList) {
		if(entityList.size() > 0) {
			double promedioAreas = (double) (sumAreaValue / entityList.size());
			resultadoExamenUsuarioService.updatePromedioArea(promedioAreas, entityList);
		}
	}
	
	private void findEstudentRank() {
		
	}
	
	private boolean validarRespuestaUsuario(String codPregunta, String respuesta) {
		RespuestaDTO respuestaDTO = preguntaService.getRespuestaByPreguntaCode(codPregunta);
		
		if(respuestaDTO != null && respuestaDTO.getLetra().equalsIgnoreCase(respuesta)) {
			return true;
		}
		return false;
	}
	
	
/**
 * Procesar respuestas usuario ** Procesar respuestas usuario ** Procesar respuestas usuario ** 
 * Procesar respuestas usuario ** Procesar respuestas usuario ** Procesar respuestas usuario ** 
 * Procesar respuestas usuario ** Procesar respuestas usuario ** Procesar respuestas usuario ** 	
 */	
	public void prepareCreate() {
		selected = new ResultadoExamenUsuarioDTO();
	}

	public IResultadoExamenUsuarioService getResultadoExamenUsuarioService() {
		return resultadoExamenUsuarioService;
	}

	public void setResultadoExamenUsuarioService(IResultadoExamenUsuarioService ResultadoExamenUsuarioService) {
		this.resultadoExamenUsuarioService = ResultadoExamenUsuarioService;
	}

	public List<ResultadoExamenUsuarioDTO> getItems() {
		return items;
	}

	public void setItems(List<ResultadoExamenUsuarioDTO> items) {
		this.items = items;
	}

	public ResultadoExamenUsuarioDTO getSelected() {
		return selected;
	}

	public void setSelected(ResultadoExamenUsuarioDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<ResultadoExamenUsuarioDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<ResultadoExamenUsuarioDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}


	public IArchivoPruebaProcesadoService getArchivoPruebaProcesadoService() {
		return archivoPruebaProcesadoService;
	}


	public void setArchivoPruebaProcesadoService(IArchivoPruebaProcesadoService archivoPruebaProcesadoService) {
		this.archivoPruebaProcesadoService = archivoPruebaProcesadoService;
	}


	public IRespuestaExamenService getRespuestaExamenService() {
		return respuestaExamenService;
	}


	public void setRespuestaExamenService(IRespuestaExamenService respuestaExamenService) {
		this.respuestaExamenService = respuestaExamenService;
	}


	public IPreguntaService getPreguntaService() {
		return preguntaService;
	}

	public void setPreguntaService(IPreguntaService preguntaService) {
		this.preguntaService = preguntaService;
	}
}
