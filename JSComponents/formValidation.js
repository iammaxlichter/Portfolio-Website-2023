// Validates the form fields to ensure all required fields are filled before submission
function validateForm() {
    var firstName = document.getElementById("firstName").value.trim();
    var lastName = document.getElementById("lastName").value.trim();
    var email = document.getElementById("email").value.trim();
    var message = document.getElementById("message").value.trim();

    if (firstName === "" || lastName === "" || email === "" || message === "") {
        alert("Please fill in all required fields.");
        return false; // Prevent form submission
    }
    return true; // Allow form submission
}
