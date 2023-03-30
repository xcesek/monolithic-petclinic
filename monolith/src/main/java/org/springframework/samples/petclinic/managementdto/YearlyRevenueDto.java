package org.springframework.samples.petclinic.managementdto;

import java.io.Serializable;

public class YearlyRevenueDto implements Serializable {

    private Integer year;
    private Long total;

    public YearlyRevenueDto() {
    }

    public YearlyRevenueDto(Integer year, Long total) {
        this.year = year;
        this.total = total;
    }

    public Integer getYear() {
        return year;
    }

    public Long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "YearlyRevenue{" +
            "year=" + year +
            ", total=" + total +
            '}';
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
