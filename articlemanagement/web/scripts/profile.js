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

function profileDetails() {
    
    var xhttp = new XMLHttpRequest();
    var id = getCookie("id");
    var status = getCookie("status");
    var url = "http://localhost:8080/articlemanagement/User?id="+id;
    xhttp.onload = function() {
        if(xhttp.readyState == 4 && xhttp.status  === 200) {
            var user = JSON.parse(xhttp.responseText);
            console.log(user);
            document.getElementById('name').innerHTML = user.username;
            document.getElementById('username').value = user.username;
             document.getElementById('password').value = user.password;
            document.getElementById('emailId').value = user.emailId;
            document.getElementById('dateOfBirth').value = user.dateOfBirth;
            document.getElementById('phoneNo').value = user.phoneNo;
            document.getElementById('gender').value = user.gender;
        } 
    };
     xhttp.open('Get', url, true);
     xhttp.send();
}


function editUserProfile() {
   
    document.getElementById('newpassword').removeAttribute('readonly'); 
    document.getElementById('confirmpassword').removeAttribute('readonly'); 
    document.getElementById('phoneNo').removeAttribute('readonly');
    document.getElementById("editbutton").disabled = true; 
}


function updateUserProfile() {
    
        var xhttp = new XMLHttpRequest();
        var userid = getCookie("id");
        var userstatus = getCookie("status");
        var url = "http://localhost:8080/articlemanagement/User?id="+userid;
        var user = document.getElementById("username").value;
        var newpswrd = document.getElementById("newpassword").value;
        var confirmpswrd = document.getElementById("confirmpassword").value;
        if(newpswrd === confirmpswrd) {
             var pswrd = newpswrd ;
        } else {
            alert("new password and confirm password does not match");
        }
        var email = document.getElementById("emailId").value;
        var dob = document.getElementById("dateOfBirth").value;
        var phno = document.getElementById("phoneNo").value;
        var fields = {
        id: userid,
        username : user,
        password : pswrd,
        emailId : email,
        dateOfBirth : dob,
        phoneNo : phno,
        status : userstatus
        };
        xhttp.onload = function() {
            if(xhttp.readyState == 4 && xhttp.status === 200) {
                alert("data updated successfully !!...");
                document.getElementById('password').setAttribute('readonly', 'readonly'); 
                document.getElementById('newpassword').setAttribute('readonly', 'readonly');
                document.getElementById('confirmpassword').setAttribute('readonly', 'readonly');
                document.getElementById('phoneNo').setAttribute('readonly', 'readonly');
                document.getElementById("savebutton").disabled = true; 
                document.getElementById("editbutton").disabled = false;
            }
        };
    xhttp.open('PUT', url, true);
    xhttp.send(JSON.stringify(fields));
}

function cancel() {
   
    alert("Do you want to cancel?");
    document.getElementById("savebutton").disabled = true;
    location.href='Admin.html';
}