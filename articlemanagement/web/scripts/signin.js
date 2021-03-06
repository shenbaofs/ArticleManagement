function login() {
    var xhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/articlemanagement/Login?";
    var username = document.getElementById("username").value;
    var pswrd  = document.getElementById("password").value;
    var datas = "username=" + username + "&" + "password=" + pswrd;
    xhttp.onload = function() {
        if(xhttp.readyState == 4 && xhttp.status  === 200) {
            var user = JSON.parse(xhttp.responseText);             
            document.cookie = "id=" + user.id;
            document.cookie = "username=" + user.username;
            document.cookie = "status=" + user.status;
            document.cookie = "role=" + user.role;
            if(user.role == "admin") {
                window.open("Admin.html", "_self");
            } else if (user.role == "user" && user.status == "APPROVED"){
                window.open("user.html", "_self");
            }    
        } else {
            alert("INVALID USER");
        }
    };
     xhttp.open('Get', url + datas, true);
     xhttp.send(JSON.stringify(datas));
}
