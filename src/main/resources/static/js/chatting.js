window.addEventListener("load",function () {
    let chatSendBtn = document.querySelector(".chat-send-btn");
    let chatInput = document.querySelector(".chat-input");
    let chatBox = document.querySelector("#chat-box");
    let chatSection = document.querySelector(".chat");

    chatSendBtn.addEventListener("click", (e) =>{
        e.preventDefault();
        let customerId = document.querySelector("#chat-title").dataset.id;
        let sellerId = document.querySelector(".member-nickname").dataset.id;
        let productId = document.querySelector(".product-title").dataset.id;
        let chatMsg = chatInput.innerText;
        let query = sellerId+"/"+customerId+"/"+productId+"/"+chatMsg;
        socket.send(query);
        chatInput.innerText = "";

        let template = `<div class="chat-send">
            <img class="my-profile-img" src="/image/example-image2.png" alt="프로필이미지">
            <span class="chat-text send">${chatMsg}</span>
            <span class="chat-time">오후 16:08</span>
          </div>`;
        chatSection.insertAdjacentHTML("beforeend",template);


    });

    socket.onmessage = function (e) {
        // let msg = e.data;
        let template = `<div class="chat-receive">
            <img class="member-profile-img" src="/image/example-image0.png" alt="프로필이미지">
            <span class="chat-text">${e.data}</span>
            <span class="chat-time">오후 16:08</span>
          </div>`;
        chatSection.insertAdjacentHTML("beforeend",template);
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