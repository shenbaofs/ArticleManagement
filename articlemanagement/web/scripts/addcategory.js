function newcategory() {
    var category = document.getElementById("categoryname").value;
    document.cookie = "newcategory=" + category;
    var url = "http://localhost:8080/articlemanagement/Category";
    var jsonVal = {
        "categoryName" : category
    };
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url , true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onreadystatechange = function () {
        console.log(xhr.status);
        if (xhr.readyState === 4) {            
            alert("category added successfully !!...");
            location.href='article.html';
        }
    };
        xhr.send(JSON.stringify(jsonVal));
}

function cancel() {
    alert("Do you want to cancel?...");
    location.href='signin.html';
}