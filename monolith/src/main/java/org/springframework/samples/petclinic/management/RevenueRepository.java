package org.springframework.samples.petclinic.management;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Query reports of revenue.
 */
public interface RevenueRepository extends Repository<Revenue, Integer> {

  @Query(
      "Select new org.springframework.samples.petclinic.management.YearlyRevenue(YEAR(r.paymentDate), sum(r.cost)) "
          + "from Revenue r " +
          "group by YEAR(r.paymentDate)")
  List<YearlyRevenue> listYearlyRevenue();

}
