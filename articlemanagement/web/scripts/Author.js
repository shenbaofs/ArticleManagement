function myFunction(response) {
        var arr = JSON.parse(response);
        var i;
        var out = "<ul>";
        for(i = 0; i < arr.length; i++) {
                out += "<div>AuthorName : " +
                arr[i].authorName +
                "</div><div><Author Carrer Profile : " +
                arr[i].authorCarrerProfile +
                "</div>";
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