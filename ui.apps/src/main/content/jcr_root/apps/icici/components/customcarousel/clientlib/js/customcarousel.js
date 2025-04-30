document.addEventListener('DOMContentLoaded', function () {
    const track = document.querySelector('.carousel-track');
    const slides = Array.from(track.children);
    const nextButton = document.querySelector('.carousel-next');
    const prevButton = document.querySelector('.carousel-prev');

    let currentIndex = 0;

    const updateSlidePosition = () => {
        const containerWidth = document.querySelector('.carousel').offsetWidth;
        const slideWidth = containerWidth / 3; // 3 slides per view

        slides.forEach(slide => {
            slide.style.flex = `0 0 ${slideWidth}px`;
        });

        const offset = currentIndex * slideWidth;
        track.style.transform = `translateX(-${offset}px)`;
    };

    nextButton.addEventListener('click', () => {
        if (currentIndex < slides.length - 3) { // show 3 slides
            currentIndex++;
            updateSlidePosition();
        }
    });

    prevButton.addEventListener('click', () => {
        if (currentIndex > 0) {
            currentIndex--;
            updateSlidePosition();
        }
    });

    window.addEventListener('resize', updateSlidePosition);
    updateSlidePosition();
});
