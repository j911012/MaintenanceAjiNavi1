package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.ShopRegistForm;
import com.example.demo.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistController {
	private final RestaurantService service;
	
	// 登録画面表示
	@GetMapping("/shop/regist")
	public String showRegistForm(@ModelAttribute ShopRegistForm form) {
		return "regist";
	}
	
	// 確認画面表示
	@PostMapping("/shop/regist/confirm")
	public String confirm(@Validated @ModelAttribute ShopRegistForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return "regist";
		}
		
		return "confirm";
	}
	
	// 登録実行
	@PostMapping("/shop/regist/complete")
	public String complete(@Validated @ModelAttribute ShopRegistForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return "regist";
		}
		
		Restaurant r = new Restaurant();
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());
		
		service.regist(r);
		
		return "redirect:/shop/regist/result";
	}
	
	// 完了画面表示
	@GetMapping("/shop/regist/result")
	public String result() {
		return "complete";
	}
}
