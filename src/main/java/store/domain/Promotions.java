package store.domain;

import java.util.ArrayList;
import java.util.List;

public class Promotions {
    private List<Promotion> promotions;
    public Promotions() {
        promotions = new ArrayList<>();
    }

    public void add(Promotion promotion) {
        promotions.add(promotion);
    }

    public void getPromotions() {
        for (Promotion promotion : promotions) {
            System.out.println(promotion);
        }
    }
}
