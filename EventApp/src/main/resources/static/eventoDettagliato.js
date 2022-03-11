
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



  /* carica commenti */
  function onPageLoaded(){
    console.log("PAGINA CARICATA");


    $(function () {
        $(".notifications:first").hide()
        $.ajax({
            url: "http://localhost:8080/commenti/11",
            
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