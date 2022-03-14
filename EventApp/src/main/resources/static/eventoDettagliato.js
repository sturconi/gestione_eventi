
//visualizza commenti (da eliminare)
var maincomment = function() {
    $('form').submit(function() {
      var comment = $('#comment').val();
      if(comment !== "") {
        var html = $('<li></li>').text(comment);
        $('ul.comments').prepend(html);
        
      }
      $('#comment').val(" ");
      return false;
    });
  };
  
  $(document).ready(maincomment);




  /* carica evento dettagliato */

  function onEventLoaded(){
    console.log("PAGINA CARICATA");
    



    $(function () {
        $(".card:first").hide()
        $.ajax({
            url: "http://localhost:8080/eventi",
            
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


  /* carica commenti */
  function onPageLoaded(){
    console.log("PAGINA CARICATA");

    var num = 33;

    $(function () {
        $(".notifications:first").hide()
        $.ajax({
            url: "http://localhost:8080/commenti/" + num,
            
            success: function(result) {
                $.each(result, function(index, item) {
                  var cards = $(".notifications:first").clone() //clone first divs

                  console.log("sium");
                  
                  var commento = item.testo_commento;
                  var immag = item.fotoprofilo;
                  var username = item.username;
                  
              
                  $(cards).find(".notifications__item__message").html(commento);
                  $(cards).find(".immagutente").html(immag);
                  $(cards).find(".notifications__item__title").html(username);
                 
                  $(cards).show() //show cards
                  $(cards).appendTo($(".commenti")) 
                 
                });
              }
            });
          });

}