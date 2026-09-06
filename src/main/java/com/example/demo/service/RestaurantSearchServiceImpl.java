package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RestaurantListDto;
import com.example.demo.repository.RestaurantSearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantSearchServiceImpl implements RestaurantSearchService {
	private final RestaurantSearchRepository repository;

	@Override
	public List<RestaurantListDto> search(String restaurantName) {
		return repository.search(restaurantName);
	}

}
