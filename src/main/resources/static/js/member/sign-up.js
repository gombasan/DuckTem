window.addEventListener("load",function(){
	
	const userIdDuplicateCheck = document.querySelector("#uid");
	const userIdInput = document.querySelector("#userIdInput");
	const alert = document.querySelector("#userIdInput .alert");
	userIdInput.addEventListener("input", function () {
	
	    let id = userIdDuplicateCheck.value;
	    
	    if(id == "") {
	        id = "default";
	    }
	
	    fetch(`/api/user/${id}`)
        .then((response) => response.json())
        .then((isValid) =>{

            alert.classList.add("d-none");

            if(!isValid) {
                alert.classList.remove("d-none");

            }
	
	        })
	});
	
//	
//	const nickNameChk = document.querySelector(".nickName");
//	const nickNameInput = document.querySelector("#nickNameInput");
//	const alertNickName = document.querySelector("#nickNameInput .alert");
//	
//	
//	
//	nickNameInput.addEventListener("input", function () {
//	
//	    let nickName = nickNameChk.value;
//	    
//	    if(nickName == "") {
//	        nickName = "default";
//	    }
//	
//	    fetch(`/api/user/${nickName}`)
//        .then((response) => response.json())
//        .then((isValid) =>{
//
//            alertNickName.classList.add("d-none");
//
//            if(!isValid) {
//                alert.classList.remove("d-none");
//
//            }
//	
//	        })
//	});
})

