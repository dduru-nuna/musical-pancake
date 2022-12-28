/**
 * 아이디, 패스워드 검사 후 오류가 발생하는 경우 사용자 입력 폼에 에러 메시지가
 * 담긴 span 태그를 추가하고 입력 양식에는 테두리를 붉게 설정하여 사용자가 
 * 잘못된 입력이라는 것을 알 수 있도록 한다.
 * 
 * 아이디는 6자리 미만인 경우 오류가 발생하게 합니다.
 * 패스워드는 패스워드와 패스워드 확인이 동일하지 않을 때 오류가 발생하게 합니다.
 * 패스워드도 아이디처럼 4자리 미만인 경우 오류가 발생하게 합니다.
 */

/* 내 풀이
function validCheck(form) {
    if(form.passwordCheck.nextElementSibling !== null) {
        form.passwordCheck.nextElementSibling.remove();
    } else if(form.password.nextElementSibling !== null) {
        form.password.nextElementSibling.remove();
    } else if(form.username.nextElementSibling !== null) {
        form.username.nextElementSibling.remove();
    }

    if(form.password.value !== form.passwordCheck.value) {
        let span = document.createElement("span");
        span.innerText = "패스워드를 다시 확인하세요";
        form.passwordCheck.style.borderColor = "red";
        form.passwordCheck.value = "";
        form.passwordCheck.after(span);
        return false;
    }
    if(form.username.value.length < 6) {
        let span = document.createElement("span");
        span.innerText = "아이디는 6자리 이상 입력하세요."
        form.username.style.borderColor = "red";
        form.username.value = "";
        form.username.after(span);
        return false;
    }
    if(form.password.value.length < 4) {
        let span = document.createElement("span");
        span.innerText = "비밀번호는 4자리 이상 입력하세요."
        form.password.style.borderColor = "red";
        form.password.value = "";
        form.password.after(span);
        return false;
    } 
}
*/
function validCheck(form) {
    var isValid = true;
    if(form.username.nextElementSibling !== null) {
        form.username.nextElementSibling.remove();
    }
    if(form.username.value.length < 6) {
        let span = document.createElement("span");
        span.innerText = "아이디는 6자리 이상 입력해야 합니다.";
        span.style.color = "red";
        form.username.style.borderColor = "red";
        form.username.after(span);
        isValid = false;
    }
    if(form.password.nextElementSibling !== null) {
        form.password.nextElementSibling.remove();
    }
    if(form.password.value.length < 4) {
        let span = document.createElement("span");
        span.innerText = "패스워드는 4자리 이상 입력해야 합니다.";
        span.style.color = "red";
        form.password.style.borderColor = "red";
        form.password.after(span);
        isValid = false;
    }
    if(form.passwordCheck.nextElementSibling !== null) {
        form.passwordCheck.nextElementSibling.remove();
    }
    if(form.password.value !== form.passwordCheck.value) {
        let span = document.createElement("span");
        span.innerText = "패스워드를 다시 확인하세요.";
        span.style.color = "red";
    /* form.passwordCheck.style.borderColor = "red";*/
        form.passwordCheck.classList.add("input-error");
        form.passwordCheck.after(span);
        isValid = false;
    }
    return isValid;
}