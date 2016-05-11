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
            if(user.role == "admin") {
                window.open("Admin.html", "_self");
            } else {
                window.open("Welcome.html", "_self");
            }    
        } else {
            alert("INVALID USER");
        }
    };
     xhttp.open('Get', url + datas, true);
     xhttp.send(JSON.stringify(datas));
}
