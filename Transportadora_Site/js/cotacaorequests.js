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

var urlCotacao;

// GET DA COTAÇÃO
client.get("http://localhost:9000/service/cotacao/", function(response){
  data = JSON.parse(response);
  document.getElementById("cotacoesTable").innerHTML = ` ${data.map(tabelaCotacoes).join('')} `;
});


// CRIAÇÃO DA TABELA COTAÇÃO
function tabelaCotacoes(data){
  let date = formatDate(data.valido);
    return `
      <tr>
        <td>${data.cotacaoId}</td>
        <td>${data.peso}</td>
        <td>${data.cep}</td>
        <td>${data.valor}</td>
        <td>${date}</td>
      </tr>
    `;
}

/*
// Alteração de tela
function alteracotacao(cotacaoId){
  document.location.href = "alterarcotacao.html";
  urlCotacao = 'http://localhost:9000/service/cotacao/' + cotacaoId;
  sessionStorage.setItem("urlAlteracao", urlCotacao);
}


// ALTERAÇÃO DA COTAÇÃO
function alteraFormCotacao(data){
  let date = formatDate(data.valido);

  return `
    <div>
      <label for="peso">PESO:
          <input type="text" id="peso" name="pesoid" value="${data.peso}">
      </label><br>
    </div>
    <div>
      <label for="cep">CEP:
        <input type="text" id="cep" name="cepid" value="${data.cep}">
      </label><br>
    </div>
    <div>
      <label for="validade">VALIDADE
        <input type="date" id="validade" name="validadeid" value="${date}">
      </label><br>
    </div>
    
  `;
}

urlCotacao = sessionStorage.getItem("urlAlteracao");

// GET DA COTAÇÃO PARA ALTERAÇÃO
client.get(urlCotacao, function(response){
  data = JSON.parse(response);
  document.getElementById("half-form").innerHTML = ` ${data.map(alteraFormCotacao).join('')} `;
})
*/


// POST DA COTAÇÃO
function getFormElementsCotacao(){
    
  let formData = document.forms.formulario;
  if(checkFormCotacao(formData)===false){
    alert("Preencha todas as informações");
  }
  else{
    let cotacao = {
      peso : formData.peso.value,
      cep : formData.cep.value,
      valido : formData.validade.value
    }
      
    var HttpRequest = new XMLHttpRequest();
    HttpRequest.open("POST", "http://localhost:9000/service/cotacao")
    HttpRequest.setRequestHeader("Content-Type", "application/json");
    HttpRequest.send(JSON.stringify(cotacao));
      
    alert("Cotacao cadastrada");
    }
}