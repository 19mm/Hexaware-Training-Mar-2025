const inputField = document.getElementById('inputText');
const displayBtn = document.getElementById('displayButton');
const outputPara = document.getElementById('outputArea');

if (inputField && displayBtn && outputPara) {
    displayBtn.addEventListener('click', function() {
        const userInput = inputField.value; 
        outputPara.textContent = userInput || '---'; 
    });
} else {
    console.error("Could not find one or more elements (input, button, output)!");
}