package model;

public class Client {
    private int clientID;
    private String numeClient;
    private String oras;

    public Client(int clientID, String numeClient, String oras){
        this.clientID=clientID;
        this.numeClient=numeClient;
        this.oras=oras;

    }

    public int getclientID() {
        return clientID;
    }

    public String getnumeClient() {
        return numeClient;
    }

    public String getOras() {
        return oras;
    }

    public void setclientID(int clientID) {
        this.clientID = clientID;
    }

    public void setnumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }
}
