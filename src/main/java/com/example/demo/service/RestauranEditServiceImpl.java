package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantEditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestauranEditServiceImpl implements RestaurantEditService {
	
	private final RestaurantEditRepository repository;

	@Override
	public Restaurant findById(Integer restaurantId) {
		return repository.findById(restaurantId);
	}

	@Override
	public void update(Restaurant restaurant) {
		repository.update(restaurant);
	}

}
