window.addEventListener("load",function(){
	let wish = document.querySelector(".wish");
	
	wish.onclick = function(e){
			
        if(!e.target.classList.contains("checked")){
			wish.classList.add("checked");
			wish.src = "/image/icon/icon-heart-red.svg";		
		}
		else if(e.target.classList.contains("checked")){
			wish.classList.remove("checked");
			wish.src = "/image/icon/heart.svg";
		}
	}
	
	
})