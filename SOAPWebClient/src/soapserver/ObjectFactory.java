
package soapserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListRooms_QNAME = new QName("http://soapwebserver.habib.com/", "ListRooms");
    private final static QName _GetMessages_QNAME = new QName("http://soapwebserver.habib.com/", "GetMessages");
    private final static QName _GetMessagesResponse_QNAME = new QName("http://soapwebserver.habib.com/", "GetMessagesResponse");
    private final static QName _Disconnect_QNAME = new QName("http://soapwebserver.habib.com/", "Disconnect");
    private final static QName _DisconnectResponse_QNAME = new QName("http://soapwebserver.habib.com/", "DisconnectResponse");
    private final static QName _ListRoomsResponse_QNAME = new QName("http://soapwebserver.habib.com/", "ListRoomsResponse");
    private final static QName _ListUsersResponse_QNAME = new QName("http://soapwebserver.habib.com/", "ListUsersResponse");
    private final static QName _NewMessagesResponse_QNAME = new QName("http://soapwebserver.habib.com/", "NewMessagesResponse");
    private final static QName _LeaveRoomResponse_QNAME = new QName("http://soapwebserver.habib.com/", "LeaveRoomResponse");
    private final static QName _CreateNewRooms_QNAME = new QName("http://soapwebserver.habib.com/", "CreateNewRooms");
    private final static QName _CreateNewRoomsResponse_QNAME = new QName("http://soapwebserver.habib.com/", "CreateNewRoomsResponse");
    private final static QName _JoinRoom_QNAME = new QName("http://soapwebserver.habib.com/", "JoinRoom");
    private final static QName _Connection_QNAME = new QName("http://soapwebserver.habib.com/", "Connection");
    private final static QName _JoinRoomResponse_QNAME = new QName("http://soapwebserver.habib.com/", "JoinRoomResponse");
    private final static QName _NewMessages_QNAME = new QName("http://soapwebserver.habib.com/", "NewMessages");
    private final static QName _ConnectionResponse_QNAME = new QName("http://soapwebserver.habib.com/", "ConnectionResponse");
    private final static QName _LeaveRoom_QNAME = new QName("http://soapwebserver.habib.com/", "LeaveRoom");
    private final static QName _ListUsers_QNAME = new QName("http://soapwebserver.habib.com/", "ListUsers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LeaveRoom }
     * 
     */
    public LeaveRoom createLeaveRoom() {
        return new LeaveRoom();
    }

    /**
     * Create an instance of {@link ListUsers }
     * 
     */
    public ListUsers createListUsers() {
        return new ListUsers();
    }

    /**
     * Create an instance of {@link Connection }
     * 
     */
    public Connection createConnection() {
        return new Connection();
    }

    /**
     * Create an instance of {@link JoinRoomResponse }
     * 
     */
    public JoinRoomResponse createJoinRoomResponse() {
        return new JoinRoomResponse();
    }

    /**
     * Create an instance of {@link CreateNewRoomsResponse }
     * 
     */
    public CreateNewRoomsResponse createCreateNewRoomsResponse() {
        return new CreateNewRoomsResponse();
    }

    /**
     * Create an instance of {@link JoinRoom }
     * 
     */
    public JoinRoom createJoinRoom() {
        return new JoinRoom();
    }

    /**
     * Create an instance of {@link NewMessages }
     * 
     */
    public NewMessages createNewMessages() {
        return new NewMessages();
    }

    /**
     * Create an instance of {@link ConnectionResponse }
     * 
     */
    public ConnectionResponse createConnectionResponse() {
        return new ConnectionResponse();
    }

    /**
     * Create an instance of {@link GetMessagesResponse }
     * 
     */
    public GetMessagesResponse createGetMessagesResponse() {
        return new GetMessagesResponse();
    }

    /**
     * Create an instance of {@link Disconnect }
     * 
     */
    public Disconnect createDisconnect() {
        return new Disconnect();
    }

    /**
     * Create an instance of {@link DisconnectResponse }
     * 
     */
    public DisconnectResponse createDisconnectResponse() {
        return new DisconnectResponse();
    }

    /**
     * Create an instance of {@link LeaveRoomResponse }
     * 
     */
    public LeaveRoomResponse createLeaveRoomResponse() {
        return new LeaveRoomResponse();
    }

    /**
     * Create an instance of {@link ListRoomsResponse }
     * 
     */
    public ListRoomsResponse createListRoomsResponse() {
        return new ListRoomsResponse();
    }

    /**
     * Create an instance of {@link ListUsersResponse }
     * 
     */
    public ListUsersResponse createListUsersResponse() {
        return new ListUsersResponse();
    }

    /**
     * Create an instance of {@link NewMessagesResponse }
     * 
     */
    public NewMessagesResponse createNewMessagesResponse() {
        return new NewMessagesResponse();
    }

    /**
     * Create an instance of {@link CreateNewRooms }
     * 
     */
    public CreateNewRooms createCreateNewRooms() {
        return new CreateNewRooms();
    }

    /**
     * Create an instance of {@link ListRooms }
     * 
     */
    public ListRooms createListRooms() {
        return new ListRooms();
    }

    /**
     * Create an instance of {@link GetMessages }
     * 
     */
    public GetMessages createGetMessages() {
        return new GetMessages();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "ListRooms")
    public JAXBElement<ListRooms> createListRooms(ListRooms value) {
        return new JAXBElement<ListRooms>(_ListRooms_QNAME, ListRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "GetMessages")
    public JAXBElement<GetMessages> createGetMessages(GetMessages value) {
        return new JAXBElement<GetMessages>(_GetMessages_QNAME, GetMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "GetMessagesResponse")
    public JAXBElement<GetMessagesResponse> createGetMessagesResponse(GetMessagesResponse value) {
        return new JAXBElement<GetMessagesResponse>(_GetMessagesResponse_QNAME, GetMessagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Disconnect }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "Disconnect")
    public JAXBElement<Disconnect> createDisconnect(Disconnect value) {
        return new JAXBElement<Disconnect>(_Disconnect_QNAME, Disconnect.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisconnectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "DisconnectResponse")
    public JAXBElement<DisconnectResponse> createDisconnectResponse(DisconnectResponse value) {
        return new JAXBElement<DisconnectResponse>(_DisconnectResponse_QNAME, DisconnectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "ListRoomsResponse")
    public JAXBElement<ListRoomsResponse> createListRoomsResponse(ListRoomsResponse value) {
        return new JAXBElement<ListRoomsResponse>(_ListRoomsResponse_QNAME, ListRoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "ListUsersResponse")
    public JAXBElement<ListUsersResponse> createListUsersResponse(ListUsersResponse value) {
        return new JAXBElement<ListUsersResponse>(_ListUsersResponse_QNAME, ListUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewMessagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "NewMessagesResponse")
    public JAXBElement<NewMessagesResponse> createNewMessagesResponse(NewMessagesResponse value) {
        return new JAXBElement<NewMessagesResponse>(_NewMessagesResponse_QNAME, NewMessagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeaveRoomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "LeaveRoomResponse")
    public JAXBElement<LeaveRoomResponse> createLeaveRoomResponse(LeaveRoomResponse value) {
        return new JAXBElement<LeaveRoomResponse>(_LeaveRoomResponse_QNAME, LeaveRoomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "CreateNewRooms")
    public JAXBElement<CreateNewRooms> createCreateNewRooms(CreateNewRooms value) {
        return new JAXBElement<CreateNewRooms>(_CreateNewRooms_QNAME, CreateNewRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "CreateNewRoomsResponse")
    public JAXBElement<CreateNewRoomsResponse> createCreateNewRoomsResponse(CreateNewRoomsResponse value) {
        return new JAXBElement<CreateNewRoomsResponse>(_CreateNewRoomsResponse_QNAME, CreateNewRoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinRoom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "JoinRoom")
    public JAXBElement<JoinRoom> createJoinRoom(JoinRoom value) {
        return new JAXBElement<JoinRoom>(_JoinRoom_QNAME, JoinRoom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Connection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "Connection")
    public JAXBElement<Connection> createConnection(Connection value) {
        return new JAXBElement<Connection>(_Connection_QNAME, Connection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinRoomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "JoinRoomResponse")
    public JAXBElement<JoinRoomResponse> createJoinRoomResponse(JoinRoomResponse value) {
        return new JAXBElement<JoinRoomResponse>(_JoinRoomResponse_QNAME, JoinRoomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "NewMessages")
    public JAXBElement<NewMessages> createNewMessages(NewMessages value) {
        return new JAXBElement<NewMessages>(_NewMessages_QNAME, NewMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "ConnectionResponse")
    public JAXBElement<ConnectionResponse> createConnectionResponse(ConnectionResponse value) {
        return new JAXBElement<ConnectionResponse>(_ConnectionResponse_QNAME, ConnectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeaveRoom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "LeaveRoom")
    public JAXBElement<LeaveRoom> createLeaveRoom(LeaveRoom value) {
        return new JAXBElement<LeaveRoom>(_LeaveRoom_QNAME, LeaveRoom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebserver.habib.com/", name = "ListUsers")
    public JAXBElement<ListUsers> createListUsers(ListUsers value) {
        return new JAXBElement<ListUsers>(_ListUsers_QNAME, ListUsers.class, null, value);
    }

}
