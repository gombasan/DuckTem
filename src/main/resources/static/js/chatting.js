window.addEventListener("load",function () {
    let chatSendBtn = document.querySelector(".send-button");
    let chatInput = document.querySelector(".chat-input");
    let chatSection = document.querySelector(".chatting-padding");
    let chatTextSection = document.querySelector(".chat-text-section");
    chatSection.scrollTo(0,chatSection.scrollHeight);

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
        chatTextSection.insertAdjacentHTML("beforeend",template);
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
        `<li className="received-wrap">
            <div className="img-wrap">
                <img className="img" src="/image/talk-icon/human.svg" alt="">
            </div>
            <div className="chat-text">
                ${e.data}
            </div>
            <div className="chat-text-date">오후 00:00</div>
        </li>`
        chatTextSection.insertAdjacentHTML("beforeend",template);
    }

})