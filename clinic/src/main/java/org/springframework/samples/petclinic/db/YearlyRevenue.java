package org.springframework.samples.petclinic.db;

public class YearlyRevenue {

    private Integer year;
    private Long cost;

    public YearlyRevenue(Integer year, Long cost) {
        this.year = year;
        this.cost = cost;
    }

    public Integer getYear() {
        return year;
    }

    public Long getCost() {
        return cost;
    }

    @Override public String toString() {
        return "YearlyRevenue{" +
            "year=" + year +
            ", cost=" + cost +
            '}';
    }
}
