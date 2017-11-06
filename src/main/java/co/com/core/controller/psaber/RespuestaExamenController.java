package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;

import co.com.core.commons.ValidationUtil;
import co.com.core.commons.converter.psaber.ArchivoPruebaProcesadoUtil;
import co.com.core.domain.psaber.Area;
import co.com.core.dto.UserDTO;
import co.com.core.dto.psaber.CompetenciaDTO;
import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.dto.psaber.ResultadoExamenUsuarioDTO;
import co.com.core.lazy.loader.psaber.RespuestaExamenLazyLoader;
import co.com.core.services.IUserService;
import co.com.core.services.psaber.ICompetenciaService;
import co.com.core.services.psaber.IRespuestaExamenService;
import co.com.core.services.psaber.IResultadoExamenUsuarioService;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;



public class RespuestaExamenController {

	private static final Logger logger = Logger.getLogger(RespuestaExamenController.class);
	
	private IRespuestaExamenService respuestaExamenService;
	private IResultadoExamenUsuarioService resultadoExamenUsuarioService;
	private IUserService userService;
	private ICompetenciaService competenciaService;
	
	private List<RespuestaExamenDTO> items;
	private RespuestaExamenDTO selected;
	private List<ResultadoExamenUsuarioDTO> itemResultado;
	private ResultadoExamenUsuarioDTO selectedResultado;
	private RespuestaExamenDTO selectedRespuestaExameDTO;
	private List<CompetenciaDTO> itemCompetencia;
	private List<ResultadoExamenUsuarioDTO> resultadoList;
	
	private CompetenciaDTO selectedCompetencia;
	private Date searchDate;

	private String userNameSearch; 
	private Integer userIdSearchResult; 
	private boolean showSearchData;
	private List<UserDTO> searchResultItems;
	private UserDTO userDtoSearchResult;
	
	private LazyDataModel<RespuestaExamenDTO> lazyModel;
	
