package com.example.user_view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.user_view.dto.DashboardDTO;
import com.example.user_view.service.UserViewService;

public class UserViewController {

    @Autowired
    private UserViewService userViewService;

    @GetMapping("/dashboard")
    public DashboardDTO getDashboard() {
        return userViewService.getDashboardDTO();
    }
}
