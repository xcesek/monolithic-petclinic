package org.springframework.samples.petclinic.management;

import java.time.LocalDate;
import java.util.List;
import org.springframework.samples.petclinic.managementdto.YearlyRevenueDto;

public interface ManagementService {

  List<YearlyRevenueDto> listYearlyRevenue();

  void registerNewRevenue(LocalDate paymentDate, Integer cost);
}
