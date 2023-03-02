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
package org.springframework.samples.petclinic.management;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple JavaBean domain object representing a revenue.
 *
 * @author Ken Krebs
 * @author Dave Syer
 */
@Entity
@Table(name = "revenue")
public class Revenue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "payment_date")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate paymentDate;

  @Column
  private Integer cost;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Creates a new instance of {@link Revenue} for the current date
   */
  public Revenue() {
    this.paymentDate = LocalDate.now();
  }

  public LocalDate getPaymentDate() {
    return this.paymentDate;
  }

  public void setPaymentDate(LocalDate date) {
    this.paymentDate = date;
  }


  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }
}
