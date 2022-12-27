window.addEventListener("load", function() {

	const userIdDuplicateCheck = document.querySelector("#uid");
	const userIdInput = document.querySelector("#userIdInput");
	const alert = document.querySelector("#userIdInput .alert");

	const nickNameChk = document.querySelector(".nickName");
	const nickNameInput = document.querySelector("#nickNameInput");
	const alertNickName = document.querySelector("#nickNameInput .alert");
	
	const pwdInput = document.querySelector(".pwdInput");
	const pwdAlert = pwdInput.querySelector(".alert");
	const pwd1 = pwdInput.querySelector(".pwd1");
	const pwd2 = pwdInput.querySelector(".pwd2");
	
	pwdInput.addEventListener("input", function(){
		
		let p1 = pwd1.value;
		let p2 = pwd2.value;
		
		if(p1 != "" && p2 != "" && p1 != p2)
			pwdAlert.classList.remove("d-none");
		else
			pwdAlert.classList.add("d-none");
	
		
	})

	userIdInput.addEventListener("input", function() {

		let id = userIdDuplicateCheck.value;

		if (id == "") {
			id = "default";
		}

		fetch(`/api/user/${id}`)
			.then((response) => response.json())
			.then((isValid) => {

				alert.classList.add("d-none");

				if (!isValid) {
					alert.classList.remove("d-none");

				}

			})
	});

	nickNameInput.addEventListener("input", function() {

		let nickName = nickNameChk.value;

		if (nickName == "") {
			nickName = "default";
		}

		fetch(`/api/user/nickchk/${nickName}`)
			.then((response) => response.json())
			.then((result) => {

				alertNickName.classList.add("d-none");

				if (!result) {
					alertNickName.classList.remove("d-none");
				}
			})
	});


})

