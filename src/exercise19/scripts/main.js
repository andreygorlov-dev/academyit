var basket = new Map();
var products = [
	{
		"id" : 0,
		"title" : "GIGABYTE H310M S2",
		"price" : 3000,
		"img" : "https://c.dns-shop.ru/thumb/st1/fit/wm/0/0/ff32f04c3b6ea94219f22887d73e0996/1e63841f75670d4fd978140be4c702bf449561f2a88e19a51fe72d6d20c36b59.jpg",
		"description" : "Материнская плата GIGABYTE H310M S2 – хорошая основа для сборки компьютера."
	}, {
		"id" : 1,
		"title" : "Esonic G41CPL3",
		"price" : 4,
		"img" : "https://c.dns-shop.ru/thumb/st1/fit/500/500/b32633f710ecbd75ae75fb09a85f3ebe/c8e470a41ad73b6329c8f6d3b6ee297aa7fb367f3188bebee790872ca4c6a90f.jpg",
		"description" : "Материнская плата Esonic G41CPL3 предназначена для создания компактных домашних и офисных систем."
	}, {
		"id" : 2,
		"title" : "GIGABYTE H310M H",
		"price" : 2999,
		"img" : "https://c.dns-shop.ru/thumb/st1/fit/500/500/ac3102d31926c26ec6a538d2b644a8d1/349b354b192ec1a1791f67972a4c9a5fca5cc108b33bb00339640c0be721a53f.jpg",
		"description" : "Материнская плата GIGABYTE H310M H оптимальна для сборки компьютера офисного класса, применение которому можно будет найти и дома."
	}
];

function onClickMenu(item) {	
	var homeBlock = document.getElementById("home_block");
	homeBlock.style.display = "none";
	fillProducts(item);
}

function addInBasket(index) {
	if (basket.get(products[index]) == undefined) {
		basket.set(products[index], 1);
	} else {
		basket.set(products[index], basket.get(products[index]) + 1);
	}
	let basketDiv = document.getElementById("basket");
	basketDiv.innerHTML = "<h2>Корзина:</h2>";
	let sumItemsRub = 0;
	basket.forEach((value, key) => {
		let element = document.createElement('p');
		element.innerHTML = "Название товара" + key.title + "<br> Цена в рублях " + key.price + "<br>Колличество: " + value;
		basketDiv.appendChild(element);
		sumItemsRub += key.price * value;
	});
	basketDiv.innerHTML += "<h2>Полная цена в рублях " + sumItemsRub + "</h2>";
	let clearButton = document.createElement("button");
	clearButton.innerHTML = "Очистить корзину";
	clearButton.addEventListener("click", function() {
		basket.clear();
		basketDiv.innerHTML = "<h2>Корзина:</h2>";
	});
	basketDiv.appendChild(clearButton);
}

/**
 *В дальнейшем будет заменено на чтение из api 
 */
function fillProducts(url) {
	var catalogBlock = document.getElementById("catalog_block");
	catalogBlock.style.display = "inline";
	catalogBlock.cle = "";
	products.forEach((item, index) => {
		let block = `<div class='row'>` +
		`<div class='product col-12'>` +
		`<img style='width: 100px; height:100px;' src='` + item.img + `'>` +
		`<h2>` + item.title + `</h2>` + 
		`<h3>` + item.price + `Р</h3>` + 
		`<button onclick="addInBasket(` + index + `)" id='addBasket` + index + `'>Добавить в корзину</button>` + 
		`</div>` +
		`</div>`;
		catalogBlock.innerHTML += block;
	});
}