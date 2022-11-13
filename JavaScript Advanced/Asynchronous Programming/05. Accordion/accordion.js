window.onload = solution();

async function solution() {
   
   const url = 'http://localhost:3030/jsonstore/advanced/articles/list'
   const res = await fetch(url);
   const data = await res.json();

   const mainSection = document.getElementById('main');

   
 
   Object.values(data).map(({_id, title}) => {
    const divAccordion = elementCreator('div', ['accordion'], '');
    const divHead = elementCreator('div', ['head'], '', divAccordion);
    const spanTitle = elementCreator('span', [], title, divHead);
    const toggleBtn = elementCreator('button', ['button'], 'More', divHead);
    toggleBtn.setAttribute('id', _id);

    return divAccordion;
   })
   .forEach(x => mainSection.appendChild(x));
   


}

function elementCreator(type, attribute, content, parent) {

    const currentElement = document.createElement(type);
    if(type == 'span' || type == 'p') {
        currentElement.setAttribute('id', attribute);
       
    }else if (type == 'div' || type == 'button') {
        attribute.forEach(x => currentElement.classList.add(x));
        
    } 

    currentElement.textContent = content
    
    if(parent !== undefined) {
        parent.appendChild(currentElement);
    } 

    if(type == 'button') {
        currentElement.addEventListener('click', toggle);
    }

    return currentElement;
}

 async function toggle(e) {
    const current = e.target
    if(current.textContent == 'More') {
        current.textContent = 'Less';
        const url = `http://localhost:3030/jsonstore/advanced/articles/details/${current.id}`
        const res = await fetch(url);
        const data = await res.json();
        
        div = elementCreator('div', ['extra']);
        div.style.display = 'block';
     
     

        elementCreator('p', [data._id], data.content, div);


      

    current.parentElement.parentElement.appendChild(div);
        

    }else if(current.textContent == 'Less') {
        current.textContent = 'More';
        e.target.parentElement.parentElement.lastChild.remove();
    }
}