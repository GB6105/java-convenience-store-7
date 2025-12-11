package store.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import store.domain.Stock;
import store.domain.Stocks;

public class StockReader {
    public Stocks readFile() {
        Stocks stocks = new Stocks();
        try {
            String fileName = "src/main/resources/products.md";
            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);

            String skip = br.readLine(); // 첫줄 skip
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
//                System.out.println(line); 디버깅 코드
                String[] input = line.split(",");
                String name = input[0];
                double price = Double.parseDouble(input[1]);
                int quantity = Integer.parseInt(input[2]);
                String promotion = input[3];
                Stock stock = new Stock(name, price, quantity,promotion);
                stocks.add(stock);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("물품 목록을 불러올 수 없습니다.");
            e.printStackTrace();
        }
        return stocks;
    }
}
