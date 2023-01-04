window.addEventListener("load",function () {
    let chatSendBtn = document.querySelector(".chat-send-btn");
    let chatInput = document.querySelector(".chat-input");
    let chatBox = document.querySelector("#chat-box");
    let chatSection = document.querySelector(".chat");
    chatSection.scrollTo(0,chatSection.scrollHeight);

    let chatSend = function (e) {
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
        chatSection.scrollTo(0,chatSection.scrollHeight);
    }

    chatSendBtn.addEventListener("click", chatSend);
    chatInput.addEventListener("keypress",(e) =>{
        if(e.code === "Enter") {
            chatSend(e);
        }
    });

    // 상대방이 메시지를 보냈을 경우.
    socket.onmessage = function (e) {
        // let msg = e.data;
        let template = `<div class="chat-receive">
            <img class="member-profile-img" src="/image/example-image0.png" alt="프로필이미지">
            <span class="chat-text">${e.data}</span>
            <span class="chat-time">오후 16:08</span>
          </div>`;
        chatSection.insertAdjacentHTML("beforeend",template);
    }

})