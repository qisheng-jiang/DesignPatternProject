package PurchaseHistory;

//create dependent object for goods information
public class Goods {

    private String goodsName;   //goods' name the consumer have bought
    private String purchaseNum;  //how many the consumer have bought

    //get goods name
    public String getGoodsName() {
        return goodsName;
    }
    //set goods name
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    //get the number of goods you've bought
    public String getPurchaseNum() {
        return purchaseNum;
    }
    //set the number of goods you've bought
    public void setPurchaseNum(String purchaseNum) {
        this.purchaseNum = purchaseNum;
    }
}
