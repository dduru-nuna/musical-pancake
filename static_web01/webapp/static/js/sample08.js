// 이벤트 등록 및 이벤트 종류

/**
 * 실시간 검사
 *    아이디는 6 ~ 12 자 사이의 값을 입력하였는지 실시간으로 검사하여 문제가
 *    있는 경우 붉은색 테두리와 에러 메시지로 사용자에게 즉시 알릴 수 있도록
 *    하고, 정상 입력인 경우 초록색 테두리와 정상 메시지로 사용자에게 알릴 수 있도록 한다.
 * 
 *    패스워드는 4 ~ 12 자 사이의 값을 입력하였는지 실시간으로 검사하여 위의 아이디와
 *    동일한 처리를 하도록 한다.
 *  
 *    패스워드 확인은 기존에 입력한 패스워드와 동일한 값인지를 실시간으로 검사하여 위의
 *    아이디와 동일한 처리를 하도록 한다.
 */

//모든 파일들이 다 불러와진 이후에 익명함수 실행
window.onload = function() {
    var form = document.forms[0];            //매개변수 e 에 input 이벤트 객체 정보가 전달
    form.username.addEventListener("input", function(e) { lengthValid(e, 6, 12) });
    form.password.addEventListener("input", function(e) { lengthValid(e, 4, 12) });
    form.passwordCheck.addEventListener("input", function(e) { lengthValid(e, 4, 12) })
    form.password.addEventListener("change", function(e) { equalValue(e, form.passwordCheck) });
    form.passwordCheck.addEventListener("change", function(e) { equalValue(e, form.password) });
}
//익명함수에 내부함수를 활용함으로써 좀 더 간단히 자리수 비교를 가능하게 함
function lengthValid(event, min, max) {
    var inputElement = event.target;  //엘리먼트 구분하지 않고 이벤트가 발생한 객체를 반환하여 inputElement 에 저장
    if(inputElement.value.length >= min && inputElement.value.length <= max) {
        inputElement.style.borderColor = "green";
        inputElement.style.borderWidth = "5px";
    } else {
        inputElement.style.borderColor = "red";
        inputElement.style.borderWidth = "5px";
    }
}   

function equalValue(event, other) {
    var inputElement = event.target;
    if(inputElement.value === other.value) {
        inputElement.style.borderColor = "green";
        inputElement.style.borderWidth = "5px";
        other.style.borderColor = "green";
        other.style.borderWidth = "5px";
    } else {
        inputElement.style.borderColor = "red";
        inputElement.style.borderWidth = "5px";
        other.style.borderColor = "red";
        other.style.borderWidth = "5px";
    }
} 
/*
function passwordCheckValid(e) {
    var passwordCheck = e.target;
    if(passwordCheck.nextElementSibling !== null) {
        passwordCheck.nextElementSibling.remove();
    }
    if(form.password.value == passwordCheck.value) {
        let span = document.createElement("span");
        span.innerText = "정상 입력입니다."
        passwordCheck.classList.add("input-success");
        passwordCheck.after(span);
    } else {
        let span = document.createElement("span");
        span.innerText = "패스워드를 다시 확인하세요."
        passwordCheck.classList.add("input-error");
        passwordCheck.after(span);
    }
}
form.passwordCheck.addEventListener("input", passwordCheckValid);
*/
