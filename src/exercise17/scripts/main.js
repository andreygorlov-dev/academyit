var product = new Array();

function onClickMenu(item) {	
	var homeBlock = document.getElementById("home_block");
	var catalogBlock = document.getElementById("catalog_block");
	homeBlock.style.display = "none";
	catalogBlock.style.display = "inline";
	switch (item) {
		case "Mother_Board":
			fillProducts("Материнская плата");
			break;
		case "Video_Card":
			fillProducts("Видео карта");
			break;
		case "CPU":
			fillProducts("Процессор");
			break;
		case "RAM":
			fillProducts("ОЗУ");
			break;
		case "ROM":
			fillProducts("ПЗУ");
			break;
		case "Power_Supply":
			fillProducts("Блок питания");
			break;
		case "Accessories":
			fillProducts("Аксессуар");
			break;
		default:
			break;
	}

	createPanels(catalogBlock)

}

function createPanels(block) {
	block.innerHTML = "";
	product.forEach(item => {
		block.innerHTML += "<div class='product'>" +
						   "<h2>" + item.title + "</h2>" + 
						   "<h3>" + item.price + "</h3>" + 
						   "<button>Добавить в корзину</button>" + 
						   "</div>"
	});
}

/**
 *В дальнейшем будет заменено на чтение из api 
 */
function fillProducts(name) {
	for (var i = 0; i < 10; i++) {
		product[i] = {
			title: name + i,
			price: "100Р"
		}
	}
}