function sendEmail() {   
   
        
    var formData = new FormData(document.forms.formRegister);
    var jsonData = JSON.stringify(Object.fromEntries(formData));

    var uriAddr = "./ticket";
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if(request.readyState == 4)
        {  
            if(request.status == 201)
            {
                window.location.replace("./login.html");

            }          
        }
    }
    
    request.open("POST", uriAddr);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(jsonData);
    return false;

   

}