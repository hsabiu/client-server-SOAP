//AUTHOR: HABIB SABIU

package com.habib.soapwebserver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService()
public class WebServer {

    private List<String> messageLogs = new ArrayList<>();
    private List<String> roomUsers = new ArrayList<>();
    private static List<String> names = new ArrayList<>();
    private static List<String> rooms = new ArrayList<String>() {
        {
            add("general");
        }
    };

    public static void main(String args[]) {
        WebServer webServer = new WebServer();
        String address = "http://localhost:8080/WebServer";
        Endpoint.publish(address, webServer);
        System.out.println("===> Web server started at localhost:8080");
    }

    @WebMethod(operationName = "Connection")
    public String connection(@WebParam(name = "connection") String userName) {

        StringBuilder sb = new StringBuilder();

        // if names list already contains 'userName', return 'failure' message
        // else
        //     add 'userName' to 'names' list
        //     append default room name to 'userName' and add it to 'roomUsers' list
        //     create a new message indicating a new user is connected and add it to 'messageLogs' list
        //     get all the previously sent messages to this group and append it to a string builder (sb) object
        //     return a string builder (sb) object containing all previous messages in this group separated by | symbol
        if (names.contains(userName.toLowerCase())) {
            sb.append("failure");
        } else {
            String TimeStamp = new java.util.Date().toString();
            String connectedTime = "Connected on " + TimeStamp;
            names.add(userName);
            roomUsers.add("general " + userName);
            messageLogs.add("general @" + userName + " " + connectedTime);

            sb.append("joined");

            for (int i = 0; i < messageLogs.size(); i++) {
                if (messageLogs.get(i).startsWith("general")) {
                    sb.append("|" + messageLogs.get(i));
                }
            }
        }
        return sb.toString();
    }

    // add a new message to the 'messageLogs' list, the new message contains 'roomName' followed by the 'message'
    @WebMethod(operationName = "NewMessages")
    public void newMessages(@WebParam(name = "newMessages") String roomName, String message) {
        messageLogs.add(roomName + " " + message);
    }

    // return the last message from 'roomName'
    @WebMethod(operationName = "GetMessages")
    public String getMessages(@WebParam(name = "roomName") String roomName) {
        String valueToReturn = "";

        // get the last message from 'messageLogs'
        String message = messageLogs.get(messageLogs.size() - 1);

        // if the last message returned is for 'roomName', append it to  'valueToReturn'
        // otherwise, 'valueToReturn' will be null
        if (message.startsWith(roomName)) {
            valueToReturn = message.substring(message.indexOf(" ") + 1);
        }

        // return last message in 'roomName', or null if there is no new message for 'roomName'
        return valueToReturn;
    }

    // return the list of all connected users
    @WebMethod(operationName = "ListUsers")
    public String listUsers(@WebParam(name = "users") String roomName) {

        StringBuilder sb = new StringBuilder();

        // loop through the names list and append all user names to a 'StringBuilder (sb)' object
        for (String s : names) {
            sb.append(s);
            sb.append(" ");
        }

        // return all users
        return sb.toString();
    }

    // return the list of all available rooms
    @WebMethod(operationName = "ListRooms")
    public String listRooms() {

        StringBuilder sb = new StringBuilder();

        // loop through the rooms list and append all available rooms to a 'StringBuilder (sb)' object
        for (String s : rooms) {
            sb.append(s);
            sb.append(" ");
        }

        // return all room names
        return sb.toString();
    }

    // create a new room 'roomName'
    @WebMethod(operationName = "CreateNewRooms")
    public String createNewRooms(@WebParam(name = "roomName") String roomName) {
        String response = "";

        // if 'roomName' already exist, return a failure message 'exist'
        // else, add 'roomName' to the rooms list and return a success message 'created'
        if (rooms.contains(roomName)) {
            response = "exist";
        } else {
            rooms.add(roomName);
            response = "created";
        }

        // return either success or failure
        return response;
    }

    // join an existing room
    @WebMethod(operationName = "JoinRoom")
    public String joinRoom(@WebParam(name = "roomToJoin") String roomToJoin, String name) {

        StringBuilder response = new StringBuilder();

        // if 'roomToJoin' does not exist, return 'no-room' failure message
        // else, append 'roomToJoin' to 'name' and add it to the 'roomUsers' list, return success message 'join'
        if (!rooms.contains(roomToJoin)) {
            response.append("no-room");
        } else {
            roomUsers.add(roomToJoin + " " + name);
            messageLogs.add(roomToJoin + " " + name + " has joined");
            response.append("joined");

            for (int i = 0; i < messageLogs.size(); i++) {
                if (messageLogs.get(i).startsWith(roomToJoin)) {
                    response.append("|" + messageLogs.get(i));
                }
            }
        }

        // return either success or failure message
        return response.toString();
    }

    // leave connected room
    @WebMethod(operationName = "LeaveRoom")
    public String leaveRoom(@WebParam(name = "roomToLeave") String roomToLeave, String name) {
        String response = "";

        // if 'rooms' does not contain 'roomToLeave' return 'no-room' failure
        // else if 'roomUsers' does not contain 'name' return 'no-user' failure
        // else remove 'name' from 'roomToLeave'
        //      send message to 'roomToLeave' users indicating the user has left
        //      return 'leave-success' success
        if (!rooms.contains(roomToLeave)) {
            response = "no-room";
        } else if (!roomUsers.contains(roomToLeave + " " + name)) {
            response = "no-user";
        } else {
            roomUsers.remove(roomToLeave + " " + name);
            messageLogs.add(roomToLeave + " " + name + " has left");
            response = "leave-success";
        }

        // return either success or failure message
        return response;
    }

    // disconnect from the chat application
    @WebMethod(operationName = "Disconnect")
    public void disconnect(@WebParam(name = "disconnect") String userName, String roomName) {
        // remove 'userName' from 'names' list
        names.remove(userName);
        // send message to 'roomName' users indicating the user has left
        messageLogs.add(roomName + " " + userName + " has left");
    }
}
