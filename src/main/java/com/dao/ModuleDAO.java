package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dao.rowmapper.RefDataTypeMapper;
import com.dao.rowmapper.ModuleMapper;
import com.to.RefDataType;
import com.util.IdGenerator;
import com.to.Module;

@Component
public class ModuleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createModule(Module module) {
		String query = "insert into module (code, name) values ( ?, ?)";
		jdbcTemplate.update(query, IdGenerator.getId(), module.getName());
	}
	
	public void updateModule(Module module) {
		String query = "update module set code=?, name=? where id=?";
		jdbcTemplate.update(query, module.getCode(), module.getName(), module.getId());
	}
	
	public Module searchModuleById(String id) {
		String query = "select * from module where id =?";
		Module module = (Module) jdbcTemplate.queryForObject(query, new Object[]{id}, new ModuleMapper());
		return module;
	}
	
	public Module searchModuleByModuleCode(String code) {
		String query = "select * from module where code =?";
		Module module = jdbcTemplate.queryForObject(query, new Object[]{code}, new ModuleMapper());
		return module;
	}
	
	public List<Module> searchModules() {
		String query = "select * from module";
		List<Module> modules = jdbcTemplate.query(query, new ModuleMapper());
		return modules;
	}

}
