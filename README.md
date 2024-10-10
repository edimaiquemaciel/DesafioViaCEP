# Sistema de Consulta de Endereço por CEP

Este projeto é uma aplicação em Java que permite a consulta de endereços através de um CEP (Código de Endereçamento Postal) utilizando a API pública do [ViaCEP](https://viacep.com.br/). O programa também gera um arquivo JSON com os detalhes do endereço consultado.

## Funcionalidades

- Consulta de endereços a partir de um CEP fornecido pelo usuário.
- Geração de um arquivo JSON contendo os dados do endereço consultado.
- Tratamento de exceções durante o processo de consulta e geração de arquivo.

## Tecnologias Utilizadas

- **Java 11** ou superior
- Biblioteca **Gson** para conversão de objetos Java para JSON
- **HttpClient** para realizar requisições HTTP à API ViaCEP

## Como Executar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/edimaiquemaciel/DesafioViaCEP.git
   ```

2. **Abra o projeto** na sua IDE favorita (Eclipse, IntelliJ IDEA, VSCode, etc.).

3. **Adicione a dependência do Gson**:
   Se estiver utilizando Maven, adicione a seguinte dependência no arquivo `pom.xml`:
   
   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.8.8</version>
   </dependency>
   ```

4. **Compile e execute** o programa:
   Compile e execute o arquivo `Principal.java`. O programa solicitará que você insira um CEP para consulta.

   Exemplo:
   ```bash
   Digite um número de CEP para consulta:
   01001-000
   ```

   Após realizar a consulta, o programa exibirá as informações do endereço e salvará um arquivo JSON com o nome do CEP fornecido (ex: `01001-000.json`).

## Estrutura do Código

### 1. **Classe `Principal`**
   - A classe principal que realiza a interação com o usuário.
   - Solicita o CEP e chama o método de consulta do endereço.
   - Caso ocorra uma exceção (CEP inválido ou erro de conexão), ela será tratada e exibida uma mensagem de erro.

### 2. **Classe `ConsultaCep`**
   - Realiza a requisição HTTP para a API ViaCEP e retorna o endereço correspondente ao CEP informado.
   - Usa o **HttpClient** para enviar a requisição e o **Gson** para desserializar o JSON da resposta em um objeto `Endereco`.

### 3. **Classe `GeradorDeArquivo`**
   - Recebe um objeto `Endereco` e salva suas informações em um arquivo JSON, nomeado de acordo com o CEP consultado.
   - O arquivo gerado é formatado de forma legível utilizando o `GsonBuilder` com `setPrettyPrinting()`.

### 4. **Classe `Endereco`**
   - Representa os dados de um endereço retornado pela API ViaCEP.
   - É implementada usando `record`, o que torna a classe imutável e mais concisa.
   - A classe possui um método `toString()` formatado para exibir as informações do endereço de maneira legível.

## Exemplo de Execução

Aqui está um exemplo de saída ao executar o programa e consultar um CEP:

```bash
Digite um número de CEP para consulta:
01001-000

CEP = 01001-000
Logradouro = Praça da Sé
Complemento = lado ímpar
Bairro = Sé
Localidade = São Paulo
UF = SP
```

Um arquivo `01001-000.json` será gerado com o seguinte conteúdo:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

## Tratamento de Erros

- Se o CEP fornecido não for válido ou a API ViaCEP não puder ser acessada, o programa exibirá uma mensagem de erro, como:
  ```bash
  Não consegui obter o endereço a partir desse CEP.
  Finalizando a aplicação
  ```

## Requisitos

- **Java 11** ou superior
- Biblioteca **Gson** para manipulação de JSON

## Possíveis Melhorias

- Validar o formato do CEP antes de fazer a requisição.
- Adicionar suporte para múltiplas consultas em uma única execução.
- Implementar uma interface gráfica para melhorar a experiência do usuário.

## Licença

Este projeto está licenciado sob os termos da licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
