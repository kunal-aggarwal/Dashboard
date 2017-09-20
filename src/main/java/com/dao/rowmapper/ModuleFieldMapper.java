package com.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.to.ModuleField;
import com.util.Util;

public class ModuleFieldMapper implements RowMapper<ModuleField> {
	
	public ModuleField mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModuleField moduleField = new ModuleField();
		moduleField.setId(rs.getInt("id"));
		moduleField.setCode(rs.getString("fieldcode"));
		moduleField.setModuleCode(rs.getString("moduleCode"));
		moduleField.setName(rs.getString("fieldname"));
		moduleField.setFieldType(rs.getString("fieldType"));
		moduleField.setDeleted(Util.isYes(rs.getString("deleted")));
		return moduleField;
	}

}
