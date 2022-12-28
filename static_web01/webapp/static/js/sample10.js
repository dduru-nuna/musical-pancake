$(document).ready(function(){         // window.onload = funcion() { } 이거랑 같은 역할
    $("form button").on("click", function(e) { addBookmark(e.target.form); });
});


function addBookmark(form) {   //this.form : DOM -> jquery 로 변환 필요
    var url = $(form.url).val();   // $("form [name=url]").val(); -> $(form.url).val(); 로 써주면 제이쿼리로 변환
    var name = $(form.name).val();
    var liTag = $("<li>").append($("<a>").attr("href", url).text(name));
    $(".bookmark-list").append(liTag);
}

