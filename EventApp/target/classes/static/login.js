

function onPageLoaded()
{
    console.log("Pagina Caricata");

    var uriAdd= "/utenti";
    
    var request= new XMLHttpRequest();
    request.onreadystatechange = function()
    {
        if(request.readyState == 4 && request.status == 200)
        {
            console.log(request.responseText);
        }
    }    
    request.open('GET', uriAdd);
    request.send(null);
}