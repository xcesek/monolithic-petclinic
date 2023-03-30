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
package org.springframework.samples.petclinic.controller;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.managementdto.ManagementClient;
import org.springframework.samples.petclinic.managementdto.YearlyRevenueDto;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ManagementController.class)
class ManagementControllerTests {

  static final List<YearlyRevenueDto> EXPECTED_REVENUES = asList(
      new YearlyRevenueDto(2020, 333L)
  );

  @Autowired
  MockMvc mockMvc;

  @MockBean
  ManagementClient managementClient;

  @BeforeEach
  void setup() {
    given(this.managementClient.listYearlyRevenue()).willReturn(EXPECTED_REVENUES);
  }

  @Test
  void testShowRevenueHtml() throws Exception {
    mockMvc.perform(get("/management/revenue")) //
        .andExpect(status().isOk()) //
        .andExpect(model().attribute("revenues", EXPECTED_REVENUES)) //
        .andExpect(view().name("management/showRevenue"));
  }

}
