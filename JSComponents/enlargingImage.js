// Enlarge an image when clicked
function enlargeImage(imgElement) {
    // Function to display an image in an enlarged view when clicked, along with its caption
    var enlargedImg = document.getElementById('enlargedImg');
    var captionText = document.getElementById('caption');

    enlargedImg.src = imgElement.src;
    captionText.innerHTML = imgElement.getAttribute('data-caption');

    enlargedImg.style.display = 'block';
    captionText.style.display = 'block';
}
