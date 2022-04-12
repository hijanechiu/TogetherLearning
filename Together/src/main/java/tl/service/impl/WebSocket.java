package tl.service.impl;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/websocket")
public class WebSocket {

	private Session session;
	
	private static CopyOnWriteArraySet<WebSocket> webSocketSet=new CopyOnWriteArraySet<>();
	
	@OnOpen
	public void onOpen(Session session) {
		this.session=session;
		webSocketSet.add(this);
		sendMessage("同學好,請問需要幫忙嗎?");
		sendMessage("註冊會員請輸入1");
		sendMessage("聯絡我們請輸入2");
	}
	
	public void sendMessage(String message) {
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		System.out.println("連接斷開,總數為:"+webSocketSet.size());
	}
	
	@OnMessage
	public void onMessage(String message) {
		if("2".equals(message)) {	
		sendMessage("contact");
		}else if("1".equals(message)) {
		sendMessage("reg");
		}else {
		sendMessage("無法回應,請重新發送訊息");
		}
	}

}
