package org.springframework.samples.petclinic.management;

import java.util.List;
import org.springframework.samples.petclinic.managementdto.YearlyRevenueDto;

public interface ManagementService {

  List<YearlyRevenueDto> listYearlyRevenue();
}
