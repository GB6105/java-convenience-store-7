package store.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import store.domain.Promotion;
import store.domain.Promotions;

public class PromotionReader {
    public Promotions readPromotion() {
        Promotions promotions = new Promotions();
        try{
            String fileName = "src/main/resources/promotions.md";
            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);

            String skip = br.readLine();
            while(true){
                String line = br.readLine();
                if(line == null){
                    break;
                }
                String[] input = line.split(",");
                String name = input[0];
                int buyCondition = Integer.parseInt(input[1]);
                int getCondition = Integer.parseInt(input[2]);
                LocalDate startDate = LocalDate.parse(input[3]);
                LocalDate endDate = LocalDate.parse(input[4]);
                Promotion promotion = new Promotion(name, buyCondition, getCondition, startDate, endDate);
                promotions.add(promotion);
            }

        }catch(IOException e){
            System.out.println("프로모션 목록을 불러올 수 없습니다.");
            e.printStackTrace();
        }
        return promotions;
    }
}
