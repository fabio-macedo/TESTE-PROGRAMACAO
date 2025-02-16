# TESTE-DE-PROGRAMACAO

## Teste de programação usando JAVA e SPRING, com banco de dados MySQL. 
Neste projeto faço uso além das tecnologias seguintes tecnologias: <br>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"/>
 <br>
 Faço uso ainda do flyway para melhor controle do banco de dados.

## O que foi pedido

Considerando que uma indústria possui as pessoas/funcionários abaixo: Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:<br>
1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate). <br>
2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String). <br>
3 – Deve conter uma classe Principal para executar as seguintes ações: OK (INSERIDOS POR MIGRATIONS) 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.<br>
3.2 – Remover o funcionário “João” da lista.<br>
3.3 – Imprimir todos os funcionários com todas suas informações, sendo que: <br>
  • informação de data deve ser exibido no formato dd/mm/aaaa; <br>
  • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula. <br>
3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor. <br>
3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”. <br>
3.6 – Imprimir os funcionários, agrupados por função. <br>
3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12. <br>
3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade. <br>
3.10 – Imprimir a lista de funcionários por ordem alfabética. <br>
3.11 – Imprimir o total dos salários dos funcionários.<br>
3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00<br>
<br>
O banco de dados foi povoado conforme a tabela abaixo repassada.<br>
![image](https://github.com/user-attachments/assets/05316b2f-75ec-4d34-8809-32ec80c89e88)
<br>
<br>
### OBS: não foi exigido, mas fiz uso do SpringBoot, bem como criei uma tela de menu para facilitar a interação com o usuário, a fim de que fique claro o que exatamente está sendo feito no programa. Visto também que não é uma API não há controllers nem o uso de clientes HTTP.
 <br> <br>

 ### INSTRUÇÕES
Para testar o projeto basta apenas ter instalado alguma ferramenta de sua preferência para abrir o projeto ( NetBeans, Eclipse, IntelliJ ), ter tambem instalado o banco de dados MySQL e configurar seu acesso (usuário e senha) no "application.properties", este criará o banco caso ele não exista. <br>
As migrations existentes se encarregam de fazer o mapeamento da tabela necessária para o banco bem como povoá-lo.  <br>
Em seguida é só iniciar o projeto e interagir
