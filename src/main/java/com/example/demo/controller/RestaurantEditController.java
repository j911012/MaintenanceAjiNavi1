package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.ShopEditForm;
import com.example.demo.service.RestaurantEditService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantEditController {
	
	private final RestaurantEditService service;
	
	@GetMapping("/shop/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id , Model model) {
		
		Restaurant restaurant = service.findById(id);
		
		ShopEditForm form = new ShopEditForm();
		form.setRestaurantId(restaurant.getRestaurantId());
		form.setRestaurantName(restaurant.getRestaurantName());
		form.setCatchPhrase(restaurant.getCatchPhrase());
		
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
		
		Restaurant r = new Restaurant();
		r.setRestaurantId(form.getRestaurantId());
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());
		
		service.update(r);
		
		return "redirect:/shop/edit/result";
	}
	
	@GetMapping("/shop/edit/result")
	public String result() {
		return "complete";
	}

}
