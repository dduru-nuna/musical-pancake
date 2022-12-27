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
    var form = document.forms[0];
    form.username.addEventListener("blur", function(e) { lengthValid(e, 5, 20) });
}

function lengthValid(event, min, max) {
    var inputElement = event.target;
    if(inputElement.value.length >= min && inputElement.value.length <= max) {
        form.classList.add('was-validation')
    }
}