window.addEventListener('load', solve);

function solve() {
    const elements = {
        productTypeElement: document.getElementById('type-product'),
        problemDescriptionElement: document.getElementById('description'),
        clientNameElement: document.getElementById('client-name'),
        clientPhoneElement: document.getElementById('client-phone')
    }

    const receivedOrdersElements = document.getElementById('received-orders');
    const completedOrdersElements = document.getElementById('completed-orders');
    
    const sendFormButton = document.querySelector('#right > form > button');
    sendFormButton.addEventListener('click', collectRepairFormData);

    const clearButton = document.querySelector('#completed-orders > button');
    clearButton.addEventListener('click', removeDivElements);

    function removeDivElements() {
       const allDivs = document.querySelectorAll('#completed-orders > div.container');
       Array.from(allDivs).forEach((x) => x.remove());
       
    }

    function collectRepairFormData(e) {
        e.preventDefault();

        const fields = {
            product: elements.productTypeElement.value,
            problem: elements.problemDescriptionElement.value,
            clientName: elements.clientNameElement.value,
            clientPhone: elements.clientPhoneElement.value
        }

       if(fields.product === '' || fields.problem === '' || fields.clientName === '' || fields.clientPhone === '') {
        return;
       }

        const div = document.createElement('div');
        div.setAttribute('class', 'container');

        const h2 = document.createElement('h2');
        h2.textContent = `Product type for repair: ${fields.product}`;
        div.appendChild(h2);

        const h3 = document.createElement('h3');
        h3.textContent = `Client information: ${fields.clientName}, ${fields.clientPhone}`;
        div.appendChild(h3);

        const h4 = document.createElement('h4');
        h4.textContent = `Description of the problem: ${fields.problem}`
        div.appendChild(h4);
        const start = document.createElement('button');
        start.setAttribute('class', 'start-btn');
        start.textContent = 'Start repair';
        div.appendChild(start);
        start.addEventListener('click', initiateRepair);

        function initiateRepair() {
            start.disabled = true;
            finish.disabled = false;
        }

        const finish = document.createElement('button');
        finish.setAttribute('class', 'finish-btn');
        finish.textContent = 'Finish repair';
        finish.disabled = true;
        div.appendChild(finish);
        finish.addEventListener('click', repairCompleted);
        
        function repairCompleted() {
            completedOrdersElements.appendChild(div);
            start.remove();
            finish.remove();
        }

        receivedOrdersElements.appendChild(div);
    
        for (const element of Object.values(elements)) {
            element.value = '';
        }
       
    }  
}