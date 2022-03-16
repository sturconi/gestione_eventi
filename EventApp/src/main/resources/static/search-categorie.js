function onPageLoaded(){
    console.log("PAGINA CARICATA");
    var pars= new URLSearchParams(window.location.search);
    var pass=pars.get("categoria");
    console.log(pass);



    $(function () {
        $(".card:first").hide()
        $.ajax({
            url: "http://localhost:8080/eventi/" + pass  ,
            
            success: function(result) {
                $.each(result, function(index, item) {
                  var cards = $(".card:first").clone() //clone first divs

                  console.log("sium");
                  
                  var nome = item.nome_evento;
                  var immag = item.immagine;
                  var indev = item.luogo;
                  var oraev = item.ora;
                  var dataev = item.data;
                  var descev = item.descrizione;
                  //add values inside divs
                //  $(cards).find(".card-header").html("user id: " + userId + " - " + "id: " + typeId);
                  $(cards).find(".titolo_evento").html(nome);
                  $(cards).find(".card__image").html(immag);
                  $(cards).find(".data_evento").html(dataev);
                  $(cards).find(".indirizzo-evento").html(indev);
                  $(cards).find(".orario-evento").html(oraev);
                  $(cards).find(".desc_evento").html(descev);
                  $(cards).show() //show cards
                  $(cards).appendTo($(".container ")) 
                 
                });
              }
            });
          });

}