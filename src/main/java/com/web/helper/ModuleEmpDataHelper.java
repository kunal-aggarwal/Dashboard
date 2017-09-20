package com.web.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.ModuleFieldDAO;
import com.to.ModuleData;
import com.to.ModuleField;
import com.to.RefData;
import com.web.ModuleDataRow;

@Component
public class ModuleEmpDataHelper {  
	
	@Autowired
	private ModuleFieldDAO moduleFieldDAO;
	
    
   public List<ModuleDataRow> consolidateEmployeeRowDataIntoRow(List<ModuleData> moduleEmpDataList){
	   Map<Integer,Map<String,String>> rowDataMap = new HashMap<Integer, Map<String,String>>();
    	
    	for(ModuleData each : moduleEmpDataList){
    		Integer rowId = each.getRowId();
    		if(!rowDataMap.containsKey(rowId)){
    			rowDataMap.put(rowId, new HashMap<String,String>());
    		}
    		rowDataMap.get(rowId).put(each.getFieldCode(), each.getFieldValue());
    	}
    	return convertMapIntoRow(rowDataMap);
    }


	private List<ModuleDataRow> convertMapIntoRow(Map<Integer, Map<String,String>> rowDataMap) {
		List<ModuleDataRow> moduleDataRows = new ArrayList<ModuleDataRow>();
		for (Integer rowId : rowDataMap.keySet()) {
				moduleDataRows.add(new ModuleDataRow(rowId, rowDataMap.get(rowId)));
			}
		
	return moduleDataRows;
	}
	
	public List<ModuleField> getModuleFields(String moduleCode) {
		List<ModuleField> moduleFields = moduleFieldDAO.searchModuleFieldsByModuleCode(moduleCode);
		return moduleFields;
	}

	public Map<String, Map<String, String>> getRefDataValuesMap(List<RefData> refDataList) {
		Map<String, Map<String, String>> refDataValuesMap = new HashMap<String, Map<String, String>>();
		for(RefData refData : refDataList){
			if(!refDataValuesMap.containsKey(refData.getCategory())){
				refDataValuesMap.put(refData.getCategory(), new HashMap<String, String>());
				refDataValuesMap.get(refData.getCategory()).put("", "-Select-");
			}
			refDataValuesMap.get(refData.getCategory()).put(refData.getCode(), refData.getCode() + "-" +refData.getName());
		}
		return refDataValuesMap;
	}


}
