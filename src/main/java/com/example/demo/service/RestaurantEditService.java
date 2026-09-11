package com.example.demo.service;

import com.example.demo.entity.Restaurant;

public interface RestaurantEditService {
	Restaurant findById(Integer restaurantId);
	void update(Restaurant restaurant);
}
