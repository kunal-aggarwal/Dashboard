package com.to;

public class ModuleData {
	
	private int id;
	private String moduleCode;
	private int rowId;
	private String fieldCode;
	private String fieldValue;
	
	
	
	public ModuleData() {
		super();
	}
	public ModuleData(String moduleCode, int rowId, String fieldCode, String fieldValue) {
		super();
		this.moduleCode = moduleCode;
		this.rowId = rowId;
		this.fieldCode = fieldCode;
		this.fieldValue = fieldValue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

}
