package org.springframework.samples.petclinic.management;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.samples.petclinic.managementdto.YearlyRevenueDto;
import org.springframework.stereotype.Service;

@Service
public class ManagementServiceLocal implements ManagementService {

  private final RevenueRepository revenueRepository;

  public ManagementServiceLocal(RevenueRepository revenueRepository) {
    this.revenueRepository = revenueRepository;
  }

  @Override
  public List<YearlyRevenueDto> listYearlyRevenue() {
    return revenueRepository.listYearlyRevenue().stream()
        .map(r -> new YearlyRevenueDto(r.getYear(), r.getTotal()))
        .collect(Collectors.toList());
  }
}
