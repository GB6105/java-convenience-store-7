package store;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import store.domain.Promotions;
import store.domain.Stock;
import store.domain.Stocks;
import store.file.PromotionReader;
import store.file.StockReader;
import store.message.ErrorMessage;
import store.view.InputView;
import store.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true){
            StockReader stockReader = new StockReader();
            PromotionReader promotionReader = new PromotionReader();

            Stocks stocks = stockReader.readFile();
            Promotions promotions = promotionReader.readPromotion();

            InputView inputView = new InputView(stocks);
            OutputView outputView = new OutputView();
            ErrorMessage errorMessage = new ErrorMessage();

            // 물품 목록을 stock으로 저장

            Map<String, Integer> itemMap = inputView.readItem();
            Iterator<Entry<String, Integer>> iterator = itemMap.entrySet().iterator();
            while(iterator.hasNext()){
                Entry<String, Integer> entry = iterator.next();
                String name= entry.getKey();
                int quantity= entry.getValue();

                List<Stock> searchResult;

            }

            String selectMembership = inputView.chooseMembership();



            // 구매를 계속할지 끝낼지 입력
            boolean continueProcessing = true;
            while(continueProcessing){
                String continueBuying = inputView.continueBuying();
                if(continueBuying.equals("Y")){
                    continueProcessing = false;
                }else if(continueBuying.equals("N")){
                    return;
                }else{
                    System.out.println(ErrorMessage.WRONG_SELECTION_INPUT);
                }
            }
        }
    }
}
