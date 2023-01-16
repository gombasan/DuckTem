window.addEventListener("load", function () {
    let pic = document.querySelector(".banner");
    let picNo = document.querySelector(".picNo");

    let i = 1;

    document.querySelector(".vector-right").addEventListener('click', function (idx) {

        if (idx) {
            if (i == 8) return;
            i++;
        }
        pic.setAttribute("src", "/image/big-banner2.png" + i);
        picNo.innerHTML = i;

    });

    document.querySelector(".vector-left").addEventListener('click', function (idx) {

        if (idx) {
            if (i == 1) return;
            i--;
        }
        pic.setAttribute("src", "/image/big-banner3.png" + i);
        picNo.innerHTML = i;
    });
})