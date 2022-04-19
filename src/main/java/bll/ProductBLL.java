package bll;

import dao.ProductDAO;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductBLL {

    public void addBLLProduct(int produsID,String numeProdus,int cantitateP,int pret){
        ProductDAO prod=new ProductDAO();
        Product newProduct=new Product(produsID,numeProdus,cantitateP,pret);
        if(newProduct.getProdusID()>0 && newProduct.getNumeProdus()!=null && newProduct.getCantitateP()>0 && newProduct.getPret()>0){
            prod.addNewProduct(newProduct);
        }
    }

    public void editBLProduct(int produsID,String numeProdus,int cantitateP,int pret) {
        ProductDAO prod = new ProductDAO();
        Product newProduct=new Product(produsID,numeProdus,cantitateP,pret);
        prod.editProduct(newProduct);
    }

    public void deleteBLLProduct(int produsID,String numeProdus,int cantitateP,int pret) {
        ProductDAO prod = new ProductDAO();
        Product newProduct=new Product(produsID,numeProdus,cantitateP,pret);
        prod.deleteProduct(newProduct);
    }

    public ArrayList<Product> viewBLLProduct() throws SQLException {
        ProductDAO prod = new ProductDAO();

        return prod.viewProducts();
    }

    public ArrayList<String> getColumns(){
        ProductDAO prod = new ProductDAO();
        return prod.retrievePropertiesPr(new Product(0, "", 0, 0));


    }

    public int getNrOfColumns(){
        ProductDAO prod = new ProductDAO();

        return prod.returnNrOfColumns(new Product(0, "", 0, 0));
    }


}
