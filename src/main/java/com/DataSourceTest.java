package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.ModuleDAO;
import com.dao.ModuleDataDAO;
import com.dao.ModuleFieldDAO;
import com.to.Module;
import com.to.ModuleData;
import com.to.ModuleField;

@Component
public class DataSourceTest {

@Autowired	
ModuleDAO moduleDao;
@Autowired
ModuleFieldDAO moduleFieldDAO;
@Autowired
ModuleDataDAO moduleEmployeeDataDAO;
	
public void foo(){
		//System.out.println(dao.createModule(module);searchEmployeeByEmpId("1"));
		
	}

public void createModule(){
	Module module = new Module();
	module.setCode("FIN");
	module.setName("Finance");
	moduleDao.createModule(module);
}

public void createModuleField(){
	ModuleField moduleField = new ModuleField();
	moduleField.setModuleCode("INV");
	moduleField.setCode("SRNO");
	moduleField.setName("Serial No");
	moduleFieldDAO.createModuleField(moduleField);
}

}
