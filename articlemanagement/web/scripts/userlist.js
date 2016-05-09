function getlistofusers()  {
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/articlemanagement/User";
        xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            myFunction(xmlhttp.responseText);
    }
};
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
    function myFunction(response) {
        var arr = JSON.parse(response);
        var i;
        var out = "<table><tr><th>Username</th><th>EmailId</th><th>PhoneNo</th><th>Status</th>";
    for(i = 0; i < arr.length; i++) {
        out += "<tr><td>" + 
        arr[i].username +
        "</td><td>" +
        arr[i].emailId +
        "</td><td>" +
        arr[i].phoneNo +
        "</td><td>" +
        arr[i].status +
        "</td></tr>";}
    out += "</table>";
    document.getElementById("button").innerHTML = out;
}
 
