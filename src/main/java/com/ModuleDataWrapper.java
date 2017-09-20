package com;

import java.util.ArrayList;
import java.util.List;

import com.web.ModuleDataRow;

public class ModuleDataWrapper {
	
	private List<ModuleDataRow> moduleDataRowList;
	private String moduleCode;
	private String moduleName;

	public ModuleDataWrapper() {
		this.moduleDataRowList = new ArrayList<ModuleDataRow>();
	}

		
	public List<ModuleDataRow> getModuleDataRowList() {
		return moduleDataRowList;
	}


	public void setModuleDataRowList(List<ModuleDataRow> moduleDataRowList) {
		this.moduleDataRowList = moduleDataRowList;
	}


	public void add(ModuleDataRow moduleDataRow){
		this.add(moduleDataRow);
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
}
