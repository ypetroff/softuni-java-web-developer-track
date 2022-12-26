const url = 'http://localhost:3030/jsonstore/messenger';
const messages = document.getElementById('messages');

function attachEvents() {
    const sendBtn = document.getElementById('submit');
    sendBtn.addEventListener('click', sendMessage);
    const refreshBtn = document.getElementById('refresh');
    refreshBtn.addEventListener('click', displayAllMessages);
}

async function sendMessage() {

    const data = {
        author: document.querySelector('#controls > input[type=text]:nth-child(2)').value,
        content: document.querySelector('#controls > input[type=text]:nth-child(5)').value
    }

    fetch(url, {
        method: 'post',
        headers: { 'Content-type': 'application/json' },
        body: JSON.stringify(data)
    })
}

async function displayAllMessages() {
 
    const res = await fetch(url);
    const data = await res.json();

    messages.textContent = Object.values(data).map(({author, content}) => `${author}: ${content}`).join('\n');
}

attachEvents();