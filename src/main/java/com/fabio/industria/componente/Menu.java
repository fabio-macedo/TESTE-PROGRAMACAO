package com.fabio.industria.componente;

import com.fabio.industria.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner {

    @Autowired
    private FuncionarioService service;

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                    
                    ##############  ESCOLHA UMA OPÇÃO  #################
                    0 - Remover funcionário João                
                    1 - Exibir todos
                    2 - Mostrar funcionários com o aumento de 10%
                    3 - Agrupar por Função
                    4 - Aniversário nos meses 10 e 12 
                    5 - Funcionário mais velho
                    6 - Funcionários por ordem alfabética
                    7 - Total de Funcionários
                    8 - Salários mínimos por funcionário
                    9 - sair
                    
                    """);

           opcao = sc.nextInt();

           switch (opcao){
               case 0 -> service.removeJoao();
               case 1 -> service.exibirTodos();
               case 2 -> service.mostrarAumento();
               case 3 -> service.agruparPorfuncao();
               case 4 -> service.mesAniversario();
               case 5 -> service.maiorIdade();
               case 6 -> service.ordemAlfabetica();
               case 7 -> service.totalFuncionarios();
               case 8 -> service.qtdSalarios();
               case 9 ->{
                   System.out.println("Saindo...");
                   break;
               }
           }

        } while (opcao != 9);

    }
}
