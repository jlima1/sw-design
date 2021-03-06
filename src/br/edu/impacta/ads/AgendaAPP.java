package br.edu.impacta.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class AgendaAPP {
	private static Scanner entrada = new Scanner(System.in);
	private static List<Contato> contatos = new ArrayList<>();

	public static void main(String[] args) {
		boolean sair = false;
		while (!sair) {
			int opcao = apresentarMenuPrincipal();
			switch (opcao) {
			case 1:
				inserirContato();
				break;
			case 2:
				buscarContato();
				break;
			case 3:
				sair = true;
				break;
			default:
				out.println("ERRO: opcao invalida!");

			}
		}
		out.println("nfim do programa!");
	}

	private static int apresentarMenuPrincipal() {
		boolean inteiro = false;
		int opcao = 0;
		while (!inteiro) {
			out.println("\nAGENDA TELEFONICA!");
			out.println("(1) Inserir");
			out.println("(2) Buscar");
			out.println("(3) Sair");
			out.print("Escolha uma opcao: ");
			String s = entrada.nextLine();
			try {
				opcao = Integer.parseInt(s);
				inteiro = true;
			} catch (Exception e) {
				out.println("Erro: op��o deve ser um valor inteiro!");
			}

		}
		return opcao;
	}

	private static void inserirContato() {
		out.println("\nInser��o de novo contato:");
		String nome = lerNome();
		String telefone = lerTelefone();
		Contato c = new Contato(nome, telefone);
		if (contatos.contains(c)) {
			out.println("Este contato j� esta cadastrado!");
		} else {
			contatos.add(c);
			out.println("Contato Ibnserido!");

		}
	}

	private static String lerNome() {
		boolean valido = false;
		String nome = "";
		while (!valido) {
			out.print("Nome: ");
			nome = entrada.nextLine();
			if (nome.length() == 0 || nome.length() > 200) {
				out.println("Erro: Nome de tamanho invalido!");
			} else {
				valido = true;
			}
		}
		return nome;

	}

	private static String lerTelefone() {
		boolean valido = false;
		String telefone = "";
		while (!valido) {
			out.print("Telefone: ");
			telefone = entrada.nextLine();
			if (telefone.length() == 0 || telefone.length() > 25) {
				out.println("Erro: telefone de tamanho invalido!");
			} else {
				valido = true;
			}
		}
		return telefone;
	}

	private static void buscarContato() {
		out.println("\nBusca de  contato:");
		String nome = lerNome();
		List<Contato> resultado = new ArrayList<>();
		for (Contato c : contatos) {
			if (nome.equals(c.getNome())) {
				resultado.add(c);

			}
		}

		if (resultado.size() == 0) {
			out.println("N�o h� contato com este nome!");
		} else {

			out.println("\nResultado da Buisca:");
			for (Contato c : resultado) {
				out.println(c);
			}
		}
	}

}