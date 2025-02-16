package com.fabio.industria.Service;

import com.fabio.industria.Model.Funcionario;
import com.fabio.industria.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private FuncionarioRepository repository;

    public void removeJoao(){
        String remocao = "João";
        System.out.println("Iniciando...");

        Funcionario funcionario = repository.findByNome(remocao);

        System.out.printf("Deseja remover o funcionario %s, id %d ? ( S/N )", funcionario.getNome(), funcionario.getId());

        char teste = new Scanner(System.in).nextLine().charAt(0);

        if(teste == 'S' || teste == 's'){
            System.out.println("Removendo o " + funcionario.getNome());
            repository.deleteById(funcionario.getId());
        }else {
            System.out.println("Não excluído");
            return;
        }
       // repository.deleteByNome("João");
    }

    public void exibirTodos(){
        List<Funcionario> funcionarios = repository.findAll();
        for (Funcionario funcionario : funcionarios){
            System.out.println(funcionario);
        }
    }

    public void mostrarAumento() {
        List<Funcionario> funcionarios = repository.findAll();

        for (Funcionario x : funcionarios) {
            BigDecimal salario = x.getSalario();
            BigDecimal aumento = salario.multiply(new BigDecimal("1.10"));
            System.out.printf("""
                        Nome: %s
                        Salário antigo: %.2f
                        Salário com aumento: %.2f
                        
                    """, x.getNome(), x.getSalario(), aumento);  // Exibir com formato
        }
    }

   public void agruparPorfuncao(){
        List<Funcionario> funcionarios = repository.findAll();

        Map<String, List<Funcionario>> agrupadosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        for(Map.Entry<String, List<Funcionario>> x : agrupadosPorFuncao.entrySet()){
            System.out.println("Função: " + x.getKey());
            x.getValue().forEach(funcionario -> {
                System.out.printf("Nome: %s \nSalário: %.2f\n\n",
                        funcionario.getNome(), funcionario.getSalario());
            });
            System.out.println("##################################");
        }
   }

   public void mesAniversario(){
        //Funcionários com aniversário nos meses 10 e 12
       List<Integer> meses = Arrays.asList(10, 12);

       List<Funcionario> funcionarios = repository.findByMesNascimento(meses);

       funcionarios.forEach(f -> System.out.println(
              "Nome: " + f.getNome() + "\nData de Nascimento:" + f.getDataNascimento().format(formatter)
               + "\n----------------------------------"
       ));
   }

   public void maiorIdade(){
        // funcionário com a maior idade

       List<Funcionario> funcionarios = repository.findAll();

       Funcionario maiorIdade = funcionarios.stream()
               .min(Comparator.comparing(Funcionario::getDataNascimento)).orElse(null);

       if(maiorIdade != null) {
           System.out.println( String.format("""
                   Funcionário mais velho: %s
                   Data de nascimento: %s
                   """, maiorIdade.getNome(), maiorIdade.getDataNascimento().format(formatter)));

       }else {
           System.out.println("Nenhum funcionário encontrado...");
       }

   }

   public void ordemAlfabetica(){
        List<Funcionario> funcionarios = repository.findAll(Sort.by(Sort.Order.asc("nome")));
        for (Funcionario x : funcionarios){
            System.out.println(x);
        }
   }

   public void totalFuncionarios(){
        long qtd = repository.count();
       System.out.println("Total de Funcionários: " + qtd);
   }

   public void qtdSalarios(){
        //qtd de salarios minimos a R$ 1212.00
       double salarioMinimo = 1212.00;

       List<Funcionario> funcionarios = repository.findAll();

       for(Funcionario x : funcionarios){
           double salario = x.getSalario().doubleValue();
           double qtdSalarios = salario/salarioMinimo;

           System.out.println(String.format("""
                   Nome: %s
                   Quantidade de salários mínimos: %.2f
                   """, x.getNome(), qtdSalarios));
       }
   }
}
