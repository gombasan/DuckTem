window.addEventListener("load", function () {
    let title = document.querySelector(".title");

    let sellingBtn = title.querySelector(".selling-btn");

    let wishListBtn = title.querySelector(".wish-list-btn");

    let reviewBtn = title.querySelector(".review-btn");

    let productPage = document.querySelector(".product-page");
    let wishListPage = document.querySelector(".wishList-page");
    let reviewPage = document.querySelector(".review");

//    내가 판매하고 있는 상품 목록 불러오기
    sellingBtn.onclick = function(e){
		wishTitleNum.init();
        productPage.classList.remove("d-none");
        wishListPage.classList.add("d-none");
        reviewPage.classList.add("d-none");
        
        
//     온클릭 이벤트가 있을 때도 초기화 되어야 함
		productPage.init();
		
    }
   
   
//   나의 판매중 상품 개수 초기화
   let myProductTitleNum = sellingBtn.lastElementChild;
   let myProductTitleNumResult;
   	myProductTitleNum.init = function(){
		myProductTitleNum.innerText = String(myProductTitleNumResult);
	}
   
//   my page 초기화 
    productPage.init = function(){
		fetch(`/myProductList`,{
			method: "GET"
		})
		.then(async(response)=>{
			let result = await response.json();
			return result;
		})
		.then((result)=>{	
			if(result == null)
				console.log("오프라인 이므로 실행하지 않습니다.");
			if(result != null){
				myProducts = result;
			}
		}).then(()=>{
			let template = null;
			for(let i=0; i<myProducts.length;i++){
				let temp = `
				    <section class="product-wrap">		
			            <div class="product-container">
			                <a href="/product/${myProducts[i].productId}">
			                    <div><img src="${myProducts[i].thumbNailImg}" alt="product-img"></div>
			
			                    <div class="price-wish">
			                        <span text="">${myProducts[i].price}원</span>	
			                        <img class ="wish" src="/image/icon/heart.svg" alt="찜" data-id = "${myProducts[i].productId}">
			                    </div>
			
			                    <div text="" class="name">
			                        ${myProducts[i].name}
			                    </div>
			
			                    <div text="" class="time">
			                        ${myProducts[i].regDate}
			                    </div>
			                </a>
			            </div>
			        </section>`;
			        if(i==0)
			        	template = temp;
			        else	
			        	template += temp;
			        
			}
		       productPage.innerHTML = template;
		       myProductTitleNumResult = myProducts.length;
		       myProductTitleNum.init();
		})
		.catch(()=>{
			console.log('에러발생');
		})
	}
    
//    productPage는 onload 될 때마다 init 되어야 함
    productPage.init();


    
//wishList=================================================================
// title 있을 때만 my-page에서 실행하고, 만들어 주기 위한 코드
	let wishTitleNum = wishListBtn.lastElementChild;
	wishTitleNum.init = function(){
		fetch(`/myPageWishNum`,{
			method: "GET"
		})
		.then((response) => response.text())
		.then((result) => {wishTitleNum.innerText = String(result)})
		.catch(()=>console.log('에러발생'));
	}

	wishTitleNum.init();

    wishListBtn.onclick = function(e){
		wishTitleNum.init();
		
        wishListPage.classList.remove("d-none");
        reviewPage.classList.add("d-none");
        productPage.classList.add("d-none");
		let wishProducts = [];
 //	찜 상품 보여주기=============================================================
		fetch(`/myWishList`,{
			method: "GET"
		})
		.then(async(response)=>{
			let result = await response.json();
			return result;
		})
		.then((result)=>{	
			if(result == null)
				console.log("오프라인 이므로 실행하지 않습니다.");
			if(result != null){
				wishProducts = result;
			}
		}).then(()=>{
			let template = null;
			for(let i=0; i<wishProducts.length;i++){
				let temp = `
				    <section class="product-wrap">		
			            <div class="product-container">
			                <a href="/product/${wishProducts[i].productId}">
			                    <div><img src="${wishProducts[i].thumbNailImg}" alt="product-img"></div>
			
			                    <div class="price-wish">
			                        <span text="">${wishProducts[i].price}원</span>	
			                        <img class ="wish checked" src="/image/icon/icon-heart-red.svg" alt="찜" data-id = "${wishProducts[i].productId}">
			                    </div>
			
			                    <div text="" class="name">
			                        ${wishProducts[i].name}
			                    </div>
			
			                    <div text="" class="time">
			                        ${wishProducts[i].regDate}
			                    </div>
			                </a>
			            </div>
			        </section>`;
			        if(i==0)
			        	template = temp;
			        else	
			        	template += temp;
			        
			}
		       wishListPage.innerHTML = template;
		        
		})
		.catch(()=>{
			console.log('에러발생');
		})

	    
    }
    
//   =================================================================
    
    reviewBtn.onclick = function(e){
        wishTitleNum.init();
        reviewPage.classList.remove("d-none");
        productPage.classList.add("d-none");
        wishListPage.classList.add("d-none"); 

    }

    // =====키워드 알림======================================================

    let profileSection = document.querySelector(".profile");
    let keywordAlert = profileSection.querySelector(".keyword-alert-btn");
    let keywordSection = document.querySelector(".keyword-alert-wrap");
    
    if(keywordSection){
	    let keywordClose = keywordSection.querySelector(".keyword-close");
	  
	    keywordAlert.onclick = function (e) {
	        e.preventDefault();
	
	        keywordSection.classList.remove("d-none");
	    }
	
	    keywordClose.onclick = function(e){
	        keywordSection.classList.add("d-none");
	    }
	}  
	
	































});