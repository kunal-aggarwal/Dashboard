package com.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.to.RefDataType;

public class RefDataTypeMapper implements RowMapper<RefDataType> {
	
	public RefDataType mapRow(ResultSet rs, int rowNum) throws SQLException {
		RefDataType refDataType = new RefDataType();
		refDataType.setId(rs.getInt("id"));
		refDataType.setCode(rs.getString("code"));
		refDataType.setName(rs.getString("name"));
		//allowedValCat.setDeleted(rs.getString("deleted"));
		return refDataType;
	}

}
