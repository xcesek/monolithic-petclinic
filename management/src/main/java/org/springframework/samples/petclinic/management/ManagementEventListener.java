package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class ManagementEventListener {

    @Autowired
    private ManagementService managementService;

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void processMessage(Map<String, Object> message) {
        final LocalDate paymentDate = LocalDate.ofEpochDay((Long)message.get("paymentDate"));
        final Integer cost = (Integer) message.get("cost");

        managementService.registerNewRevenue(paymentDate, cost);
    }


}
