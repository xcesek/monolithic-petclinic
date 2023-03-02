package org.springframework.samples.petclinic.management;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ManagementService {

    private final RevenueRepository revenueRepository;

    public ManagementService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<YearlyRevenue> listYearlyRevenue() {
        return revenueRepository.listYearlyRevenue();
    }
}
