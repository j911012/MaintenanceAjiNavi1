package com.example.demo.repository;

import com.example.demo.entity.Restaurant;

public interface RestaurantEditRepository {
	Restaurant findById(Integer restaurantId);
	void update(Restaurant restaurant);
}
