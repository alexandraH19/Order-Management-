package presentation;

import bll.OrderBLL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Controller3 {
    private View3 v3;

    private OrderBLL or=new OrderBLL();


    public Controller3(View3 v3,OrderBLL ord) {
        this.v3 = v3;


        this.v3.addComandaListener(new AddOrderListener());

    }
    class AddOrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                or.addBLLOrder(v3.getOrderID(),v3.getNumeCl(),v3.getNumePr(),v3.getCantPr());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
