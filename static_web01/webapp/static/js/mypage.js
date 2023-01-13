$(document).ready(function() {
    $("button").each(function(index, element) {
        let e = $(element);
        if(e.text() === "저장") {
            $(element.form).find("input, select").on("change", function(e) {saveButtonEnable(e, element); })
        }
    });
});

function saveButton(event, target) {
    let e = $(event.target);
    let t = $(target);
    t.attr("disabled", false);
    t.removeClass("btn-outline-secondary");
    t.addClass("btn-outline-info")
}