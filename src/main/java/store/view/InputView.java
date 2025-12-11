package store.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import store.domain.Stocks;
import store.message.ErrorMessage;

public class InputView {
    private static String REQUIRE_PRODUCT_AND_QUANTITY= "구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])";
    private static String MEMBERSHIP_CHOOSE = "멤버십 할인을 받으시겠습니까? (y/n)";
    private Stocks stocks;
    // TODO
    // stocks 대신 List<Stock> 사용하기

    public InputView(Stocks stocks) {
        this.stocks = stocks;
    }

    // 구매 상품 수량 입력
    public Map<String,Integer> readItem(){
        System.out.println(REQUIRE_PRODUCT_AND_QUANTITY);
        String input = Console.readLine();
        String[] items = input.split(",");

        // 이 부분 취약
        Map<String,Integer> map = new HashMap<>();

        for(String item : items){
            String cleanItem = item.replace("[","").replace("]","");
            String[] parts = cleanItem.split("-");
            String name = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            // 형식 오류

            // 존재 하지 않는 상품
            if(!stocks.find(name)){
                throw new IllegalArgumentException();
            }
            // 구매 수량 재고 초과
            boolean isEnough = stocks.checkQuantity(name, quantity);
            if(!isEnough){
                throw new IllegalArgumentException();
            }
            // 기타 잘못된 입력

            map.put(parts[0],Integer.parseInt(parts[1]));
        }
        return map;
    }

    public String addPromotionQuantity(String productName, int getQuantity){
        System.out.println("현재 " + productName + "은(는) " + getQuantity + "개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)");
        String input = validateInput();
        return input;
    }

    public String payOriginalPrice(String productName, int remainQuantity){
        System.out.println("현재 " + productName + " " + remainQuantity + "개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)" );
        String input = validateInput();
        return input;
    }

    public String chooseMembership(){
        System.out.println(MEMBERSHIP_CHOOSE);
        String input = validateInput();
        return input;
    }

    public String continueBuying(){
        System.out.println("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)");
        String input = validateInput();
        return input;
    }

    //이 부분 취약
    public String validateInput(){
        while(true){
            try{
                String input = Console.readLine();
                checkInput(input);
                return input;

            }catch(IllegalArgumentException e){
                System.out.println(ErrorMessage.WRONG_SELECTION_INPUT);
            }
        }
    }

    public void checkInput(String input){
        if(!input.equals("Y") && !input.equals("N")){
            throw new IllegalArgumentException();
        }
    }
}