	public void init() {
		Log.error(lazyModel);
	}
	
	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			respuestaExamenService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [RespuestaExamenController.saveNew]: " +ex.getMessage());
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
				respuestaExamenService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenController.save]: " +ex.getMessage());
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
				respuestaExamenService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [RespuestaExamenController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareCreate() {
		selected = new RespuestaExamenDTO();
	}

	/**
	 * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 * * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 * * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 */
	public void retrieveEntriesByUser() {
		if(userDtoSearchResult != null) {
			lazyModel = new RespuestaExamenLazyLoader(respuestaExamenService, userDtoSearchResult, searchDate);
		}
	}
	
	public void getByRespuestaExamenResultado(RespuestaExamenDTO dto) {
		selectedRespuestaExameDTO = dto;
		itemResultado = resultadoExamenUsuarioService.getByRespuestaExamen(dto);
		
		if(itemResultado!=null && itemResultado.size() > 0) {
			List<Area> areaList = new ArrayList<>();
			for(ResultadoExamenUsuarioDTO item : itemResultado) {
				areaList.add(item.getAreaId());
			}
			if(areaList.size() > 0) {
				getCompetenciasAreas(areaList);
			}
		}
		
	}
	
	private void getCompetenciasAreas(List<Area> areaList) {
		itemCompetencia = competenciaService.getByAreaList(areaList);
	}
	
	public void getUbicacionArea(ResultadoExamenUsuarioDTO dto) {
		
		try {
			List<RespuestaExamenDTO> respExamenList = respuestaExamenService.getByArchivoPruebaProcesado
					(ArchivoPruebaProcesadoUtil.getDtoFromEntity(selectedRespuestaExameDTO.getArchivoPruebaProcesadoId()));
			
			resultadoList = resultadoExamenUsuarioService.getByAreaRespuestaExamenList(respExamenList, dto);
			
			Collections.sort(resultadoList);
			
			logger.info("" + resultadoList);
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	
	/**
	 * search an item using the advance search component
	 */
	public void advancedSearch() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(userNameSearch!=null && userNameSearch.length()>4) {
			String localNameSearch = ValidationUtil.cleanString(userNameSearch);
			searchResultItems = userService.getUserByName(localNameSearch.toLowerCase());
			if(searchResultItems!=null && searchResultItems.size() > 0) {
				showSearchData = true;
			} else {
				showSearchData = false;
			}
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "menos de 4 letras", null));
		}
	}
	
	public void selectResult(UserDTO dto) {
		userDtoSearchResult = dto;
		userIdSearchResult = dto.getUserId();
		userNameSearch = dto.getCompleteName();
		showSearchData = false;
		searchResultItems = new ArrayList<UserDTO>();
	}
	
	public void  generatePDFReport() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/template","root", "admin");
			HashMap<String, Object> params = new HashMap<>(); 
			
			params.put("respuesta_examen_id", selectedRespuestaExameDTO.getRespuestaExamenId());
			params.put("user_id", userIdSearchResult);
			
			JasperPrint print = JasperFillManager.fillReport("C:\\Users\\diego.nieto\\Documents\\DiegoNieto\\template\\pdf_files\\resultadoExamenUsuario.jasper", params, connection);
			JRExporter exporter = new JRPdfExporter();
			
			String outFileName = "C:\\Users\\diego.nieto\\Documents\\DiegoNieto\\template\\pdf_files\\resultadoExamenUsuarioTest.pdf";
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            // Export the PDF file
            exporter.exportReport();
		} catch(Exception ex) {
			logger.error("PDF Error: " +ex.getMessage());
		}
	}
	
	
	/**
	 * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 * * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 * * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 */

	
	/*private class ResultadoExamenUsuarioDTOComparator implements  {

		
	}*/
	
	public IRespuestaExamenService getRespuestaExamenService() {
		return respuestaExamenService;
	}

	public void setRespuestaExamenService(IRespuestaExamenService RespuestaExamenService) {
		this.respuestaExamenService = RespuestaExamenService;
	}

	public List<RespuestaExamenDTO> getItems() {
		return items;
	}

	public void setItems(List<RespuestaExamenDTO> items) {
		this.items = items;
	}

	public RespuestaExamenDTO getSelected() {
		return selected;
	}

	public void setSelected(RespuestaExamenDTO selected) {
		this.selected = selected;
	}

	public LazyDataModel<RespuestaExamenDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<RespuestaExamenDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}

	public IResultadoExamenUsuarioService getResultadoExamenUsuarioService() {
		return resultadoExamenUsuarioService;
	}

	public void setResultadoExamenUsuarioService(IResultadoExamenUsuarioService resultadoExamenUsuarioService) {
		this.resultadoExamenUsuarioService = resultadoExamenUsuarioService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

	public String getUserNameSearch() {
		return userNameSearch;
	}

	public void setUserNameSearch(String userNameSearch) {
		this.userNameSearch = userNameSearch;
	}

	public Integer getUserIdSearchResult() {
		return userIdSearchResult;
	}

	public void setUserIdSearchResult(Integer userIdSearchResult) {
		this.userIdSearchResult = userIdSearchResult;
	}

	public boolean isShowSearchData() {
		return showSearchData;
	}

	public void setShowSearchData(boolean showSearchData) {
		this.showSearchData = showSearchData;
	}

	public List<UserDTO> getSearchResultItems() {
		return searchResultItems;
	}

	public void setSearchResultItems(List<UserDTO> searchResultItems) {
		this.searchResultItems = searchResultItems;
	}

	public List<ResultadoExamenUsuarioDTO> getItemResultado() {
		return itemResultado;
	}

	public void setItemResultado(List<ResultadoExamenUsuarioDTO> itemResultado) {
		this.itemResultado = itemResultado;
	}

	public ResultadoExamenUsuarioDTO getSelectedResultado() {
		return selectedResultado;
	}

	public void setSelectedResultado(ResultadoExamenUsuarioDTO selectedResultado) {
		this.selectedResultado = selectedResultado;
	}

	public ICompetenciaService getCompetenciaService() {
		return competenciaService;
	}


	public void setCompetenciaService(ICompetenciaService competenciaService) {
		this.competenciaService = competenciaService;
	}


	public List<CompetenciaDTO> getItemCompetencia() {
		return itemCompetencia;
	}


	public void setItemCompetencia(List<CompetenciaDTO> itemCompetencia) {
		this.itemCompetencia = itemCompetencia;
	}

	public CompetenciaDTO getSelectedCompetencia() {
		return selectedCompetencia;
	}

	public void setSelectedCompetencia(CompetenciaDTO selectedCompetencia) {
		this.selectedCompetencia = selectedCompetencia;
	}

	public List<ResultadoExamenUsuarioDTO> getResultadoList() {
		return resultadoList;
	}

	public void setResultadoList(List<ResultadoExamenUsuarioDTO> resultadoList) {
		this.resultadoList = resultadoList;
	}
}
