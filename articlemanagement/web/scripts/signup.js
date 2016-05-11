function signup() {

    if(document.getElementById("signUpForm").checkValidity()) {
    
            var user = document.getElementById("username").value;
            var pswrd  = document.getElementById("password").value;
            var email = document.getElementById("emailId").value;
            var dob = document.getElementById("dateOfBirth").value;
            var phno = document.getElementById("phoneNo").value;
            if(document.getElementById("male").checked == true) {
             var gender = document.getElementById("male").value;
            } else {
            var gender = document.getElementById("female").value;
            }
        
            var url = "http://localhost:8080/articlemanagement/User";
            var jsonVal = {
            "username" : user,
            "password" : pswrd,
            "emailId" : email,
            "dateOfBirth" : dob,
            "phoneNo" : phno,
            "gender" : gender
            };
            var xhr = new XMLHttpRequest();
            xhr.open('POST', url , true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.onreadystatechange = function () {
                console.log(xhr.status);
                if (xhr.readyState === 4) {            
                    alert("data added successfully !!...");
                     location.href='signin.html';
                }
            };
            xhr.send(JSON.stringify(jsonVal));
      }
}


function cancel() {
   
    alert("Do you want to cancel???????...");
    location.href='signin.html';
}