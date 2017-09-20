package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dao.rowmapper.ModuleFieldMapper;
import com.to.ModuleField;
import com.util.IdGenerator;

@Component
public class ModuleFieldDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createModuleField(ModuleField moduleField) {
		String query = "insert into modulefield (fieldcode, fieldname, modulecode, fieldtype) values ( ?, ?, ?,?)";
		jdbcTemplate.update(query, IdGenerator.getId(), moduleField.getName(),
				moduleField.getModuleCode(), moduleField.getFieldType());
	}
	
	public void updateAllowedValueCategory(ModuleField moduleField) {
		String query = "update modulefield set fieldcode=?, fieldname=?, modulecode=? where id=?";
		jdbcTemplate.update(query, moduleField.getCode(), moduleField.getName(), moduleField.getModuleCode(),
				moduleField.getId());
	}
	
	public ModuleField searchModuleFieldById(String id) {
		String query = "select * from modulefield where id =?";
		ModuleField moduleField = (ModuleField) jdbcTemplate.queryForObject(query, new Object[]{id}, new ModuleFieldMapper());
		return moduleField;
	}
	
	public List<ModuleField> searchModuleFieldsByModuleCode(String moduleCode) {
		String query = "select * from modulefield where modulecode =?";
		List<ModuleField> moduleFields = jdbcTemplate.query(query, new Object[]{moduleCode}, new ModuleFieldMapper());
		return moduleFields;
	}

}
