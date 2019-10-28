let main = document.getElementById('main');
let categoryItems = document.getElementsByClassName('category__item');
let vote = document.getElementsByClassName('vote');

//show vote panel and click then hide
Array.from(vote).forEach(element => {
    element.addEventListener('click', showVotePanel);
});
// end

for (let i = 0; i < categoryItems.length; i++) {
    categoryItems[i].onclick = function () {
        for (let i = 0; i < categoryItems.length; i++) {
            categoryItems[i].classList.remove('category__item--active');
            categoryItems[i].classList.remove('category__item--border');
        }
        categoryItems[i].classList.add('category__item--active');
        categoryItems[i].classList.add('category__item--border');
    }
}