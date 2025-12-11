package store.domain;

import java.time.LocalDate;

public class Promotion {
    private String name;
    private int buyCondition;
    private int getCondition;
    private LocalDate startDate;
    private LocalDate endDate;

    public Promotion(String name, int buyCondition, int getCondition, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.buyCondition = buyCondition;
        this.getCondition = getCondition;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
