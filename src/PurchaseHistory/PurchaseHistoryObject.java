package PurchaseHistory;

//create CoarseGrainedObject --purchase history object
public class PurchaseHistoryObject {

    Consumer consumer =new Consumer();
    Goods goods = new Goods();

    //get purchase history
    public String[] getPurchaseHistory(){
        return new String[] {consumer.getConsumerName(),goods.getGoodsName(),goods.getPurchaseNum()};
    }

    //set purchase history
    public void setPurchaseHistory(String consumerName,String goodsName,String purchaseNum){

        consumer.setConsumerName(consumerName);
        goods.setGoodsName(goodsName);
        goods.setPurchaseNum(purchaseNum);
    }
}
