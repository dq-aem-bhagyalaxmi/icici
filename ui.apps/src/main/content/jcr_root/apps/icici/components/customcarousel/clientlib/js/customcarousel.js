document.addEventListener("DOMContentLoaded", function () {
    const track = document.querySelector('.carousel-track');
    const cards = Array.from(track?.children || []);
    const prevButton = document.querySelector('.prev-button');
    const nextButton = document.querySelector('.next-button');
    const dotsContainer = document.querySelector('.dots-container');

    if (!track || cards.length === 0) {
        console.error("Carousel track or cards not found!");
        return;
    }

    const cardsToShow = 3; // Number of cards visible at a time
    const totalCards = cards.length;
    const maxIndex = totalCards - cardsToShow;
    let currentIndex = 0;

    // Create dots based on the number of slides
    const dotsCount = maxIndex + 1;
    const dots = [];

    function createDots() {
        if (!dotsContainer) {
            console.error("Dots container not found!");
            return;
        }

        dotsContainer.innerHTML = ""; // Clear existing dots
        for (let i = 0; i < dotsCount; i++) {
            const dot = document.createElement('button');
            dot.classList.add('dot');
            dot.setAttribute('aria-label', `Slide ${i + 1}`);
            dot.setAttribute('role', 'tab');
            dot.addEventListener('click', () => {
                currentIndex = i;
                updateCarousel();
            });
            dotsContainer.appendChild(dot);
            dots.push(dot);
        }
    }

    function updateCarousel() {
        const cardWidth = cards[0].getBoundingClientRect().width;
        const moveX = cardWidth * currentIndex;
        track.style.transform = `translateX(-${moveX}px)`;
        updateDots();
        updateButtons();
    }

    function updateDots() {
        dots.forEach((dot, idx) => {
            dot.classList.toggle('active', idx === currentIndex);
        });
    }

    function updateButtons() {
        prevButton.disabled = currentIndex === 0;
        nextButton.disabled = currentIndex === maxIndex;
        prevButton.style.opacity = prevButton.disabled ? '0.3' : '1';
        nextButton.style.opacity = nextButton.disabled ? '0.3' : '1';
        prevButton.style.cursor = prevButton.disabled ? 'default' : 'pointer';
        nextButton.style.cursor = nextButton.disabled ? 'default' : 'pointer';
    }

    prevButton?.addEventListener('click', () => {
        if (currentIndex > 0) {
            currentIndex--;
            updateCarousel();
        }
    });

    nextButton?.addEventListener('click', () => {
        if (currentIndex < maxIndex) {
            currentIndex++;
            updateCarousel();
        }
    });

    // Initialize
    createDots();
    updateCarousel();
});
