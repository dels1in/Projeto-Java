package controller;

import model.Cotacao;
import model.ListStatus;
import model.Pedido;
import model.PrecoRange;
import model.Transportadora;
import util.HttpRequestUtil;

public class Controller {
	private static Controller controller;
	
	private Controller() {
		
	}
	
	// Instancia para pegar os controles
	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	
	/* Models */
	private Cotacao cotacao;
	private ListStatus status;
	private Pedido pedido;
	private PrecoRange range;
	private Transportadora transp;
	
	/* Util */
	private HttpRequestUtil httpReq;
	
	
	/* Menus */
	
	public void menuModels() {
		System.out.println("Escolha qual model deseja fazer a operacao: \n"
				+ "1- Cotacao\n"
				+ "2- List Status\n"
				+ "3- Pedido\n"
				+ "4- Preco Range\n"
				+ "5- Transportadora\n");
	}
	
	public void menuCotacao() {
		limpaTela();
		System.out.println("Escolha a operacao a ser realizada com a 'COTACAO': \n"
				+ "1- GET All\n"
				+ "2- POST");
	}
	
	public void menuStatus() {
		limpaTela();
		System.out.println("Escolha a operacao a ser realizada com o 'STATUS': \n"
				+ "1- GET All\n"
				+ "2- POST");
	}
	
	public void menuPedido() {
		limpaTela();
		System.out.println("Escolha a operacao a ser realizada com o 'PEDIDO': \n"
				+ "1- GET All\n"
				+ "2- GET Por ID\n"
				+ "3- POST");
	}
	
	public void menuRange() {
		limpaTela();
		System.out.println("Escolha a operacao a ser realizada com o 'RANGE': \n"
				+ "1- GET All\n"
				+ "2- GET por CEP\n"
				+ "3- POST");
	}
	
	public void menuTransp() {
		limpaTela();
		System.out.println("Escolha a operacao a ser realizada com a 'TRANSPORTADORA': \n"
				+ "1- GET All\n"
				+ "2- POST");
	}
	
	public void limpaTela() {
		int x = 0;
		while(x < 50) {
			System.out.println("");
			x++;
		}
	}
	
	
	/* Get dos menus */
	public void getCotacao(int opc) {
		httpReq = new HttpRequestUtil();
		
		// GET ALL
		if(opc == 1) {
			httpReq.getRequest("http://localhost:9000/service/cotacao/");
		// POST	
		}else if(opc == 2) {
			cotacao = new Cotacao();
			cotacao.setCep(80000000 + randomNumber());
			cotacao.setPeso(randomNumber());
			cotacao.setValido("2019-06-05");
			
			httpReq.postRequest(cotacao, "http://localhost:9000/service/cotacao/");
			
		}else {
			System.out.println("Escolha uma opcao valida!");
		}
	}
	
	public void getStatus(int opc) {
		httpReq = new HttpRequestUtil();
		
		//GET ALL
		if(opc == 1) {
			httpReq.getRequest("http://localhost:8000/services/status");
		//POST
		}else if(opc == 2) {
			status = new ListStatus();
			status.setSituacao("Situacao TESTE");
			
			httpReq.postRequest(status, "http://localhost:8000/services/status");
		}else {
			System.out.println("Escolha uma opcao valida!");
		}
	}
	
	public void getPedido(int opc) {
		httpReq = new HttpRequestUtil();
		
		// GET ALL
		if(opc == 1) {
			httpReq.getRequest("http://localhost:8000/services/pedidostatus");
		// GET BY ID
		}else if(opc == 2) {
			httpReq.getRequest("http://localhost:8000/services/pedidostatus/"+(randomNumber()%3+1));
		// POST
		}else if(opc == 3) {
			pedido = new Pedido();
			pedido.setClientId(randomNumber());
			pedido.setCotacaoId(1);
			pedido.setDataPedido("2019-06-05");
			pedido.setListStatus(new ListStatus(1));
			pedido.setOrdemVendaId(randomNumber());
			pedido.setPedidoId(randomNumber());
			pedido.setTransp(new Transportadora(1));
			
			httpReq.postRequest(pedido, "http://localhost:8000/services/pedido");
		}else {
			System.out.println("Escolha uma opcao valida!");
		}
	}
	
	public void getRange(int opc) {
		httpReq = new HttpRequestUtil();
		
		//GET ALL
		if(opc == 1) {
			httpReq.getRequest("http://localhost:9000/service/range");
		// GET BY CEP
		}else if(opc == 2) {
			httpReq.getRequest("http://localhost:9000/service/rangecep/"+(80000000+randomNumber()));
		//POST
		}else if(opc == 3) {
			range = new PrecoRange();
			range.setCepMin((80000000+randomNumber()));
			range.setCepMax((80000000+randomNumber()));
			range.setPesoMax(randomNumber());
			range.setPesoMin(randomNumber());
			range.setValor(randomNumber());
			
			httpReq.postRequest(range, "http://localhost:9000/service/range");
		}else {
			System.out.println("Escolha uma opcao valida!");
		}
	}
	
	public void getTransp(int opc) {
		httpReq = new HttpRequestUtil();
		
		//GET ALL
		if(opc == 1) {
			httpReq.getRequest("http://localhost:8000/services/transportadora");
		//POST
		}else if(opc == 2) {
			transp = new Transportadora();
			transp.setTranspNome("Transportadora Teste");
			
			httpReq.postRequest(transp, "http://localhost:8000/services/transportadora");
		}else {
			System.out.println("Escolha uma opcao valida!");
		}
	}
	
	public int randomNumber() {
		int number;
		
		number = (int) (Math.random() * ((2999 - 1) + 1)+ 1);
		
		return number;
	}

}
