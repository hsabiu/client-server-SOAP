## Introduction
This is a client-server chat application implemented using Java and SOAP Web Services.

#### Compiling and Testing

#### Server
To compile and run the server, import the *SAOPWebServer* project into intelliJ IDEA and run the *WebServer.java* class.

#### Client
After the server started successfully, create multiple clients using the using the *SOAPWebClient* project. To compile and run the client, import the *SOAPWebClient* project into intelliJ IDEA and run the *ClientConnection.java* class.

Before a client can connect to the web server, the client has to provide a user name to the server. The server then checks to make sure no any other connected client is using the  same user name. If the user name exist on the server, an error message is displayed asking the user to choose a different user name. Otherwise, the server register the user to the default 'general' room and inform all the users connected to this room that a new client is connected. 

Use the created clients to interact with the server by performing various operations such as:

  * Create chat-rooms by issuing the command **'/create roomName'**
  * List all existing rooms by issuing the command **'/rooms'**
  * Join existing chat-rooms by issuing the command **'/join roomName'**
  * Send messages to chat-rooms by simply writing a message into the client text box and pressing the enter key or send button on the client
  * Leave a chat-room by issuing the command **'/leave roomName'**
  * List all users by issuing the command **'/users'**

When a user connect to a new room, all the previous messages in this room are displayed to the user. In addition, all messages sent by the user are shown to all other clients connected to the same room with 1 second maximum delay. When a user leave a room, the server disconnect the user from the system.
