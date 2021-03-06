var userList = [];
var status  = "";

function getlistofusers() {
        status = document.getElementById("mySelect").value;
        getUsersService(status);
}

function approve(arr) {
    var user = {};
    for(var userVal in userList) {
      if(userList[userVal].id == arr) { 
        user = userList[userVal];
      }
    }
    user.status = "APPROVED";
    var xhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/User?";
    xhttp.onload = function() {
        if(xhttp.readyState == 4 && xhttp.status  === 200) {
            alert("USER APPROVED SUCCESSFULLY");
        }
    };
     xhttp.open('Put', url, true);
     xhttp.send(JSON.stringify(user));
}

function disapprove(arr) {
    var user = {};
    for(var userVal in userList) {
       if(userList[userVal].id == arr) {
        user = userList[userVal];
      }
    }
        user.status = "DISAPPROVED";
    var xhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/User?";
    xhttp.onload = function() {
        if(xhttp.readyState == 4 && xhttp.status  === 200) {
            alert("USER DISAPPROVED SUCCESSFULLY");
        }
    };
     xhttp.open('Put', url, true);
     xhttp.send(JSON.stringify(user));
}

function myFunction(response) {
        var arr = JSON.parse(response);
        userList = arr;
        var i;
        var out = "<table><tr><th>Username</th><th>EmailId</th><th>PhoneNo</th><th>DateOfBirth</th><th>Status</th><th>Action</th>";
        for(i = 0; i < arr.length; i++) {
                out += "<tr><td>" +
                arr[i].username +
                "</td><td>" +
                arr[i].emailId +
                "</td><td>" +
                arr[i].phoneNo +
                "</td><td>" +
                arr[i].dateOfBirth +
                "</td><td>" +
                arr[i].status +
                "</td><td><button id='status' value='DISAPPROVED' onclick='disapprove("+arr[i].id+")'>DISAPPROVE</button></td></tr>";
     }
    out += "</table>";
    document.getElementById("userTable").innerHTML = out;
}
 
function getUsersService(status) {
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/User?status="+status;
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.status == 200) {
            myFunction(xmlhttp.responseText);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
