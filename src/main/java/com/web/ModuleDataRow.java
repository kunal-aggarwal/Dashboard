package com.web;

import java.util.Map;

public class ModuleDataRow{
	
	private int rowId;
	private Map<String, String> fieldCodeValuesMap;
	
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	
	public Map<String, String> getFieldCodeValuesMap() {
		return fieldCodeValuesMap;
	}
	public void setFieldCodeValuesMap(Map<String, String> fieldCodeValuesMap) {
		this.fieldCodeValuesMap = fieldCodeValuesMap;
	}
	
	public ModuleDataRow() {
		super();
	}
	public ModuleDataRow(int rowId, Map<String, String> fieldCodeValuesMap) {
		super();
		this.rowId = rowId;
		this.fieldCodeValuesMap = fieldCodeValuesMap;
	}
}