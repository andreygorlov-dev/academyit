<html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script>
    function load() {
        fetch("/Internet_Shop_war/categories")
            .then(text => text.json())
            .then(data => {
                data.forEach((item) => {
                    document.getElementById("menu")
                        .innerHTML += "<li class='nav-item dropdown'>" +
                        "<a onclick='onClickMenu(" + item.id + ")' class='nav-link' href='#' id='navbarDropdown'>" + item.title + "</a>" +
                        "</li>";
                });
            });
    }

    function onClickMenu(id) {
        console.log(id);
        fetch("/Internet_Shop_war/products?category_id=" + id)
            .then(text => text.json())
            .then(data => {
                document.getElementById("content").innerHTML = "";
                data.forEach((item) => {
                    console.log(item);
                    document.getElementById("content")
                        .innerHTML += "<tr>" +
                        "<td>" + item.title + "</td>" +
                        "<td><img src='" + item.img + "'/></td>" +
                        "<td>" + item.description + "</td>" +
                        "<td>" + item.price + "</td>" +
                        "<td><button onclick='addProductInBasket(" + item.id + ")'>Добавить в корзину</button></td>"
                    "</tr>";
                });
            });
    }

    function addProductInBasket(id) {

    }

</script>
<body onload="load()">
<header class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto" id="menu">

        </ul>
    </div>
</header>
<div class="container mt-5 pt-5">
    <table id="content">

    </table>
</div>
</body>
</html>
