package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RestaurantListDto;

public interface RestaurantSearchService {
	List<RestaurantListDto> search(String restaurantName);
}
