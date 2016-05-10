function getlistofusers()  {
        var status = document.getElementById("mySelect").value;
        getUsersService(status);
}

function approve(arr) {
    var id = arr;
    var xhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/User?";
    var status = document.getElementById("status").value;
    var datas = "id=" + id + "&" + "status=" + status;
    xhttp.onload = function() {
        if(xhttp.readyState == 4 && xhttp.status  === 200) {
            alert("USER APPROVED SUCCESSFULLY");
        }
    };
     xhttp.open('Put', url + datas, true);
     xhttp.send(JSON.stringify(datas));
}

function disapprove(arr) {
    var id = arr;
    var xhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/User?";
    var status = document.getElementById("status").value;
    var datas = "id=" + id + "&" + "status=" + status;
    xhttp.onload = function() {
        if(xhttp.readyState == 4 && xhttp.status  === 200) {
            alert("USER DISAPPROVED  SUCCESSFULLY");
        }
    };
     xhttp.open('Put', url + datas, true);
     xhttp.send(JSON.stringify(datas));
}

function myFunction(response) {
        var arr = JSON.parse(response);
        var i;
        var out = "<table><tr><th>Username</th><th>EmailId</th><th>PhoneNo</th><th>DateOfBirth</th><th>Status</th><th>Action</th>";
        for(i = 0; i < arr.length; i++) {
            if( arr[i].status == "APPROVED") {
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
                "</td> <td><button id='status' value='DISAPPROVED' onclick='disapprove("+arr[i].id+")'>DISAPPROVE</button></td></tr>";
            } else if(arr[i].status == "DISAPPROVED") {
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
                "</td><td><button id='status' value='APPROVED' onclick='approve("+arr[i].id+")'>APPROVE</button></td></tr>";
        } else if(arr[i].status == "WFA") {
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
                "</td><td><button id='status' value='APPROVED' onclick='approve("+arr[i].id+")'>APPROVE</button>  <button id='status' value='DISAPPROVED' onclick='disapprove("+arr[i].id+")'>DISAPPROVE</button></td></tr>";}
        }
    out += "</table>";
    document.getElementById("button").innerHTML = out;
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

function cancel() {
   
    alert("Do you want to cancel???????...");
    location.href='userlist.html';
}