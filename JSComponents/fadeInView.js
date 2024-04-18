// Apply fade-in effect to elements when they come into view
function fadeInView() {
    var content = document.querySelectorAll('.fade-in-view');

    content.forEach(function(content) {
        if (isInViewport(content)) {
            content.classList.add('fade-in-view-active');
        }
    });
}

// Check if an element is in the viewport
function isInViewport(element) {
    var rect = element.getBoundingClientRect();

    return (
        rect.top >= 0 &&
        rect.left >= 0 &&
        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
        rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
}

// Event listener to trigger fadeInView function when the page is scrolled
window.addEventListener('scroll', fadeInView);

// Event listener to trigger fadeInView function when the DOM content is loaded
document.addEventListener('DOMContentLoaded', function() {
    fadeInView();
    setTimeout(fadeInView, 200);
});
