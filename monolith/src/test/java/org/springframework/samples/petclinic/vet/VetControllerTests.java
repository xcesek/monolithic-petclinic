/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.vet;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class VetControllerTests {

    @Autowired
    MockMvc mockMvc;

    private final WireMockServer wireMock = new WireMockServer(options().port(8089));

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }


    @Test
    void testShowVetListHtml() throws Exception {
        wireMock.stubFor(WireMock.get(urlEqualTo("/api/vets"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody("[\n" +
                    "    {\n" +
                    "        \"id\": 1,\n" +
                    "        \"firstName\": \"James\",\n" +
                    "        \"lastName\": \"Carter\",\n" +
                    "        \"specialties\": []\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"id\": 2,\n" +
                    "        \"firstName\": \"Helen\",\n" +
                    "        \"lastName\": \"Leary\",\n" +
                    "        \"specialties\": [\n" +
                    "            {\n" +
                    "                \"id\": 1,\n" +
                    "                \"name\": \"radiology\"\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    }]")));

        mockMvc.perform(get("/vets"))
            .andExpect(status().isOk())
            .andExpect(xpath("//table[@id='vets']").exists())
            .andExpect(xpath("//table[@id='vets']/tbody/tr").nodeCount(2))
            .andExpect(xpath("//table[@id='vets']/tbody/tr[position()=1]/td[position()=1]").string("James Carter"))
            .andExpect(xpath("//table[@id='vets']/tbody/tr[position()=1]/td[position()=2]/span").string("none"))
            .andExpect(xpath("//table[@id='vets']/tbody/tr[position()=2]/td[position()=1]").string("Helen Leary"))
            .andExpect(xpath("//table[@id='vets']/tbody/tr[position()=2]/td[position()=2]/span").string("radiology "))
        ;
    }

}
