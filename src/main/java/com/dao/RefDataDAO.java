package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dao.rowmapper.RefDataMapper;
import com.to.RefData;

@Component
public class RefDataDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createRefData(RefData allowedValue) {
		String query = "insert into refdata (code, name, category) values ( ?, ?, ?)";
		jdbcTemplate.update(query, allowedValue.getCode(), allowedValue.getName(), allowedValue.getCategory());
	}
	
	public List<RefData> searchRefData() {
		String query = "select * from refdata";
		return (List<RefData>) jdbcTemplate.query(query, new RefDataMapper());
	}
	
	public List<RefData> searchRefDataByCategorye(String category) {
		String query = "select * from refdata where category =?";
		List<RefData> refData = (List<RefData>) jdbcTemplate.query(query, new Object[]{category}, new RefDataMapper());
		return refData;
	}
}
