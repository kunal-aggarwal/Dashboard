package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dao.rowmapper.ModuleDataMapper;
import com.to.ModuleData;

@Component
public class ModuleDataDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createModuleData(ModuleData moduleData) {
		String query = "insert into moduledata (fieldcode, fieldvalue, modulerowid, modulecode) values ( ?, ?, ?,?)";
		jdbcTemplate.update(query, moduleData.getFieldCode(), moduleData.getFieldValue(),
				moduleData.getRowId(), moduleData.getModuleCode());
	}
	
	public void updateModuleData(ModuleData moduleData) {
		int modulerowid = moduleData.getRowId();
		String moduleCode = moduleData.getModuleCode();
		String fieldCode = moduleData.getFieldCode();
		String fieldValue = searchModuleData(modulerowid, moduleCode, fieldCode);
		if (fieldValue == null) {
			createModuleData(moduleData);
		} else {
			String query = "update moduledata set fieldvalue=?  where modulecode=? and modulerowid=? and fieldcode=?";
			jdbcTemplate.update(query, moduleData.getFieldValue(), moduleData.getModuleCode(),
					moduleData.getRowId(), moduleData.getFieldCode());
		}
	}
	
	public ModuleData searchModuleData(int modulerowid, int moduleId) {
		String query = "select * from moduledata where modulerowid =? and modulecode=?";
		ModuleData moduleData = (ModuleData) jdbcTemplate.queryForObject(
				query, new Object[]{modulerowid, moduleId}, new ModuleDataMapper());
		return moduleData;
	}
	
	public List<ModuleData> searchModuleDataByModuleId(String moduleCode) {
		String query = "select * from moduledata where modulecode =? order by modulecode,modulerowid, fieldcode";
		List<ModuleData> moduleDatalist = jdbcTemplate.query(query, new Object[]{moduleCode}, new ModuleDataMapper());
		return moduleDatalist;
	}
	
	public int getNextRowIdForModule(String moduleCode) {
		String query = "select max(modulerowid) from moduledata where modulecode =?";
		Integer maxRow = jdbcTemplate.queryForObject(query, new Object[]{moduleCode}, Integer.class);
		return maxRow == null ? 1 : maxRow+1;
	}
	
	public String searchModuleData(int modulerowid, String moduleCode, String fieldCode) {
		String query = "select fieldvalue from moduledata where modulerowid =? and modulecode=? and fieldCode=?";
		try{
		String fieldValue = (String) jdbcTemplate.queryForObject(
				query, new Object[]{modulerowid, moduleCode, fieldCode}, String.class);
		return fieldValue;
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
