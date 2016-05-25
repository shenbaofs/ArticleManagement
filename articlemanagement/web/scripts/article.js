var role = getCookie("role");
var articleList = [];
var category  = "";

function getlistofarticles()  {
        category = document.getElementById("mySelect").value;
        getArticlesService(category);
}

function approve(arr) {
    var article = articleList[arr-1];
    var xhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/Article?articleId="+article.articleId +"&status=APPROVED";
    xhttp.onload = function() {
        if(xhttp.readyState == 4 && xhttp.status  === 200) {
            alert("USER APPROVED SUCCESSFULLY");
        }
    };
     article.status = "APPROVED";
     xhttp.open('Put', url, true);
     xhttp.send();
}

function disapprove(arr) {
    var article = articleList[arr-1];
    var xhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/Article?articleId="+article.articleId +"&status=DISAPPROVED";
    xhttp.onload = function() {
        if(xhttp.readyState == 4 && xhttp.status  === 200) {
            alert("USER DISAPPROVED SUCCESSFULLY");
        }
    };
     article.status = "DISAPPROVED";
     xhttp.open('Put', url, true);
     xhttp.send();
}

function myFunction(response) {
        var arr = JSON.parse(response);
        articleList = arr;
        var i;
        var out = "<ul>";
        for(i = 0; i < arr.length; i++) {
                out += "<li><dt>Article Name : </dt><dd>" +
                arr[i].articleName +
                "</dd><dt>Author Name : </dt><dd><a href='author.html' onclick='setAuthorId("+arr[i].authorId+")'>" +
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
                if(role == 'admin') {
                    if(arr[i].status == 'APPROVED') {
                        out += "<dd> <a id='status' href='viewarticle.html' onclick='setArticleId("+arr[i].articleId+")'>VIEW</a> <button id = 'status' value = 'DisApproved' onclick='disapprove("+arr[i].articleId+")'>DISAPPROVE</button></dd>"
                    } else if(arr[i].status == 'DISAPPROVED') {
                        out += "<dd> <a href='viewarticle.html' onclick='setArticleId("+arr[i].articleId+")'>VIEW</a> <button id = 'status' value = 'Approved' onclick='approve("+arr[i].articleId+")'>APPROVE</button></dd>"
                    } else if(arr[i].status == 'WFA') {
                        out += "<dd> <a href='viewarticle.html' onclick='setArticleId("+arr[i].articleId+")'>VIEW</a> <button id = 'status' value = 'Approved' onclick='approve("+arr[i].articleId+")'>APPROVE</button> <button id = 'status' value = 'DisApproved' onclick='disapprove("+arr[i].articleId+")'>DISAPPROVE</button></dd>"
                    } 
                } else {
                    out += "<dd> <a href='viewarticle.html' onclick='setArticleId("+arr[i].articleId+")'>VIEW</a>"
                }
                    out += "</li>";
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
        var b64Data =  value.authorImage;
        var byteCharacters = atob(b64Data);
        var byteNumbers = new Array(byteCharacters.length);
        for (var i = 0; i < byteCharacters.length; i++) {
            byteNumbers[i] = byteCharacters.charCodeAt(i);
        }
        var arrayBufferView = new Uint8Array(byteNumbers);   
        var out;
        out = "<div id='main'><img id='photo'></img><div id='authordetails'>AuthorName : " +
                                     value.authorName +
                             "</div><div>Author Carreer Profile : " + 
                                    value.authorCarrerProfile +
                            "</div>";
         out += "</div>";        
       document.getElementById("authordetails").innerHTML = out;
       var blob = new Blob( [ arrayBufferView ], { type: "image/jpeg" } );
       var urlCreator = window.URL || window.webkitURL;
       var imageUrl = urlCreator.createObjectURL( blob );
       var img = document.querySelector( "#photo" );
       img.src = imageUrl;
}

function getCookie(cname) {
                console.log("hello");
                var name = cname + "=";
                var ca = document.cookie.split(';');
                for(var i=0; i<ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0)==' ') {
                        c = c.substring(1);
                    }
                    if (c.indexOf(name) === 0) {
                        return c.substring(name.length, c.length);
                    }
                }
                return "";
}

var authorIdVal = 0;
function setAuthorId(authorId){
    document.cookie = "authorIdVal=" + authorId;
}

function getAuthorDetails() {
    var xmlhttp = new XMLHttpRequest();
    var authorId = getCookie("authorIdVal");
    var url = "http://localhost:8080/articlemanagement/Article?authorId="+authorId;
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.status == 200) {
            authorDetails(xmlhttp.responseText);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function articleDetails(response) {
         var value = JSON.parse(response);
        var out;
        out = "<div id='main'><div>Article Name : " +
                                     value.articleName +
                             "</div><div>Date of Publish : " + 
                                    value.dateOfPublish + 
                             "</div><div>Author Name : " + 
                                    value.authorName +
                             "</div><div>Category: " + 
                                    value.category +
                             "</div><div>Description: " + 
                                    value.description + 
                            "</div>";
         out += "</div>";        
       document.getElementById("articledetails").innerHTML = out;
}

var articleIdVal = 0;
function setArticleId(articleId){
    document.cookie = "articleIdVal=" + articleId;
}

function getArticleDetails() {
    var xmlhttp = new XMLHttpRequest();
    var articleId = getCookie("articleIdVal");
    var url = "http://localhost:8080/articlemanagement/Article?articleId="+articleId;
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.status == 200) {
            articleDetails(xmlhttp.responseText);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}