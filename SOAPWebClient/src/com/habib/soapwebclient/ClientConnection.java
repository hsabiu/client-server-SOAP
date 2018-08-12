//AUTHOR: HABIB SABIU

package com.habib.soapwebclient;

import soapserver.WebServer;
import soapserver.WebServerService;

import javax.swing.*;

// client connection GUI
public class ClientConnection extends JFrame {

    private WebServer service = new WebServerService().getPort(WebServer.class);
    private JButton btnConnect;
    private JTextField txtName;

    private ClientConnection() {
        // initialize the connection GUI
        initComponents();
    }

    // starting point of the WebClient
    public static void main(String args[]) {

        // set the look and feel of the frame to Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ClientConnection().setVisible(true);
        });
    }

    // this method 'initComponents()' deals with creating the client connection GUI,
    // it does not contain any connection logic, this is mostly editor generated code
    private void initComponents() {

        JLabel lblName = new JLabel();
        txtName = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        JButton btnCancel = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Connection");
        setResizable(false);

        lblName.setText("NAME");

        txtName.addActionListener(this::txtNameActionPerformed);

        btnConnect.setText("CONNECT");
        btnConnect.addActionListener(this::btnConnectActionPerformed);

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnConnect)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCancel))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblName)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancel)
                                        .addComponent(btnConnect))
                                .addGap(18, 18, 18))
        );

        pack();
    }

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {

        // connect to the WebServer by calling the WebMethod 'connection'
        String connectionResponse = service.connection(txtName.getText());

        // if the WebServer returns failure, then display JOptionPane indicating the connection was not successful
        //    this is to indicated the user name choosing was already in use by another user
        // else set the appropriate variables of ClientGUI class and create an object of the class
        if (connectionResponse.equals("failure")) {
            JOptionPane.showMessageDialog(null, "Please choose a different name");
        } else {

            // set this client username to the selected name
            ClientGUI.userName = txtName.getText();

            // add this client to the default room of "general"
            ClientGUI.connectedRoom = "general";

            // add the WebServer response to the ClientGUI JTextArea
            ClientGUI.strResponse = connectionResponse;

            // set the connection frame to false to hide it
            setVisible(false);

            // dispose the connection frame
            dispose();

            // create an object of the ClientGUI class
            ClientGUI client = new ClientGUI();

            // change the title of ClientGUI to username @ default group
            client.setTitle(ClientGUI.userName + " @ " + ClientGUI.connectedRoom);

            // set ClientGUI to visible
            client.setVisible(true);
        }
    }

    // action to perform when enter key is clicked on 'btnConnect'
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {
        btnConnect.doClick();
    }

    // action to perform when 'btnCancel' is clicked
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
}
