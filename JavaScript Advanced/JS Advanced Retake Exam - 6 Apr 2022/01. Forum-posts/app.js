window.addEventListener("load", solve);

function solve() {
  const titleElement = document.getElementById("post-title");
  const categoryElement = document.getElementById("post-category");
  const contentElement = document.getElementById("post-content");
  const publishButton = document.getElementById("publish-btn");
  const publishedList = document.getElementById('published-list');
  const reviewList = document.getElementById('review-list');

  publishButton.addEventListener("click", publishInput);

  const clearButton = document.getElementById('clear-btn');
  clearButton.addEventListener('click', removeAllElements);

  function publishInput() {
    const title =  titleElement.value;
    const category = categoryElement.value;
    const content = contentElement.value;

    titleElement.value = "";
    categoryElement.value = "";
    contentElement.value = "";

    if (title === "" || category === "" || content === "") {
      return;
    }
    
    const reviewTitle = document.createElement('h4');
    reviewTitle.textContent = title;            //innerText & textContent
    const reviewCategory = document.createElement('p');
    reviewCategory.textContent = `Category: ${category}`;
    const reviewContent = document.createElement('p');
    reviewContent.textContent = `Content: ${content}`;

    const article = document.createElement('article');

    article.appendChild(reviewTitle);
    article.appendChild(reviewCategory);
    article.appendChild(reviewContent);

    const li = document.createElement('li');
    li.appendChild(article);
    li.classList.add('rpost');
//classList add only one class at a time, className could add multiple classes the same valid for setAttribute
// it took me way more time
    const editButton = document.createElement('button');
    editButton.classList.add('action-btn');
    editButton.classList.add('edit');
    //editButton.className = 'action-btn edit';
    editButton.textContent = 'Edit';
    li.appendChild(editButton);

    const approveButton = document.createElement('button');
    approveButton.classList.add('action-btn');
    approveButton.classList.add('approve');
   //approveButton.className = 'action-btn approve';
    approveButton.textContent = 'Approve';
    li.appendChild(approveButton);

    
    reviewList.appendChild(li); //here

    editButton.addEventListener('click', returnBack);
    function returnBack() {
      titleElement.value = title;
      categoryElement.value = category;
      contentElement.value = content;
      li.remove();
      }
    approveButton.addEventListener('click', moveToUploadedPosts);
    function moveToUploadedPosts() {

      editButton.remove();
      approveButton.remove();
      publishedList.appendChild(li);
      console.log(publishedList.children.length);
    }
  }

  function removeAllElements() {
   Array.from(publishedList.querySelectorAll('li')).forEach(x => x.remove());
  }
}
