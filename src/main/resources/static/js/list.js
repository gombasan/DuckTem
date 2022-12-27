window.addEventListener("load", function() {


	const superCategoryBox = document.querySelector(".supercategory")
	const categoryBox = document.querySelector(".subcategory")
	let superCategory = this.document.querySelectorAll(".supercategory span");
	superCategory[0].classList.add("selected");

	let currentLi = document.querySelector(".supercategory span.selected");


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


		let queryString = `?c=${currentLi.dataset.id}`;

		if (currentLi.dataset.id == null)
			queryString = "";

		fetch(`/api/lists${queryString}`, {
			method: "GET"
		})
			.then((response) => response.json())
			.then((data) => {
				console.log(data[0])
				categoryBox.innerHTML = "";

			
				let index = 1;

				for (let i of data) {

					let template =
						`
			<span>
                <input  type="checkbox" name="" id="${index}-btn">
                <label class="btn btn-default aaa" for="${index}-btn">${i.categoryName}</label>
            </span>
			`
					index++;
					
					let el = new DOMParser()
						.parseFromString(template, "text/html")
						.body
						.firstElementChild;

					categoryBox.append(el);
				}




			})


	}







})