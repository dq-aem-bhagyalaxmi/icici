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
    document.querySelectorAll('.faq-item').forEach(item => {
        const question = item.querySelector('.faq-question');
        const answer = item.querySelector('.faq-answer');
        question.classList.add('active');
        answer.classList.add('open');
        answer.style.maxHeight = answer.scrollHeight + "px";
    });
}

function collapseAllFaqs() {
    document.querySelectorAll('.faq-item').forEach(item => {
        const question = item.querySelector('.faq-question');
        const answer = item.querySelector('.faq-answer');
        question.classList.remove('active');
        answer.classList.remove('open');
        answer.style.maxHeight = null;
    });
}
