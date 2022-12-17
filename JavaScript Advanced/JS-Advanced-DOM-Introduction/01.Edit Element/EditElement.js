function editElement(reference, match, replacer) {
    const refElement = reference.textContent;
    const matcher = new RegExp(match, 'g');
    const edited = refElement.replace(matcher, replacer);
    reference.textContent = edited;
}