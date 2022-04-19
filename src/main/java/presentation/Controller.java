package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Client;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
        private View v;
        private ClientBLL cl=new ClientBLL();



        public Controller(View v,ClientBLL cl) {
            this.v = v;

            this.v.addClientListener(new AddClientListener());

            this.v.editClientListener(new EditClListener());

            this.v.delClientListener(new DelClientListener());

            this.v.showClientListener(new ShowClientListener());


        }

        class AddClientListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
               cl.addBLLClient(v.getIDCl(),v.getNumeCl(),v.getOrasCl());
            }
        }



        class EditClListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
               cl.editBLLClient(v.getIDCl(),v.getNumeCl(),v.getOrasCl());
            }
        }


        class DelClientListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
            cl.deleteBLLClient(v.getIDCl(),v.getNumeCl(),v.getOrasCl());
            }
        }


        class ShowClientListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Client> clientList = new ArrayList<Client>();
                try {
                    clientList = cl.viewBLLClients();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String[] columns = new String[cl.getNrOfColumns()];
                String[][] rows = new String[clientList.size()][cl.getNrOfColumns()];


                for(int i = 0; i < clientList.size(); i++){

                    rows[i][0] = Integer.toString(clientList.get(i).getclientID());
                    rows[i][1] = clientList.get(i).getnumeClient();
                    rows[i][2] = clientList.get(i).getOras();


                }

                for(int i = 0; i < cl.getColumns().size(); i++){
                    columns[i] = cl.getColumns().get(i);
                }

                JTable table = new JTable(rows, columns);

                JScrollPane pane=new JScrollPane(table);
                pane.setSize(300,300);

                v.getP3().add(pane);

            }

        }


    }

