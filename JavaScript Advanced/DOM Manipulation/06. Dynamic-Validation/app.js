function validate() {
   let intputElement = document.getElementById('email').addEventListener('change', verifyEmail);

   function verifyEmail(e) {
       const regex = /^[a-z]+@[a-z]+\.[a-z]+$/g;
       const currentEmailInput = e.target.value
       
       if(!regex.test(currentEmailInput)) {
        e.target.classList.add('error');
       }else {
        e.target.classList.remove('error');
       }
   }
}