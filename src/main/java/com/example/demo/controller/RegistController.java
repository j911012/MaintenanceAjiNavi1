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
	
	// 登録実行
	@PostMapping("/shop/regist/complete")
	public String complete(@Validated @ModelAttribute ShopRegistForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return "regist";
		}
		
		/*
		 * 後でService/Repositoryを呼び出してDB登録する
		 */
		
		return "redirect:/shop/regist/result";
	}
	
	// 完了画面表示
	@GetMapping("/shop/regist/result")
	public String result() {
		return "complete";
	}
}
