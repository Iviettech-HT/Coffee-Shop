categoryItem = document.getElementsByClassName("category__item");
categoryItem[1].addEventListener("click", getAllProduct2);

function getAllProduct2(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "/list-san-pham?name=" + "caphe");
    xhttp.send();
    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == 4 && xhttp.status == 200){
            console.log(xhttp.responseText);
        }
    }
}


