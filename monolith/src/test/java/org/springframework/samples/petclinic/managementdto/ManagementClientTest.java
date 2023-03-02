package org.springframework.samples.petclinic.managementdto;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.github.tomakehurst.wiremock.WireMockServer;

@SpringBootTest
@ActiveProfiles("test")
class ManagementClientTest {
    private final WireMockServer wireMock = new WireMockServer(options().port(8089));

    @Autowired
    private ManagementClient managementClient;

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void test_get_yearly_revenues() {
        wireMock.stubFor(get(urlEqualTo("/api/yearly-revenue")).willReturn(aResponse().withHeader("Content-Type",
                "application/json")
                .withBody("[\n" + "    {\n" + "        \"year\": 2023,\n" + "        \"cost\": 650\n" + "    }]")));

        Collection<YearlyRevenueDto> result = managementClient.listYearlyRevenue();

        assertThat(result).hasSize(1);
    }
}
