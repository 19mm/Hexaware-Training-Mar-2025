const form = document.getElementById('myForm');
const usernameInput = document.getElementById('username');
const emailInput = document.getElementById('email');
const usernameError = document.getElementById('usernameError');
const emailError = document.getElementById('emailError');

if (form) {
    form.addEventListener('submit', function(event) {
        let isValid = true;

        usernameError.textContent = '';
        emailError.textContent = '';

        if (usernameInput.value.trim() === '') {
            usernameError.textContent = 'Username is required.';
            isValid = false;
        }

        if (emailInput.value.trim() === '') {
            emailError.textContent = 'Email is required.';
            isValid = false;
        } else if (!/\S+@\S+\.\S+/.test(emailInput.value)) { 
            emailError.textContent = 'Please enter a valid email address.';
            isValid = false;
        }

        if (!isValid) {
            event.preventDefault(); 
            console.log("Form validation failed.");
        } else {
            console.log("Form validation passed. Submitting...");
        }
    });
} else {
    console.error("Could not find the form element!");
}