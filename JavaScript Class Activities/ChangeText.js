const paragraphElement = document.getElementById('myParagraph');
const buttonElement = document.getElementById('changeTextButton');

if (paragraphElement && buttonElement) {
    buttonElement.addEventListener('click', function() {
        paragraphElement.textContent = "The text has been changed!";
    });
} else {
    console.error("Could not find paragraph or button element!");
}