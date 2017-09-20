package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ModuleDAO;
import com.to.Module;

@Controller
public class ModuleController {  
	
	@Autowired
	private ModuleDAO moduleDAO;
	
    @RequestMapping("/hello")  
    public ModelAndView hello() {  
        return new ModelAndView("hello");  
    }
    
    @RequestMapping("/showModule")  
    public ModelAndView showModule(Model model) {
    	model.addAttribute("modules", moduleDAO.searchModules());
    	model.addAttribute("module", new Module());
        return new ModelAndView("showModule");  
    }
    
    @RequestMapping(value="/processModule", params="add")  
    public ModelAndView processModule(Model model, @ModelAttribute Module module) {
    	moduleDAO.createModule(module);
        return showModule(model);  
    }
} 