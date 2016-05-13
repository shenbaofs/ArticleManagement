function getlistofarticles()  {
        var category = document.getElementById("mySelect").value;
        getArticlesService(category);
}

function myFunction(response) {
        var arr = JSON.parse(response);
        var i;
        var out = "<ul>";
        for(i = 0; i < arr.length; i++) {
            if(arr[i].category == "Java") {
                out += "<li><dt>ArticleName : </dt><dd>" +
                arr[i].articleName +
                "</dd><dt>Author : </dt><dd>" +
                arr[i].author +
                "</dd><dt>Category : </dt><dd>" +
                arr[i].category +
                "</dd><dt>Description : </dt><dd>" +
                arr[i].description +
                "</dd><dt>Date Of Publish : </dt><dd>" +
                arr[i].dateOfPublish +
                "</dd><dt>Status : </dt><dd>"
                arr[i].status +
                "</dd></li>";
            }
         }
    out += "</ul>";
    document.getElementById("articleList").innerHTML = out;
}
 
function getArticlesService(category) {
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/Article?category="+category;
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.status == 200) {
            myFunction(xmlhttp.responseText);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}