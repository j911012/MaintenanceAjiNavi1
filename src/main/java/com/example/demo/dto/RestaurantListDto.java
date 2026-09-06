package com.example.demo.dto;

import lombok.Data;

@Data
public class RestaurantListDto {
	private Integer restaurantId;
	private String restaurantName;
	private String catchPhrase;
	private int reviewCount;
}
