document.addEventListener("DOMContentLoaded", function () {
  const track = document.querySelector(".carousel-track");
  const slides = Array.from(track.children);
  const nextButton = document.querySelector(".carousel-next");
  const prevButton = document.querySelector(".carousel-prev");
  const dotsNav = document.querySelector(".carousel-dots");
  const dots = Array.from(dotsNav.children);

  const slideWidth = slides[0].getBoundingClientRect().width;

  // Arrange slides next to one another
  slides.forEach((slide, index) => {
      slide.style.left = slideWidth * index + "px";
  });

  const moveToSlide = (track, currentSlide, targetSlide) => {
      track.style.transform = "translateX(-" + targetSlide.style.left + ")";
      currentSlide.classList.remove("current-slide");
      targetSlide.classList.add("current-slide");
  };

  const updateDots = (currentDot, targetDot) => {
      currentDot.classList.remove("active");
      targetDot.classList.add("active");
  };

  const hideShowArrows = (slides, prevButton, nextButton, targetIndex) => {
      if (targetIndex === 0) {
          prevButton.classList.add("is-hidden");
          nextButton.classList.remove("is-hidden");
      } else if (targetIndex === slides.length - 1) {
          prevButton.classList.remove("is-hidden");
          nextButton.classList.add("is-hidden");
      } else {
          prevButton.classList.remove("is-hidden");
          nextButton.classList.remove("is-hidden");
      }
  };

  // Click Next Button
  nextButton.addEventListener("click", () => {
      const currentSlide = track.querySelector(".current-slide");
      const nextSlide = currentSlide.nextElementSibling;
      const currentDot = dotsNav.querySelector(".active");
      const nextDot = currentDot.nextElementSibling;
      const nextIndex = slides.findIndex((slide) => slide === nextSlide);

      moveToSlide(track, currentSlide, nextSlide);
      updateDots(currentDot, nextDot);
      hideShowArrows(slides, prevButton, nextButton, nextIndex);
  });

  // Click Prev Button
  prevButton.addEventListener("click", () => {
      const currentSlide = track.querySelector(".current-slide");
      const prevSlide = currentSlide.previousElementSibling;
      const currentDot = dotsNav.querySelector(".active");
      const prevDot = currentDot.previousElementSibling;
      const prevIndex = slides.findIndex((slide) => slide === prevSlide);

      moveToSlide(track, currentSlide, prevSlide);
      updateDots(currentDot, prevDot);
      hideShowArrows(slides, prevButton, nextButton, prevIndex);
  });

  // Click Dots
  dotsNav.addEventListener("click", (e) => {
      const targetDot = e.target.closest("button");

      if (!targetDot) return;

      const currentSlide = track.querySelector(".current-slide");
      const currentDot = dotsNav.querySelector(".active");
      const targetIndex = dots.findIndex((dot) => dot === targetDot);
      const targetSlide = slides[targetIndex];

      moveToSlide(track, currentSlide, targetSlide);
      updateDots(currentDot, targetDot);
      hideShowArrows(slides, prevButton, nextButton, targetIndex);
  });
});