package principal;

import java.util.Scanner;

import controllers.ProdutoController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			Scanner scanner = new Scanner(System.in);

			System.out.println("\nControle de produtos:\n");
			System.out.println("\n(1) Cadastrar produto");
			System.out.println("\n(2) Atualizar produto");
			System.out.println("\n(3) Excluir produto");
			System.out.println("\n(4) Consultar produto");

			System.out.println("\nEscolha a opcao desejada: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			ProdutoController produtoController = new ProdutoController();

			switch (opcao) {
			case 1:
				produtoController.cadastrarProduto();
				break;

			case 2:
				produtoController.atualizarProduto();
				break;

			case 3:
				produtoController.excluirProduto();
				break;
			case 4:
				produtoController.consultarProdutos();
				break;

			default:
				System.out.println("\nOpcao Invalida");
				break;

				
			}
			

			scanner.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("\nOcorreu um erro: " + e.getMessage());

		}

	}

}
