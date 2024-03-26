// Function to handle navbar functionality
function handleNavbar() {
    // Extract the current page URL parameter
    var urlParams = new URLSearchParams(window.location.search);
    var currentPage = urlParams.get('page');


    // Get all navbar links
    var navLinks = document.querySelectorAll('.navbar-nav .nav-link');
console.log("hi")
    // Loop through each navbar link
    navLinks.forEach(function(link) {
        
        // Check if the link's data-page matches the current page URL parameter
        if (link.dataset.page === currentPage) {
            
            // Add a class to underline the active link
            link.classList.add('active');
        }
    });
}

// Call the handleNavbar function when the document is fully loaded
document.addEventListener("DOMContentLoaded", handleNavbar);
