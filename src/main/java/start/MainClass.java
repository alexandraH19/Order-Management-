package start;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import presentation.*;


public class MainClass {
    public static void main(String[] args)  {
        View v=new View();
        View2 v2=new View2();
        View3 v3=new View3();

        ClientBLL cl=new ClientBLL();
        ProductBLL prod=new ProductBLL();
        OrderBLL or=new OrderBLL();
        Controller c=new Controller(v,cl);
        Controller2 c2=new Controller2(v2,prod);
        Controller3 c3=new Controller3(v3,or);
        v.setVisible(true);
        v2.setVisible(true);
        v3.setVisible(true);
    }
}
