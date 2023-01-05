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
		
		fetch(`/api/search/${keyword}/${option}`)
			.then((response) => response.json())
			.then((list) => {
				
				productBox.innerHTML = "";
				
				for(let l of list){
					
					let template = `
                    <div class="product-container">
	                    <div>
	                        <img src="${l.thumbNailImg}" alt="product-img">
	                    </div>
	
	                    <div class="price-wish">
	                        <span> ${l.price}원</span>
	                    </div>
	
	                    <div class="name">${l.name}</div>
	                    <div class="time">${l.regDate}</div>
	                </div>
					`
				productBox.insertAdjacentHTML("beforeend",template);
				}
				
		         // <img th:if="${l.status == 1}" class="wish checked" src="/image/icon/icon-heart-red.svg" alt="찜" th:data-id="${l.productId}">
		         //<img th:unless="${l.status == 1}" class="wish" src="/image/icon/heart.svg" alt="찜" th:data-id="${l.productId}">
				
				}
			)
		

	}
	
})