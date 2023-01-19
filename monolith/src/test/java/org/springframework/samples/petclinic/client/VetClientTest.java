package org.springframework.samples.petclinic.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.vetdto.VetDto;

import java.util.Collection;
import java.util.List;
import org.springframework.test.context.ActiveProfiles;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class VetClientTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8089));

    @Autowired
    private VetClient vetClient;

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void test_get_vets() {
        wireMock.stubFor(get(urlEqualTo("/api/vets"))
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

        Collection<VetDto> result = vetClient.allVets();

        assertThat(result).hasSize(2);
    }
}
