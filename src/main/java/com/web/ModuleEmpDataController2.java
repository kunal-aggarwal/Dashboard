package com.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ModuleDAO;
import com.dao.ModuleDataDAO;
import com.dao.ModuleFieldDAO;
import com.to.ModuleData;
import com.to.ModuleField;

@Controller
public class ModuleEmpDataController2 {/*  
	
	@Autowired
	private ModuleEmployeeDataDAO moduleEmployeeDataDAO;
	@Autowired
	private ModuleDAO moduleDAO;
	@Autowired
	private ModuleFieldDAO moduleFieldDAO;
	
	//List<ModuleEmployeeDataRow> moduleEmployeeDataRow = new ArrayList<ModuleEmployeeDataRow>();
	
    @RequestMapping("/moduleEmpData")  
    public ModelAndView showModule(Model model, @RequestParam String code) {
    	List<ModuleEmployeeData> moduleEmpDataList = moduleEmployeeDataDAO.searchModuleEmployeeDataByModuleId(code);
    	List<ModuleDataRow> moduleDataRows = consolidateEmployeeRowDataIntoRow(moduleEmpDataList);
    	model.addAttribute("moduleDataRowList", moduleDataRows);
    	model.addAttribute("moduleName", moduleDAO.searchModuleByModuleCode(code));
    	model.addAttribute("fieldNames", getFieldNames(code));
    	
        return new ModelAndView("moduleEmpData");  
    }
    
   private List<ModuleDataRow> consolidateEmployeeRowDataIntoRow(List<ModuleEmployeeData> moduleEmpDataList){
	   Map<String,Map<Integer,Map<String,String>>> employeeRowData = new HashMap<String,Map<Integer,Map<String,String>>>();
    	
    	for(ModuleEmployeeData each : moduleEmpDataList){
    		String employeeId = each.getEmployeeId();
    		if(!employeeRowData.containsKey(employeeId)){
    			employeeRowData.put(employeeId, new HashMap<Integer, Map<String,String>>());
    		}
    		Map<Integer,Map<String,String>> rowDataMap = employeeRowData.get(employeeId);
    		Integer rowId = each.getRowId();
    		if(!rowDataMap.containsKey(rowId)){
    			rowDataMap.put(rowId, new HashMap<String,String>());
    		}
    		rowDataMap.get(rowId).put(each.getFieldCode(), each.getFieldValue());
    	}
    	return convertMapIntoRow(employeeRowData);
    }


	private List<ModuleDataRow> convertMapIntoRow(Map<String, Map<Integer, Map<String,String>>> employeeRowData) {
		List<ModuleDataRow> moduleDataRows = new ArrayList<ModuleDataRow>();

		for (String employeeId : employeeRowData.keySet()) {
			Map<Integer, Map<String,String>> rowDataMap = employeeRowData.get(employeeId);
			for (Integer rowId : rowDataMap.keySet()) {
				moduleDataRows.add(new ModuleDataRow(employeeId, rowId, rowDataMap.get(rowId)));
			}
		}
	return moduleDataRows;
	}
	
	private List<String> getFieldNames(String moduleCode) {
		List<ModuleField> moduleFields = moduleFieldDAO.searchModuleFieldsByModuleCode(moduleCode);

		List<String> fields = new ArrayList<String>();

		for (ModuleField moduleField : moduleFields) {
			fields.add(moduleField.getCode());
		}
		return fields;
	}
*/}