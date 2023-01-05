// 웹 소켓은 어느페이지에 있던 항상 열려있게 하기 위해 var 전역스코프로 설정.
var socket = new WebSocket("ws://localhost:8080/chatting/start");

// 덕톡 알람.
socket.onmessage = function(e) {
    alert(`${e.data}`);
}