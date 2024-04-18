// Handles navbar functionality by underlining the active link based on the current page URL parameter
function handleNavbar() {
    var urlParams = new URLSearchParams(window.location.search);
    var currentPage = urlParams.get('page');

    var navLinks = document.querySelectorAll('.navbar-nav .nav-link');
    var dropdownLink = document.querySelectorAll('.dropdown-menu .dropdown-item');

    navLinks.forEach(function (link) {
        if (link.dataset.page === currentPage) {
            link.classList.add('active');
        }
    });

    dropdownLink.forEach(function (link) {
        if (link.dataset.page === currentPage) {
            link.classList.add('active');
        }
    });
}

// Calls the handleNavbar function when the document is fully loaded
document.addEventListener("DOMContentLoaded", handleNavbar);
