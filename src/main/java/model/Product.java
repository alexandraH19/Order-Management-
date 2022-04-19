package model;

import dao.ProductDAO;

public class Product {

    private int produsID;
    private String numeProdus;
    private int cantitateP;
    private int pret;

    public Product(int produsID,String numeProdus,int cantitateP,int pret){
        this.produsID=produsID;
        this.numeProdus=numeProdus;
        this.cantitateP=cantitateP;
        this.pret=pret;

    }

    public int getCantitateP() {
        return cantitateP;
    }

    public int getPret() {
        return pret;
    }

    public int getProdusID() {
        return produsID;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setCantitateP(int cantitateP) {
        this.cantitateP = cantitateP;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setProdusID(int produsID) {
        this.produsID = produsID;
    }

    public void editareProduse(){
        ProductDAO prod=new ProductDAO();
        prod.editProduct(this);
    }


}
