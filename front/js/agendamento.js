function cadastrar(event) {
    event.preventDefault(); //não faça o comportamento padrão, ou seja, enviar o formulário, eu vou enviar por programação (fetch)
 
    let cliente=document.getElementById("txtCliente");
    let email=document.getElementById("txtEmail");
    let cellWpp=document.getElementById("txtCellWpp");
    let data=document.getElementById("txtData");
    let agencia=document.getElementById("txtAgencia");
    let horaInicio=document.getElementById("txtHoraInicio");
    //let horaFim=document.getElementById("txtHoraFim");
 
    let cadastrarMsg={
        //num_seq: "null",
        nome: cliente.value,
        email: email.value,
        celular: cellWpp.value,
        dataAgendamento: data.value,
        horaAgendamento: horaInicio.value,
        //observacao: "null",
        agencia: {id: agencia.value}
    }
 
    let cabecalho={
        method: 'POST',
        body: JSON.stringify(cadastrarMsg),
        headers:{
            'Content-type':'application/json' //padrão qndo é json
        }
    }
 
    //envia o pedido para o servidor 
    fetch('http://localhost:8080/agendamento/novo', cabecalho);
 
}