package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller2 {

        private View2 v2;

        private ProductBLL prod=new ProductBLL();


        public Controller2(View2 v2,ProductBLL prod) {
            this.v2 = v2;


            this.v2.addProdusListener(new AddProdListener());

            this.v2.editPrListener(new EditPrListener());

            this.v2.delPrListener(new DelPrListener());

            this.v2.showPrListener(new ShowPrListener());

        }
    class AddProdListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            prod.addBLLProduct(v2.getPrID(),v2.getNumePr(),v2.getCantPr(),v2.getPret());
        }
    }

    class EditPrListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            prod.editBLProduct(v2.getPrID(),v2.getNumePr(),v2.getCantPr(),v2.getPret());
        }
    }

    class DelPrListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            prod.deleteBLLProduct(v2.getPrID(),v2.getNumePr(),v2.getCantPr(),v2.getPret());
        }
    }

    class ShowPrListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<Product> productList = new ArrayList<Product>();
            try {
                productList = prod.viewBLLProduct();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String[] columns = new String[prod.getNrOfColumns()];
            String[][] rows = new String[productList.size()][prod.getNrOfColumns()];

            System.out.println(prod.getNrOfColumns());
            System.out.println(productList.size());

            for(int i = 0; i < productList.size(); i++){

                    rows[i][0] = Integer.toString(productList.get(i).getProdusID());
                    rows[i][1] = productList.get(i).getNumeProdus();
                    rows[i][2] = Integer.toString(productList.get(i).getCantitateP());
                    rows[i][3] = Integer.toString(productList.get(i).getPret());

            }

            for(int i = 0; i < prod.getColumns().size(); i++){
                columns[i] = prod.getColumns().get(i);
            }

            JTable table = new JTable(rows, columns);

            JScrollPane pane=new JScrollPane(table);
            pane.setSize(300,300);

            v2.getP3().add(pane);

        }
    }
}
