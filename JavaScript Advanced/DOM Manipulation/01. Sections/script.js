function create(words) {

   let content =  document.querySelector('#content');

 words.forEach(x => {
   let div = document.createElement('div');
   let p = document.createElement('p');
   p.textContent = x;
   p.style.display = 'none';
   div.appendChild(p);
   div.addEventListener('click', showText);
   content.appendChild(div);
 });

 function showText(e) {

   e.currentTarget.querySelector('p').style.display = 'block';
    
 }
}