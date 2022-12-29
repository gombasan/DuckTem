let chatting = function () {
    let duckTalk = document.querySelector("#duck-talk");
    let query = duckTalk.dataset.id
    let sellerId = query.split("/").at(0);
    let customerId = query.split("/").at(1);
    let TempProductId = query.split("/").at(2);
    let productId = Number.parseInt(TempProductId);
    if(sellerId != "null"){
        duckTalk.onclick = function (e) {
            e.preventDefault();
          window.location.href = "/chatting?sellerId="+sellerId+"&&customerId="+customerId+"&&productId="+productId;
        };
    }
};
window.addEventListener("load",chatting);