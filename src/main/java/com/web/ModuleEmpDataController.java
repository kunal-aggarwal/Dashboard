package com.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ModuleDataWrapper;
import com.dao.ModuleDAO;
import com.dao.ModuleDataDAO;
import com.dao.RefDataDAO;
import com.to.Module;
import com.to.ModuleData;
import com.to.ModuleField;
import com.to.RefData;
import com.web.helper.ModuleEmpDataHelper;

@Controller
public class ModuleEmpDataController {  
	
	@Autowired
	private ModuleDataDAO moduleEmployeeDataDAO;
	@Autowired
	private ModuleDAO moduleDAO;
	@Autowired
	private RefDataDAO refDataDAO;
	
	@Autowired
	ModuleEmpDataHelper moduleEmpDataHelper;
	
	
	
	//List<ModuleEmployeeDataRow> moduleEmployeeDataRow = new ArrayList<ModuleEmployeeDataRow>();
	
    @RequestMapping("/moduleEmpData")  
    public ModelAndView showModule(Model model, @RequestParam String code) {
    	List<ModuleData> moduleEmpDataList = moduleEmployeeDataDAO.searchModuleDataByModuleId(code);
    	List<ModuleDataRow> moduleDataRows = moduleEmpDataHelper.consolidateEmployeeRowDataIntoRow(moduleEmpDataList);
    	
    	ModuleDataWrapper moduleDataWrapper = new ModuleDataWrapper();
    	addEmptyRow(moduleDataRows);
    	moduleDataWrapper.setModuleDataRowList(moduleDataRows);
    	Module module = moduleDAO.searchModuleByModuleCode(code);
    	moduleDataWrapper.setModuleCode(module.getCode());
    	moduleDataWrapper.setModuleName(module.getName());
    	model.addAttribute("moduleDataWrapper", moduleDataWrapper);
    	List<ModuleField> moduleFields = moduleEmpDataHelper.getModuleFields(code);
    	model.addAttribute("moduleFields", moduleFields);
    	List<RefData> refDataList = refDataDAO.searchRefData();
    	model.addAttribute("refDataValuesMap", moduleEmpDataHelper.getRefDataValuesMap(refDataList));
        return new ModelAndView("moduleEmpData");  
    }
    
    private void addEmptyRow(List<ModuleDataRow> moduleDataRows){
    	ModuleDataRow emptyModuleDataRow = new ModuleDataRow(-1, null);
    	moduleDataRows.add(emptyModuleDataRow);
    }
    
   
    @RequestMapping(value="/processModuleData", params="update")  
    public ModelAndView processModule(Model model, @ModelAttribute ModuleDataWrapper moduleDataWrapper) {
    	String moduleCode = moduleDataWrapper.getModuleCode();
    	int maxModuleRow  = moduleEmployeeDataDAO.getNextRowIdForModule(moduleCode);
    	List<ModuleData> moduleEmployeeDataList  = new ArrayList<ModuleData>();
    	for(ModuleDataRow moduleEmployeeData : moduleDataWrapper.getModuleDataRowList()){
    		Map<String, String> fieldCodeValuesMap = moduleEmployeeData.getFieldCodeValuesMap();
    		for(String fieldCode : fieldCodeValuesMap.keySet()){
    			String fieldValue = fieldCodeValuesMap.get(fieldCode);
    			int rowId  = moduleEmployeeData.getRowId();
    			if(isNewRow(rowId, fieldValue)){
    				rowId = maxModuleRow + 1;
    			}
    			if(rowId != -1){
    				moduleEmployeeDataList.add(new ModuleData(moduleCode, rowId, fieldCode, fieldValue));
    			}
    		}
    	}
    	for(ModuleData moduleEmployeeData : moduleEmployeeDataList){
    		moduleEmployeeDataDAO.updateModuleData(moduleEmployeeData);
    	}
        return showModule(model, moduleCode);  
    }

	private boolean isNewRow(int rowId, String fieldValue) {
		return rowId == -1 && !StringUtils.isEmpty(fieldValue);
	}


}