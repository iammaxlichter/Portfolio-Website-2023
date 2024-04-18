// Applies a fade-in effect to images sliding in from the left when they enter the viewport
function slideInLeft() {
    var content = document.querySelectorAll('.slide-in-left');

    content.forEach(function(content) {
        if (isInViewport(content)) {
            content.classList.add('slide-in-left-active');
        }
    });
}

// Checks if an element is within the viewport
function isInViewport(element) {
    var rect = element.getBoundingClientRect();

    return (
        rect.top >= 0 &&
        rect.left >= 0 &&
        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
        rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
}

// Triggers the slideInLeft function on page scroll
window.addEventListener('scroll', slideInLeft);

// Initially triggers the slideInLeft function and then after a short delay to ensure images outside the initial viewport also fade in
document.addEventListener('DOMContentLoaded', function() {
    slideInLeft();
    setTimeout(slideInLeft, 200);
});
