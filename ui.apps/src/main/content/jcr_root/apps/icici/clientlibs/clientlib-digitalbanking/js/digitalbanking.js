document.addEventListener('DOMContentLoaded', function () {
    const tabs = document.querySelectorAll('.tab');
    const image1 = document.getElementById('actorImageTab1');
    const image2 = document.getElementById('actorImageTab2');
    const features1 = document.getElementById('features-tab1');
    const features2 = document.getElementById('features-tab2');
    const appimg = document.getElementById('appImageTab1');

    let featureItems = features1.querySelectorAll('.feature-item');
    let currentIndex = 0;
    const stepHeight = 30; // Adjust based on spacing between items

   function highlightFeature() {
    const activeFeaturesList = (document.getElementById('features-tab1').style.display !== 'none') 
        ? document.getElementById('features-tab1') 
        : document.getElementById('features-tab2');

    featureItems = activeFeaturesList.querySelectorAll('.feature-item');

    if (currentIndex === 0) {
        // Reset all dot borders
        featureItems.forEach(item => {
            const dot = item.querySelector('.dot');
            if (dot) dot.style.borderColor = '#f1f1f1';
        });
        activeFeaturesList.style.setProperty('--line-height', `0px`);
    }

    // Highlight current item
    featureItems.forEach(item => item.classList.remove('active'));
    const currentItem = featureItems[currentIndex];
    currentItem.classList.add('active');

    const outerDot = currentItem.querySelector('.dot');
    if (outerDot) outerDot.style.borderColor = '#f26f21';

    activeFeaturesList.style.setProperty('--line-height', `${(currentIndex) * stepHeight}px`);

    currentIndex++;
    if (currentIndex >= featureItems.length) {
        currentIndex = 0;
    	}
	}

    setInterval(highlightFeature, 2000);

    tabs.forEach(tab => {
        tab.addEventListener('click', function () {
            tabs.forEach(t => t.classList.remove('active'));
            tab.classList.add('active');

            if (tab.getAttribute('data-tab') === 'tab1') {
                image1.style.display = 'block';
                image2.style.display = 'none';
                features1.style.display = 'block';
                features2.style.display = 'none';
                appimg.style.display = 'block';
                featureItems = features1.querySelectorAll('.feature-item');
            } else {
                image1.style.display = 'none';
                image2.style.display = 'block';
                features1.style.display = 'none';
                features2.style.display = 'block';
                appimg.style.display = 'none';
                featureItems = features2.querySelectorAll('.feature-item');
            }

            currentIndex = 0;
        });
    });
});
