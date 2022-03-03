function onPageLoaded(){
    console.log("PAGINA CARICATA");
    



    $(function () {
        $(".card-container:first").hide()
        $.ajax({
            url: "http://localhost:8080/eventi",
            headers: {
                'Content-Type': 'http://127.0.0.1:5500'
            },
            type: "GET", /* or type:"GET" or type:"PUT" */
            dataType: "json",
            data: {
            },

        

            success: function(result) {
                $.each(result, function(index, item) {
                  var cards = $(".card-container:first").clone() //clone first divs

                  console.log("sium");
                  
                  var nome = item.nome_evento;
                  var immag = item.immagine;
                  var indev = item.luogo;
                  var oraev = item.ora;
                  var dataev = item.data;
                  var descev = item.descrizione;
                  //add values inside divs
                //  $(cards).find(".card-header").html("user id: " + userId + " - " + "id: " + typeId);
                  $(cards).find(".card-title").html(nome);
                 // $(cards).find(".event--img").html(immag);
                 // $(cards).find(".orario-evento").html(oraev);
                  $(cards).find(".indirizzo-evento").html(indev);
                  $(cards).find(".data-evento").html(dataev);
                  $(cards).find(".descrizione-evento").html(descev);
                  $(cards).show() //show cards
                  $(cards).appendTo($(".portfolio-container ")) 
                 
                });
              }
            });
          });

}