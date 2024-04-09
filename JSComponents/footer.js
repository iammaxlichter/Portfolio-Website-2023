
// Ensure your scrollToTop function is also included
function scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
  
  
  // Function to open share modal
  function openShareModal(event) {
    event.preventDefault();  // Prevent default action
  
    var modal = document.getElementById("shareModal");
    var textBox = modal.querySelector("#shareLink");
    textBox.value = "https://iammaxlichter.github.io";
    modal.style.display = "block";
  
    // Show the backdrop
    document.getElementById("modalBackdrop").style.display = "block";
  
    // Center the modal
    modal.querySelector(".modal-dialog").classList.add("modal-dialog-centered");
  }
  
  
  // Function to close share modal
  function closeShareModal() {
    var modal = document.getElementById("shareModal");
    modal.style.display = "none";
  
    // Hide the backdrop
    document.getElementById("modalBackdrop").style.display = "none";
  }
  
  // Event listener for closing share modal when clicking off the modal or pressing Escape key
  document.addEventListener("click", function (event) {
    var modalBackdrop = document.getElementById("modalBackdrop");
    var modal = document.getElementById("shareModal");
    var modalContent = modal.querySelector(".modal-content");
    if (modalContent.contains(event.target)) {
      // Click occurred inside the modal, do nothing
      return;
    }
    if (modal === event.target || modalBackdrop === event.target) {
      // Click occurred outside the modal, close it
      closeShareModal();
    }
  });
  
  
  // Function to copy URL to clipboard
  function copyUrlToClipboard() {
    var text = document.getElementById("shareLink").value;
    // Copy text to clipboard
    navigator.clipboard.writeText(text)
      .then(function () {
        // Show success message
        var successMessage = document.getElementById("copySuccessMessage");
        successMessage.style.display = "block";
        // Hide success message after 2 seconds
        setTimeout(function () {
          successMessage.style.display = "none";
        }, 2000);
      })
      .catch(function (error) {
        console.error('Failed to copy: ', error);
      });
  }
  
  // Close modal when Escape key is pressed
  document.addEventListener("keydown", function (event) {
    if (event.key === "Escape") {
      closeShareModal();
    }
  });