package com.poetry.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
 
@ServerEndpoint(value="/webSocket/{userId}/{message}")
@Component
public class WebSocket {
    private static int onlineCount=0;
 
    private static CopyOnWriteArraySet<WebSocket> webSocketSet=new CopyOnWriteArraySet<WebSocket>();
 
    private static HashMap<String,Session> sessionHashMap = new HashMap<>();
 
    private Session session;
 
    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId,@PathParam("message") String message, Session session) {
        if(userId != null){
            //从url中获取userId
            sessionHashMap.put(userId,session);
        }
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        try {
            sendMessage(message,session);
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }
 
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        sessionHashMap.remove(this.session.getPathParameters().get("userId"));
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
 
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message,Session session) {
        String[] split = message.split("-");
        System.out.println("来自客户端的消息:" + split[0]);
        try{
            Session session1 = sessionHashMap.get(split[0]);
            //如果获取不到session表明此客户端已下线，则获取到session为null，则群发
            if(session1 == null){
                //点对面
                for (WebSocket item : webSocketSet) {
                    try {
                        item.sendMessage(message,item.session);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                sendMessage(split[0],session1);
            }
        }catch(IOException e){
 
        }
    }
    //消息推送
    public void sendMessage(String message,Session session) throws IOException {
        session.getBasicRemote().sendText(message);
    }
 
 
    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
 
    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }
 
    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}
