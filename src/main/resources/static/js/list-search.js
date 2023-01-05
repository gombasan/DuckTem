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
					
					let wishStatus = "wish";
					let wishSrc = "/image/icon/heart.svg"

					console.log(l.status);
					if(l.status == 1){
						wishStatus = "wish checked";
						wishSrc = "/image/icon/icon-heart-red.svg"
					}

					let template = `
                    <div class="product-container">
	                    <div>
	                        <img src="${l.thumbNailImg}" alt="product-img">
	                    </div>
	
	                    <div class="price-wish">
	                        <span> ${l.price}원</span>
					        <img class="${wishStatus}" src="${wishSrc}" alt="찜">
	                    </div>
	
	                    <div class="name">${l.name}</div>
	                    <div class="time">${l.regDate}</div>
	                </div>
					`
				productBox.insertAdjacentHTML("beforeend",template);
							
				}
				
				
				}
			)

	}
	
})