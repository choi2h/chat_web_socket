package chat.socket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

//websocket관련 설정 파일
@Configuration  //컨테이너 등록
@EnableWebSocketMessageBroker //웹소켓 서버 사 용 설정
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /*
    addEndpoint() : 클라이언트에서 websocket에 접속하기 위한 endpoint를 등록 (ex. localhost:8080/websocekt)
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
