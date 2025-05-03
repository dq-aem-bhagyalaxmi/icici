document.addEventListener('DOMContentLoaded', function () {
    const featuresList = document.getElementById('features-tab1');
    const verticalLine = document.querySelector('.vertical-line');
    const featureItems = featuresList.querySelectorAll('.feature-item');
    let currentIndex = 0;
    const stepHeight = 60; // Adjust based on design

    function highlightFeature() {
        if (currentIndex === 0) {
            featureItems.forEach(item => {
                const dot = item.querySelector('.dot');
                if (dot) dot.style.borderColor = '#f1f1f1';
            });
            verticalLine.style.setProperty('--line-height', `0px`);
        }

        featureItems.forEach(item => item.classList.remove('active'));
        const currentItem = featureItems[currentIndex];
        currentItem.classList.add('active');

        const outerDot = currentItem.querySelector('.dot');
        if (outerDot) outerDot.style.borderColor = '#f26f21';

        verticalLine.style.setProperty('--line-height', `${currentIndex * stepHeight}px`);

        currentIndex++;
        if (currentIndex >= featureItems.length) {
            currentIndex = 0;
        }
    }

    setInterval(highlightFeature, 2000);
});