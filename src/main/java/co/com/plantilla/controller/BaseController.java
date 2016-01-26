package co.com.plantilla.controller;

import co.com.plantilla.services.IBaseService;

public class BaseController {

	private IBaseService baseService;

	public IBaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(IBaseService baseService) {
		this.baseService = baseService;
	}
	
	public String getProp1() {
		return "prop1Value";
	}
}
