package com.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ModuleDAO;
import com.dao.ModuleFieldDAO;
import com.dao.RefDataTypeDAO;
import com.to.ModuleField;
import com.to.RefDataType;

@Controller
public class ModuleFieldController {  
	
	@Autowired
	private ModuleFieldDAO moduleFieldDAO;
	
	@Autowired
	private RefDataTypeDAO refDataTypeDAO;
	
	@Autowired
	private ModuleDAO moduleDAO;
	
    @RequestMapping("/showModuleField")  
    public ModelAndView showModule(Model model, @RequestParam String code) {
    	model.addAttribute("moduleFields", moduleFieldDAO.searchModuleFieldsByModuleCode(code));
    	Map<String, String> fieldTypes = new HashMap<String, String>();
    	fieldTypes.put("TEXT", "Text");
    	fieldTypes.putAll(getRefFieldTypes());
    	model.addAttribute("fieldTypes", fieldTypes);
    	model.addAttribute("moduleName", moduleDAO.searchModuleByModuleCode(code));
    	ModuleField moduleField = new ModuleField();
    	moduleField.setModuleCode(code);
    	model.addAttribute("moduleField", moduleField);
        return new ModelAndView("showModuleField");  
    }
    
    @RequestMapping("/addModuleField")  
    public ModelAndView showModule(@ModelAttribute ModuleField moduleField, Model model) {
    	moduleFieldDAO.createModuleField(moduleField);
        return showModule(model, moduleField.getModuleCode());  
    }
    
    private Map<String,String> getRefFieldTypes() {
    	List<RefDataType> refDataTypeList = refDataTypeDAO.searchRefDataTypeCategories();
    	Map<String,String> refDataTypeMap = new HashMap<String, String>();
    	for(RefDataType refDataType : refDataTypeList){
    		refDataTypeMap.put(refDataType.getCode(), refDataType.getName());
    	}
        return refDataTypeMap;  
    }
    
    
    
    
} 