# Solução MapLink Code Challenge

## Passos para rodar o programa

### Clonagem do repositório 

1) Instalar o git e maven previamente. Os passos para instalação de ambos estão além do escopo deste manual.
2) Executar o comando: <code>git clone https://github.com/Hromenique/maplinkcodechallenge.git</code> 
3)Após isso o diretório <b>maplinkcodechallenge</b> (repositório local) será criado.
4) Após a criação do repositório local. Existem duas maneiras de rodar o projeto/programa: 
* Pelo maven plugin  <b>spring-boot</b>
* Gerando um jar (fat jar) atráves maven

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

