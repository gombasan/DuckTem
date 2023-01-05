window.addEventListener("load", function(){
	let productContainer = document.querySelectorAll(".product-container");
	if(productContainer){
		
		for(let product of productContainer){
			product.onclick=function(e){
				if(e.target.classList.contains("wish"))
					return;
				let productId = product.dataset.location;	
				location.href = "/product/" + productId;
			}
		}
	}
	
	
});

