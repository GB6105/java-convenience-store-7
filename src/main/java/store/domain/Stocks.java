package store.domain;

import java.util.ArrayList;
import java.util.List;

public class Stocks {
    private List<Stock> stocks;

    public Stocks() {
        stocks = new ArrayList<>();
    }

    public void add(Stock stock){
        stocks.add(stock);
    }

    public void getStocks(){
        for(Stock stock : stocks){
            System.out.println(stock.getName()+ " " + stock.getQuantity() + " " + stock.getPrice() + " " + stock.getPromotion());
        }
    }

    public boolean find(String name){
        for(Stock stock : stocks){
            if(stock.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean checkQuantity(String name, int quantity){
        for(Stock stock : stocks){
            if(stock.getName().equals(name) && stock.getQuantity() >= quantity){
                return true;
            }
        }
        return false;
    }
}
