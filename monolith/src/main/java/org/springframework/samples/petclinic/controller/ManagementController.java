package org.springframework.samples.petclinic.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.management.ManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    @GetMapping("/management/revenue")
    public String showRevenue(Map<String, Object> model) {
        model.put("revenues", managementService.listYearlyRevenue());
        return "management/showRevenue";
    }

}
