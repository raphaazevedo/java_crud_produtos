package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Produto;
import repositories.ProdutoRepository;

// camada de controle de interações
public class ProdutoController {

	public void cadastrarProduto() {

		try {

			System.out.println("\nCADASTRO DE PRODUTO\n");

			Produto produto = new Produto();
			Scanner scanner = new Scanner(System.in);

			System.out.println("\nInsira o nome do produto:");
			produto.setNome(scanner.nextLine());

			System.out.println("\nInsira a descricao do produto:");
			produto.setDescricao(scanner.nextLine());
			
			System.out.println("\nInsira o Preco:");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));
			
			System.out.println("\nInsira a quantidade:");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
			
			ProdutoRepository produtoRepository = new ProdutoRepository();
			produtoRepository.create(produto);

			System.out.println("/nPRODUTO DADASTRADO COM SUCESSO!!!/n");

			scanner.close();

		} catch (Exception e) {

			System.out.println("\nFalha em cadastrar produto\n" + e.getMessage());

		}

	}

	public void atualizarProduto() {
		// TODO
		
		try {
			
			System.out.println("\nAtualização do produto:");
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Id do produto: ");
			Integer id = Integer.parseInt(scanner.nextLine());
			
			ProdutoRepository produtoRepository = new ProdutoRepository();
			Produto produto = produtoRepository.findById(id);
			
			// verificar se foi encontrado
			if (produto != null) {
				
				System.out.println("Nome: ");
				produto.setNome(scanner.nextLine());
				System.out.println("Descrição: ");
				produto.setDescricao(scanner.nextLine());
				System.out.println("preço: ");
				produto.setPreco(Double.parseDouble(scanner.nextLine()));
				System.out.println("Quantidade: ");
				produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
				
				produtoRepository.update(produto);
				
				System.out.println("\nPRODUTO ALTERADO COM SUCESSO\n");
				
			} else {

				System.out.println("\nPRODUTO NÃO EXISTENTE\n");
			}
			
			scanner.close();
			
		} catch (Exception e) {
			System.out.println("\nFALHA AO AATUALIZAR PRODUTO: \n"+ e.getMessage());
		}
		
		
		
	}

	public void excluirProduto() {
		// TODO
		try {
			
			System.out.println("\nExcluir produto:");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Id do produto: ");
			Integer id = Integer.parseInt(scanner.nextLine());
			
			ProdutoRepository produtoRepository = new ProdutoRepository();
			Produto produto = produtoRepository.findById(id);
			
			// verificar se foi encontrado
			if (produto != null) {
				
				produtoRepository.delete(produto.getId());
				System.out.println("\nPRODUTO EXCLUIDO COM SUCESSO\n");
				
			} else {

				System.out.println("\nPRODUTO NÃO EXISTENTE\n");
			}
			
			scanner.close();
			
		} catch (Exception e) {

			System.out.println("\nFALHA EXCLUIR PRODUTO: \n"+ e.getMessage());
			
			
			
			
		}
		
		
	}

	public void consultarProdutos() {
		// TODO
		
		try {
			System.out.println("\nCONSULTA DE  PRODUTO: \n");
			
			ProdutoRepository produtoRepository = new ProdutoRepository();
			List<Produto> lista = produtoRepository.findAll();
			
			
			for(Produto produto : lista) {
				
				System.out.println("ID: "+ produto.getId());
				System.out.println("NOME: "+ produto.getNome());
				System.out.println("DESCRICAO: "+ produto.getDescricao());
				System.out.println("PRECO: "+ produto.getPreco());
				System.out.println("QUANTIDADE: "+ produto.getQuantidade());
				System.out.println(".......................................");
				
			}
			
			
			
			
		} catch (Exception e) {


			System.out.println("\nFALHA AO CONSULTAR PRODUTO: \n"+ e.getMessage());
		}
		
		
		
		
		
		
		
	}
}
