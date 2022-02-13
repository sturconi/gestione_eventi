



function doSubmit(){
    var uriAddr = "./utenti";

    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if(request.readyState == 4 && request.status == 200)
        {            
            console.log(request.responseText);
            var utentListObj = JSON.parse(request.responseText);
            var code;
            for(var idx=0; idx<utentListObj.length; idx++)
            {
                var u = utentListObj[idx];
                console.log(u.username);
                if(document.getElementById("usernameLogin").value==u.username){
                     code=1;
                }
                else{
                    code=0;
                }
            }
            if(code==1){
                alert("Login Effettuato!")
                window.location.replace("./utenti");
            }
            else{
                alert("Username o Password Errati!")
                window.location.reload();
            }
           
        }
    };
    request.open("GET", uriAddr);
    request.send(null);
    return false;
}