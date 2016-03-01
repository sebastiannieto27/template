package co.com.core.commons.reports.jasper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import co.com.core.dto.IBaseDTO;

public class BaseJasperPDFReport {

	private Map<String,Object> parameters;
	private String jFilePath;
	private List<? extends IBaseDTO> itemList;
	
	public BaseJasperPDFReport(Map<String,Object> params, String path, List<? extends IBaseDTO> dtoList) {
		this.parameters = params;
		this.jFilePath = path;
		this.itemList = dtoList;
	}
	
	public void createPDFReport(String reportName) throws JRException, IOException {
		File jasper = new File(jFilePath);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, new JRBeanCollectionDataSource(itemList));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=" + reportName +".pdf");
		ServletOutputStream stream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}
}
