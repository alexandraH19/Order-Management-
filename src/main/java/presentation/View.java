package presentation;

import dao.ClientDAO;
import model.Client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class View extends JFrame {

    private JLabel l1 = new JLabel("ID Client:");
    private JLabel l2 = new JLabel("Nume client:");
    private JLabel l3 = new JLabel("Oras:");

    private JTextField f1 = new JTextField();
    private JTextField f2 = new JTextField();
    private JTextField f3 = new JTextField();


    private JButton addCl = new JButton("Adauga");

    private JButton editCl = new JButton("Edit");

    private JButton delCl = new JButton("Sterge");

    private JButton showCl = new JButton("Vizualizare");

    JPanel p3 = new JPanel();


    // ======constructor=======
    public View(){
        this.setTitle("Client");
        ClientDAO cl=new ClientDAO();

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);

        p1.add(l1);
        p1.add(f1);
        p1.add(l2);
        p1.add(f2);
        p1.add(l3);
        p1.add(f3);

        JPanel p2 = new JPanel();
        //p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p2.add(addCl);
        p2.add(delCl);
        p2.add(editCl);
        p2.add(showCl);

         //panel pt butoane
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.add(p1);
        p3.add(p2);
        this.add(p3);


        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getIDCl(){
        return Integer.parseInt(f1.getText());
    }

    public String getNumeCl(){
        return f2.getText();
    }

    public String getOrasCl(){
        return f3.getText();
    }


    //ASCULTATORI

    void addClientListener(ActionListener list1) {
        addCl.addActionListener(list1);
    }

    void editClientListener(ActionListener list3) {
        editCl.addActionListener(list3);
    }

    void delClientListener(ActionListener list5) {
        delCl.addActionListener(list5);
    }

    void showClientListener(ActionListener list7) {
        showCl.addActionListener(list7);
    }

    public JPanel getP3(){
        return p3;
    }

}
