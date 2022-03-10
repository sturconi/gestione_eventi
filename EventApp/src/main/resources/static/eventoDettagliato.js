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