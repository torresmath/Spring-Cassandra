# Spring-Cassandra
<br>
<h1>Sobre</h1>
Um simples CRUD utilizando Spring Data e Cassandra DB para fins de estudo. 
<br>
<br>
A proposta do Cassandra é ser um banco altamente disponível e tolerante a partições. Ao contrário dos bancos relacionais estruturados por tabelas, o Cassandra utiliza uma estrutura Colunar: os dados podem ser salvos em colunas sem relação direta umas com as outras. Ainda assim, podemos criar Famílias de Colunas, que são estruturas análogas às tabelas de SQL.
<br>
Essas diferenças conceituais entre SQL e NoSQL podem ser especialmente difíceis de se absorver para um desenvolvedor Java iniciando em bancos NoSQL, principalmente pelo fato de que não existem Relacionamentos entre tabelas/Column Families no Cassandra. Conceitos como JOINs, Many to Many, One To Many precisam ser desconstruídos e interpretados de forma não-relacional.
<br>
<br>
Como o Cassandra se compromete a ser um banco de consultas rápidas, todas as queries são feitas a partir de uma Chave primária. Não é possível <b><i> naturalmente </b></i> realizar consultas a partir de colunas que não componham uma Chave primária <b><i>(naturalmente, pois é possível configurar o banco para permitir consultas sem chave primária, apesar de não ser recomendado justamente por deturpar o propósito de consultas rápidas)</b></i>. Assim o principal ponto de atenção na modelagem de entidades com Cassandra em aplicações Java é que nossas classes devem representar consultas e não tabelas, afinal não teremos flexibilidade na construção de queries.
<br>
<br>
Na aplicação de exemplo, temos as entidades Movie e Actor. Além delas, criamos entidades para consultas como MovieByActor e MovieByGenre. Há um certo trabalho braçal nisso, pois para manter a coesão entre os dados de cada consulta precisamos garantir que ao registar ou deletar um filme, os dados sejam propagados para suas tabelas de consulta. Essa implementação pode ser vista na classe MovieRepositoryImpl.

<br>
<br>
<h1>Como rodar</h1>
<h2>Requisitos</h2>
<li>Java 11</li>
<li>Maven OU IntelliJ</li>
<li>Docker e Docker compose</li>
<br>
Basta dar um docker-compose up no terminal para subir os nodes do Cassandra.

<h1>Referências</h1>
<li>
  <a href="https://www.casadocodigo.com.br/products/livro-apache-cassandra?_pos=1&_sid=aa6fb17d4&_ss=r">Apache Cassandra - Escalabilidade horizontal para aplicações Java]</a></li>
<li>
  <a href="https://pt.wikipedia.org/wiki/Teorema_CAP">Teorema CAP</a>
</li>
<li>
  <a href="https://lankydan.dev/2017/11/26/more-complex-modelling-with-spring-data-cassandra">Projeto baseado nesse artigo</a>
</li>
<br>
