import {wish as bottomWish} from './wish.js';

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
            console.log("/chatting?sellerId="+sellerId+"&&customerId="+customerId+"&&productId="+productId);
          window.location.href = "/chatting?sellerId="+sellerId+"&&customerId="+customerId+"&&productId="+productId;
        };
    }
    else{
		let bottomWrap = document.querySelector(".bottom-bar-wrap");
		bottomWrap.onclick = function(e){
			bottomWish(e.target);			
		}
	}
    
};
window.addEventListener("load",chatting);





