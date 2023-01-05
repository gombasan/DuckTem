import wish from "./wish.js";
// let chatting = function () {


//     let duckTalk = document.querySelector("#duck-talk");
//     let query = duckTalk.dataset.id
//     let sellerId = query.split("/").at(0);
//     let customerId = query.split("/").at(1);
//     let TempProductId = query.split("/").at(2);
//     let productId = Number.parseInt(TempProductId);
//     if(sellerId != "null"){
//         duckTalk.onclick = function (e) {
//             e.preventDefault();
//             console.log("/chatting?sellerId="+sellerId+"&&customerId="+customerId+"&&productId="+productId);
//           window.location.href = "/chatting?sellerId="+sellerId+"&&customerId="+customerId+"&&productId="+productId;
//         };
//     }
//     else{
// 		let bottomWrap = document.querySelector(".bottom-bar-wrap");
//       bottomWrap.onclick = function(e){
//         wish(e.target);			
// 		}
// 	}
    
// };
// window.addEventListener("load",chatting);
window.addEventListener("load",function(){
//  let duckTalk = document.querySelector("#duck-talk");
//  let query = duckTalk.dataset.id
//  let sellerId = query.split("/").at(0);
//  let customerId = query.split("/").at(1);
//  let TempProductId = query.split("/").at(2);
//  let productId = Number.parseInt(TempProductId);
//  if(sellerId != "null"){
//      duckTalk.onclick = function (e) {
//          e.preventDefault();
//          console.log("/chatting?sellerId="+sellerId+"&&customerId="+customerId+"&&productId="+productId);
//        window.location.href = "/chatting?sellerId="+sellerId+"&&customerId="+customerId+"&&productId="+productId;
//      };
//  }

	let bottomWish = document.querySelector(".bottom-wish-box");
	let nums = document.querySelector(".bottom-wish-nums");	
	let currentNums = null;
		
  	if(bottomWish){
    	bottomWish.onclick = function(e){
    		wish(e.target);
    		if(e.target.classList.contains("checked"))
    			currentNums--;
    		else if(!e.target.classList.contains("checked"))
    			currentNums++;
    		
    		nums.innerText = String(currentNums);
	  }
	  
	  		// bottom 있을 때만 실행하고, 만들어 주기 위한 코드	
		// nums 초기화
			nums.init = function(){
				let id = nums.previousElementSibling.dataset.id;
				fetch(`/${id}/nums`,{
					method: "GET"
				})
		        .then((response) => response.text())
		        .then((result) => {
					nums.innerText = String(result);
					currentNums = result;
				})
				.catch(()=>console.log('에러발생'));
			};

			nums.init();
  }


});




