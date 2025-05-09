document.addEventListener("DOMContentLoaded", function () {
    const images = document.querySelectorAll(".rotating-img");
    const buttons = document.querySelectorAll("#optionButtons .option-button");

    let currentIndex = 0;
    const total = images.length;

    function showImage(index) {
        images.forEach((img, i) => {
            img.style.display = i === index ? "block" : "none";
        });

        buttons.forEach((btn, i) => {
            if (i === index) {
                btn.classList.add("active");
            } else {
                btn.classList.remove("active");
            }
        });
    }

    // Initial display
    showImage(0);

    // Auto rotate every 5 seconds
    setInterval(() => {
        currentIndex = (currentIndex + 1) % total;
        showImage(currentIndex);
    }, 5000);

    // Manual switch via button click
    buttons.forEach((button, i) => {
        button.addEventListener("click", () => {
            currentIndex = i;
            showImage(i);
        });
    });
});
