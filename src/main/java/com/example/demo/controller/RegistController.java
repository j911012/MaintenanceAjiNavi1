package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ShopRegistForm;

@Controller
public class RegistController {
	
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
}
