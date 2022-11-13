window.onload = loadRepos;

function loadRepos() {
	const usernameElement = document.getElementById("username");
	const button = document.querySelector("body > button");
	window.onload = getRepos;
	button.addEventListener("click", getRepos);
	const resultElement = document.getElementById("repos");
	const url = `https://api.github.com/users/${usernameElement.value}/repos`;

	

	function getRepos() {
		fetch(url)
		.then(handleResponse)
		.then(parseData)
		.catch(errorMessage);
	}


	function handleResponse(res) {

		if(res.ok === true) {
			return res.json();
		}else {
			throw new Error(`${res.status} ${res.statusText}`)
		}
	}


	function parseData(data) {

		resultElement.replaceChildren();

		data.map(({full_name, html_url}) => ({full_name, html_url}))
		.forEach(repo => {
			const li = document.createElement('li');
			const a = document.createElement('a');
			const link = document.createTextNode(repo.full_name);
			a.appendChild(link);
			a.href = repo.html_url;
			a.title = repo.full_name;
			li.appendChild(a);
			resultElement.appendChild(li)
		});
	}

	function errorMessage(error) {
		resultElement.innerHTML = `${error.message}`;
	}
}
