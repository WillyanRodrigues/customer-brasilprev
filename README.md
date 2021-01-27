# customer-register

Customer-register é uma API Rest simples que cuida de cadastro de clientes.

Para inicializá-la você precisa:

**1** - Ter Git instalado. Caso não tenha o git instalado, faça o download através do link https://git-scm.com/downloads.

**2** - Faça o clone do projeto para seu computador.

**3** - Tenha o JDK8 ou superior instalado em sua máquina.Faça o download através do link https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html.

**4** - Fazer o download do maven e configure o nas suas variaveis de ambiente. Faça o download através do link https://maven.apache.org/download.cgi.

**5** - Abra o prompt de comando, depois vá até a pasta onde se encontra o arquivo pom.xml do projeto e execute o camndo mvn spring-boot:run.

**6** - Para acessar os recursos da api o usuário e senha são os mesmos : brasilprev.

**7** - A aplicação deve subir corretamente na porta 8080. Para acessá-la digite http://localhost:8080/swagger-ui.html em seu navegador e encontrar a documentação da API.

**8** - O banco de dados da aplicação é o H2 um banco que fica embutido na aplicação através de algumas configurações e pode ser facilmente acessado através da url: http://localhost:8080/h2-console/login.jsp

**Obs:  Para fazer login no banco o campo JDBC URL do formulário deve ser o mesmo da propriedade spring.datasource.url. A senha do banco é a mesma encotranda na propriedade spring.datasource.password. Essas propriedades são encontradas no arquivo application.properties dentro do projeto.**

**Para poder executar a subida do projeto através da sua IDE de preferencia, lembre-se de configurar a mesma para que não hajam conflitos com anotações como lombok. Link de referencia:** https://dicasdejava.com.br/como-configurar-o-lombok-no-eclipse/

**USE A COLLECTION DO POSTMAN QUE SE ENCONTRA NA RAIZ DO PROJETO PARA FAZER OS TESTES. ESTA COLLECTION CONTEM AS URLS DA API PUBLICADA NO HEROKU.**

**LINK DO DOCKER HUB PARA FAZER CLONE DA IMAGEM CASO NECESSÁRIO: https://hub.docker.com/repository/docker/willyanrodrigues/customer-register"**




