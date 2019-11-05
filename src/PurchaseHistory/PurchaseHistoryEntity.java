package PurchaseHistory;

//create composite entity --PurchaseHistoryEntity
public class PurchaseHistoryEntity {

    PurchaseHistoryObject purchaseHistory = new PurchaseHistoryObject();

    //get purchase history
    public String[] getPurchaseHistory(){
       return purchaseHistory.getPurchaseHistory();
    }

    //set purchase history
    public void setPurchaseHistory(String consumerName,String goodsName, String goodsNum){
        purchaseHistory.setPurchaseHistory(consumerName, goodsName, goodsNum);
    }
}
