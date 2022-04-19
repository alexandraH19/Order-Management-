package dao;

import connection.ConnectionFactory;
import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {

    private final static String addOrderSt="insert into comanda values (?,?,?,?)";
    private final static String deleteOrderSt="delete from comanda where orderID=?";
    ProductDAO produs=new ProductDAO();

    public void addNewOrder(Order or) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Product> produse=produs.viewProducts();

        for(Product p:produse){
            System.out.println(p.getNumeProdus());
            System.out.println(or.getProductName());
            if(p.getNumeProdus().equals(or.getProductName())){
                System.out.println(p.getCantitateP());
                System.out.println(or.getCantitate());
                if(p.getCantitateP()>or.getCantitate()) {
                    p.setCantitateP(p.getCantitateP() - or.getCantitate());
                    p.editareProduse();
                    System.out.println(p.getCantitateP());

                }
                else
                    System.out.println("Nu sunt destule produse");
            }
        }
        try {
            statement=con.prepareStatement(addOrderSt);
            statement.setInt(1,or.getOrderID());
            statement.setString(2,or.getClientName());
            statement.setString(3,or.getProductName());
            statement.setInt(4,or.getCantitate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOrder(Order order){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement=con.prepareStatement(deleteOrderSt);
            statement.setInt(1,order.getOrderID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(con);
        }
    }

}
