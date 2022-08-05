var basket = new Set();
var motherBoardData;

function onClickMenu(item) {	
	var homeBlock = document.getElementById("home_block");
	homeBlock.style.display = "none";
	fillProducts(item);
}

function addInBasket(index) {
	basket.add(motherBoardData[index]);
	let basketDiv = document.getElementById("basket");
	basketDiv.innerHTML = "<h2>Корзина:</h2>";
	let sumItemsRub = 0;
	let sumItemsUsd = 0;
	basket.forEach(item => {
		let element = document.createElement('p');
		element.innerHTML = "Название товара" + item.title + "<br> Цена в рублях " + item.price + "<br> Цена в доллах " + item.usd;
		basketDiv.appendChild(element);
		sumItemsRub += item.price * 1;
		sumItemsUsd += item.usd * 1;
	});
	basketDiv.innerHTML += "<h2>Фулл цена в рублях " + sumItemsRub + " Фулл цена в долларах " + sumItemsUsd + "</h2>";
}

/**
 *В дальнейшем будет заменено на чтение из api 
 */
function fillProducts(url) {
	var catalogBlock = document.getElementById("catalog_block");
	catalogBlock.style.display = "inline";
	fetch("scripts/" + url)
        .then(text => text.json()) //text - это исходный код файла, к которому коннектились. А json() - преобразует строку json из файла в объект js и возвращает объект Promise
        .then(data => {//data - это коллекция объектов, полученных после json()
			catalogBlock.innerHTML = "";
			motherBoardData = data;
            data.forEach((item, index) => {
			fetch('https://www.cbr-xml-daily.ru/daily_json.js')
				.then(text => text.json()) 
				.then(data => {
					usd = data.Valute.USD.Value;
					item.usd = (item.price / usd).toFixed(2);
					catalogBlock.innerHTML += `<div class='row'>` +
						   `<div class='product col-12'>` +
						   `<img style='width: 100px; height:100px;' src='` + item.img + `'>` +
						   `<h2>` + item.title + `</h2>` + 
						   `<h3>` + item.price + `Р</h3>` + 
						   `<h3>` + item.usd + `$</h3>` + 
						   `<button onclick="addInBasket(` + index + `)" id='addBasket` + index + `'>Добавить в корзину</button>` + 
						   `</div>` +
						   `</div>`;
				});
				
			});
        });
}