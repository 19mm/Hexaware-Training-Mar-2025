const toggleBtn = document.getElementById('toggleButton');
const divToToggle = document.getElementById('toggleDiv');

if (toggleBtn && divToToggle) {
    toggleBtn.addEventListener('click', function() {
        if (divToToggle.style.display === 'none' || divToToggle.style.display === '') {
            divToToggle.style.display = 'block'; 
        } else {
            divToToggle.style.display = 'none';
        }
    });
} else {
    console.error("Could not find button or div element!");
}