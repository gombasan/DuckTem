window.addEventListener("load", function() {


	const superCategoryBox = document.querySelector(".supercategory")
	const categoryBox = document.querySelector(".subcategory")
	const productBox = document.querySelector(".product-wrap");
	let superCategory = this.document.querySelectorAll(".supercategory span");
	let superCategoryId = 1;
	superCategory[0].classList.add("selected");

	const URLSearch = new URLSearchParams(location.search);
	let supercate = URLSearch.get('super');
	superCategory[0].classList.remove("selected");
	superCategory[supercate-1].classList.add("selected");


	//  =========== 대분류 선택을 위한 함수 ==========
	superCategoryBox.onclick = function(e) {
		let currentLiForSuperCategory = document.querySelector(".supercategory span.selected");


		e.preventDefault();

		const el = e.target;

		if (el.tagName != "SPAN" && el.tagName != "A")
			return;


		let li;

		if (el.tagName == "A")
			li = el.parentElement;



		li.classList.add("selected");
		currentLiForSuperCategory.classList.remove("selected");
		currentLiForSuperCategory = li;


		let queryString = `?super=${currentLiForSuperCategory.dataset.id}`;
		superCategoryId = currentLiForSuperCategory.dataset.id;

		if (currentLiForSuperCategory.dataset.id == null)
			queryString = "";

		fetch(`/api/lists${queryString}`, {
			method: "GET"
		})
			.then(response => response.json())
			.then(data => {

				let result = data.resultObject;
				categoryBox.innerHTML = "";
				productBox.innerHTML = "";
				
console.log(Object.values(data))
console.log(data)
console.log(data['categoryList'])


				//for (let i of data[Object.keys(data)[0]]) {
					for (let i of data['categoryList']) {


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
                <label data-id="-1" class="btn btn-default aaa selectAll" for="selectAll-btn">전체보기</label>
            </span>
			`

				categoryBox.insertAdjacentHTML("afterbegin", selectAlltemplate);


				for (let i of data[Object.keys(data)[1]]) {

					let template =
						`
				<div class="product-container"  >
				<a href="/product/${i.productId}">
					<div>
						<img src="${i.thumbNailImg}" alt="product-img">
					</div>

					<div class="price-wish">
						<span>${i.price}</span> 
						<img class="wish" src="/image/icon/heart.svg" alt="찜" value="${i.productId}">
					</div>

					<div class="name">${i.name}</div>

					<div class="time">${i.regDate}</div>
				</a>
			</div>
				`

					let el = new DOMParser()
						.parseFromString(template, "text/html")
						.body
						.firstElementChild;

					productBox.append(el);

				}



			})


	}




	//  =========== 소분류 선택을 위한 함수 ==========
	categoryBox.onclick = function(e) {
		let currentLiForCategory = document.querySelector(".subcategory span label:checked");

		e.preventDefault();

		const el = e.target;
		let li;

		if (el.tagName != "SPAN" && el.tagName != "INPUT" && el.tagName != "LABEL")
			return;

		if (el.tagName == "LABEL")
			li = el;

		currentLiForCategory = li;

		let queryString = `?super=${superCategoryId}&cate=${currentLiForCategory.dataset.id}`;

		fetch(`/api/lists${queryString}`, {
			method: "GET"
		})
			.then(response => response.json())
			.then(data => {

				productBox.innerHTML = "";

				for (let i of data[Object.keys(data)[1]]) {

					let template =
						`
				<div class="product-container">
				
					<div>
						<img src="${i.thumbNailImg}" alt="product-img">
					</div>

					<div class="price-wish">
						<span>${i.price}</span> 
						<img class="wish" src="/image/icon/heart.svg" alt="찜" value="${i.productId}">
					</div>

					<div class="name">${i.name}</div>

					<div class="time">${i.regDate}</div>
				
			</div>
				`
					let el = new DOMParser()
						.parseFromString(template, "text/html")
						.body
						.firstElementChild;

					productBox.append(el);

				}

			})





	}









})