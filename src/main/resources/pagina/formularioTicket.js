
let boton = document.getElementById("btnGuardar");

boton.addEventListener("click", evento=>{
    registrarTicket();
});

let registrarTicket = async()=>{

let campos = {}

document.getElementById("idClient").value;
document.getElementById("idFly").value;

const peticion = await fetch("http://localhost:8090/agenciaviajes/ticket",

{
    method:'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(campos)

});

}