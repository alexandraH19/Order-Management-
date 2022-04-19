package presentation;
import dao.OrderDAO;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View3 extends JFrame{

        private JLabel l4 = new JLabel("ID Comanda:");
        private JLabel l5 = new JLabel("Nume produs:");
        private JLabel l6 = new JLabel("Nume client:");
        private JLabel l7 = new JLabel("Cantitate:");

        private JTextField orID = new JTextField();
        private JTextField prNume = new JTextField();
        private JTextField cant = new JTextField();
        private JTextField clNume = new JTextField();

        private JButton comanda = new JButton("Comanda");


        public View3() {
            this.setTitle("Order");

            OrderDAO or = new OrderDAO();
            JPanel p1 = new JPanel();
            p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500, 500);

            p1.add(l4);
            p1.add(orID);
            p1.add(l5);
            p1.add(prNume);
            p1.add(l6);
            p1.add(clNume);
            p1.add(l7);
            p1.add(cant);

            JPanel p2 = new JPanel();
            p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
            p2.add(comanda);

            JPanel p3 = new JPanel(); //panel pt butoane
            p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
            p3.add(p1);
            p3.add(p2);
            this.add(p3);


            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public String getNumePr(){
            return prNume.getText();
        }

        public int getOrderID(){
            return Integer.parseInt(orID.getText());
        }

        public int getCantPr(){
            return Integer.parseInt(cant.getText());
        }

        public String getNumeCl(){
            return clNume.getText();
        }

        void addComandaListener(ActionListener list2) {
            comanda.addActionListener(list2);
        }



    }


