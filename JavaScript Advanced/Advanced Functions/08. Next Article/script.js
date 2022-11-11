function getArticleGenerator(articles) {
    let articlesArray = articles;

    return () => {
        if(articlesArray.length > 0) {
    const container = document.querySelector('#content');
    const article = document.createElement('article');
    const currentText = articles.shift();
    article.innerText = currentText;
    container.appendChild(article);
        }
    }

}
