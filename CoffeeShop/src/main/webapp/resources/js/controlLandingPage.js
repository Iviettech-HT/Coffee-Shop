let product = document.getElementsByClassName('product')[0];

categoryItems = document.getElementsByClassName('category__item');

for(let categoryItem of categoryItems){
    categoryItem.addEventListener('click', function(){getAllProduct(categoryItem.children[0].innerHTML)});
}

function getAllProduct(name){
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', '/CoffeeShop/list-san-pham?name=' + name);
    xhttp.send();
    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == 4 && xhttp.status == 200){
            product.innerHTML = xhttp.responseText;
        }
    }
}


