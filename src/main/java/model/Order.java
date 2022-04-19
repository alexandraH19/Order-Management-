package model;

public class Order {

    private int orderID;
    private String clientName;
    private String productName;
    private int cantitate;

    public Order(int orderID,String clientName,String productName,int cantitate){
        this.orderID=orderID;
        this.clientName=clientName;
        this.productName=productName;
        this.cantitate=cantitate;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProductName() {
        return productName;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
