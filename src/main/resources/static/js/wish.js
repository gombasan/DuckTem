window.addEventListener("load",function(){
	let main = document.querySelector("main");
	
	main.onclick = function(e){
		if(e.target.classList.contains("wish"))	{
			e.preventDefault();

//			if(`${member.userId}`== ""){
//				console.log("찍히고는 있는가???")
//				if(confirm("로그인 안 함. 로그인 하실?"))
//					location.href='/login';
//			}
			
	        if(!e.target.classList.contains("checked")){ // 하트가 안눌린 것  
		        // fetch api
		        
		        let id = e.target.dataset.id;

		        fetch(`${id}/wish`,{
					method: "POST"
				})
	            .then((response) => {
					e.target.classList.add("checked");
					e.target.src = "/image/icon/icon-heart-red.svg";	
//					console.log(e.target.dataset.id);
				})                              			
				.catch(()=>{
					console.log('에러발생');
				})
				}
/*			else if(e.target.classList.contains("checked")){
		        // fetch api
		        fetch(`/wish/wishList`,{
					method: "PUT",
					body: JSON.stringify({
					status: false
					}),			
				})		
	            .then((response) => response.json())     
					e.target.classList.remove("checked");
					e.target.src = "/image/icon/heart.svg";
				}*/
		}
	}
	
	
	
	
})