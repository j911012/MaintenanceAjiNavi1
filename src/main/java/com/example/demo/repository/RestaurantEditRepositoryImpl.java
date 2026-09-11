package com.example.demo.repository;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Restaurant;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantEditRepositoryImpl implements RestaurantEditRepository {
	private final JdbcTemplate jdbcTemplate;

	@Override
	public Restaurant findById(Integer restaurantId) {

		String sql = "SELECT restaurant_id, restaurant_name, catch_phrase" +
				" FROM m_restaurant" +
				" WHERE restaurant_id = ?";

		Map<String, Object> row = jdbcTemplate.queryForMap(sql, restaurantId);

		Restaurant r = new Restaurant();
		r.setRestaurantId((Integer) row.get("restaurant_id"));
		r.setRestaurantName((String) row.get("restaurant_name"));
		r.setCatchPhrase((String) row.get("catch_phrase"));

		return r;
	}

	@Override
	public void update(Restaurant restaurant) {

		String sql = "UPDATE m_restaurant" + " SET restaurant_name = ?, catch_phrase = ?" + " WHERE restaurant_id = ?";

		jdbcTemplate.update(sql,
				restaurant.getRestaurantName(),
				restaurant.getCatchPhrase(),
				restaurant.getRestaurantId());

	}

}
