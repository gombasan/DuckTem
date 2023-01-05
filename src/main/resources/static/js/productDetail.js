let chatting = function() {


	let duckTalk = document.querySelector("#duck-talk");
	let query = duckTalk.dataset.id
	let sellerId = query.split("/").at(0);
	let customerId = query.split("/").at(1);
	let TempProductId = query.split("/").at(2);
	let productId = Number.parseInt(TempProductId);
	if (sellerId != "null") {
		duckTalk.onclick = function(e) {
			e.preventDefault();
			console.log("/chatting?sellerId=" + sellerId + "&&customerId=" + customerId + "&&productId=" + productId);
			window.location.href = "/chatting?sellerId=" + sellerId + "&&customerId=" + customerId + "&&productId=" + productId;
		};
	}
};
window.addEventListener("load", chatting);





//▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼  여기서부터  ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
window.addEventListener('load', function() {

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


});
//▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲   여기까지   ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲





