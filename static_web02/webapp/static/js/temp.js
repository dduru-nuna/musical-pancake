$(document).ready(function() {
    $(".list-group").eq(0).find(".list-group-item").on("click", sideMenuActive);
    $(".pagination").find(".page-item").on("click", pagingActive);
});

function sideMenuActive(event) {
    $(event.target).siblings(".active").removeClass("active");
    $(event.target).addClass("active");
    $("section h4").text($(event.target).text()); //제목의 텍스트도 변경되게 설정
}

function pagingActive(event) { //currentTarget 은 실제 이벤트가 등록된 엘리먼트. target은 이벤트가 발생된 엘리먼트. 보통은 target과 currentTarget이 일치한다
     //previous 버튼 눌렀을 때 
    if(event.currentTarget == $(event.currentTarget).parent().children()[0]) {  
        let active = $(event.currentTarget).siblings(".active");
        if(event.currentTarget != active.prev()[0]) { //prev버튼에는 활성화(색상변경) 되지 않도록 if문 써줌
            active.prev().addClass("active");
            active.removeClass("active");
        }
     //next 버튼 눌렀을 때    
    } else if(event.currentTarget == $(event.currentTarget).parent().children().last()[0]) { 
        let active = $(event.currentTarget).siblings(".active");
        if(event.currentTarget != active.next()[0]) { //next버튼에는 활성화(색상변경) 되지 않도록 if문 써줌
            active.next().addClass("active");
            active.removeClass("active");
        }
     //일반 숫자 버튼 눌렀을 때    
    } else { 
        $(event.currentTarget).siblings(".active").removeClass("active");
        $(event.currentTarget).addClass("active");
    }
}