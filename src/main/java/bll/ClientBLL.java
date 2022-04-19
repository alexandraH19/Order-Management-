package bll;

import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClientBLL {

    public void addBLLClient(int clientID, String numeClient, String oras){
        ClientDAO cl=new ClientDAO();
        Client newClient=new Client(clientID,numeClient,oras);
        if (newClient.getclientID()>0 && newClient.getnumeClient()!=null && newClient.getOras()!=null)
        cl.addNewClient(newClient);
    }

    public void editBLLClient(int clientID, String numeClient, String oras){
        ClientDAO cl=new ClientDAO();
        Client newClient=new Client(clientID,numeClient,oras);
        cl.editClient(newClient);
    }

    public void deleteBLLClient(int clientID, String numeClient, String oras){
        ClientDAO cl=new ClientDAO();
        Client newClient=new Client(clientID,numeClient,oras);
        cl.deleteClient(newClient);
    }

    public ArrayList<Client> viewBLLClients() throws SQLException {
        ClientDAO cl = new ClientDAO();

        return cl.viewClients();
    }

    public ArrayList<String> getColumns(){
        ClientDAO cl = new ClientDAO();
        return cl.retrievePropertiesCl(new Client(0, "", ""));
    }

    public int getNrOfColumns(){
        ClientDAO cl = new ClientDAO();

        return cl.returnNrOfColumnsCl(new Client(0, "", ""));
    }



}
