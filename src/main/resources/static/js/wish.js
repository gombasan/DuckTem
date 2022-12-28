window.addEventListener("load",function(){
	let main = document.querySelector("main");
	let bottomWrap = document.querySelector(".bottom-bar-wrap");
	let wishes = main.querySelectorAll(".wish");
	let nums = main.querySelector(".nums");
	let id = null;
	
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
			.catch(()=>console.log('에러발생'))
		}
	
		nums.init();
	}
		

//	wishes 초기화
	wishes.init = function(){
		
		fetch(`/wish`,{
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
			for(let i = 0; i<wishes.length;i++){
				for(let j=0; j<result.length; j++){
					if(wishes[i].dataset.id == result[j].productId){
						wishes[i].src = "/image/icon/icon-heart-red.svg";
						wishes[i].classList.add("checked");
					}
				}
			}	
				
			}		
		})
		
	}	
	
	wishes.init();

	
// wishList check
	main.onclick = function(e){
		
		if(e.target.classList.contains("wish"))	{
			e.preventDefault();
			
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
				})
				}
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
				})
				}
				

		}
	}
	
	
	
	
})