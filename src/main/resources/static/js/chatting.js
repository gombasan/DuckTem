window.addEventListener("load",function () {
    let chatSendBtn = document.querySelector(".chat-send-btn");
    let chatInput = document.querySelector(".chat-input");



    chatSendBtn.addEventListener("click", (e) =>{
        e.preventDefault();
        let customerId = document.querySelector("#chat-title").dataset.id;
        let sellerId = document.querySelector(".member-nickname").dataset.id;
        let productId = document.querySelector(".product-title").dataset.id;
        let chatMsg = chatInput.innerText;
        let query = sellerId+"/"+customerId+"/"+productId+"/"+chatMsg;
        console.log(chatMsg);
        socket.send(query);
        chatInput.innerText = "";
    });




    socket.onmessage = function(e) {


    }


    // btn.onclick = function () {
    //     let msg = document.querySelector("#msg").value;
    //     websocket.send(msg);
    // }
    // websocket.onmessage = function(e) {
    //     alert(`${e.id}`);
    //     alert(`서버로부터 전송받은 데이터 : ${e.data}`);
    // }
})