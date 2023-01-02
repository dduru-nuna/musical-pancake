$(document).ready(function() {
    $(".list-group").eq(0).find(".list-group-item").on("click", sideLeftActive);
    $(".list-group").eq(1).find(".list-group-item").on("click", sideRightActive);
});

function sideLeftActive(event) {
    $(event.target).siblings(".active").removeClass("active");
    $(event.target).addClass("active");
    $("section h4").text($(event.target).text());
}

function sideRightActive(event) {
    $(event.target).siblings(".active").removeClass("active");
    $(event.target).addClass("active");
    $("section h4").text($(event.target).text());
}