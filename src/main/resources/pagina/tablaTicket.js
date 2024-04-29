
window.onload = function(){
    listarTicket();
}


let listarTicket = async ()=>{
    
    const peticion = await fetch("http://localhost:8090/agenciaviajes/ticket", 
        {
        method:'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'}
        });
     
    const tickets = await peticion.json();
    
    let contenidoTabla = "";

    for(let ticket of tickets){
        let contenidoFila = `<tr>
        <td>${ticket.id}</td>
        <td>${ticket.price}</td>
        <td>${ticket.fly}</td>
        <td>${ticket.customer}</td>
        <td>${ticket.departure}</td>
        <td>${ticket.arrival}</td>
        <td>${ticket.purchase}</td>
        <td><i class="material-icons button edit">edit</i>
        <i class="material-icons button delete">delete</i></td>
        </tr>`
        contenidoTabla += contenidoFila;       
    }

    document.querySelector("#tablaTicket tbody").outerHTML = contenidoTabla;


}