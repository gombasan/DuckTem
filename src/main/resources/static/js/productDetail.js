import wish from "./wish.js";

//==========================================================
//===================   급조된 자스  준현아 미안하게 됐따. 그냥 써라.  ===================
//==========================================================
window.addEventListener('load', function() {

//	let chatting = function() {
//
//
//    let duckTalk = document.querySelector("#duck-talk");
//    let query = duckTalk.dataset.id
//    let sellerId = query.split("/").at(0);
//    let customerId = query.split("/").at(1);
//    let TempProductId = query.split("/").at(2);
//    let productId = Number.parseInt(TempProductId);
//    if(sellerId != "null"){
//        duckTalk.onclick = function (e) {
//            e.preventDefault();
//          window.location.href = "/chatting?sellerId="+sellerId+"&&customerId="+customerId+"&&productId="+productId;
//        };
//    }
//};
//
//	chatting();




	let imageBox = document.querySelectorAll(".image-box")
	let vectorRight = document.querySelector(".vector-right")
	let vectorLeft = document.querySelector(".vector-left")
	let indexDot = document.querySelectorAll(".index-dot");

	let imageIndexNow = 0;

	for (let i = 0; i < imageBox.length; i++) {
		imageBox[i].classList.add("d-none")
	}
	imageBox[imageIndexNow].classList.remove("d-none")
	indexDot[imageIndexNow].classList.add("dot-hightlight")




	vectorRight.onclick = function(e) {

		if(imageIndexNow==imageBox.length-1){
			imageIndexNow = imageBox.length-1
		}
		else{
		imageBox[imageIndexNow].classList.add("d-none")
		indexDot[imageIndexNow].classList.remove("dot-hightlight")
		imageIndexNow++;
		imageBox[imageIndexNow].classList.remove("d-none")
		indexDot[imageIndexNow].classList.add("dot-hightlight")
		}

	}

	vectorLeft.onclick = function(e) {

		if(imageIndexNow==0){
			imageIndexNow = 0
		}
		else{
		imageBox[imageIndexNow].classList.add("d-none")
		indexDot[imageIndexNow].classList.remove("dot-hightlight")
		imageIndexNow--;
		imageBox[imageIndexNow].classList.remove("d-none")
		indexDot[imageIndexNow].classList.add("dot-hightlight")
		}

	}

//==========================================================
//===================   for bottom Wish   ===================
//==========================================================

//  .   ____          _            __ _ _
// /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
//( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
// \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
//  '  |____| .__|_| |_|_| |_\__, | / / / /
// =========|_|==============|___/=/_/_/_/



	let bottomWish = document.querySelector(".bottom-wish");
	let nums = document.querySelector(".bottom-wish-nums");
	let currentNums = null;


    	bottomWish.onclick = function(e){
    		wish(e.target);
    		if(e.target.classList.contains("checked")){
    			currentNums--;	
			}
    		else if(!e.target.classList.contains("checked")){
    			currentNums++;
			}

    		nums.innerText = String(currentNums);
	  }

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



});




