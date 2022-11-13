async function loadCommits() {
   
    const username = document.getElementById('username').value;
    const repo = document.getElementById('repo');
    const list = document.getElementById('commits');

    try {
    const res = await fetch(`https://api.github.com/repos/${username}/${repo}/commits`);

    if(res.ok == false) {
        throw new Error(`${res.status} ${res.statusText}`)
    }

    const data = await res.json();
    list.innerHTML = '';

    for (const { commit } of data) {
        const li = document.createElement('li');
        li.textContent = `${commit.author.name}: ${commit.message}`;
        list.appendChild(li);
        
    }
}catch (err) {
list.innerHTML = `Error ${err.message}`
}
}
