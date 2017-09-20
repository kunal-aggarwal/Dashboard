package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dao.rowmapper.RefDataTypeMapper;
import com.to.RefDataType;
import com.util.IdGenerator;

@Component
public class RefDataTypeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createRefDatatype(RefDataType refDatatype) {
		String query = "insert into refDatatype (code, name) values ( ?, ?)";
		jdbcTemplate.update(query, IdGenerator.getId(), refDatatype.getName());
	}
	
	public List<RefDataType> searchRefDataTypeCategories() {
		String query = "select * from refDatatype";
		List<RefDataType> allowedValueCatList = jdbcTemplate.query(query, new RefDataTypeMapper());
		return allowedValueCatList;
	}
	
	public RefDataType searchRefDataTypeByCategory(String category) {
		String query = "select * from refDatatype where code=?";
		RefDataType allowedValueCat = (RefDataType)jdbcTemplate.queryForObject(query, new Object[]{category}, new RefDataTypeMapper());
		return allowedValueCat;
	}

}
