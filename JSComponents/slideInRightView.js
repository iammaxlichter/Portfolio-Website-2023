// Applies a fade-in effect to images sliding in from the right when they enter the viewport
function slideInRight() {
    var content = document.querySelectorAll('.slide-in-right');

    content.forEach(function(content) {
        if (isInViewport(content)) {
            content.classList.add('slide-in-right-active');
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

// Triggers the slideInRight function on page scroll
window.addEventListener('scroll', slideInRight);

// Initially triggers the slideInRight function and then after a short delay to ensure images outside the initial viewport also fade in
document.addEventListener('DOMContentLoaded', function() {
    slideInRight();
    setTimeout(slideInRight, 200);
});
