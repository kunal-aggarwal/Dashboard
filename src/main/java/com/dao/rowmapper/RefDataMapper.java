package com.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.to.RefData;

public class RefDataMapper implements RowMapper<RefData> {
	
	public RefData mapRow(ResultSet rs, int rowNum) throws SQLException {
		RefData allowedVal = new RefData();
		allowedVal.setId(rs.getInt("id"));
		allowedVal.setCode(rs.getString("code"));
		allowedVal.setName(rs.getString("name"));
		allowedVal.setCategory(rs.getString("category"));
		return allowedVal;
	}

}
