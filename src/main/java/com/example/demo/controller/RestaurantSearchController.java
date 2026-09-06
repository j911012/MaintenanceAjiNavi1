package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.RestaurantListDto;
import com.example.demo.form.RestaurantSearchForm;

@Controller
public class RestaurantSearchController {
	
	// 検索画面表示（初期表示）
	@GetMapping("/shop/search")
	public String showSearchForm(@ModelAttribute RestaurantSearchForm form) {
		return "search-form";
	}
	
	// 検索実行（ダミー）
	@PostMapping("/shop/search/result")
	public String search(@ModelAttribute RestaurantSearchForm form, Model model) {
		
		List<RestaurantListDto> list = new ArrayList<RestaurantListDto>();
		
		RestaurantListDto r1 = new RestaurantListDto();
		r1.setRestaurantId(1);
		r1.setRestaurantName("ラーメン太郎");
		r1.setCatchPhrase("背脂こってり系");
		r1.setReviewCount(5);
		list.add(r1);
		
		RestaurantListDto r2 = new RestaurantListDto();
		r2.setRestaurantId(2);
		r2.setRestaurantName("寿司花子");
		r2.setCatchPhrase("新鮮なネタが自慢");
		r2.setReviewCount(2);
		list.add(r2);
		
		model.addAttribute("restaurantList", list);
		
		return "search-result";
	}

}
