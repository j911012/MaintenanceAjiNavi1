package com.example.demo.repository;

import java.util.List;

import com.example.demo.dto.RestaurantListDto;

public interface RestaurantSearchRepository {
	List<RestaurantListDto> search(String restaurantName);
}
