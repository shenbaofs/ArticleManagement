function getlistofarticles()  {
        var category = document.getElementById("mySelect").value;
        getArticlesService(category);
}

function myFunction(response) {
        var arr = JSON.parse(response);
        var i;
        var out = "<ul>";
        for(i = 0; i < arr.length; i++) {
            if(arr[i].category == "AngularJs") {
                out += "<li><dt>ArticleName : </dt><dd>" +
                arr[i].articleName +
                "</dd><dt>AuthorName : </dt><dd><a href='author.html' onclick='getdetailsOfAuthor("+arr[i].authorId+")'>" +
                arr[i].authorName +
                "</a></dd><dt>Category : </dt><dd>" +
                arr[i].category +
                "</dd><dt>Description : </dt><dd>" +
                arr[i].description +
                "</dd><dt>Date Of Publish : </dt><dd>" +
                arr[i].dateOfPublish +
                "</dd><dt>Status : </dt><dd>" +
                arr[i].status +
                "</dd>";
                if(arr[i].status == 'APPROVED') {
                    out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'DisApproved'>DISAPPROOVE</button></dd>"
                } else if(arr[i].status == 'DISAPPROVED') {
                     out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'Approved'>APPROOVE</button></dd>"
                } else if(arr[i].status == 'WFA') {
                    out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'Approved'>APPROOVE</button> <button id = 'status' value = 'DisApproved'>DISAPPROOVE</button></dd>"
                } 
                    out += "</li>";
                } else if(arr[i].category == "Business") {
                    out += "<li><dt>ArticleName : </dt><dd>" +
                    arr[i].articleName +
                    "</dd><dt>AuthorName : </dt><dd><a href='author.html' onclick='getdetailsOfAuthor("+arr[i].authorId+")'>" +
                    arr[i].authorName +
                    "</a></dd><dt>Category : </dt><dd>" +
                    arr[i].category +
                    "</dd><dt>Description : </dt><dd>" +
                    arr[i].description +
                    "</dd><dt>Date Of Publish : </dt><dd>" +
                    arr[i].dateOfPublish +
                    "</dd><dt>Status : </dt><dd>" +
                    arr[i].status +
                    "</dd>";
                    if(arr[i].status == 'APPROVED') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'DisApproved'>DISAPPROOVE</button></dd>"
                    } else if(arr[i].status == 'DISAPPROVED') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'Approved'>APPROOVE</button></dd>"
                    } else if(arr[i].status == 'WFA') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'Approved'>APPROOVE</button> <button id = 'status' value = 'DisApproved'>DISAPPROOVE</button></dd>"
                    }
                        out += "</li>";
            }  else if(arr[i].category == "Workworld") {
                    out += "<li><dt>ArticleName : </dt><dd>" +
                    arr[i].articleName +
                    "</dd><dt>AuthorName : </dt><dd><a href='author.html' onclick='getdetailsOfAuthor("+arr[i].authorId+")'>" +
                    arr[i].authorName +
                    "</a></dd><dt>Category : </dt><dd>" +
                    arr[i].category +
                    "</dd><dt>Description : </dt><dd>" +
                    arr[i].description +
                    "</dd><dt>Date Of Publish : </dt><dd>" +
                    arr[i].dateOfPublish +
                    "</dd><dt>Status : </dt><dd>" +
                    arr[i].status +
                    "</dd>";
                    if(arr[i].status == 'APPROVED') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'DisApproved'>DISAPPROOVE</button></dd>"
                    } else if(arr[i].status == 'DISAPPROVED') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'Approved'>APPROOVE</button></dd>"
                    } else if(arr[i].status == 'WFA') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'Approved'>APPROOVE</button> <button id = 'status' value = 'DisApproved'>DISAPPROOVE</button></dd>"
                    }
                        out += "</li>";
            }  else if(arr[i].category == "Socialmedia") {
                    out += "<li><dt>ArticleName : </dt><dd>" +
                    arr[i].articleName +
                    "</dd><dt>AuthorName : </dt><dd><a href='author.html' onclick='getdetailsOfAuthor("+arr[i].authorId+")'>" +
                    arr[i].authorName +
                    "</a></dd><dt>Category : </dt><dd>" +
                    arr[i].category +
                    "</dd><dt>Description : </dt><dd>" +
                    arr[i].description +
                    "</dd><dt>Date Of Publish : </dt><dd>" +
                    arr[i].dateOfPublish +
                    "</dd><dt>Status : </dt><dd>" +
                    arr[i].status +
                    "</dd>";
                    if(arr[i].status == 'APPROVED') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'DisApproved'>DISAPPROOVE</button></dd>"
                    } else if(arr[i].status == 'DISAPPROVED') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'Approved'>APPROOVE</button></dd>"
                    } else if(arr[i].status == 'WFA') {
                        out += "<dd> <button id = 'status' value = 'view'>VIEW</button> <button id = 'status' value = 'Approved'>APPROOVE</button> <button id = 'status' value = 'DisApproved'>DISAPPROOVE</button></dd>"
                    }
                   out += "</li>";
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

function authorDetails(response) {
        var value = JSON.parse(response);
        var i;
        var out = "<ul>";
        out += "<li><dt>AuthorName : </dt><dd>" +
                value.authorName +
                "</dd><dt>Author Carrer Profile : </dt><dd>" + 
                value.authorCarrerProfile +
                "</dd>";
       out += "</ul>";
       document.getElementById("authordetails").innerHTML = out;
}

function getdetailsOfAuthor(authorId) {
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/Article?authorId="+authorId;
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.status == 200) {
            authorDetails(xmlhttp.responseText);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}