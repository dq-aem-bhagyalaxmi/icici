document.addEventListener("DOMContentLoaded", function () {
    const carousels = document.querySelectorAll('.carousel-container');

    carousels.forEach((carousel) => {
        const track = carousel.querySelector('.carousel-track');
        const cards = Array.from(track?.children || []);
        const prevButton = carousel.querySelector('.prev-button');
        const nextButton = carousel.querySelector('.next-button');
        const dotsContainer = carousel.querySelector('.dots-container');

        if (!track || cards.length === 0) {
            console.error("Carousel track or cards not found for one of the carousels!");
            return;
        }

        const cardsToShow = 3;
        const totalCards = cards.length;
        const maxIndex = totalCards - cardsToShow;
        let currentIndex = 0;
        const dots = [];

        function createDots() {
            if (!dotsContainer) return;

            dotsContainer.innerHTML = "";
            for (let i = 0; i <= maxIndex; i++) {
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
            if (prevButton && nextButton) {
                prevButton.disabled = currentIndex === 0;
                nextButton.disabled = currentIndex === maxIndex;
                prevButton.style.opacity = prevButton.disabled ? '0.3' : '1';
                nextButton.style.opacity = nextButton.disabled ? '0.3' : '1';
                prevButton.style.cursor = prevButton.disabled ? 'default' : 'pointer';
                nextButton.style.cursor = nextButton.disabled ? 'default' : 'pointer';
            }
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

        // Init
        createDots();
        updateCarousel();
    });
});
