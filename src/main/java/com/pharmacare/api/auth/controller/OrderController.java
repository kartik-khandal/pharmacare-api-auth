package com.pharmacare.api.auth.controller;

import com.pharmacare.api.auth.response.ResponseData;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Example REST resource protected by a role-based method authorization rule. */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping
    // Method security checks the authenticated user's authority before the controller runs.
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseData<String> getOrders() {
        return new ResponseData<>(true, "Orders list", "Orders retrieved successfully");
    }
}
