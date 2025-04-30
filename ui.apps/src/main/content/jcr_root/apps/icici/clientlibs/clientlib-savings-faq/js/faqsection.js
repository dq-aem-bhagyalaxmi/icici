function toggleFaq(element) {
    const question = element;
    const answer = question.nextElementSibling;

    const isActive = question.classList.contains('active');

    // Close all
    document.querySelectorAll('.faq-question').forEach(q => q.classList.remove('active'));
    document.querySelectorAll('.faq-answer').forEach(a => {
        a.classList.remove('open');
        a.style.maxHeight = null;
    });

    // Open current if it was not active
    if (!isActive) {
        question.classList.add('active');
        answer.classList.add('open');
        answer.style.maxHeight = answer.scrollHeight + "px";
    }
}

function expandAllFaqs() {
    document.querySelectorAll('.cmp-accordion__button').forEach(btn => {
        if (btn.getAttribute('aria-expanded') === 'false') {
            btn.click();
        }
    });
}

function collapseAllFaqs() {
    document.querySelectorAll('.cmp-accordion__button').forEach(btn => {
        if (btn.getAttribute('aria-expanded') === 'true') {
            btn.click();
        }
    });
}
