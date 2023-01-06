
window.addEventListener("load", function () {
    let title = document.querySelector(".title");

    let sellingBtn = title.querySelector(".selling-btn");

    let wishListBtn = title.querySelector(".wish-list-btn");

    let reviewBtn = title.querySelector(".review-btn");

    let productPage = document.querySelector(".product-page");
    let wishListPage = document.querySelector(".wishList-page");
    let reviewPage = document.querySelector(".review");

//    내가 판매하고 있는 상품 목록 불러오기
    sellingBtn.onclick = function(){
		wishTitleNum.init();
        productPage.classList.remove("d-none");
        wishListPage.classList.add("d-none");
        reviewPage.classList.add("d-none");
        
        pageInfo("myProductList","GET",productPage,myProductTitleNum);
		
    }
   
   
//   나의 판매중 상품 개수 초기화
   let myProductTitleNum = sellingBtn.lastElementChild;
   let myProductTitleNumResult;
   	myProductTitleNum.init = function(){
		myProductTitleNum.innerText = String(myProductTitleNumResult);
	}

    let pageInfo = function(myPageInfo,methodType,place,titleNum){
		
		fetch(`/${myPageInfo}`,{
			method: methodType
		})
		.then(async(response)=>{
			let result = await response.json();
			return result;
		})
		.then((result)=>{	
			if(result == null)
				console.log("오프라인 이므로 실행하지 않습니다.");
			if(result != null){
				products = result;
			}
		}).then(()=>{
			let template = null;
			let tempHeart = null;
			for(let i=0; i<products.length;i++){
				if(products[i].status == 1)
					tempHeart = `<img class ="wish checked" src="/image/icon/icon-heart-red.svg" alt="찜" data-id = "${products[i].productId}">`
				else
					tempHeart = `<img class ="wish" src="/image/icon/heart.svg" alt="찜" data-id = "${products[i].productId}">`

				let temp = `
			            <div class="product-container" data-location="${products[i].productId}">
		                    <div><img src="${products[i].thumbNailImg}" alt="product-img"></div>
		
		                    <div class="price-wish">
		                        <span text="">${products[i].price}원</span>
		                        ${tempHeart}
		                   </div>
		
		                    <div text="" class="name">
		                        ${products[i].name}
		                    </div>
		
		                    <div text="" class="time">
		                        ${products[i].regDate}
		                    </div>
			            </div>`;
			        
			        if(i==0)
			        	template = temp;
			        else	
			        	template += temp;
			        
			}
		       place.innerHTML = template;
		       titleNum.innerText = String(products.length);
		       
		})
		.catch(()=>{
			console.log('에러발생');
		})
	}
    
    
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

    wishListBtn.onclick = function(){
        wishListPage.classList.remove("d-none");
        reviewPage.classList.add("d-none");
        productPage.classList.add("d-none");
        pageInfo("myWishList","GET",wishListPage,wishTitleNum);
        	    
    }
    
//   =================================================================
   let myReviewTitleNum = reviewBtn.lastElementChild;
   let myReviewtTitleNumResult;
   let myPageReviews = [];
   	myReviewTitleNum.init = function(){
		myReviewTitleNum.innerText = String(myReviewtTitleNumResult);
	} 
	
    reviewBtn.onclick = function(){
        wishTitleNum.init();
        reviewPage.classList.remove("d-none");
        productPage.classList.add("d-none");
        wishListPage.classList.add("d-none"); 
    }
    
    fetch(`/getMyReviewList`,{
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
				myPageReviews = result;
			}
		}).then(()=>{
			let template = null;
			for(let i=0; i<myPageReviews.length;i++){
				if(!myPageReviews[i].profileImg){
					myPageReviews[i].profileImg = "/image/profile-img.png";
				}
				
				let temp = `
					<div class="review-detail">
	                    <div><img src="${myPageReviews[i].profileImg}" alt=""></div>
	                    <div>${myPageReviews[i].memberId}</div>
	                    <div>${myPageReviews[i].regDate}</div>
	                    <div><img src="/image/icon/report.svg" alt=""></div>
	                    <div>${myPageReviews[i].productName}</div>
	                    <div>${myPageReviews[i].content}</div>
	                </div>
				`;
			        if(i==0)
			        	template = temp;
			        else	
			        	template += temp;
			        
			}
			if(template!=null){				
		       reviewPage.insertAdjacentHTML('beforeend',template);
		       myReviewtTitleNumResult = myPageReviews.length;
		       myReviewTitleNum.init();
			}
		        
		})
		.catch(()=>{
			console.log('에러발생');
		})

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