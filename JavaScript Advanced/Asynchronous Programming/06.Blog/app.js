const selectElement = document.getElementById('posts');

function attachEvents() {
  const loadPostsBtn = document.getElementById('btnLoadPosts');
  loadPostsBtn.addEventListener('click', loadAllOptions);

  const viewPostBtn = document.getElementById('btnViewPost');
  viewPostBtn.addEventListener('click', displayAllInfo);
}

attachEvents();

async function loadAllOptions() {
  const url = 'http://localhost:3030/jsonstore/blog/posts';
  const data = await fetchData(url);
  selectElement.replaceChildren();
  Object.values(data).forEach(({id, title}) => createOption('option', id, title.toUpperCase(), selectElement));
}

async function displayAllInfo() {
  const postId = selectElement.value;

  const [post, comments] = await Promise.all([
    loadPost(postId),
    loadComments(postId)
  ])

  document.getElementById('post-title').textContent = post.title;
  document.getElementById('post-body').textContent = post.body;

  const commentSectionElement = document.getElementById('post-comments');
  commentSectionElement.replaceChildren();
  
  comments.forEach(x => {
    const li = document.createElement('li');
    li.textContent = x.text;
    commentSectionElement.appendChild(li);
  });
}

async function loadPost(postId) {
  const url = `http://localhost:3030/jsonstore/blog/posts/${postId}`;
  return fetchData(url);
}

async function loadComments(postId) {
  const url = 'http://localhost:3030/jsonstore/blog/comments';
  const data = await fetchData(url);
  return Object.values(data).filter(x => x.postId == postId);
}

async function fetchData(url) {
  const res = await fetch(url);
  return res.json();
}

function createOption(type, value, text, parent) {
  const element = document.createElement(type);
  element.value = value;
  element.textContent = text;
  parent.appendChild(element);
}



  