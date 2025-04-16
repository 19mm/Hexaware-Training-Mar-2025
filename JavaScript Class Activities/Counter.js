const countDisplay = document.getElementById('countDisplay');
const incrementButton = document.getElementById('incrementBtn');
const decrementButton = document.getElementById('decrementBtn');

if (countDisplay && incrementButton && decrementButton) {
    let currentCount = 0; 

    function updateDisplay() {
        countDisplay.textContent = currentCount;
    }

    incrementButton.addEventListener('click', function() {
        currentCount++;
        updateDisplay();
    });

    decrementButton.addEventListener('click', function() {
        currentCount--;
        updateDisplay();
    });

    updateDisplay();

} else {
    console.error("Could not find one or more counter elements!");
}