# Portpolio
포트폴리 오 
* Web Socket 정리 
  - WebSocket은 Spring4 스펙에 포함 (4.0부터 새롭게 등장)
    cf) 기존 Http는 비연결통신 -> 때문에 Java Socket을 사용(connect->bind->...수업시간에 한거처럼) 하나하나 구현해야했음
    
   But) Spring 4에서는 API를 만들어서 Http의 비연결통신을 보완 
   
   * Spring WebSocket 
   1) onOpen: 웹 소켓이 열리면 호출 
   2) onMessage: 메시지가 도착하면 호축 
   3) onError : 에러가 발생하면 호출 
   4) onClose: 웹 소켓이 닫히면 호출
   -> 4개의 '이벤트핸들러'(JavaFx에서 쓴것과 비슷한듯)
   5) send: 메시지 전송 
   6) close: 웹 소켓 닫기 
   -> 2개의 '일반 함수'로 구성
   
