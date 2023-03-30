package org.springframework.samples.petclinic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ManagementEventListener {

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void processMessage(String content) {
        System.out.println(content);

        // TODO
    }


}
