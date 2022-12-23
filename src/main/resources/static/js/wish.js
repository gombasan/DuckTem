window.addEventListener("load",function(){
	let main = document.querySelector("main");
	
	main.onclick = function(e){
	
		if(e.target.classList.contains("wish"))	{
			e.preventDefault();
	        if(!e.target.classList.contains("checked")){
				e.target.classList.add("checked");
				e.target.src = "/image/icon/icon-heart-red.svg";		
			}
			else if(e.target.classList.contains("checked")){
				e.target.classList.remove("checked");
				e.target.src = "/image/icon/heart.svg";
			}
		}
	}
	
	
	
	
	
	
	
})