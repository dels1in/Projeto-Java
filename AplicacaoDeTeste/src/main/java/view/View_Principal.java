package view;

import java.util.Scanner;

import controller.Controller;

public class View_Principal {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int opc, opc2, x=1;
		
		while(x != 0) {
		Controller.getInstance().menuModels();
		opc = scn.nextInt();
		switch(opc) {
			case 1:
				// COTACAO
				Controller.getInstance().menuCotacao();
				opc2 = scn.nextInt();
				Controller.getInstance().getCotacao(opc2);
				break;
			case 2:
				// STATUS
				Controller.getInstance().menuStatus();
				opc2 = scn.nextInt();
				Controller.getInstance().getStatus(opc2);
				break;
			case 3:
				// PEDIDO
				Controller.getInstance().menuPedido();
				opc2 = scn.nextInt();
				Controller.getInstance().getPedido(opc2);
				break;
			case 4:
				// RANGE
				Controller.getInstance().menuRange();
				opc2 = scn.nextInt();
				Controller.getInstance().getRange(opc2);
				break;
			case 5:
				// TRANSP
				Controller.getInstance().menuTransp();
				opc2 = scn.nextInt();
				Controller.getInstance().getTransp(opc2);
				break;
			case 0:
				x = 0;
				break;
			// Break da OPC 1
			default:
				System.out.println("Digite um numero valido!\n");
				break;
		}
		}
		
		
		scn.close();
	}
}
