package dao;

import connection.ConnectionFactory;
import model.Product;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

    private final static String addProductSt="insert into product values (?,?,?,?)";
    private final static String editProductSt="update product set cantitateP = ? where produsID = ?";
    private final static String deleteProductSt="delete from product where produsID=?";
    private final static String viewProductSt="select * from product ";
    private final static String editHelpProductSt="select * from product where produsID=?";

    public static void addNewProduct(Product product) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(addProductSt);
            statement.setInt(1, product.getProdusID());
            statement.setString(2, product.getNumeProdus());
            statement.setInt(3, product.getCantitateP());
            statement.setInt(4, product.getPret());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(con);
        }
    }

        public static void editProduct(Product p){
            Connection con = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            int cantTotala;
            try {
                con = ConnectionFactory.getConnection();
                statement=con.prepareStatement(editHelpProductSt);
                statement.setInt(1,p.getProdusID());
                resultSet=statement.executeQuery();
                if(resultSet.next()){
                cantTotala=resultSet.getInt("cantitateP");

                p.setCantitateP(p.getCantitateP());
                statement=con.prepareStatement(editProductSt);
                statement.setInt(1,p.getCantitateP());
                statement.setInt(2,p.getProdusID());
                statement.executeUpdate();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void deleteProduct(Product product){
            Connection con = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                con = ConnectionFactory.getConnection();
                statement=con.prepareStatement(deleteProductSt);
                statement.setInt(1,product.getProdusID());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionFactory.close(resultSet);
                ConnectionFactory.close(statement);
                ConnectionFactory.close(con);
            }
        }

    public static ArrayList<Product> viewProducts() throws SQLException {
        ArrayList<Product> produse=new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        statement=con.prepareStatement(viewProductSt);
        resultSet=statement.executeQuery();
        while(resultSet.next()){
            Product prod=new Product(Integer.parseInt(resultSet.getString("produsID")),resultSet.getString("numeProdus"),Integer.parseInt(resultSet.getString("cantitateP")),Integer.parseInt(resultSet.getString("pret")));
            produse.add(prod);
        }
        return produse;
    }

    public static int returnNrOfColumns(Object o){
        return o.getClass().getDeclaredFields().length;
    }

    public static ArrayList<String> retrievePropertiesPr(Object object){
        ArrayList<String> fieldNames = new ArrayList<>();
        for(Field field: object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try{
                fieldNames.add(field.getName());

            }catch(IllegalArgumentException e){
                e.printStackTrace();
            }
        }
        return fieldNames;
    }

}
