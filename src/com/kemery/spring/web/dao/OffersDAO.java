package com.kemery.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {

//	private NamedParameterJdbcTemplate jdbc;
	private JdbcTemplate jdbc;

	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc); //new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {

		// MapSqlParameterSource params = new MapSqlParameterSource("name",
		// "Ellen");

		return jdbc.query("select * from offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("email"));
				offer.setEmail(rs.getString("text"));
				return offer;
			}
		});
	}

	public boolean create(Offer offer) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("INSERT INTO offers (name, email, text) VALUES (:name, :email, :text)", params) == 1;

	}
	
	
	// @Transactional The transactional annotation adds an all or none property to the method
	public int[] create(List<Offer> offers) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return jdbc.batchUpdate("INSERT INTO offers (id, name, email, text) VALUES (:id, :name, :email, :text)", params);
		
	}
	

	public int delete(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("DELETE FROM offers where id = :id", params);
	}
	

	public Offer getOffer(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));

				return offer;
			}

		});

	}
	
	
	public boolean update(Offer offer) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("UPDATE offers SET name = :name, email = :email, text = :text WHERE id = :id", params) == 1;
	}
}
