

document.addEventListener("DOMContentLoaded", function () {
    const images = document.querySelectorAll("#rotating-image .rotating-img");


    let current = 0;
    if (images.length > 1) {
        setInterval(() => {
            images[current].style.display = "none";
            current = (current + 1) % images.length;
            images[current].style.display = "block";
        }, 1000);
    }
});
