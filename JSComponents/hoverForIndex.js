// JavaScript for hover effect and sentence display
document.querySelectorAll('.slide').forEach(item => {
    item.addEventListener('mouseenter', function() {
        this.classList.add('blur'); // Add blur effect on hover
        this.querySelector('.caption').style.display = 'block'; // Display the caption
    });

    item.addEventListener('mouseleave', function() {
        this.classList.remove('blur'); // Remove blur effect on hover out
        this.querySelector('.caption').style.display = 'none'; // Hide the caption
    });
});
