# WebSocket

  

### 웹소켓이란?

HTML5의 표준 기술

HTTP환경에서 클라이언트와 서버 사이에 하나의 TCP연결을 통해 실시간으로 전이중 통신을 가능하게 만든 프로토콜

- 전이중(full-duplex) 통신 지원 = 양방향 통신 지원 → 신뢰성 보장 → Handshake과정 진행
- RFC6455에 정의되어 있음
- 자주 많은 양의 신속한(지연이 짦은) 통신을 할 수록 적합하다. (채팅, 게임)

  

**기존의 TCP기반 프로토콜 :** TCP layer에서의 Handshke를 통해 연결 수립

**webSocket** : HTTP요청 기반으로 Handshke과정을 거쳐 연결 수립

  

### 웹소켓 연결과정

1. 클라이언트가 HTTP헤더에 아래 내용을 포함하여 요청 전송  
    `Upgrade: websocket`   
    `Connection: Upgrade`   
    `Sec-WebSocket-Key`  :   
    ![](./f69ada74-1f82-4910-be2f-07f548c8cb6f.png)  
    
2. 서버에서는 `101 Switching Protocols` 로 정상 응답  
    `Sec-WebSocket-Accept` : 클라이언트에게 연결요청한 곳이 맞다는 보안을 위한 응답 키  
    ![](./010714f1-09f8-4399-b3cc-29855285f383.png)  
    
3. 위 과정을 통해 연결이 수립되면 HTTP에서 webSocket으로 프로토콜이 변경되며 HTTP는 사용하지 않는다.

  

### HTTP와 웹소켓의 차이점

- HTTP는 단방향 통신만 가능하며 서버에서 클라이언트로의 요청은 불가능하다.  
    그러나 웹소켓은 클라이언트와 서버간 접속이 유지되며 서로 데이터를 주고 받는 형식으로 대화가 가능하다.
- HTTP통신은 많은 URI와 Http Method를 통해 상호작용하지만,  
    웹소켓은 초기 연결 수립을 위한 오직 하나의 URL만 존재하며 모든 메시지는 초기에 연결된 TCP연결로만 통신한다.

  

참조 : [https://tecoble.techcourse.co.kr/post/2021-08-14-web-socket/](https://tecoble.techcourse.co.kr/post/2021-08-14-web-socket/)
