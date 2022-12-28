/*window.addEventListener('load', () => {
    const forms = document.getElementsByClassName('validation-form');

    Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('blur', function(event) {
            if(form.username.value.length < 5 || form.username.value.length > 20) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validation');
        }, false);
    });
}, false);*/

window.onload = function() {
    form = document.forms[0];
    form.username.addEventListener("blur", function(e) { requiredValid(e); })
    form.username.addEventListener("change", function(e) { lengthValid(e, 5, 20, "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.") });
    form.username.addEventListener("change", function(e) { charValid(e, "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.", lower=true, upper=false, number=true, special=true, specialChar="_-"); });

    form.pass1.addEventListener("blur", function(e) { requiredValid(e); });
    form.pass1.addEventListener("change", function(e) { lengthValid(e, 8, 16, "8~16자의 영문 대소문자, 숫자와 특수문자를 사용하세요.") });
    form.pass1.addEventListener("change", function(e) { charValid(e, "8~16자의 영문 대소문자, 숫자와 특수문자를 사용하세요.", lower=true, upper=true, number=true, special=true); });

    form.pass2.addEventListener("blur", function(e) { requiredValid(e); });
    form.pass2.addEventListener("change", function(e) { lengthValid(e, 8, 16, "8~16자의 영문 대소문자, 숫자와 특수문자를 사용하세요."); });
    form.pass2.addEventListener("change", function(e) { equalValue(e, form.pass1); });

    createMonthOption();
}

function requiredValid(event) {
    var inputElement = event.target;
    if(inputElement.value = ""){
        errorMessage(inputElement, "필수 입력입니다.")
    }
}

function lengthValid(event, min, max) {
    var inputElement = event.target;
    if(inputElement.value.length >= min && inputElement.value.length <= max) {
        form.classList.add('was-validation')
    }
}

function errorMessage(element, message) {  //event.target인 inputElement를 element로 받아옴
    var divError = document.createElement("div"); //에러메시지 출력할 div 생성
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
       element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        divError = element.parentElement.lastElementChild; //피드백 메시지가 이미 있는 경우 출력 메시지 위치 다시 조정
       }
}