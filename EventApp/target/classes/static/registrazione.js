var curUtente;

function requestUtenteinfo(id){
    var uriAdd= "./utente/"+id;
    var request= new XMLHttpRequest();
    request.onreadystatechange = function(){
    if(request.readyState == 4 && request.status == 200)
    {
        curUtente=JSON.parse(request.responseText)
        document.getElementById("nome").setAttribute("value", curUtente.nome)
        document.getElementById("id").setAttribute("value", curUtente.id)
        document.getElementById("cognome").setAttribute("value", curUtente.cognome)
        document.getElementById("username").setAttribute("value", curUtente.username)
        document.getElementById("email").setAttribute("value", curUtente.email)
        document.getElementById("password").setAttribute("value", curUtente.password)
        document.getElementById("data").setAttribute("value", curUtente.data)
        }
};
request.open('GET', uriAdd);
request.send(null);
}

function onPageLoaded(){
    var params= new URLSearchParams(location.search);
    var idval=params.get("id");
    if(idval!=null ){
     requestUtenteinfo(parseInt(idval))
    }
    else{
        curUtente=null;
    }
}

function doSubmit()
{   
    var formData = new FormData(document.forms.formRegister);
    var jsonData = JSON.stringify(Object.fromEntries(formData));

    var uriAddr = "./utenti";
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
    if(curUtente == null)
    {
        request.open("POST", uriAddr);
    }
    request.setRequestHeader("Content-Type", "application/json");
    request.send(jsonData);
    return false;
}
