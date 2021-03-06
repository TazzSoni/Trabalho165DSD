/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.CriaConexao;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int opcao = 0;
        String dados = "";

        CriaConexao conexao = new CriaConexao();

        while (opcao != 2) {
            System.out.println("Bem vindo ao Sistema de cadastro de Funcionários.");
            System.out.println("Cadastre os setores desejados:");

            System.out.println("1. Para cadastrar;");
            System.out.println("2. Para sair;");

            Scanner ler = new Scanner(System.in);
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    dados = "insertsetor";
                    ler.nextLine();
                    System.out.println("Digite nome do setor:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Digite o número da equipe do setor:");
                    dados += ";" + ler.nextLine();
                    conexao.criaConexao(dados);
                    break;
            }

        }
        while (opcao != 11) {
            System.out.println("");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir um Registro de funcionário;");
            System.out.println("2. Atualizar um Registro de funcionário;");
            System.out.println("3. Deletar um Registro de funcionário;");
            System.out.println("4. Buscar um Registro de funcionário;");
            System.out.println("5. Listar todos os Registro de funcionário;");
            System.out.println("6. Inserir um Registro de setor;");
            System.out.println("7. Atualizar um Registro de setor;");
            System.out.println("8. Deletar um Registro de setor;");
            System.out.println("9. Buscar um Registro de setor;");
            System.out.println("10. Listar todos os Registro de setor;");
            System.out.println("11. Sair;");

            Scanner ler = new Scanner(System.in);
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    dados = "insertpessoa";
                    //Parei aqui
                    ler.nextLine();
                    System.out.println("Digite o CPF do funcionario:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Digite o nome do funcionario:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Digite o endereço do funcionario:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Para CLT digite 1, ou temporário digite 2:");
                    opcao = ler.nextInt();
                    if (opcao == 1) {
                        dados += ";clt";
                        ler.nextLine();
                        System.out.println("Digite o mês e ano de contratação (formato MMAAAA):");
                        dados += ";" + ler.nextLine();
                        System.out.println("Digite a função");
                        dados += ";" + ler.nextLine();
                    } else {
                        dados += ";temporario";
                        ler.nextLine();
                        System.out.println("Digite o tempo do contrato (Formato MM):");
                        dados += ";" + ler.nextLine();
                        System.out.println("Digite a função");
                        dados += ";" + ler.nextLine();
                    }
                    System.out.println("Defina um setor:");
                    conexao.criaConexao("listsetor");
                    System.out.println("");
                    dados += ";" + ler.nextLine();
                    break;
                case 2:
                    dados = "updatepessoa";
                    ler.nextLine();
                    System.out.println("Digite o CPF do funcionario:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Digite o nome do funcionario:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Digite o endereço do funcionario:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Para CLT digite 1, ou temporário digite 2:");
                    opcao = ler.nextInt();
                    if (opcao == 1) {
                        dados += ";clt";
                        ler.nextLine();
                        System.out.println("Digite o mês e ano de contratação (formato MMAAAA):");
                        dados += ";" + ler.nextLine();
                        System.out.println("Digite a função");
                        dados += ";" + ler.nextLine();
                    } else {
                        dados += ";temporario";
                        ler.nextLine();
                        System.out.println("Digite o tempo do contrato (Formato MM):");
                        dados += ";" + ler.nextLine();
                        System.out.println("Digite a função");
                        dados += ";" + ler.nextLine();
                    }
                    System.out.println("Defina um setor:");
                    conexao.criaConexao("listsetor");
                    System.out.println("");
                    dados += ";" + ler.nextLine();
                    break;
                case 3:
                    dados = "deletepessoa";
                    ler.nextLine();
                    System.out.println("Digite o CPF do funcionario:");
                    dados += ";" + ler.nextLine();
                    break;
                case 4:
                    dados = "getpessoa";
                    ler.nextLine();
                    System.out.println("Digite o CPF do funcionario:");
                    dados += ";" + ler.nextLine();
                    break;
                case 5:
                    dados = "listpessoa";
                    break;
                case 6:
                    dados = "insertsetor";
                    ler.nextLine();
                    System.out.println("Digite nome do setor:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Digite o número da equipe do setor:");
                    dados += ";" + ler.nextLine();
                    break;
                case 7:
                    dados = "updatesetor";
                    ler.nextLine();
                    System.out.println("Digite nome do setor:");
                    dados += ";" + ler.nextLine();
                    System.out.println("Digite o número da equipe do setor:");
                    dados += ";" + ler.nextLine();
                    break;
                case 8:
                    dados = "deletesetor";
                    ler.nextLine();
                    System.out.println("Digite nome do setor:");
                    dados += ";" + ler.nextLine();
                    break;
                case 9:
                    dados = "getsetor";
                    ler.nextLine();
                    System.out.println("Digite nome do setor:");
                    dados += ";" + ler.nextLine();
                    break;
                case 10:
                    dados = "listsetor";
                    break;
                    
            }

            conexao.criaConexao(dados);

            //insert;00783962042;LacoSouzaTassoni;Rua arbt Wagner;clt;mecânica;123456;032021;mecânico
            //insert;00783962045;RodrigoSouzaTassoni;Rua Adolfo Wagner;temporario;mecânica;123456;03;mecânico
        }
        System.out.println("");
        System.out.println("Obrigado por usar nosso sistema!!!");
    }
}
