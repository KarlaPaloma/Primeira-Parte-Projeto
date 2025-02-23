package negocio;


import java.util.Scanner;

import dados.RepositorioPessoasList;


public class TestaAluno1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		RepositorioPessoas rep = new RepositorioPessoasList();		
		int opcao = 0;

		do {
			System.out.println("MENU PRINCIPAL - Digite a op��o desejada: \n");
			System.out.println("         =============================");
			System.out.println("         |     1 - Inserir ALUNO      |");
			System.out.println("         |     2 - Inserir PROFESSOR  |");
			System.out.println("         |     3 - Procurar           |");
			System.out.println("         |     4 - Remover            |");		
			System.out.println("         |     0 - Sair               |");
			System.out.println("         =============================\n");
			opcao = input.nextInt();
			
			switch (opcao) {
			
			case 1:
				System.out.println("Insira um nome: \n");			
				String nome = input.next();	
				System.out.println("Insira um sobrenome: \n");			
				String sobrenome = input.next();	
				System.out.println("Insira um cpf: \n");
				String cpf = input.next();	
				System.out.println("Insira uma idade: \n");			
				int idade = input.nextInt();
				System.out.println("Deve inserir um Curso!");
				System.out.println("Digite o c�digo do Curso: \n");
				String codigo = input.next();				
				System.out.println("Digite o nome do Curso: \n");
				String nomeCurso = input.next();
				Curso curso1 = new Curso(codigo, nomeCurso);				
				Aluno aluno = new Aluno();	
				aluno.setNome(nome);
				aluno.setSobrenome(sobrenome);
				aluno.setCpf(cpf);
				aluno.setIdade(idade);
				aluno.setCurso(curso1);
				rep.inserir(aluno);
				System.out.println("######Lista atual de pessoas: "+((RepositorioPessoasList) rep).listarPessoas());
				break;
			
			case 2:
				System.out.println("Insira um nome: \n");			
				String nomeProf = input.next();	
				System.out.println("Insira um cpf: \n");
				String cpfProf = input.next();				
				System.out.println("Insira uma idade: \n");				
				int idadeProf = input.nextInt();				
				System.out.println("Deve inserir um Sal�rio!");
				System.out.println("Digite o valor do Sal�rio: \n");
				int salarioProf = input.nextInt();	
				Professor professor = new Professor();
				professor.setNome(nomeProf);
				professor.setCpf(cpfProf);
				professor.setIdade(idadeProf);
				professor.setSalario(salarioProf);	
				rep.inserir(professor);
				System.out.println("######Lista atual de pessoas: "+((RepositorioPessoasList) rep).listarPessoas());
				break;
			
			case 3:
				System.out.println("Digite o cpf que deseja PROCURAR: \n");				
				String cpfProcura = input.next();
				Pessoa p = rep.procurar(cpfProcura);
				if(p != null) {
					System.out.println("CPF encontrado!");
					System.out.println(p.toString());
				} else {
					System.out.println("CPF n�o encontrado!");
				}
				break;
			
			case 4:
				System.out.println("######Lista atual de pessoas: "+((RepositorioPessoasList) rep).listarPessoas());
				System.out.println("Digite o cpf que deseja REMOVER: \n");								
				String procuradoRemover = input.next();				
				try {
					rep.remover(procuradoRemover);
					System.out.println("CPF removido: "+procuradoRemover);
					System.out.println("###### Lista atual de pessoas: "+((RepositorioPessoasList) rep).listarPessoas());
					System.out.println("-- FIM --");
					break;
				} catch (RemoveException e) {
					System.out.println("Falha ao remover!");
					break;
				}
			case 0:
				System.out.println("Encerrando. Obrigada por utilizar o sistema! ");
				break;
			
			default:
				
				System.out.println("Op��o Inv�lida!");
				break;
			}			
		} while (opcao != 0);
		input.close();
	}
}
