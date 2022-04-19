package dao;

import connection.ConnectionFactory;
import model.Client;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO {

    private final static String addClientSt="insert into client values (?,?,?)";
    private final static String editClientSt="update client set numeClient=? where clientID=?";
    private final static String deleteClientSt="delete from client where clientID=?";
    private final static String viewClientSt="select * from client";
    private final static String editHelpClientSt="select * from client where clientID=?";

    /***
     * Metoda ce exeuta interogarea de adaugare a unui client in tabelul din baza de date
     * @param cl
     */
    public static void addNewClient(Client cl) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            con = ConnectionFactory.getConnection();
            statement=con.prepareStatement(addClientSt);
            statement.setInt(1,
                    cl.getclientID());
            statement.setString(2,cl.getnumeClient());
            statement.setString(3,cl.getOras());
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(con);
        }

    }

    /***
     * Metoda ce executa editarea campului name unui client din tabelul din DB in functie de ID
     * @param cl
     */
    public static void editClient(Client cl){
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String name;
        try {
            con = ConnectionFactory.getConnection();
            statement=con.prepareStatement(editHelpClientSt);
            statement.setInt(1,cl.getclientID());
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                name=resultSet.getString("numeClient");
                cl.setnumeClient(cl.getnumeClient());

            statement=con.prepareStatement(editClientSt);
            statement.setInt(2,cl.getclientID());
            statement.setString(1,cl.getnumeClient());
            statement.executeUpdate();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * Metoda ce executa stergerea unui client din DB
     * @param cl
     */
    public static void deleteClient(Client cl){
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            con = ConnectionFactory.getConnection();
            statement=con.prepareStatement(deleteClientSt);
            statement.setInt(1,cl.getclientID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(con);
        }
    }

    public static ArrayList<Client> viewClients() throws SQLException {
        ArrayList<Client> clienti=new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        statement=con.prepareStatement(viewClientSt);
        resultSet=statement.executeQuery();
        while(resultSet.next()){
            Client cl=new Client(Integer.parseInt(resultSet.getString("clientID")),resultSet.getString("numeClient"),resultSet.getString(("oras")));
            clienti.add(cl);
        }
        return clienti;
    }


    public static int returnNrOfColumnsCl(Object o){
        return o.getClass().getDeclaredFields().length;
    }

    public static ArrayList<String> retrievePropertiesCl(Object object){
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
