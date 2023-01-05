window.addEventListener("load", function(){
	const searchFilter = document.querySelector(".search-filter");
	const productBox = document.querySelector(".product-wrap");
	const keywordBox = document.querySelector(".search-result");
	
	searchFilter.onchange = function(e){
		e.preventDefault();
		let el = e.target;
		let option = null;
		
		
		for(let i=0; i<el.length; i++){
			if(el.options[i].selected){
				option= el.options[i].value;
				break;
			}
		}
		
		let keyword = keywordBox.innerHTML;
		
		console.log("keyword = "+keyword);//맞게 나옴
		
		fetch(`/api/search/${keyword}/${option}`)
			.then((response) => response.json())
			.then((list) => {
				
				productBox.innerHTML = "";
				
				for(let p of list){
					
					let template = `
	                    <div>
	                        <img th:src="${p.thumbNailImg}" alt="product-img">
	                    </div>
	
	                    <div class="price-wish">
	                        <span th:text="${p.price}"> 80,000원</span>
	                        <img th:if="${p.status == 1}" class="wish checked" src="/image/icon/icon-heart-red.svg" alt="찜" th:data-id="${p.productId}">
	                     	<img th:unless="${p.status == 1}" class="wish" src="/image/icon/heart.svg" alt="찜" th:data-id="${p.productId}">
	                    </div>
	
	                    <div th:text="${p.name}" class="name">러브다이브미공포</div>
	                    <div th:text="${p.regDate}" class="time">0일 전</div>
	                </div>
					`
					
				}
				
				}
			)
		

	}
	
})