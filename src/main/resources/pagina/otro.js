let datos = {
  idClient:"WALA771012HCRGR054",
  idFly:11,
}

fetch("http://localhost:8090/agenciaviajes/ticket",
  {
    method: "POST",
    headers:
    {
      "Content-type": "application/json"
    },
    body: JSON.stringify(datos)
  })

