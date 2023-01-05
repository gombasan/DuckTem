window.addEventListener("load",function(){
	let main = document.querySelector("main");
	let productsWrap = document.querySelector(".product-wrap");
//	my page 빼고 적용,load와 동시에 만들어야 함
	let wishes = main.querySelectorAll(".wish");

//	detail page 특수 기능
	let bottomWrap = document.querySelector(".bottom-bar-wrap");
	let nums = main.querySelector(".nums");
	let id = null;

//	찜 상품 넘어갈 때 새로고침
	let openWithWish = main.querySelector(".open-with-wish");
	if(openWithWish){
		openWithWish.onclick = function(){
			wishes.init();

		};
	};

// bottom 있을 때만 실행하고, 만들어 주기 위한 코드	
	if(bottomWrap){
	// nums 초기화
		nums.init = function(){
			id = nums.previousElementSibling.dataset.id;
			fetch(`/${id}/nums`,{
				method: "GET"
			})
	        .then((response) => response.text())
	        .then((result) => {
				nums.innerText = String(result);

			})
			.catch(()=>console.log('에러발생'));
		};

		nums.init();
	};


// wishList check, 공통
	productsWrap.onclick = function(e){

		if(e.target.classList.contains("wish"))	{

	        if(!e.target.classList.contains("checked")){ // 하트가 안눌린 것
		        // fetch api
		        console.log("하트가 눌리는 곳입니다.");

		        id = e.target.dataset.id;

		        fetch(`/${id}/wish`,{
					method: "POST"
				})
	            .then((response) => response.text())
	            .then((result) => {
					if(result == "/login")
						location.href = result;
					else if(result == "ok"){
						e.target.classList.add("checked");
						e.target.src = "/image/icon/icon-heart-red.svg";
					}

				})
				.then(()=>{
					if(e.target.classList.contains("bottom"))
						nums.init();
				})
				.catch(()=>{
					console.log('에러발생');
				});
				};

			if(e.target.classList.contains("checked")){
		        // fetch api
		        id = e.target.dataset.id;
		        console.log("하트가 눌리지 않는 곳입니다.");
		        fetch(`/${id}/wish/delete`,{
					method: "DELETE"
				})
	            .then((response) => response.text())
	            .then((result) => {
					if(result =="deleteDone"){
						e.target.classList.remove("checked");
						e.target.src = "/image/icon/heart.svg";
					}
					else{
						console.log("안된다.");
					}
				})
				.then(()=>{
					if(e.target.classList.contains("bottom"))
						nums.init();
				});
			};

		}
		let isProductClick = e.target.parentElement.classList.contains("product-container") || e.target.tagName === "IMG"

		if(isProductClick) {
			let productId = e.target.parentElement.dataset.location || e.target.parentElement.parentElement.dataset.location;
			window.location.href = `/product/${productId}`

		}



	};




})