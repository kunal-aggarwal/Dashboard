package com.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.to.ModuleData;
import com.to.ModuleField;
import com.util.Util;

public class ModuleDataMapper implements RowMapper<ModuleData> {
	
	public ModuleData mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModuleData moduleEmployeeData = new ModuleData();
		moduleEmployeeData.setId(rs.getInt("id"));
		moduleEmployeeData.setFieldCode(rs.getString("fieldcode"));
		moduleEmployeeData.setFieldValue(rs.getString("fieldValue"));
		moduleEmployeeData.setModuleCode(rs.getString("modulecode"));
		moduleEmployeeData.setRowId(rs.getInt("modulerowid"));
		return moduleEmployeeData;
	}

}
