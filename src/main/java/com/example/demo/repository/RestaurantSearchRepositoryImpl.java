package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.RestaurantListDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantSearchRepositoryImpl implements RestaurantSearchRepository {
	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<RestaurantListDto> search(String restaurantName) {
		String sql = "	SELECT										" +
				"		mr.restaurant_id,							" +
				"		mr.restaurant_name,							" +
				"		mr.catch_phrase,							" +
				"		COUNT(tr.review_id) AS review_count		" +
				"	FROM											" +
				"		m_restaurant mr								" +
				"		LEFT OUTER JOIN t_review tr					" +
				"			ON mr.restaurant_id = tr.restaurant_id	" +
				"	WHERE											" +
				"		mr.restaurant_name LIKE ?					" +
				"	GROUP BY										" +
				"		mr.restaurant_id, 							" +
				"		mr.restaurant_name,							" +
				"		mr.catch_phrase								";
		
		String p = "%" + restaurantName + "%";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, p);
		
		List<RestaurantListDto> list = new ArrayList<RestaurantListDto>();
		
		for(Map<String, Object> row : rows) {
			RestaurantListDto dto = new RestaurantListDto();
			dto.setRestaurantId((Integer) row.get("restaurant_id"));
			dto.setRestaurantName((String) row.get("restaurant_name"));
			dto.setCatchPhrase((String) row.get("catch_phrase"));
			dto.setReviewCount(((Long) row.get("review_count")).intValue());
			
			list.add(dto);
		}
		
		return list;
	}

}
