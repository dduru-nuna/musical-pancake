function validCheck() {
    /* 
     * 유효성 검사 후 문제가 발생하면 false 를 반환하여 서버에 전송이 안되게 할 것 
     * 사용자가 입력한 두 개의 패스워드가 동일 할 때에만 서버에 전송이 되도록 한다.
     * 두 개의 패스워드가 동일하지 않은 경우 서버에 데이터를 전송하지 않고 추가로
     * 패스워드 확인 옆에 "패스워드를 다시 입력하시오." 라는 메시지가 출력될 수 있도록 한다.
     */
    var form = document.forms[0];
    if(form.password.value !== form.passwordCheck.value) {
        /* alert("패스워드를 다시 입력하시오.")*/
        var message = document.getElementById("checkErr");
        message.innerText = "패스워드를 다시 입력하시오.";
        form.passwordCheck.value = "";
        return false;
    } 
}