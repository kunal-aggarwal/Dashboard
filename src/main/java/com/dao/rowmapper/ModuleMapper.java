package com.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.to.Module;

public class ModuleMapper implements RowMapper<Module> {
	
	public Module mapRow(ResultSet rs, int rowNum) throws SQLException {
		Module module = new Module();
		module.setId(rs.getInt("id"));
		module.setCode(rs.getString("code"));
		module.setName(rs.getString("name"));
		return module;
	}

}
