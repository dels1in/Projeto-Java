/* Função para gerar o Request */
let HttpClient = function() {
    this.get = function(url, callback) {
        var HttpRequest = new XMLHttpRequest();
        HttpRequest.onreadystatechange = function() { 
            if (HttpRequest.readyState == 4 && HttpRequest.status == 200)
            callback(HttpRequest.responseText);
        }
        HttpRequest.open( "GET", url, true ); 
        HttpRequest.send( null ); 
  }
}

/* Criação do client para fazer o request da API */
  
let client = new HttpClient();

let data;

var pedidoUrl;
var historicoUrl;

/* Pegando o URL passando e usando a função de get
  armazenando (JSON) dentro de uma variavel */
client.get('http://localhost:8000/services/pedidostatus', function(response){
    data = JSON.parse(response);
    document.getElementById("pedidosTable").innerHTML = `
      ${data.map(TabelaPedidos).join('')}
    `
});


/* Função para gerar a tabela com o JSON */
function TabelaPedidos(data){
    const date = formatDate(data.dataPedido);
    return `
        <tr>
            <td>${data.pedidoId}</td>
            <td>${data.statusId.situacao}</td>
            <td>${date}</td>
            <td>${data.cotacaoId}</td>
            <td><button onclick="alterarButton(${data.pedidoId})">Alterar</button></td>
            <td><button onclick="historicoButton(${data.pedidoId})">Histórico</button></td>
        </tr>
    `;
}

// histórico do pedido
function historicoButton(pedidoId){
    document.location.href = "historicopedido.html";
    historicoUrl = 'http://localhost:8000/services/pedido/' + pedidoId;
    sessionStorage.setItem("urlHistorico", historicoUrl);
}



// ALTERAÇÃO DE TELA
function alterarButton(pedidoId){
    document.location.href = "alterarPedido.html";
    pedidoUrl = 'http://localhost:8000/services/pedidostatus/' + pedidoId;
    sessionStorage.setItem("urlAlteracao", pedidoUrl);
}


// Gerador do formulário do pedido
function alteraFormPedido(data){
    document.getElementById("status").selectedIndex = data.statusId.statusId;
    //document.getElementById("transp").selectedIndex = data.transp.transpId;
  
    let date = formatDate(data.dataPedido);
  
    return `
    <div>
        <label for="pedido">Pedido ID:
            <input type="text" id="pedido" name="pedidoid" value="${data.pedidoId}" disabled>
        </label><br>
    </div>
    <div>
        <label for="client">Cliente ID:
            <input type="text" id="client" name="clientid" value="${data.clientId}" disabled>
        </label><br>
    </div>
    <div>
        <label for="cotacao">Cotação ID
            <input type="text" id="cotacao" name="cotacaoid" value="${data.cotacaoId}" disabled>
        </label><br>
    </div>
    <div>
        <label for="data-pedido">Data do Pedido
            <input type="date" id="data-pedido" name="datapedidoname" value="${date}" disabled>
        </label><br>
    </div>
    <div>
        <label for="ordem-venda">Ordem de Venda ID
                <input type="text" id="ordem-venda" name="ordemvendaid" value="${data.ordemVendaId}" disabled>
        </label><br>
    </div>
    <div>
    </div>
    `;
}
  
pedidoUrl = sessionStorage.getItem("urlAlteracao");
  
// GET PEDIDO BY LAST STATUS
client.get(pedidoUrl, function(response){
    data = JSON.parse(response);
    document.getElementById("half-form").innerHTML = ` ${data.map(alteraFormPedido).join('')} `;
})
  
  

// GET HISTORICO

historicoUrl = sessionStorage.getItem("urlHistorico");

client.get(historicoUrl, function(response){
    data = JSON.parse(response);
    document.getElementById("historicoTable").innerHTML = `
      ${data.map(tabelaHistorico).join('')}
    `
});

// Table histórico
function tabelaHistorico(data){
    const date = formatDate(data.dataPedido);
    return `
        <tr>
            <td>${data.pedidoId}</td>
            <td>${data.statusId.situacao}</td>
            <td>${date}</td>
            <td>${data.cotacaoId}</td>
        </tr>
    `;
}

// Função para pegar os dados do form e mandar pra API cadastrar -- PEDIDO
function getFormElementsPedido(){
    
    let formData = document.forms.formulario;
    
    if (checkFormPedido(formData)===false){
        alert("Preencha todos os dados");
    }
    else{
        let pedido = {
        pedidoId : formData.pedidoid.value,
        clientId : formData.clientid.value,
        cotacaoId : formData.cotacaoid.value,
        dataPedido : formData.datapedidoname.value,
        ordemVendaId : formData.ordemvendaid.value,
        statusId : {
            statusId : formData.statusid.value
        },
        transp : {
            transpId : formData.transpid.value
        }
        }
        var HttpRequest = new XMLHttpRequest();
        HttpRequest.open("POST", "http://localhost:8000/services/pedido")
        HttpRequest.setRequestHeader("Content-Type", "application/json");
        HttpRequest.send(JSON.stringify(pedido));
        
        alert("Pedido cadastrado");
    }
}


function getAlteracaoForm(){
    
    let formData = document.forms.formulario;
  
    let pedido = {
      pedidoId : formData.pedidoid.value,
      clientId : formData.clientid.value,
      cotacaoId : formData.cotacaoid.value,
      dataPedido : formData.datapedidoname.value,
      ordemVendaId : formData.ordemvendaid.value,
      statusId : {
        statusId : formData.statusid.value
      },
      transp : {
        transpId : 1
      }
    }
  
    alert(JSON.stringify(pedido));
  
    var HttpRequest = new XMLHttpRequest();
    HttpRequest.open("POST", "http://localhost:8000/services/pedido")
    HttpRequest.setRequestHeader("Content-Type", "application/json");
    HttpRequest.send(JSON.stringify(pedido));
}