export default function wish(target){
   //   detail page 특수 기능

      let id = null;

   


      if(!target.classList.contains("checked")){ // 하트가 안눌린 것
           // fetch api
           id = target.dataset.id;

           fetch(`/${id}/wish`,{
            method: "POST"
         })
            .then((response) => response.text())
            .then((result) => {
            if(result == "/login")
               location.href = "/login";
            else if(result == "ok"){
               target.classList.add("checked");
               target.src = "/image/icon/icon-heart-red.svg";
            }

         })
         .then(()=>{
            if(target.classList.contains("bottom"))
               nums.init();
         })
         .catch(()=>{
            console.log('에러발생');
         });
         };

      if(target.classList.contains("checked")){
           // fetch api
           id = target.dataset.id;
           fetch(`/${id}/wish/delete`,{
            method: "DELETE"
         })
            .then((response) => response.text())
            .then((result) => {
            if(result =="deleteDone"){
               target.classList.remove("checked");
               target.src = "/image/icon/heart.svg";
            }
            else{
               console.log("안된다.");
            }
         })
      };
      
      
      

}

window.addEventListener("load",function(){
//   my page 빼고 적용,load와 동시에 만들어야 함
   let productsWrap = document.querySelector(".product-wrap");

// wishList check, 공통
   productsWrap.onclick = function(e){

      if(e.target.classList.contains("wish"))   {
         wish(e.target);
      }
      
      else if(!e.target.classList.contains("wish")){

         let isProductClick = e.target.parentElement.classList.contains("product-container") || e.target.tagName === "IMG"
   
         if(isProductClick) {
            let productId = e.target.parentElement.dataset.location || e.target.parentElement.parentElement.dataset.location;
            window.location.href = `/product/${productId}`
   
         }
      }



   };



});
