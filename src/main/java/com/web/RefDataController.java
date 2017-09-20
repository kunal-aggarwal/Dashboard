package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RefDataDAO;
import com.dao.RefDataTypeDAO;
import com.to.RefData;
import com.to.RefDataType;

@Controller
public class RefDataController {  
	
	
	@Autowired
	private RefDataDAO refDataDAO;
	
	@Autowired
	private RefDataTypeDAO refDataTypeDAO;
	
    @RequestMapping("/showRefData")  
    public ModelAndView showRefData(Model model, @RequestParam String category) {
    	model.addAttribute("refDataList", refDataDAO.searchRefDataByCategorye(category));
    	RefData refData = new RefData();
    	refData.setCategory(category);
    	
    	RefDataType refDataType = refDataTypeDAO.searchRefDataTypeByCategory(category);
    	model.addAttribute("refData", refData);
    	model.addAttribute("refDataType", refDataType);
        return new ModelAndView("refData");  
    }
    
    @RequestMapping(value="/processRefData", params="add")  
    public ModelAndView processModule(@ModelAttribute RefData refData, Model model) {
    	refDataDAO.createRefData(refData);
        return showRefData(model, refData.getCategory());  
    }
} 