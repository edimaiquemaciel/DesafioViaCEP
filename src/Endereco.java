public record Endereco(String cep, String logradouro,String complemento,
                       String bairro, String localidade, String uf) {

    @Override
    public String toString() {
        return  """
                CEP = %s
                Logradouro = %s
                Complemento = %s
                Bairro = %s
                Localidade = %s
                UF = %s
                
                """.formatted(cep, logradouro, complemento, bairro, localidade, uf);
    }
}
