package com.pluralsight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.model.Share;
import com.pluralsight.service.ExerciseService;
import com.pluralsight.service.ShareService;


@Controller
public class MinutesController {

	@Autowired
	private ExerciseService exerciseService;
	@Autowired
	private ShareService shareService;
	
//	@RequestMapping(value = "/addMinutes",  method = RequestMethod.GET)
//	public String getMinutes(@ModelAttribute ("exercise") Exercise exercise) {
//	
//		return "addMinutes";
//	}
//	
//	@RequestMapping(value = "/addMinutes",  method = RequestMethod.POST)
//	public String addMinutes(@Valid @ModelAttribute ("exercise") Exercise exercise, BindingResult result) {
//		
//		System.out.println("exercise: " + exercise.getMinutes());
//		System.out.println("exercise activity: " + exercise.getActivity());
//		
//		if(result.hasErrors()) {
//			return "addMinutes";
//		}
//		
//		return "addMinutes";
//	}

	@RequestMapping(value = "/addMinutes",  method = RequestMethod.GET)
	public String getMinutes(@ModelAttribute ("share") Share share) {
	
		return "addMinutes";
	}
	
	@RequestMapping(value = "/addMinutes",  method = RequestMethod.POST)
	public String addMinutes(@Valid @ModelAttribute ("share") Share share, BindingResult result) {
		
		System.out.println("share: " + share.getName());
//		System.out.println("exercise activity: " + exercise.getActivity());
		
		if(result.hasErrors()) {
			return "addMinutes";
		}
		
		return "addMinutes";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}
	
	@RequestMapping(value = "/shares", method = RequestMethod.GET)
	public @ResponseBody List<Share> findAllShares() {
		return shareService.findAllShares();
	}
	
}
