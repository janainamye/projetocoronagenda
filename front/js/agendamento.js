function cadastrar(event) {
    event.preventDefault(); //não faça o comportamento padrão, ou seja, enviar o formulário, eu vou enviar por programação (fetch)
 
    let cliente=document.getElementById("txtCliente");
    let email=document.getElementById("txtEmail");
    let cellWpp=document.getElementById("txtCellWpp");
    let data=document.getElementById("txtData");
    let agencia=document.getElementById("sel_agencias");
    let horaInicio=document.getElementById("txtHoraInicio");
    //let horaFim=document.getElementById("txtHoraFim");

    let d = new Date(data.value);
    let novadata = d.getDate() + "/0" + (d.getMonth() + 1) + "/" + d.getFullYear();
    console.log(d, novadata);
 
    let cadastrarMsg={
        //num_seq: "null",
        nome: cliente.value,
        email: email.value,
        celular: cellWpp.value,
        dataAgendamento: novadata,
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
    fetch('http://localhost:8080/agendamento/novo', cabecalho)
    .then(res => tratarResposta(res)); //arrow function chamando a funcao tratarResposta
 
}
function tratarResposta(res) {
    if (res.status == 200) {
        alert("Cadastro OK!")
    } else {
        alert("Algo deu errado!");
    }
}
 
function obterAgencias() {
    fetch("http://localhost:8080/agencias")
        .then(res => res.json())
        .then(res => preencheAgencias(res));
}
 
function preencheAgencias(res) {
    let agencias = '';
 
    agencias = `<option hidden > Escolha uma opção</option>`;
    for (let index = 0; index < res.length; index++) {
        agencias = agencias + `<option value = ${res[index].id}> ${res[index].nome} </option>`;
    }
    document.getElementById("sel_agencias").innerHTML = agencias;
}