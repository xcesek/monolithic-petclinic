package org.springframework.samples.petclinic.management;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.samples.petclinic.managementdto.YearlyRevenueDto;
import org.springframework.stereotype.Component;

@Component
public class ManagementEventListener {

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void processMessage(YearlyRevenueDto yearlyRevenue) {
        System.out.println(yearlyRevenue);

        // TODO
    }


}
