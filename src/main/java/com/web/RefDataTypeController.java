package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ModuleDAO;
import com.dao.RefDataTypeDAO;
import com.to.Module;
import com.to.ModuleField;
import com.to.RefDataType;

@Controller
public class RefDataTypeController {  
	
	@Autowired
	private RefDataTypeDAO refDataTypeDAO;
	
    @RequestMapping("/showRefDataType")  
    public ModelAndView shoRefDataType(Model model) {
    	model.addAttribute("refDataTypes", refDataTypeDAO.searchRefDataTypeCategories());
    	model.addAttribute("refDataType", new RefDataType());
        return new ModelAndView("refDataType");  
    }
    
    @RequestMapping(value="/processRefDataType", params="add")  
    public ModelAndView processModule(@ModelAttribute RefDataType refDataType, Model model) {
    	refDataTypeDAO.createRefDatatype(refDataType);
        return shoRefDataType(model);  
    }
} 