package org.springframework.samples.petclinic.management;

import org.springframework.samples.petclinic.managementdto.YearlyRevenueDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ManagementApi {

    ManagementService managementService;

    public ManagementApi(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping(value = "/yearly-revenues", produces = "application/json")
    public List<YearlyRevenueDto> getYearlyRevenues() {
        return managementService.listYearlyRevenue();
    }

}
