window.addEventListener("load",function () {
    let chatSendBtn = document.querySelector(".send-button");
    let chatInput = document.querySelector(".chat-input");
    let chatSection = document.querySelector(".chatting-padding");
    let chatList = document.querySelector(".chat-text-section");
    chatSection.scrollTo(0,chatSection.scrollHeight);
    console.log(chatList);
    let chatSend = function (e) {
        e.preventDefault();
        let customerId = document.querySelector("#chat-box").dataset.id;
        let sellerId = document.querySelector(".others").dataset.id;
        let productId = document.querySelector("#product-name").dataset.id;
        let chatMsg = chatInput.value;
        let query = sellerId+"/"+customerId+"/"+productId+"/"+chatMsg;
        socket.send(query);
        chatInput.value = "";

        let template =
        `<li class="send-wrap">
            <div class="img-wrap">
                <img class="img" src="/image/talk-icon/human.svg" alt="">
            </div>
            <div class="chat-text">
                ${chatMsg}
            </div>
            <div class="chat-text-date">오후 00:00</div>
        </li>`
        chatList.insertAdjacentHTML("beforeend",template);
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
        let template =
        `<li class="received-wrap">
            <div class="img-wrap">
                <img class="img" src="/image/talk-icon/human.svg" alt="">
            </div>
            <div class="chat-text">
                ${e.data}
            </div>
            <div className="chat-text-date">오후 00:00</div>
        </li>`
        chatList.insertAdjacentHTML("beforeend",template);
        chatSection.scrollTo(0,chatSection.scrollHeight);
    }

})