package com.poetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.service.GetRecommendService;

@RestController
@RequestMapping("/recommendAction")
public class GetRecommendControl {

	@Autowired GetRecommendService getRecommendService;
}
