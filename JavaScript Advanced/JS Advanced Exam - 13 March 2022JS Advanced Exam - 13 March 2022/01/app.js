function solve() {

const recipientElement = document.getElementById('recipientName');
const titleElement = document.getElementById('title');
const messageElement = document.getElementById('message');

const listOfMailsListElement = document.getElementById('list');

const sentMailsListElement = document.querySelector('body > section > article > div.sent-mails > ul');
// or const e = document.getElementsByClassName('sent-list')[0];
const deleteMailsListElement = document.querySelector('body > section > article > div.trash > ul');

const addButton = document.getElementById('add');
const resetButton = document.getElementById('reset');

addButton.addEventListener('click', addMail);
resetButton.addEventListener('click', clearFields);

function addMail(e) {
    
    e.preventDefault();

    const title = titleElement.value;
    const receipt = recipientElement.value;
    const message = messageElement.value;

    if(title === '' || receipt === '' || message === '') {
        return;
    }

    const titleElementForListOfMails = document.createElement('h4');
    titleElementForListOfMails.textContent = `Title: ${title}`;

    const receptElementForListOfMails = document.createElement('h4');
    receptElementForListOfMails.textContent = `Recipient Name: ${receipt}`;

    const spanElement = document.createElement('span');
    spanElement.textContent = message;

    const sendButton = document.createElement('button');
    sendButton.setAttribute('type', 'submit');
    sendButton.setAttribute('id', 'send');
    sendButton.textContent = 'Send';
    sendButton.addEventListener('click', sendMail);

    function sendMail() {
        const spanForReceipient = document.createElement('span');
        spanForReceipient.textContent = `To: ${receipt}`;

        const spanForTitle = document.createElement('span');
        spanForTitle.textContent = `Title: ${title}`;

        const deleteButton = document.createElement('button');
        deleteButton.setAttribute('type', 'submit');
        deleteButton.classList.add('delete');
        deleteButton.textContent = 'Delete'
        deleteButton.addEventListener('click', deleteEmail);

        function deleteEmail() {
            const li = document.createElement('li');
            const spanR = document.createElement('span');
            spanR.textContent = `To: ${receipt}`;

        const spanF = document.createElement('span');
        spanF.textContent = `Title: ${title}`;

        li.appendChild(spanR);
        li.appendChild(spanF);
        deleteMailsListElement.appendChild(li);

            // deleteButton.remove();
            // const delLiElement = liForSent.cloneNode(true);
            // deleteMailsListElement.appendChild(delLiElement);
            liForSent.remove();
        }

        const divForDelBtn = document.createElement('div');
        divForDelBtn.classList.add('btn');
        divForDelBtn.appendChild(deleteButton);

        const liForSent = document.createElement('li');
        liForSent.appendChild(spanForReceipient);
        liForSent.appendChild(spanForTitle);
        liForSent.appendChild(divForDelBtn);

        sentMailsListElement.appendChild(liForSent);
        liForListOfMails.remove();
    }

    
    const deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'submit');
    deleteButton.setAttribute('id', 'delete');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', deleteMail);

    function deleteMail() {
        const spanForReceipient = document.createElement('span');
        spanForReceipient.textContent = `To: ${receipt}`;
        spanForReceipient.setAttribute('id', 'sp1')

        const spanForTitle = document.createElement('span');
        spanForTitle.textContent = `Title: ${title}`;
        spanForTitle.setAttribute('id', 'sp2');
        
        const li = document.createElement('li');
        li.appendChild(spanForReceipient);
        li.appendChild(spanForTitle);
        deleteMailsListElement.appendChild(li);
        liForListOfMails.remove();
    }

    const divForListOfMails = document.createElement('div');
    divForListOfMails.setAttribute('id', 'list-action');
    divForListOfMails.appendChild(sendButton);
    divForListOfMails.appendChild(deleteButton);

    const liForListOfMails = document.createElement('li');
    liForListOfMails.appendChild(titleElementForListOfMails);
    liForListOfMails.appendChild(receptElementForListOfMails);
    liForListOfMails.appendChild(spanElement);
    liForListOfMails.appendChild(divForListOfMails);
    
    listOfMailsListElement.appendChild(liForListOfMails);

    titleElement.value = '';
    recipientElement.value = '';
    messageElement.value = '';
}

function clearFields(e) {

    e.preventDefault();

    titleElement.value = '';
    recipientElement.value = '';
    messageElement.value = '';
}

}
solve()