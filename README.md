# Solução MapLink Code Challenge

## Passos para rodar o programa

### Clonagem do repositório 

1) Instalar o git e maven previamente. Os passos para instalação de ambos estão além do escopo deste manual.
2) Executar o comando: <code>git clone https://github.com/Hromenique/maplinkcodechallenge.git</code> 
3) Após isso o diretório <b>maplinkcodechallenge</b> (repositório local) será criado.
4) Após a criação do repositório local. Existem duas maneiras de rodar o projeto/programa: 
* Pelo maven plugin  <b>spring-boot</b>
* Gerando um jar (fat jar) atráves do maven

### Rodar o projeto pelo plugin spring-boot

1) Navegar até o diretório recém criado maplinkcodechallenge
2) Executar o plugin <b>spring-boot</b>  com a  goal <b>run</b>, atráves do comando: <code>mvn spring-boot:run</code>

### Rodar o projeto através de um jar(fat jar)

1) Navegar até o diretório recém criado maplinkcodechallenge
2) Executar a fase de <b>package</b>, através do comando: <code>mvn package</code>
3) Ainda dentro do diretório maplinkcodechallenge. Navegue até o diretório <b>target</b>
4. Dentro deste diretório, existirá o jar recém criado: <b>maplinkcodechallenge-0.0.1-SNAPSHOT.jar</b>
5. Executar o comando: <code>java -jar maplinkcodechallenge-0.0.1-SNAPSHOT</code>

### Interação com o programa 

O programa (API) estará acessível através do endereço: <code>\<HOST\>:8080/\<OPERACAO\></code>. Onde <b>\<HOST\></b> 
é o ip da máquina onde está rodando o programa. Por exemplo:
<code>http://localhost:8080/location?q=mood%20frabrics</code>.
Neste caso, o teste está sendo feito na mesma máquina (localhost) onde o programa encontra-se rodado.

## API REST
Temos 3 endpoints, sendo todos consumidos  através do método <b>HTTP GET</b>:

1) GET /address?q=\<endereço\>
2) GET /location?q=\<localidade\>
3) GET /coordinate?q=\<latitude\>,\<longitude\>

### address
GET /address?q=\<endereço\> <br>
<b>Ex</b>: http://localhost:8080/address?q=Rua%20Rom%C3%AAnia,%2066,%20Jd%20S%C3%A3o%20Jos%C3%A9,%20Suzano,%20SP <br>
Status e respostas: <br>
* <b>200 Ok</b>: Resultado da consulta contendo os locais e a probabilidade de ataque do Coringa (Joker)
* <b>403 Forbidden</b>: Quando o endereço fornecido com a localização do Coringa encontra-se fora dos limites de Gotham City
* <b>404 Not Found</b>: Quando não é possível encontra o endereço fornecido

### location
GET /location? q=\<localidade\> <br>
<b>Ex</b>: http://localhost:8080/location?q=mustang%20harry%27s <br>
Status e respostas: <br>
* <b>200 Ok</b>: Resultado da consulta contendo os locais e a probabilidade de ataque do Coringa (Joker)
* <b>403 Forbidden</b>: Quando o endereço fornecido com a localização do Coringa encontra-se fora dos limites de Gotham City
* <b>404 Not Found</b>: Quando não é possível encontra o endereço fornecido

### coordinate
GET /coordinate?q=\<latitude\>,\<longitude\> <br>
<b>Ex</b>: localhost:8080/coordinate?q=40.760134,-73.979021 <br>
Status e respostas: <br>
* <b>200 Ok</b>: Resultado da consulta contendo os locais e a probabilidade de ataque do Coringa (Joker)
* <b>400 Bad Request</b>: Quando a query string está malformada (não está no formato <b>\<latitude\>,\<longitude\></b>) ou quando os valores de latitude e/ou longitude estão fora do intervalo esperado (latitude de -90 a 90 e longitude de -180 a 180)
* <b>403 Forbidden</b>: Quando o endereço fornecido com a localização do Coringa encontra-se fora dos limites de Gotham City
* <b>404 Not Found</b>: Quando não é possível encontra o endereço fornecido











