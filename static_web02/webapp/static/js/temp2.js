$(document).ready(function() {
    // $(".list-group").eq(0).find(".list-group-item").on("click", sideMenuActive);
    $("button").each(function(index, element) {
        let e = $(element);
        if(e.text() === "저장") {
            $(element.form).find("input,select").on("change", function(e) { saveButtonEnable(e, element); });
        }  //저장 버튼 찾아서 input, select 에 변화가 생기면 함수 발동
    });
});

function saveButtonEnable(event, target) {
    let e = $(event.target);
    let t = $(target);
    t.attr("disabled", false);
    t.removeClass("btn-outline-secondary");
    t.addClass("btn-outline-success");
}

function createAddressForm(element) {
    let e = $(element);
    let tagText = '<div id="addressForm" class="card border-0 mb-3"><div class="mb-2 text-end dropdown custom-dropdown"><a class="dropdown-toggle fw-bold" role="button" data-bs-toggle="dropdown"><span class="material-symbols-outlined">more_vert</span></a><ul class="dropdown-menu"><li><a class="dropdown-item text-danger fw-bold" role="button" onclick="removeAddressForm(this, \'#addressForm\');">삭제</a></li></ul></div><div class="row mb-2"><label class="col-2 col-form-label">주소 분류</label><div class="col-4"><select name="addressType" class="form-select"><option value="home" selected>집</option><option value="company">회사</option><option value="other">기타</option></select></div><label class="col-2 col-form-label">우편번호</label><div class="col-4"><input type="text" class="form-control" name="birthday" value="01234"></div></div><div class="row mb-2"><label class="col-2 col-form-label">주소</label><div class="col-10"><input type="text" class="form-control" name="address" value="서울시 XXX XXX XXXXXXX XXXXX 123-45"></div></div></div>'
    e.parent().before($(tagText)); //일반 텍스트(html형식)를 제이쿼리 함수에 넣으면 엘리먼트 객체로 만들어줌
}

function removeAddressForm(element, id) {
    let e = $(element);
    e.parents(id).remove();  //부모 중 id 가 addressForm 인 것만 찾아서 제거
}

// function sideMenuActive(event) {
//     $(event.target).siblings(".active").removeClass("active");
//     $(event.target).addClass("active");
//     event.stopimmediatepropagation();
// }
