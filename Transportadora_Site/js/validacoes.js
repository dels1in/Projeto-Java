function checkFormPedido(dados){

    var pedidoId = dados.pedidoid.value;
    var clientId = dados.clientid.value;
    var cotacaoId = dados.cotacaoid.value;
    var dataPedido = dados.datapedidoname.value;
    var ordemVendaId = dados.ordemvendaid.value;
    var statusId = dados.statusid.value;
    var transpId = dados.transpid.value;

    if (pedidoId===null || pedidoId==="" || clientId===null || clientId==="" ||
    cotacaoId===null || cotacaoId==="" || dataPedido===null || dataPedido==="" ||
    dataPedido==="dd/mm/aaaa" || ordemVendaId===null || ordemVendaId==="" || 
    statusId===null || statusId==="0" ||transpId===null || transpId==="0"){
        return false;
    }
    else{
        return true;
    }
}

function checkFormCotacao(cotacao){
    var peso = cotacao.peso.value;
    var cep = cotacao.cep.value;
    var valido = cotacao.validade.value;

    if(peso===null || peso==="" || cep===null || 
    cep==="" || valido===null || valido==="" ||
    valido==="dd/mm/aaaa"){
        return false;
    }
    else{
        return true;
    }
}