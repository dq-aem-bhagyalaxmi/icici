(function() {
  document.addEventListener('DOMContentLoaded', function() {
    const button = document.querySelector('.toggle-button');
    const accordionBody = document.querySelector('.accordion-body');

    if (button && accordionBody) {
      button.addEventListener('click', function() {
        accordionBody.classList.toggle('active');

        if (accordionBody.classList.contains('active')) {
          button.innerText = 'READ LESS';
        } else {
          button.innerText = 'READ MORE';
        }
      });
    }
  });
})();
