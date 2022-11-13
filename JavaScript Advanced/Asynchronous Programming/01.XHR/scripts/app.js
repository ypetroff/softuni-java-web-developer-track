function loadRepos() {
   const loadButtion = document.querySelector('body > button');
   loadButtion.addEventListener('click', getRepos());

   function getRepos() {
      
      const url = 'https://api.github.com/users/testnakov/repos';
      const httpRequest = new XMLHttpRequest;
      httpRequest.addEventListener('readystatechange', function() {
         const numberOfRequests = 4;
         if(httpRequest.readyState == numberOfRequests && httpRequest.status == 200) {
            document.getElementById('res').textContent = httpRequest.response;
         }
      });
      httpRequest.open('GET', url);
      httpRequest.send();
   }


}