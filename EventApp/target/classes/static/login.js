const sign_in_btn_=document.querySelector('#sign-in-button');
const sign_up_btn= document.querySelector('#sign-up-button');
const container =document.querySelector('.container');
sign_up_btn.addEventListener('click', ()=>{
    container.classList.add('sign-up-mode')
});
sign_in_btn.addEventListener('click', ()=>{
    container.classList.remove('sign-up-mode')
});



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
                    window.location.replace("./home.html")
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