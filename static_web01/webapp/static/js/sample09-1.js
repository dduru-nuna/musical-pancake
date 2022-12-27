window.onload = function() { //html, css, js 모두 로드 된 이후에 함수 실행
    form = document.forms[0]; //전역변수로 form 설정
    createMonthOption();
    form.username.addEventListener("blur", function(e) { requiredValid(e); });
    form.username.addEventListener("change", function(e) { lengthValid(e, 5, 20, "{1}~{2}자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다."); });
    form.username.addEventListener("change", function(e) { charValid(e, "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.", lower=true, upper=false, number=true, special=true, specialChar="_-"); });
                                                        // 길이 체크하는 메서드, 문자 체크하는 메서드 나눔
    form.password[0].addEventListener("blur", function(e) { requiredValid(e); });
    form.password[0].addEventListener("change", function(e) { lengthValid(e, 8, 16, "{1}~{2}자의 영문 대 소문자, 숫자와 특수문자를 사용하세요."); });
    form.password[0].addEventListener("change", function(e) { charValid(e, "8~16자의 영문 대소문자, 숫자, 특수문자를 사용하세요.", lower=true, upper=true, number=true, special=true); });

    form.password[1].addEventListener("blur", function(e) { requiredValid(e); });
    form.password[1].addEventListener("change", function(e) { lengthValid(e, 8, 16, "{1}~{2}자의 영문 대 소문자, 숫자와 특수문자를 사용하세요."); });
    form.password[1].addEventListener("change", function(e) { equalValue(e, form.password[0]) });
};

//인증번호 받기 난수값 생성. 인증번호 입력후 가입하기 버튼 활성화
function createAuthNumber() {
    var num = (Math.random() * 9000 + 1000).toFixed(0);
    alert(num);
    form.authNumber.disabled = false;
    form.submitButton.disabled = true;
    validReset(form.authNumber); //인증번호 받기 다시 누르면 초기화 시키는 메서드
    form.authNumber.value = "";
    form.authNumber.addEventListener("change", function (e) {
        if(e.target.value == num) {
            validMessage(e.target, "인증 번호가 일치 합니다.");
            form.submitButton.disabled = false; //버튼 활성화
        } else {
            errorMessage(e.target, "인증 번호가 일치하지 않습니다.");
        }
    });
}

function createMonthOption() {   //반복문 이용하여 옵션 태그 만들어지도록 함
    for(let m = 1; m <= 12; m++) {
        let option = document.createElement("option");
        option.innerText = m + "월";
        option.value = m;
        form.month.append(option);
    }
}

function requiredValid(event) {
    var inputElement = event.target;
    if(inputElement.value === "") {
        errorMessage(inputElement, "필수 입력 입니다.");
    }
}

function lengthValid(event, min, max, message) {
    var inputElement = event.target;
    if(inputElement.value.length < min || inputElement.value.length > max) {
        errorMessage(inputElement, format(message, min, max));
        event.stopImmediatePropagation(); //같은 이벤트에 대해 나머지 수신기가 발동하지 못하게 함
    } else {
        validMessage(inputElement, "정상입니다.");
    }
}

function equalValue(event, other) {
    var inputElement = event.target;
    if(inputElement.value === other.value) {
        validMessage(inputElement, "정상입니다.");
    } else {
        errorMessage(inputElement, "비밀번호를 다시 확인하세요.");
    }
}
               // (문자검사타겟, 출력메시지, 추가옵션들 기본값 설정) 
function charValid(event, message, lower=false, upper=false, number=false, special=false, specialChar="") {
    /**
     * {lower: true, upper: true, number: true, special: true, specialChar: "_-"}
     */
    var inputElement = event.target;
    var isLower = lower ? lowerCheck(inputElement.value) : !lowerCheck(inputElement.value);
    var isUpper = upper ? upperCheck(inputElement.value) : !upperCheck(inputElement.value);
    var isNumber = number ? numberCheck(inputElement.value) : !numberCheck(inputElement.value);
    var isSpecial = special ? specialCheck(inputElement.value, specialChar) : !specialCheck(inputElement.value, specialChar);
                                                       //,specialChar : 지정한 특수문자를 사용하였는지 확인하기위한 매개변수 추가
    if(isLower && isUpper && isNumber && isSpecial) {
        validMessage(inputElement, "정상입니다.");
    } else {
        errorMessage(inputElement, message);
    }
}

function specialCheck(string, specialChar = "") {
    //사용할 수 있는 모든 특수문자 배열에 담음
    var specialCharList = ["~", "!", "`", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "[", "]", "{", "}", ";", "'", ":", "\"", ".", "/", "<", ">", "?", "\\", "|"];
    for(let idx = 0; idx < specialCharList.length; idx++) {
        if(string.indexOf(specialCharList[idx]) >= 0) { //indexOf 로 특수문자 있는지 없는지 검사 (없으면 -1 반환)
            if(specialChar !== "") {
                if(specialChar.indexOf(specialCharList[idx]) === -1) {
                    return false;
                }
            }
        }
    }
    return true;
}

function lowerCheck(string) {  //소문자 아스키 코드
    return charRangeCheck(string, "a".charCodeAt(0), "z".charCodeAt(0));
}

function upperCheck(string) {  //대문자 아스키 코드
    return charRangeCheck(string, "A".charCodeAt(0), "Z".charCodeAt(0));
}

function numberCheck(string) {  //숫자 아스키 코드
    return charRangeCheck(string, "0".charCodeAt(0), "9".charCodeAt(0));
}

function charRangeCheck(string, min, max) { //아스키코드 가장 작은값~큰값 에 문자열이 있는지
    for(let idx = 0; idx < string.length; idx++) {
        if(string.charCodeAt(idx) >= min && string.charCodeAt(idx) <= max) {
            return true;
        }
    }
    return false;
}

function errorMessage(element, message) {
    var divError = document.createElement("div");
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
       element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        divError = element.parentElement.lastElementChild;
    }
    divError.innerText = message;
    divError.className = "invalid-feedback";
    element.parentElement.append(divError);
    element.classList.remove("is-valid");
    element.classList.add("is-invalid");
}

function validMessage(element, message) {
    var divValid = document.createElement("div");
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
       element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        divValid = element.parentElement.lastElementChild;
    }
    divValid.innerText = message;
    divValid.className = "valid-feedback";
    element.parentElement.append(divValid);
    element.classList.remove("is-invalid");
    element.classList.add("is-valid");
}

function validReset(element) {
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
       element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        element.parentElement.lastElementChild.remove();
    }
    element.classList.remove("is-valid");
    element.classList.remove("is-invalid");
}

//포맷팅 기능 따로 만듦. {} 중괄호가 있으면 replace 하는 포맷형식
function format(string, ...args) {  
    for(let idx = 0; idx < args.length; idx++) {
        string = string.replace("{" + (idx + 1) + "}", args[idx]);
    }
    return string;
}