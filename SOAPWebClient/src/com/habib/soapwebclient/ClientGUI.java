//AUTHOR: HABIB SABIU

package com.habib.soapwebclient;

import soapserver.WebServer;
import soapserver.WebServerService;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

class ClientGUI extends javax.swing.JFrame {

    static String userName = "";
    static String connectedRoom = "";
    static String strResponse = "";

    private String lastMessage = "";
    private javax.swing.JTextArea txtServerMessages;
    private javax.swing.JButton btnSend;
    private javax.swing.JTextField txtMessagesToSend;
    private WebServer service = new WebServerService().getPort(WebServer.class);

    ClientGUI() {

        // initialized all GUI components
        initComponents();

        // create a connection to the web server
        //proxy = (new WebServerService()).getWebServerPort();

        // get the response from the web server and display it on 'txtServerMessages'
        String[] strResponseParts = strResponse.split(Pattern.quote("|"));
        for (int i = 1; i < strResponseParts.length - 1; i++) {
            String[] strArr = strResponseParts[i].split(" ", 2);
            txtServerMessages.append(strArr[1] + "\n");
        }

        // create a thread that will keep asking the web server if there is a new
        // message sent to the connected room every 500 milliseconds
        Thread receivingMessages = new Thread(() -> {
            while (true) {
                String serverResponse = service.getMessages(connectedRoom);
                if (!(serverResponse.equals(lastMessage)) && !(serverResponse.equals(""))) {
                    lastMessage = serverResponse;
                    txtServerMessages.append(serverResponse + "\n");
                }

                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        // start the receiving messages thread
        receivingMessages.start();

        // the action to perform when the close button is clicked on this frame
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to disconnect?", "Disconnect",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    service.disconnect(userName, connectedRoom);
                    System.exit(0);
                }
            }
        });
    }

    // this method 'initComponents()' deals with creating the client GUI, it does not contain any client logic
    // this is mostly editor generated code
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        txtServerMessages = new javax.swing.JTextArea();
        txtMessagesToSend = new javax.swing.JTextField();
        JLabel lblMessage = new JLabel();
        btnSend = new javax.swing.JButton();
        JButton btnDisconnect = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtServerMessages.setEditable(false);
        txtServerMessages.setColumns(20);
        txtServerMessages.setRows(5);
        txtServerMessages.setFocusable(false);
        txtServerMessages.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(txtServerMessages);

        txtMessagesToSend.addActionListener(this::txtMessagesToSendActionPerformed);

        lblMessage.setText("MESSAGE");

        btnSend.setText("SEND");
        btnSend.addActionListener(this::btnSendActionPerformed);

        btnDisconnect.setText("DISCONNECT");
        btnDisconnect.addActionListener(this::btnDisconnectActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblMessage)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtMessagesToSend))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDisconnect)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMessagesToSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMessage))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSend)
                                        .addComponent(btnDisconnect))
                                .addContainerGap())
        );

        pack();
    }
    // action to perform when 'btnSend' is clicked
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {

        // if the message typed into 'txtMessagesToSend' starts with the keyword '/join'
        //    get the room name to join
        //    if the user is already connected to that room, append a message indicating this to 'txtMessagesToSend'
        //    else, call the WebMethod 'joinRoom' and pass the room name to join and the 'userName'
        //         get the response from the WebMethod
        //         if the response is 'joined', leave the previously connected method
        //             display all the previous messages sent to the new connected room
        //         else if the response is 'no-room', display room not found error
        //         else, display invalid command error
        if (txtMessagesToSend.getText().startsWith("/join")) {
            String[] inputParts = txtMessagesToSend.getText().split(Pattern.quote(" "));
            if (inputParts[1].equalsIgnoreCase(connectedRoom)) {
                txtServerMessages.append("You are already in this room\n");
            } else {
                String response = service.joinRoom(inputParts[1], userName);
                String[] responseParts = response.split(Pattern.quote("|"));

                if (response.startsWith("joined")) {

                    String leave = service.leaveRoom(connectedRoom, userName);
                    connectedRoom = inputParts[1];
                    setTitle(userName + " @ " + connectedRoom);
                    txtServerMessages.append("You have left " + connectedRoom + " room\n");

                    for (int i = 1; i < responseParts.length - 1; i++) {
                        String[] arr = responseParts[i].split(" ", 2);
                        txtServerMessages.append(arr[1] + "\n");
                    }

                } else if (response.equals("no-room")) {
                    txtServerMessages.append(inputParts[1] + " room not found\n");
                } else {
                    txtServerMessages.append("Invalid command room\n");
                }
            }

            // clean up the typed message
            txtMessagesToSend.setText("");


            // else if the message typed into 'txtMessagesToSend' starts with the keyword '/leave'
            //      first check the room to leave
            //      if it's general then display an error message
            //      else check to make sure the room exist and the user is connected to the room
            //      display the appropriate message (either success or failure)

        } else if (txtMessagesToSend.getText().startsWith("/leave")) {
            String[] inputParts = txtMessagesToSend.getText().split(Pattern.quote(" "));
            if (inputParts[1].equals("general")) {
                txtServerMessages.append("You cant leave general room\n");
            } else {
                String response = service.leaveRoom(inputParts[1], userName);
                if (response.equals("no-room")) {
                    txtServerMessages.append(inputParts[1] + " room not found\n");
                } else if (response.equals("no-user")) {
                    txtServerMessages.append("You are not in " + inputParts[1] + " room\n");
                } else if (response.equals("leave-success")) {
                    connectedRoom = "general";
                    setTitle(userName + " @ " + connectedRoom);
                    txtServerMessages.append("You have left " + inputParts[1] + " room\n");
                } else {
                    txtServerMessages.append("Invalid command room\n");
                }
            }

            // clean up the typed message
            txtMessagesToSend.setText("");

            // else if the message typed into 'txtMessagesToSend' starts with the keyword '/users'
            // get the list of all users by calling the WebMethod 'listUsers' and display the returned list
        } else if (txtMessagesToSend.getText().startsWith("/users")) {
            String returnValue = service.listUsers(connectedRoom);
            String[] returnValueParts = returnValue.split(Pattern.quote(" "));

            txtServerMessages.append("*** All Users ***\n");
            for (int i = 0; i < returnValueParts.length; i++) {
                txtServerMessages.append((i + 1) + ". " + returnValueParts[i] + "\n");
            }
            txtServerMessages.append("*******************\n");

            // clean up the typed message
            txtMessagesToSend.setText("");

            // else if the message typed into 'txtMessagesToSend' starts with the keyword '/rooms'
            // get the list of all rooms by calling the WebMethod 'listRooms' and display the returned list
        } else if (txtMessagesToSend.getText().startsWith("/rooms")) {
            String returnValue = service.listRooms();
            String[] returnValueParts = returnValue.split(Pattern.quote(" "));

            txtServerMessages.append("*** Rooms ***\n");
            for (int i = 0; i < returnValueParts.length; i++) {
                txtServerMessages.append((i + 1) + ". " + returnValueParts[i] + "\n");
            }
            txtServerMessages.append("*******************\n");

            // clean up the typed message
            txtMessagesToSend.setText("");

            // else if the message typed into 'txtMessagesToSend' starts with the keyword '/create'
            // create a new group if it does not already exist
        } else if (txtMessagesToSend.getText().startsWith("/create")) {
            String[] inputParts = txtMessagesToSend.getText().split(Pattern.quote(" "));
            String response = service.createNewRooms(inputParts[1]);
            if (response.equals("exist")) {
                txtServerMessages.append(inputParts[1] + " room does not exist\n");
            } else if (response.equals("created")) {
                txtServerMessages.append(inputParts[1] + " room was created\n");
            }

            // clean up the typed message
            txtMessagesToSend.setText("");

            // else send the message typed into 'txtMessagesToSend' to all connected users by calling the WebMethod 'newMessages'
            // and passing the room to add the message to (connectedRoom), 'userName', and the 'txtMessagesToSend'
        } else {
            service.newMessages(connectedRoom, "@" + userName + ":" + txtMessagesToSend.getText());
            txtMessagesToSend.setText("");
        }
    }//GEN-LAST:event_btnSendActionPerformed

    // the action to perform when enter key is pressed on 'txtMessagesToSend' JTextArea
    private void txtMessagesToSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessagesToSendActionPerformed

        btnSend.doClick();
    }//GEN-LAST:event_txtMessagesToSendActionPerformed

    // the action to perform when 'btnDisconnect' is clicked
    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnDisconnectActionPerformed
    // End of variables declaration//GEN-END:variables
}
