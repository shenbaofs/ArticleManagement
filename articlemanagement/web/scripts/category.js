function myFunction(response) {
        var arr = JSON.parse(response);
        userList = arr;
        var i;
        var out = "<table><tr><th>Category Id</th><th>Category Name</th>";
        for(i = 0; i < arr.length; i++) {
                out += "<tr><td>" +
                arr[i].categoryId +
                "</td><td>" +
                arr[i].categoryName +
                "</td></tr>";
     }
    out += "</table>";
    document.getElementById("category").innerHTML = out;
}
 
function getlistofcategory() {
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/Category";
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.status == 200) {
            myFunction(xmlhttp.responseText);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}