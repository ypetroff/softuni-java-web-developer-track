window.addEventListener("load", solve);

function solve() {
  const genreElement = document.getElementById("genre");
  const songNameElement = document.getElementById("name");
  const authorElement = document.getElementById("author");
  const dateElement = document.getElementById("date");
  const allHitsElement =
    document.getElementsByClassName("all-hits-container")[0];

const likesElement = document.querySelector('#total-likes > div > p');
let likesCounter = 0;
console.log(likesElement.textContent);

const savedSongsElement = document.getElementsByClassName('saved-container')[0];

  const addButton = document.getElementById("add-btn");
  addButton.addEventListener("click", addSong);

  function addSong(e) {
    e.preventDefault();

    const song = {
      genre: genreElement.value,
      name: songNameElement.value,
      author: authorElement.value,
      date: dateElement.value,
    };

    if (
      song.genre === "" ||
      song.name === "" ||
      song.author === "" ||
      song.date === ""
    ) {
      return;
    }

    const div = document.createElement("div");
    div.setAttribute("class", "hits-info");
    const img = document.createElement("img");
    img.setAttribute("src", "./static/img/img.png");
    div.appendChild(img);

    const h2G = document.createElement("h2");
    h2G.textContent = `Genre: ${song.genre}`;
    div.appendChild(h2G);

    const h2N = document.createElement("h2");
    h2N.textContent = `Name: ${song.name}`;
    div.appendChild(h2N);

    const h2A = document.createElement("h2");
    h2A.textContent = `Author: ${song.author}`;
    div.appendChild(h2A);

    const h3D = document.createElement('h3');
    h3D.textContent = `Date: ${song.date}`;
    div.appendChild(h3D);

    // for (const [key, value] of Object.entries(song)) {
    //   let el = "";

    //   if (key === "date") {
    //     el = document.createElement("h2"); //in the problem description si h3
    //   } else {
    //     el = document.createElement("h2");
    //   }

    //   el.textContent = `${key}: ${value}`;
    //   div.appendChild(el);
    // }

    const saveSongBtn = document.createElement('button');
    saveSongBtn.setAttribute('class', 'save-btn');
    saveSongBtn.textContent = 'Save song';
    div.appendChild(saveSongBtn);
    saveSongBtn.addEventListener('click', saveSong);

    function saveSong() {
        savedSongsElement.appendChild(div);
        saveSongBtn.remove();
        likeSongBtn.remove();
    }

    const likeSongBtn = document.createElement('button');
    likeSongBtn.setAttribute('class', 'like-btn');
    likeSongBtn.textContent = 'Like song';
    div.appendChild(likeSongBtn);
    likeSongBtn.addEventListener('click', likeSong);

    function likeSong() {
        likesCounter++;
        likesElement.textContent = `Total Likes: ${likesCounter}`
        likeSongBtn.disabled = true;
    }


    const delSongBtn = document.createElement('button');
    delSongBtn.setAttribute('class', 'delete-btn');
    delSongBtn.textContent = 'Delete';
    div.appendChild(delSongBtn);
    delSongBtn.addEventListener('click', deleteSong);

    function deleteSong() {
        div.remove();
    }

    allHitsElement.appendChild(div);

    genreElement.value = "";
    songNameElement.value = "";
    authorElement.value = "";
    dateElement.value = "";
  }
}
