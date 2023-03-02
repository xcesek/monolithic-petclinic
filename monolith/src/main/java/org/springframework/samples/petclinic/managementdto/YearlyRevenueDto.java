package org.springframework.samples.petclinic.managementdto;

public class YearlyRevenueDto {

    private Integer year;
    private Long total;

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
}
