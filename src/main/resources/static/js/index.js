function addBook() {
    $.ajax({
        url: '/add_book',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            name: document.getElementById("name").value,
            year: document.getElementById("year").value,
            author: document.getElementById("author").value

        }),
        success: function () {
            alert("Книга добавлена")
        }
    })
}

function showBook() {
    $.get('/showBooks', function (data) {
        let out = document.getElementById("book_1")

        let table = "<table> <tr><th>id</th><th>Название</th><th>Год</th><th>Автор</th></tr>";

        for (i = 0; i<data.length; i++){
            table = table + "<tr><td>" + data[i].id +"</td>" +
                "<td>" + data[i].name + "</td>" +
                "<td>" + data[i].year + "</td>" +
                "<td>" + data[i].author +"</td></tr>";
        }
        table = table + "</table>";

        out.innerHTML = table;
    })
}

function deleteBook() {
    $.ajax({
        url: '/deleteBook',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            id: document.getElementById("id").value
        }),
        success: function () {
            alert("Книга удалена!")
        }
    })
}

function updateBook() {
    $.ajax({
        url: '/updateBook',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            name: document.getElementById('up_book').value,
            year: document.getElementById("up_year").value,
            author: document.getElementById("up_author").value,
            id: document.getElementById('up_id').value
        }),
        success: function () {
            alert('Информация о книге обновлена!!!!')
        }
    })
}

function ratingAuthor() {
    $.get('/showBooks', function (data) {
        let inp_author = document.getElementById("reit_author").value;
        let rating = 0;
        let table = "<table> <tr><th>Название книги</th></tr>";

        for (i = 0; i<data.length; i++) {
            if (data[i].author == inp_author) {
                rating++;
                table = table +  "<tr></tr><td>" + data[i].name + "</td></tr>"
            }
        }
        table = table + "</table>";
        document.getElementById("reit").innerHTML = rating;
        document.getElementById("list_books").innerHTML = table;
    })
}
