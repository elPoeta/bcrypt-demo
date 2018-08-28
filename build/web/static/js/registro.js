const URL_REGISTRO = 'Registrar';

const regEmail = document.querySelector('#reg-email');
const regPass = document.querySelector('#reg-pass');
const btnRegistrar = document.querySelector('#btn-registrar');


btnRegistrar.addEventListener('click', e =>{
   reg = {};
   reg.email = regEmail.value;
   reg.password = regPass.value;
   
   Http.post(URL_REGISTRO,reg)
       .then(response => response.json())
           .then(data =>{
               console.log(data);
               document.querySelector('#panelmsgreg').innerHTML = data;
   })
     .catch (err =>{
      console.log(err);   
   });          
e.preventDefault();
});
