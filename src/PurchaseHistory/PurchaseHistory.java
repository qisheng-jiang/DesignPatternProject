package PurchaseHistory;

import java.util.ArrayList;
import java.util.List;

//Create a client class that uses the composite entity.
public class PurchaseHistory {

    //a list to store purchase history
    private static List<PurchaseHistoryEntity> purchaseHistoryEntityList = new ArrayList<>();

    //set the purchase history's consumerName, goodsName, purchaseNum
    public static void setPurchaseHistory(String consumerName, String goodsName, String purchaseNum){

        PurchaseHistoryEntity purchaseHistoryEntity =new PurchaseHistoryEntity();
        purchaseHistoryEntity.setPurchaseHistory(consumerName, goodsName, purchaseNum);
        purchaseHistoryEntityList.add(purchaseHistoryEntity);

    }

    //show the shop's purchase history list
    public static void getPurchaseHistory(){

        //no purchase history
        if(purchaseHistoryEntityList.isEmpty()){
            System.out.println("No purchase history.");
            return;
        }
        for(PurchaseHistoryEntity purchaseHistoryEntity : purchaseHistoryEntityList){

            System.out.println(purchaseHistoryEntity.getPurchaseHistory()[0]+
                    " bought "+ purchaseHistoryEntity.getPurchaseHistory()[2]+
                    " "+purchaseHistoryEntity.getPurchaseHistory()[1]);

        }
    }
}
