function getCategory(response) {
    var arr = JSON.parse(response);
    categoryList = arr;
    var i;
    var out = "<table><tr><th>Category Id</th><th>Category Name</th></tr>";
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

function selectFunction(response) {
    var arr = JSON.parse(response);
    categoryList = arr;
    var i;
    var out = "<select id='selectcategory' onchange='getlistofarticles()'>";
    for(i = 0; i < arr.length; i++) {
        out += "<option>" +
        arr[i].categoryName +
        "</option>"; 
    }         
    out += "</select>";
    document.getElementById("categories").innerHTML = out;
    getlistofarticles();
}
 
function getlistofcategory(isDropdown) {
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/Category";
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.status == 200) {
            if(isDropdown != 'false') {
                selectFunction(xmlhttp.responseText);
            } else {
                getCategory(xmlhttp.responseText);
            }
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

 