package com.kriss.spring.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoTemplateImpl {
	
	public static final String DEFAULT_SQL = "SELECT * FROM Circle";
	
	private DataSource dataSource;
	
	private JdbcTemplate template;
	private NamedParameterJdbcTemplate namedTemplate;
	
	public void getCount(String sql) {
		int count = template.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	
	public Circle getCircle(String sql) {
		return template.queryForObject(sql, new Object[] {1}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles(String sql) {
		return template.query(sql, new CircleMapper());
	}
	
	public void insertCircle(Circle circle) {
		String sql = "Insert into Circle values (:id, :name)";
		SqlParameterSource namedParams = new MapSqlParameterSource("id", circle.getId())
												.addValue("name", circle.getName());
		namedTemplate.update(sql, namedParams);
	}
	
	public void getTableData() {
		getTableData(DEFAULT_SQL);
	}
	
	public void getTableData(String sql) {
		List<Map<String, Object>> list = template.queryForList(sql);
		for(Map<String, Object> map : list) {
			System.out.println(map.keySet());
			for(Map.Entry<String, Object> entry : map.entrySet()) {
				System.out.println(entry.getValue());
			}
		}
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
		this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	private static final class CircleMapper implements RowMapper<Circle> {

		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle c = new Circle();
			c.setId(rs.getInt("ID"));
			c.setName(rs.getString("NAME"));
			return c;
		}
		
	}
	
}
