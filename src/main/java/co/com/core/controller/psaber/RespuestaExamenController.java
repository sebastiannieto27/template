package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;

import co.com.core.commons.ValidationUtil;
import co.com.core.commons.charts.GenericBarChart;
import co.com.core.commons.charts.GenericLineChart;
import co.com.core.commons.converter.psaber.ArchivoPruebaProcesadoUtil;
import co.com.core.commons.converter.psaber.ArchivoPruebaUtil;
import co.com.core.domain.psaber.Area;
import co.com.core.dto.UserDTO;
import co.com.core.dto.psaber.ArchivoPruebaDTO;
import co.com.core.dto.psaber.CompetenciaDTO;
import co.com.core.dto.psaber.MediaNacionalAreaDTO;
import co.com.core.dto.psaber.PromedioAreaArchivoPruebaProcesadoDTO;
import co.com.core.dto.psaber.RespuestaExamenDTO;
import co.com.core.dto.psaber.ResultadoExamenUsuarioDTO;
import co.com.core.lazy.loader.psaber.RespuestaExamenLazyLoader;
import co.com.core.services.IUserService;
import co.com.core.services.psaber.IArchivoPruebaService;
import co.com.core.services.psaber.ICompetenciaService;
import co.com.core.services.psaber.IMediaNacionalAreaService;
import co.com.core.services.psaber.IPromedioAreaArchivoPruebaProcesadoService;
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
	private IArchivoPruebaService archivoPruebaService;
	private IPromedioAreaArchivoPruebaProcesadoService promedioAreaArchivoPruebaProcesadoService;
	private IMediaNacionalAreaService mediaNacionalAreaService;
	
	private List<RespuestaExamenDTO> items;
	private RespuestaExamenDTO selected;
	private RespuestaExamenDTO selectedRespuestaExamen;
	private List<ResultadoExamenUsuarioDTO> itemResultado;
	private ResultadoExamenUsuarioDTO selectedResultado;
	private RespuestaExamenDTO selectedRespuestaExameDTO;
	private List<CompetenciaDTO> itemCompetencia;
	private List<ResultadoExamenUsuarioDTO> resultadoList;
	
	private CompetenciaDTO selectedCompetencia;
	private Date searchDate;

	private int percentilEstudiante;
	private String userNameSearch; 
	private Integer userIdSearchResult; 
	private boolean showSearchData;
	private List<UserDTO> searchResultItems;
	private UserDTO userDtoSearchResult;
	
	private Integer archivoPruebaId;
	private ArchivoPruebaDTO archivoPruebaDTO;
	private Date archivoSearchDate;
	
	private LazyDataModel<RespuestaExamenDTO> lazyModel;
	
	private LazyDataModel<RespuestaExamenDTO> lazyModelRespuestaExamen;
	
	private LineChartModel lineModelPercentil;
	
	private BarChartModel resultadoGeneralChart;
	
	public void init() {
		lineModelPercentil = new LineChartModel();
		resultadoGeneralChart = new BarChartModel();
	}
	
	/**
	 * Creates new entry in the database
	 * @return
	 */
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

	/**
	 * Updates an existing entry
	 * @return
	 */
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
	
	/**
	 * Deletes an existing entry
	 */
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

	/**
	 * prepares the form and variables to create a new entry
	 */
	public void prepareCreate() {
		selected = new RespuestaExamenDTO();
	}

	/**
	 * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 * * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 * * RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN *** RESPUESTA EXAMEN **
	 */
	/**
	 * retrieves all entries by archivoPruebaProcesado.user and archivoPruebaProcesado.fecCre
	 */
	public void retrieveEntriesByUser() {
		if(userDtoSearchResult != null) {
			lazyModel = new RespuestaExamenLazyLoader(respuestaExamenService, userDtoSearchResult, searchDate);
		}
	}
	
	/**
	 * retrieves RespuestaExamenResultado by RespuestaExamen
	 * @param dto
	 */
	public void getByRespuestaExamenResultado(RespuestaExamenDTO dto) {
		selectedRespuestaExameDTO = dto;
		itemResultado = resultadoExamenUsuarioService.getByRespuestaExamen(dto);
		
		if(itemResultado!=null && itemResultado.size() > 0) {
			List<Area> areaList = new ArrayList<>();
			for(ResultadoExamenUsuarioDTO item : itemResultado) {
				areaList.add(item.getAreaId());
			}
		}
		
	}
	
	/**
	 * retrieves all competencia entries by area
	 * @param dto
	 */
	public void getCompetenciasArea(ResultadoExamenUsuarioDTO dto) {
		itemCompetencia = competenciaService.getByArea(dto.getAreaId());
	}
	
	/**
	 * retrieves RespuestaExamen by archivoPruebaProcesado 
	 * then retrieves ResultadoExamenUsuario by respuestaExamen and area 
	 * finally sorts by ResultadoExamenUsuario.porcentajeAcierto 
	 * @param dto
	 */
	public void getUbicacionArea(ResultadoExamenUsuarioDTO dto) {
		
		try {
			List<RespuestaExamenDTO> respExamenList = respuestaExamenService.getByArchivoPruebaProcesado
					(ArchivoPruebaProcesadoUtil.getDtoFromEntity(selectedRespuestaExameDTO.getArchivoPruebaProcesadoId()));
			
			resultadoList = resultadoExamenUsuarioService.getByAreaRespuestaExamenList(respExamenList, dto.getAreaId());
			
			Collections.sort(resultadoList);
			
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * calculates the percentile by area and creates a linear chart
	 * @param dto
	 */
	public void percentilEstudianteArea(ResultadoExamenUsuarioDTO dto) {
		try {
			List<RespuestaExamenDTO> respExamenList = respuestaExamenService.getByArchivoPruebaProcesado
					(ArchivoPruebaProcesadoUtil.getDtoFromEntity(selectedRespuestaExameDTO.getArchivoPruebaProcesadoId()));
			
			List<ResultadoExamenUsuarioDTO> listResultado = resultadoExamenUsuarioService.getByAreaRespuestaExamenList(respExamenList, dto.getAreaId());
		
			double nElements = 89;//listResultado.size();TODO
			double houndredPercent = 100;
			double userResult = dto.getPorcentajeAcierto();
			
			double tempValue = ((nElements * userResult) / houndredPercent);
			percentilEstudiante = (int) Math.floor(tempValue);		

			//individual chart
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("label", "percentil");
			dataMap.put("13", "0.5");//TODO
			
			//List of charts
			List<Map> charList = new ArrayList<>();
			charList.add(dataMap);
			
			//general map
			Map<String, Object> generalMap = new HashMap<>();
			generalMap.put("chartList", charList);
			generalMap.put("title", "Percentil Estudiante");
			generalMap.put("yAxisMin", "0");
			generalMap.put("yAxisMax", "1");
			generalMap.put("xAxisMin", "0");
			generalMap.put("xAxisMax", "100");//TODO
			
			GenericLineChart lineChart = new GenericLineChart();
			lineModelPercentil = lineChart.createLineModels(generalMap);
			
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void getRespuestaExamenByArchivoPruebaFecCre() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(archivoPruebaId==null || archivoPruebaId==0) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					geProperty("archivoPrubeaRequiredMessage"), geProperty("pleaseVerifySummary")));
			return;
		}
		
		if(archivoSearchDate==null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					geProperty("fecExamenRequiredMessage"), geProperty("pleaseVerifySummary")));
			return;
		}
		//get the archvioPrueba dto
        archivoPruebaDTO = archivoPruebaService.getByArchivoPruebaId(archivoPruebaId);
        //archivoSearchDate
        lazyModelRespuestaExamen = new RespuestaExamenLazyLoader(respuestaExamenService, archivoPruebaDTO, archivoSearchDate); 
	}
	
	public void verGraficaResultadoGeneralColegio(RespuestaExamenDTO dto) {
		
		//get the mean of the areas associated to archivoPrueba
		List<PromedioAreaArchivoPruebaProcesadoDTO> promedioList = 
		promedioAreaArchivoPruebaProcesadoService.getByArchivoPruebaProcesado(ArchivoPruebaProcesadoUtil.getDtoFromEntity(dto.getArchivoPruebaProcesadoId()));
	
		List<MediaNacionalAreaDTO> mediaNacionalList = 
				mediaNacionalAreaService.getMediaNacionalByArchivoPrueba(ArchivoPruebaUtil.getDtoFromEntity(dto.getArchivoPruebaProcesadoId().getArchivoPruebaId()));
		
		//General chart map - contains values such as title,xTitle,yTitle
		Map<String, Object> charData = new HashMap<>();
		charData.put("title", "Resultado General Colegio");
		charData.put("xTitle", "Área");
		charData.put("yTitle", "Media");
		
		//chart data list, contains one or more maps with all the chart values
		List<Map<String, Object>> dataList = new ArrayList<>();
		
		Map<String, Object> colegioMap = new HashMap<>();
		colegioMap.put("label", "Media Colegio");
		if(promedioList!=null && promedioList.size()>0) {
			for(PromedioAreaArchivoPruebaProcesadoDTO item : promedioList) {
				String area = item.getAreaId().getNombre();
				colegioMap.put(area, item.getValor());
			}
		}
		dataList.add(colegioMap);
		
		Map<String, Object> mediaNacionalMap = new HashMap<>();
		mediaNacionalMap.put("label", "Media Nacional");
		if(mediaNacionalList!=null && mediaNacionalList.size()>0) {
			for(MediaNacionalAreaDTO item : mediaNacionalList) {
				String area = item.getAreaId().getNombre();
				mediaNacionalMap.put(area, item.getValor());
			}
		}
		dataList.add(mediaNacionalMap);
		charData.put("chartList", dataList);
		GenericBarChart genericBarChart = new GenericBarChart();
		resultadoGeneralChart = genericBarChart.createBarModel(charData);
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

	public int getPercentilEstudiante() {
		return percentilEstudiante;
	}

	public void setPercentilEstudiante(int percentilEstudiante) {
		this.percentilEstudiante = percentilEstudiante;
	}

	public LineChartModel getLineModelPercentil() {
		return lineModelPercentil;
	}

	public void setLineModelPercentil(LineChartModel lineModelPercentil) {
		this.lineModelPercentil = lineModelPercentil;
	}

	public LazyDataModel<RespuestaExamenDTO> getLazyModelRespuestaExamen() {
		return lazyModelRespuestaExamen;
	}

	public void setLazyModelRespuestaExamen(LazyDataModel<RespuestaExamenDTO> lazyModelRespuestaExamen) {
		this.lazyModelRespuestaExamen = lazyModelRespuestaExamen;
	}

	public RespuestaExamenDTO getSelectedRespuestaExameDTO() {
		return selectedRespuestaExameDTO;
	}

	public void setSelectedRespuestaExameDTO(RespuestaExamenDTO selectedRespuestaExameDTO) {
		this.selectedRespuestaExameDTO = selectedRespuestaExameDTO;
	}

	public RespuestaExamenDTO getSelectedRespuestaExamen() {
		return selectedRespuestaExamen;
	}

	public void setSelectedRespuestaExamen(RespuestaExamenDTO selectedRespuestaExamen) {
		this.selectedRespuestaExamen = selectedRespuestaExamen;
	}

	public Integer getArchivoPruebaId() {
		return archivoPruebaId;
	}

	public void setArchivoPruebaId(Integer archivoPruebaId) {
		this.archivoPruebaId = archivoPruebaId;
	}

	public Date getArchivoSearchDate() {
		return archivoSearchDate;
	}

	public void setArchivoSearchDate(Date archivoSearchDate) {
		this.archivoSearchDate = archivoSearchDate;
	}

	public IArchivoPruebaService getArchivoPruebaService() {
		return archivoPruebaService;
	}

	public void setArchivoPruebaService(IArchivoPruebaService archivoPruebaService) {
		this.archivoPruebaService = archivoPruebaService;
	}

	public IPromedioAreaArchivoPruebaProcesadoService getPromedioAreaArchivoPruebaProcesadoService() {
		return promedioAreaArchivoPruebaProcesadoService;
	}

	public void setPromedioAreaArchivoPruebaProcesadoService(
			IPromedioAreaArchivoPruebaProcesadoService promedioAreaArchivoPruebaProcesadoService) {
		this.promedioAreaArchivoPruebaProcesadoService = promedioAreaArchivoPruebaProcesadoService;
	}

	public IMediaNacionalAreaService getMediaNacionalAreaService() {
		return mediaNacionalAreaService;
	}

	public void setMediaNacionalAreaService(IMediaNacionalAreaService mediaNacionalAreaService) {
		this.mediaNacionalAreaService = mediaNacionalAreaService;
	}

	public BarChartModel getResultadoGeneralChart() {
		return resultadoGeneralChart;
	}

	public void setResultadoGeneralChart(BarChartModel resultadoGeneralChart) {
		this.resultadoGeneralChart = resultadoGeneralChart;
	}
}
