package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.RestaurantListDto;
import com.example.demo.form.RestaurantSearchForm;
import com.example.demo.service.RestaurantSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantSearchController {
	
	private final RestaurantSearchService service;
	
	// 検索画面表示（初期表示）
	@GetMapping("/shop/search")
	public String showSearchForm(@ModelAttribute RestaurantSearchForm form) {
		return "search-form";
	}
	
	// 検索実行
	@PostMapping("/shop/search/result")
	public String search(@ModelAttribute RestaurantSearchForm form, Model model) {
		
		List<RestaurantListDto> list = service.search(form.getRestaurantName());
		
		model.addAttribute("restaurantList", list);
		
		return "search-result";
	}

}
