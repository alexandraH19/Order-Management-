package bll;

import dao.OrderDAO;
import model.Order;

import java.sql.SQLException;

public class OrderBLL {

    public void addBLLOrder(int orderID,String clientName,String productName,int cantitate) throws SQLException {
        OrderDAO or=new OrderDAO();
        Order newOder= new Order(orderID,clientName,productName,cantitate);
        if(newOder.getOrderID()>0 && newOder.getClientName()!=null && newOder.getProductName()!=null && newOder.getCantitate()!=0){
            or.addNewOrder(newOder);
        }
    }


    public void deleteBLLOrder(int orderID,String clientName,String productName,int cantitate){
        OrderDAO or=new OrderDAO();
        Order newOder= new Order(orderID,clientName,productName,cantitate);
        or.deleteOrder(newOder);
    }
}
