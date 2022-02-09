var curUtente;
function requestInfo(UtenteId){
    var uri= "http://localhost:8080/utente/" +UtenteId;
    var xmlUtente = new XMLHttpRequest();
    xmlUtente.onreadystatechange=function(){
        if(xmlUtente.readyState == 4 && xmlUtente.status == 200)
        {  
            //codice di gestione del JSON di ritorno 
            curUtente = JSON.parse(xmlUtente.responseText);
            document.getElementById("usernameField").setAttribute("value", curUtente.username);
            document.getElementById("passwordField").setAttribute("value", curUtente.password);

        }
    };
        xmlUtente.open("GET",uri);
    xmlUtente.send(null);
}
function onPageLoaded(){
    var params = new URLSearchParams(location.search);
    var nomeVal = params.get("username");
    
    if (nomeVal!=null) {
        document.title="Modifica Utente";
        document.getElementById("nome").innerHTML="Modifica Utente "+nomeVal+"info";
        requestCaneInfo(parseInt(nomeVal));
    }
    else
    curCane=null;
}
function doSubmit()
{
    var form = document.getElementById("newForm");
    
    var formData = new FormData(document.forms.newForm);
    var jsonData = JSON.stringify(Object.fromEntries(formData));

    var uriAddr = "http://localhost:8080/cani/";
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4)
        {  
            if(xmlHttp.status == 201)
            {
                if(confirm("CANE CREATO, NE VUOI CREARE UN ALTRO?"))
                location.reload();
                else 
                window.location.replace("http://localhost:8080/home.html");

            }    
            else if (xmlHttp.status == 200)
            {
                alert("CANE MODIFICATO");
                window.location.replace("http://localhost:8080/home.html");
            }          
        }
    }
    if(curCane == null)
    {
        xmlHttp.open("POST", uriAddr);
    }
    else{
        xmlHttp.open("PUT", uriAddr + "/"+ curCane.nome);
    }
    
    xmlHttp.setRequestHeader("Content-Type", "application/json");
    xmlHttp.send(jsonData);
    return false;
}
