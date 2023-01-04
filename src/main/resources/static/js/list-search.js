window.addEventListener("load", function(){
	const searchFilter = document.querySelector(".search-filter");
	
	searchFilter.onchange = function(e){
//		console.log("change");
		e.preventDefault();
		let el = e.target;
		let option = null;
		
		
		for(let i=0; i<el.length; i++){
			if(el.options[i].selected){
				option= el.options[i].value;
				break;
			}
		}
		
//		switch(option){
//			case 'latest'://regDate
//				console.log("1");
//				option
//				break;
//			case 'price-high'://price
//				console.log("2");
//				break;
//			case 'price-low'://price
//				console.log("3");
//				break;
//			case 'most-viewed'://hits
//				console.log("4");
//				break;
//		}
		
//		fetch(`/api/search/${keyword}/${option}`)
//			.then((response) => response.json())
//			.then((list) => {
//				//작성중
//				}
//			)
		

	}
	
})