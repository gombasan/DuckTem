window.addEventListener("load", function() {


	const superCategoryBox = document.querySelector(".supercategory")
	const categoryBox = document.querySelector(".subcategory")
	let superCategory = this.document.querySelectorAll(".supercategory span");
	superCategory[0].classList.add("selected");

	let currentLi = document.querySelector(".supercategory span.selected");




//  =========== 대분류 선택을 위한 함수 ==========
	superCategoryBox.onclick = function(e) {
		e.preventDefault();

		const el = e.target;

		if (el.tagName != "SPAN" && el.tagName != "A")
			return;


		let li;

		if (el.tagName == "A")
			li = el.parentElement;



		li.classList.add("selected");
		currentLi.classList.remove("selected");
		currentLi = li;


		let queryString = `?sup=${currentLi.dataset.id}`;

		if (currentLi.dataset.id == null)
			queryString = "";

		fetch(`/api/lists${queryString}`, {
			method: "GET"
		})
			.then((response) => response.json())
			.then((data) => {
				console.log(data[0])
				categoryBox.innerHTML = "";

	

				for (let i of data) {
					
					let template =
			`
			<span>
                <input  type="checkbox" name="" id="${i.categoryId}-btn">
                <label data-id="${i.categoryId}" class="btn btn-default aaa" for="${i.categoryId}-btn">${i.categoryName}</label>
            </span>
			`

					
					let el = new DOMParser()
						.parseFromString(template, "text/html")
						.body
						.firstElementChild;

					categoryBox.append(el);
				}



			let selectAlltemplate =
						`
			<span>
                <input type="checkbox" name="" id="selectAll-btn">
                <label class="btn btn-default aaa" for="selectAll-btn">전체보기</label>
            </span>
			`
			
			
			categoryBox.insertAdjacentHTML("afterbegin",selectAlltemplate);

			})
			
			
	}
	
	
//  =========== 소분류 선택을 위한 함수 ==========
	categoryBox.onclick = function(e) {
		
		
		
		
	}
	
	
	
	







})