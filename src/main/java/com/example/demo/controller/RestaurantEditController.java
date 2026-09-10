package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ShopEditForm;

@Controller
public class RestaurantEditController {
	
	@GetMapping("/shop/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id , Model model) {
		
		// ダミー
		ShopEditForm form = new ShopEditForm();
		form.setRestaurantId(id);
		form.setRestaurantName("hoge");
		form.setCatchPhrase("hogehogeのキャッチフレーズ");
		
		model.addAttribute("shopEditForm", form);
		
		return "edit";
	}
	
	@PostMapping("/shop/edit/confirm")
	public String confirm(@Validated @ModelAttribute ShopEditForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit";
		}
		
		return "edit-confirm";
	}
	
	@PostMapping("/shop/edit/complete")
	public String complete(@Validated @ModelAttribute ShopEditForm form, BindingResult result) {
		
		if(result.hasErrors() ) {
			return "edit";
		}
		
		// ダミー：本来はServiceでUPDATEする
		System.out.println("---店舗更新---");
		System.out.println(form);
		
		return "redirect:/shop/edit/result";
	}
	
	@GetMapping("/shop/edit/result")
	public String result() {
		return "complete";
	}

}
