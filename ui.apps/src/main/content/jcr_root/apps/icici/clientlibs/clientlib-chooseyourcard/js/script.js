document.addEventListener('DOMContentLoaded', function () {
    const btn = document.querySelector('.more-button');
    const cards = document.querySelector('.card-wrapper');
    if (btn && cards) {
        btn.addEventListener('click', function () {
            cards.classList.toggle('expanded');
        });
    }
});

<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>