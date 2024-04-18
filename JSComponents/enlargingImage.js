function enlargeImage(imgElement) {
    var enlargedImg = document.getElementById('enlargedImg');
    var captionText = document.getElementById('caption');
    enlargedImg.src = imgElement.src;
    captionText.innerHTML = imgElement.getAttribute('data-caption');
    enlargedImg.style.display = 'block';
    captionText.style.display = 'block';
}