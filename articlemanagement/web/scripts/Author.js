function myFunction(response) {
        var arr = JSON.parse(response);
        var i;
        var out = "<ul>";
        for(i = 0; i < arr.length; i++) {
                out += "<li><dt>AuthorName : </dt><dd>" +
                arr[i].authorName +
                "</dd><dt>Author Carrer Profile : </dt><dd>" +
                arr[i].authorCarrerProfile +
                "</dd>";
            }
    out += "</ul>";
    document.getElementById("authordetails").innerHTML = out;
}

function getdetailsOfAuthor(authorId) {
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/Article?authorId="+authorId;
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.status == 200) {
            myFunction(xmlhttp.responseText);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}