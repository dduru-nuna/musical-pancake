/** 내 풀이
function addItem() {
    var form = document.forms[0];
    var ul = document.getElementsByTagName("ul")[0];
    var li = document.createElement("li");
    li.innerText += form.item.value;
    if(form.check.value == "f"){
        ul.prepend(li);
    } else {
        ul.append(li);  
    }
    form.item.value = "";
}
*/

/* this와 매개변수,id 사용한 선생님 풀이 */
function addItem(form, targetId) {
    var target = document.getElementById(targetId);
    var li = document.createElement("li");
    li.innerText = form.item.value;
    form.item.value = "";

    if(form.check.value === "f") {
        target.prepend(li);
    } else if(form.check.value === "e") {
        target.append(li);
    }
}

function validCheck(form) {
    if(form.passwordCheck.nextElementSibling !== null) {
        form.passwordCheck.nextElementSibling.remove();
    }
    if(form.password.value !== form.passwordCheck.value) {
        let span = document.createElement("span");
        span.innerText = "패스워드를 다시 확인하세요";
        form.passwordCheck.value = "";
        form.passwordCheck.after(span);
        return false;
    }
}

/* 번호는 tbody의 행수로 계산하여 +1 씩 증가. 조회수는 초기값 0, 작성일은 new Date(); 를 활용하여 현재 날짜로. */
function addRow(form, targetRow) {
    var target = document.getElementById(targetRow);
    var tbody = document.getElementsByTagName("table")[0].getElementsByTagName("tbody")[0];
    var tr = document.createElement("tr");
    var td = document.createElement("td");
    var now = new Date();
    target.append(tr);
    td.innerText =(tbody.rows.length + 1)/*, form.writer.value, now, 0;*/
    tr.append(td);
    var base = tr.children[0];
    var td = document.createElement("td");
    td.innerText = form.title.value;
    base.after(td);
    
}