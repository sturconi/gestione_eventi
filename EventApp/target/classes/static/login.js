



function doSubmit(){
    var uriAddr = "./utenti";
    var code=false;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if(request.readyState == 4 && request.status == 200)
        {            
            console.log(request.responseText);
            var utentListObj = JSON.parse(request.responseText);
            var user=document.getElementById("usernameLogin").value
            var pass=document.getElementById("passwordLogin").value
            for(var idx=0; idx<utentListObj.length; idx++)
            {
                console.log( utentListObj[idx].username);
                if(user==utentListObj[idx].username && pass==utentListObj[idx].password){
                    alert("Login Effettuato!")
                    window.location.replace("./utente/"+utentListObj[idx].username+"/"+utentListObj[idx].password);
                    code=true;
                }
            }
            if(code==false){
                alert("Username o Password Errati!")
                window.location.reload();
            }
           
        }
    };
   
    request.open("GET", uriAddr);
    request.send(null);
    return false;
}