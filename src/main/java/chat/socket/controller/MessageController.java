package chat.socket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller
@ServerEndpoint("/websocket")
public class MessageController extends Socket {
//    private Logger logger = LoggerFactory.getLogger(MessageController.class);
    private static final List<Session> sessionList = new ArrayList<Session>();

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @OnOpen
    public void open(Session newUser) {
        System.out.println("Connect new user. id= " + newUser.getId());
        sessionList.add(newUser);
    }

    @OnMessage
    public void getMessage(Session receiveSession, String msg) {
        for(Session session : sessionList) {
            if(!receiveSession.getId().equals(session.getId())) {
                sendMessageForUser(session, "상대 : " +  msg);
            } else {
                sendMessageForUser(session, "나 : " + msg);
            }
        }
    }

    private void sendMessageForUser(Session user, String msg) {
        try {
            user.getBasicRemote().sendText(msg);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
