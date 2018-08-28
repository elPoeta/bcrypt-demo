const URL_LOGIN = 'Login';

const logEmail = document.querySelector('#log-email');
const logPass = document.querySelector('#log-pass');
const btnLogin = document.querySelector('#btn-login');


btnLogin.addEventListener('click', e =>{
   log = {};
   log.email = logEmail.value;
   log.password = logPass.value;
   
   Http.post(URL_LOGIN,log)
       .then(response => response.json())
       .then(data =>{
               console.log(data);
               document.querySelector('#panelmsglog').innerHTML = data;
   })
     .catch (err =>{
      console.log(err);   
   });          
   e.preventDefault();
});

