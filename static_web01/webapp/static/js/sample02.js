function createList() {  /* prompt 실행하여 할당된 값은 items 에 저장됨 */
    var result = document.getElementById("result1");
    var itemList = getItems();

    var list = "";
    for(let item of itemList) {
        list += "<li>" + item + "</li>";   
    }
    result.innerHTML = "<ul>" + list + "</ul>";
}

function getItems() {
    var input = prompt("쉼표를 구분문자로 사용하여 태그명을 작성하세요.");
    return input.split(",");
}


function createMonth() {
    var now = new Date();
    var currentMonth = now.getMonth();

    var result = document.getElementById("result2")
    /*var months = [1,2,3,4,5,6,7,8,9,10,11,12];*/
    var list = "";
    /*
    for(let month of months) {
        if(month == (currentMonth+1)) {
            list += "<option selected>" + month + "월</option>";
        } else {
            list += "<option>" + month + "월</option>";
        }
    }*/
    for(let m = 1; m <= 12; m++) {
        list += m === currentMonth + 1 ? "<option selected>" : "<option>";
        list += m + "월</option>";
    }
    result.innerHTML = "<select>" + list + "</select>";
}