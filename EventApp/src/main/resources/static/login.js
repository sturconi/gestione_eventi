
function onPageLoaded()
{
    console.log("Pagina Caricata");
}

function Conferma(){
    var uriAdd= "/conferma";
    
    var request= new XMLHttpRequest();
    request.onreadystatechange = function()
    {
        if(request.readyState == 4 && request.status == 200)
        {
            var UtentObj = JSON.parse(request.responseText);
            console.log(request.responseText);
            for(var idx=0; idx<UtentObj.length;idx++)
            {
                var utente= UtentObj[idx];
                if(document.getElementById("passwordLogin").value == utente.password && document.getElementById("usernameLogin").value == utente.username){
                 alert("Login Effettuato");
                 window.location.replace("./home.html");  
                 return false; 
                }
                else{
                    alert("Password o Username errato");
                    document.getElementById("usernameLogin").focus();
                    return false;
                }
            
            }
    }    
    request.open('GET', uriAdd);
    request.send(null);
    return false;
}
}