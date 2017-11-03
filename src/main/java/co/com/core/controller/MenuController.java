package co.com.core.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.Columns;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import co.com.core.commons.ApplicationConstants;
import co.com.core.commons.ApplicationUtil;
import co.com.core.commons.converter.UserUtil;
import co.com.core.commons.reports.jasper.BaseJasperPDFReport;
import co.com.core.domain.Menu;
import co.com.core.domain.Page;
import co.com.core.domain.User;
import co.com.core.dto.MenuDTO;
import co.com.core.dto.UserDTO;
import co.com.core.services.IMenuService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class MenuController {

	private List<Menu> menuList; 
	private MenuModel model;
	private MenuModel generalModel;
	private String userName;
	
	private LoginController login;
	private IMenuService menuService;
	
	List<MenuDTO> items;
	private MenuDTO selected;
	private Integer parentMenuId;
	private Integer pageId;
	
	private static final Logger logger = Logger.getLogger(MenuController.class);
	
	public void init() {
		model = new DefaultMenuModel();
		items = menuService.getAll();
	}
	

	public void jasperTestOne() {
			Map<String,Object> parametros= new HashMap<String,Object>();
			parametros.put("PRINT_BY", "Diego Nieto");
			
			String jPath = "C:\\Users\\diego.nieto\\Documents\\DiegoNieto\\template\\pdf_files\\test.pdf";
			BaseJasperPDFReport reporter = new BaseJasperPDFReport(parametros, jPath, this.getItems());
			String currDateStr = ApplicationUtil.getFormattedDate(new Date(), ApplicationConstants.SIMPLE_DATE_FORMAT, null);
			String reportName = "test" + currDateStr;
			try {
				reporter.createPDFReport(reportName);
			} catch (JRException e) {
				System.out.println("JRException " + e.getMessage());
			} catch (IOException e) {
				System.out.println("IOException " + e.getMessage());
			}
	}
	
	public void createPDF3() {
		
		try {
			Connection connection = null;
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mydb","root", "admin");
			
			java.sql.Statement stmt = connection.createStatement();

		    ResultSet rs = stmt.executeQuery("SELECT menu_id, menu_name, submenu, page_id FROM menu;");

		    JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(rs);

		    final Map<String, Object> parameter = new HashMap<String, Object>();
		    parameter.put("menu_id", "ID");
		    parameter.put("menu_name", "NAME");
		    parameter.put("submenu", "Submenu");
		    parameter.put("page_id", "PAGE");

		    ClassLoader classloader = getClass().getClassLoader();
		    InputStream url = null;
		    url = classloader.getResourceAsStream("OK/report3.jrxml");
		    JasperReport jasperReport = JasperCompileManager.compileReport(url);

		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, resultSetDataSource);

		    JasperViewer.viewReport(jasperPrint, false);
		} catch(Exception ex) {
			
		}
		
		
	}
	
	
	public void createPDF2() {
		Connection connection = null;
		
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mydb","root", "admin");
			
			JasperReportBuilder report = DynamicReports.report();
			Columns.column("Menu Id", "menu_id", DataTypes.integerType());
			report
			  .columns(
			    Columns.column("Customer Id", "menu_id", DataTypes.integerType()),
			    Columns.column("Name", "menu_name", DataTypes.stringType()),
			    Columns.column("Submenu", "submenu", DataTypes.stringType()),
			    Columns.column("Page", "page_id", DataTypes.integerType()));
			
			report.title(//title of the report
					    Components.text("SimpleReportExample")
					      .setHorizontalAlignment(HorizontalAlignment.CENTER))
					  .pageFooter(Components.pageXofY());//show page number on the page footer
			report.setDataSource("SELECT menu_id, menu_name, submenu, page_id FROM menu", 
                    connection);
			report.show();

            //export the report to a pdf file
			report.toPdf(new FileOutputStream("/Users/dienieto/Documents/DocumentsDiego/projects/friogan/reports/pdf/report.pdf"));
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}*/
	}
	
	public void createReport() {
		try {
			if(items!=null && items.size() > 0) {
				
				/*String excelFile = "/Users/dienieto/Documents/DocumentsDiego/projects/friogan/reports/excel/test.xls";
				
				HSSFWorkbook workbook = new HSSFWorkbook();
		        HSSFSheet sheet = workbook.createSheet("FirstSheet");  
		        List<String> headList = new ArrayList<String>();
		        headList.add("No.");
		        headList.add("Name");
		        headList.add("SubMenu");
		        headList.add("General");
		        headList.add("Parent");
		        headList.add("Page");
		        HSSFRow rowhead = ExcelReportUtil.createFileHead(headList, sheet, 0);
		        		
		        Row titleRow = sheet.createRow((short) 1);
		        Cell cell = titleRow.createCell((short) 1);
		        cell.setCellValue("Merging cells in an excel output in POI");

		        // Create a new font and alter it.
		        Font font = ExcelReportUtil.crateFileFontStyle(workbook, HSSFColor.RED.index, "Tahoma", 24, true, false);
		        //create the style object
		        HSSFCellStyle style = workbook.createCellStyle();
		        //set the font style
		        style.setFont(font);
		        //set the style to the cell
		        cell.setCellStyle(style);
		        //merge some rows and cols
		        sheet.addMergedRegion(new CellRangeAddress(
		                1, //first row (0-based)
		                2, //last row  (0-based)
		                1, //first column (0-based)
		                6  //last column  (0-based)
		        ));
		        
		        
		        int rowCounter = 3;
		       for(MenuDTO item : items) {
		    	   	HSSFRow row = sheet.createRow(rowCounter);

		            row.createCell(0).setCellValue("item.getMenuId()");
		            row.createCell(1).setCellValue("item.getMenuName()");
		            row.createCell(2).setCellValue("item.getSubmenu()");
		            row.createCell(3).setCellValue("item.getGeneral()");
		            row.createCell(4).setCellValue("item.getParentMenuId().getMenuName()");
		            row.createCell(5).setCellValue("item.getPageId().getUrl()");
		            
		            rowCounter++;
		        }
		       
		        FileOutputStream fileOut = new FileOutputStream(excelFile);
	            workbook.write(fileOut);
	            fileOut.close();
	            System.out.println("Your excel file has been generated!");*/
			}
		} catch(Exception ex) {
			logger.error("Error: " + ex.getMessage());
		}
	}
	
	public void loadMenu(UserDTO userDto) {
		User user = UserUtil.getEntityFromDto(userDto);
		List<MenuDTO> menuList = menuService.getUserMenu(user);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				if(!menu.getSubmenu()) {
					DefaultSubMenu subMenu = new DefaultSubMenu(menu.getMenuName());
					for(MenuDTO menuItem : menuList) {
						if(menuItem.getSubmenu() && menuItem.getParentMenuId()!=null) {
							if(menuItem.getParentMenuId().getMenuId() == menu.getMenuId() ) {
								DefaultMenuItem item = new DefaultMenuItem(menuItem.getMenuName());
								if(menuItem.getPageId()!=null) {
									item.setUrl(menuItem.getPageId().getUrl());
									//TODO item.setIcon(icon);
								}
								subMenu.addElement(item);
							}
						}
					}
					model.addElement(subMenu);
				} 
			}
		}
	}

	public void loadGeneralMenu() {
		generalModel = new DefaultMenuModel();
		List<MenuDTO> menuList = menuService.getMenuGeneral();
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				if(!menu.getSubmenu()) {
					DefaultSubMenu subMenu = new DefaultSubMenu(menu.getMenuName());
					for(MenuDTO menuItem : menuList) {
						if(menuItem.getSubmenu() && menuItem.getParentMenuId()!=null) {
							if(menuItem.getParentMenuId().getMenuId() == menu.getMenuId() ) {
								DefaultMenuItem item = new DefaultMenuItem(menuItem.getMenuName());
								item.setUrl(menuItem.getPageId().getUrl());
								//TODO item.setIcon(icon);
								subMenu.addElement(item);
							}
						}
					}
					generalModel.addElement(subMenu);
				} 
			}
		}
	}
	
	/*************************ADMIN********************************/
	
	public void prepareEdit() {
		selected = new MenuDTO();
	}

	public void prepareCreate() {
		selected = new MenuDTO();
	}
	
	public void saveNew() {
		try {
			
			Page page = new Page(pageId);
			
			if(parentMenuId != null && parentMenuId !=0) {
				Menu parent = new Menu(parentMenuId);
				selected.setParentMenuId(parent);
			}
			selected.setPageId(page);
			menuService.createMenu(selected);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Creación exitosa", "Menu"));
		} catch (Exception ex) {
			logger.error("Throwed Exception [MenuController.saveNew]: " +ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error en creación", "Menu"));
		} finally {
			items = menuService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			try {
				menuService.delete(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado", "Menu"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MenuController.delete]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en eliminación", "Menu"));
			} finally {
				items = menuService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			try {
				Page page = new Page(pageId);
				
				if(parentMenuId != null && parentMenuId !=0) {
					Menu parent = new Menu(parentMenuId);
					selected.setParentMenuId(parent);
				}
				selected.setPageId(page);
				
				menuService.update(selected);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Actualizado", "Menu"));
			} catch (Exception ex) {
				logger.error("Throwed Exception [MenuController.save]: " +ex.getMessage());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error en actualización", "Menu"));
			} finally {
				items = menuService.getAll();
			}
		}
	}
	
	public List<MenuDTO> getItems() {
		return items;
	}

	public void setItems(List<MenuDTO> items) {
		this.items = items;
	}

	public MenuDTO getSelected() {
		return selected;
	}

	public void setSelected(MenuDTO selected) {
		this.selected = selected;
	}

	public LoginController getLogin() {
		return login;
	}

	public void setLogin(LoginController login) {
		this.login = login;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public MenuModel getGeneralModel() {
		return generalModel;
	}

	public void setGeneralModel(MenuModel generalModel) {
		this.generalModel = generalModel;
	}

	public Integer getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
