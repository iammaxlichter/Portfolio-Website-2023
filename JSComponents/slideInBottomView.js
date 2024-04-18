// Applies a fade-in effect to images sliding in from the bottom when they enter the viewport
function slideInBottom() {
    var content = document.querySelectorAll('.slide-in-bottom');

    content.forEach(function(content) {
        if (isInViewport(content)) {
            content.classList.add('slide-in-bottom-active');
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

// Triggers the slideInBottom function on page scroll
window.addEventListener('scroll', slideInBottom);

// Initially triggers the slideInBottom function and then after a short delay to ensure images outside the initial viewport also fade in
document.addEventListener('DOMContentLoaded', function() {
    slideInBottom();
    setTimeout(slideInBottom, 200);
});
