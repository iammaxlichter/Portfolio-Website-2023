function enlargeImage(imgElement) {
    var enlargedImg = document.getElementById('enlargedImg');
    var captionText = document.getElementById('caption');
    enlargedImg.src = imgElement.src; // Set the source of the placeholder to the clicked image's source
    captionText.innerHTML = imgElement.getAttribute('data-caption'); // Set the caption
    enlargedImg.style.display = 'block'; // Make the enlarged image visible
    captionText.style.display = 'block'; // Make the caption visible
}