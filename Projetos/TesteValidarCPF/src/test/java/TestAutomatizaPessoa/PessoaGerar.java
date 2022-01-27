package TestAutomatizaPessoa;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PessoaGerar {

    static Pessoa pessoa = new Pessoa();
    static Endereco endereco = new Endereco();

    @BeforeClass
    public static void gerarPessoa() {
        // toda a parte de buscar na web
        pessoa.setNome("joana Lima Ferreira Branco");
        pessoa.setCpf("016.403.019-09");
        pessoa.setSexo("Feminino");
        pessoa.setSigno("Áries");
        pessoa.setMae("monica Estranha Dalberto da Silva");
        pessoa.setPai("Eduardo Rodrigues da silva Machado");
        pessoa.setEmail("debora_laurabrit@okframe.com");
        pessoa.setSenha("125yayagCyagya");
        endereco.setCep("58025-540");
        endereco.setEndereco("Av São Paulo");
        endereco.setNumero("25");
        endereco.setEstado("Minas Gerais");
        endereco.setCidade("Blumenau");
        endereco.setBairro("Fortaleza");
        pessoa.setTelefone("(47)3222-1200");
        pessoa.setCelular("(47)99684-5090");
        pessoa.setPeso("55.0");
        pessoa.setCor("Vermelho");
    }

    @Test
    //1 - NOME passa SE conter apenas letras E possuir 4 nomes ("da" e "de" não conta como nome, nomes válidos possuem no minimo 3 letras)
    public void validacaoNome() {

        String nomeInserido = pessoa.getNome().trim();     // <- Tira os espaços do inicio e do final;

        if (nomeInserido.matches("[a-zA-Z-\s]+")) {  // <- verifica se tem apenas letras

            String[] nomeArray = nomeInserido.split(" ");  // <- quebra o nome em array
            int resultado = 0;

            for (int i = 0; i < nomeArray.length; i++) {
                if (nomeArray[i].length() >= 3) {  //<- verifica se o nome tem mais de 3 letras
                    resultado++;                    // <- se tiver incrementa aqui
                }
            }
            if (resultado == 4) {   // <- verifica se o que incrementou (quantos nomes tem mais de 3 letras) se é maior que 4
                System.out.println("\n Seu nome " + pessoa.getNome() + " está correto.");
                Assert.assertTrue(true);
            } else {
                Assert.fail("\nSeu nome " + pessoa.getNome() + " não tem exatamente 4 nomes.");  // <- se não tiver 4 dá erro
            }
        } else {
            Assert.fail("\nSeu nome " + pessoa.getNome() + " não contém apenas letras"); // <- se não contém apenas letra dá erro
        }
    }

    @Test // 2 - CPF passa SE o calculo do CPF for válido E possuir formatação (XXX.XXX.XXX-XX)
    public void cpfValido() {
        String S1, S2, S3, S4, S5, S6, S7, S8, S9, confere = "";
        int N1, N2, N3, N4, N5, N6, N7, N8, N9, verificador1, verificador2;
        S1 = pessoa.getcpf().substring(0, 1);
        N1 = Integer.parseInt(S1);
        S2 = pessoa.getcpf().substring(1, 2);
        N2 = Integer.parseInt(S2);
        S3 = pessoa.getcpf().substring(2, 3);
        N3 = Integer.parseInt(S3);
        S4 = pessoa.getcpf().substring(4, 5);
        N4 = Integer.parseInt(S4);
        S5 = pessoa.getcpf().substring(5, 6);
        N5 = Integer.parseInt(S5);
        S6 = pessoa.getcpf().substring(6, 7);
        N6 = Integer.parseInt(S6);
        S7 = pessoa.getcpf().substring(8, 9);
        N7 = Integer.parseInt(S7);
        S8 = pessoa.getcpf().substring(9, 10);
        N8 = Integer.parseInt(S8);
        S9 = pessoa.getcpf().substring(10, 11);
        N9 = Integer.parseInt(S9);
        verificador1 = (N1 * 10 + N2 * 9 + N3 * 8 + N4 * 7 + N5 * 6 + N6 * 5 + N7 * 4 + N8 * 3 + N9 * 2);
        if ((verificador1 % 11) < 2)
            verificador1 = 0;
        else
            verificador1 = 11 - (verificador1 % 11);

        verificador2 = (N1 * 11 + N2 * 10 + N3 * 9 + N4 * 8 + N5 * 7 + N6 * 6 + N7 * 5 + N8 * 4 + N9 * 3 + verificador1 * 2);
        if ((verificador2 % 11) < 2)
            verificador2 = 0;
        else
            verificador2 = 11 - (verificador2 % 11);

        confere = (S1 + S2 + S3 + "." + S4 + S5 + S6 + "." + S7 + S8 + S9 + "-" + verificador1 + "" + verificador2);

        if (confere.equals(pessoa.getcpf())) {
            System.out.println("CpfValido de cpf\n0 seguinte CPF '" + pessoa.getcpf() + "' é um CPF válido.");
        } else if (pessoa.getcpf().charAt(3) == '.' && pessoa.getcpf().charAt(7) == '.' && pessoa.getcpf().charAt(11) == '-') {
            Assert.fail("\nSeu CPF" + pessoa.getcpf() + "não é um cpf válido.");
        } else {
            Assert.fail("\nSeu CPF não está no formato de CPF.");
        }


    }


    @Test // 3 - SEXO passa SE no getSexo() retornar 'F' para feminino ou 'M' para Masculino
    public void retornoFouM() {
        String sexo = "Feminino";
        String sexo1 = "Masculino";

        if (pessoa.getSexo().equals(sexo)) {
            System.out.println("F\n");
            Assert.assertTrue(true);

        } else if (pessoa.getSexo().equals(sexo1)) {
            System.out.println("M\n");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Sexo: Inválido");
        }
//        Assert.assertTrue("Erro: o sexo não é valido. Esperava-se M ou F e foi recebido " + pessoa.getSexo(), pessoa.getSexo() == 'M' || pessoa.getSexo() == 'F'); = Outra maneira de fazer
    }

    @Test // 4 - SIGNO passa SE for um signo válido (guardar os signos válidos em um array)
    public void Signovalido() {
        String[] Signosvalidos = {"Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário", "Capricórnio", "Áquario", "Peixes"};
        boolean passou = false;
        // i = identificador
        // ++ = somar ou incrementar
        for (int i = 0; i < Signosvalidos.length; i++) {    //for é um laço, onde ele vai correr a array procurando o que esta dentro do if
            if (Signosvalidos[i].equals(pessoa.getSigno())) {
                passou = true;
                Assert.assertTrue(true);
            }
        }
        if (passou) {
            System.out.println("Validou signo");
        } else {
            Assert.fail("Não é um signo válido");
        }
    }

    @Test
    // 6 - MAE passa SE conter apenas letras E possuir 4 nomes ("da" e "de" não conta como nome, nomes válidos possuem no minimo 3 letras)
    public void validarNomeMae() {

        String nomeInserido = pessoa.getMae().trim();     // <- Tira os espaços do inicio e do final;

        if (nomeInserido.matches("[a-zA-Z-\s]+")) {  // <- verifica se tem apenas letras

            String[] nomeArray = nomeInserido.split(" ");  // <- quebra o nome em array
            int resultado = 0;

            for (int i = 0; i < nomeArray.length; i++) {
                if (nomeArray[i].length() >= 3) {  //<- verifica se o nome tem mais de 3 letras
                    resultado++;                    // <- se tiver incrementa aqui
                }
            }
            if (resultado == 4) {   // <- verifica se o que incrementou (quantos nomes tem mais de 3 letras) se é maior que 4
                System.out.println("\n Nome Mãe: Seu nome " + pessoa.getMae() + " está correto.");
                Assert.assertTrue(true);
            } else {
                Assert.fail("\nNome Mãe:Nome " + pessoa.getMae() + " não tem exatamente 4 nomes.");  // <- se não tiver 4 dá erro
            }
        } else {
            Assert.fail("\nNome Mãe: Nome " + pessoa.getMae() + " não contém apenas letras"); // <- se não contém apenas letra dá erro
        }
    }

    @Test
    // 7 - PAI passa SE conter apenas letras E possuir 4 nomes ("da" e "de" não conta como nome, nomes válidos possuem no minimo 3 letras)
    public void validarNomePai() {

        String nomeInserido = pessoa.getPai().trim();     // <- Tira os espaços do inicio e do final;

        if (nomeInserido.matches("[a-zA-Z-\s]+")) {  // <- verifica se tem apenas letras

            String[] nomeArray = nomeInserido.split(" ");  // <- quebra o nome em array
            int resultado = 0;

            for (int i = 0; i < nomeArray.length; i++) {
                if (nomeArray[i].length() >= 3) {  //<- verifica se o nome tem mais de 3 letras
                    resultado++;                    // <- se tiver incrementa aqui
                }
            }
            if (resultado == 4) {   // <- verifica se o que incrementou (quantos nomes tem mais de 3 letras) se é maior que 4
                System.out.println("\n Nome Mãe: Seu nome " + pessoa.getPai() + " está correto.");
                Assert.assertTrue(true);
            } else {
                Assert.fail("\nNome Mãe:Nome " + pessoa.getPai() + " não tem exatamente 4 nomes.");  // <- se não tiver 4 dá erro
            }
        } else {
            Assert.fail("\nNome Mãe: Nome " + pessoa.getPai() + " não contém apenas letras"); // <- se não contém apenas letra dá erro
        }
    }

    @Test // 8 - EMAIL passa SE tiver @ e .
    public void EmailCorreto() {
        String emailInserido = pessoa.getEmail().trim();
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher macher = p.matcher(pessoa.getEmail());
        boolean matchFound = macher.matches();
        if (!matchFound) {
            Assert.fail("Formato de e-mail inválido");
        } else {
            Assert.assertTrue(true);
            System.out.println("E-mail: E-mail Correto");
        }
    }

    @Test // 9 - SENHA passa SE conter letras maiusculas E letras minusculas E numeros
    public void Senha() {
        Assert.assertTrue(pessoa.getSenha().matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$"));
    }

    @Test // 10 - CEP passa SE conter a formatação certa (apenas numeros e no formato XXXXX-XXX)
    public void CEP() {
        String Cep = endereco.getCep();
        boolean retorno = false;

        if (Cep.matches("[0-9-]+") && Cep.charAt(5) == '-' && Cep.length() == 9) {
            Assert.assertTrue(true);
            retorno = true;
        }
        if (retorno) {
            System.out.println("O Cep contém " + endereco.getCep().length() + " caracteres.");

        } else Assert.fail("Não é CEP");
    }

    @Test // 11 - ENDEREÇO/RUA passa SE começar com "Rua" ou "Av" (avenida) - ||= ou
    public void validaçãoEndereço() {

        if (endereco.getEndereco().startsWith("Rua ") || endereco.getEndereco().startsWith("Av ")) {
            Assert.assertTrue(true);
            System.out.println("O endereço é válido");
        } else {
            Assert.fail("Endereço inválido");
        }
    }

    @Test // 12 - NUMERO passa SE conter apenas numeros
    public void ApenasNumero() {
        boolean numero = false;
        if (endereco.getNumero().matches("[0-9]+")) {
            Assert.assertTrue(true);
            numero = true;
        }
        if (numero) {
            System.out.println("Contém apenas número");
        } else Assert.fail("Não contém apenas número");
    }

    @Test // 13 - BAIRRO passa SE for um nome válido (nomes válidos não possuem numeros e possuem no minimo 3 letras)
    public void BairroValido() {
        String Bairro = endereco.getBairro();
        boolean retorno = false;
        if (Bairro.matches("[a-zA-Z]+") && Bairro.length() >= 3) {
            Assert.assertTrue(true);
            retorno = true;
        }
        if (retorno) {
            System.out.println("É um bairro " + endereco.getBairro().length());

        } else Assert.fail("Não é Bairro");
    }

    @Test // 14 - CIDADE passa SE for um nome válido (nomes válidos não possuem numeros e possuem no minimo 3 letras)
    public void CidadeValido() {
        String Cidade = endereco.getCidade();
        boolean retorno = false;
        if (Cidade.matches("[a-zA-Z]+") && Cidade.length() >= 3) {
            Assert.assertTrue(true);
            retorno = true;
        }
        if (retorno) {
            System.out.println("É uma cidade " + endereco.getBairro().length());

        } else Assert.fail("Não é uma cidade");
    }

    @Test // 15 - ESTADO passa SE for um estado válido (guardar os estados válidos em um array) = signo
    public void EstadosValidos() {
        String[] EstadosValidos = {"Mato Grosso", "Bahia", "Minas Gerais", "Goias", "Paraná", "Rio Grande do Sul", "São Paulo", "Santa Catarina", "Amazonas", "Manaus", "Ceará", "Pará", "Rio de Janeiro", "Pernambuco", "Espirito Santo", "Rio Grande do Norte", "Piauí", "Maranhão", "Paraíba", "Tocatins", "Alagoas", "Mato Grosso do Sul", "Sergipe", "Rondônia", "Acre", "Roraima", "Amapá"};
        boolean passou = false;
        // i = identificador
        // ++ = somar ou incrementar
        for (int i = 0; i < EstadosValidos.length; i++) {    //for é um laço, onde ele vai correr a array procurando o que esta dentro do if
            if (EstadosValidos[i].equals(endereco.getEstado())) {
                passou = true;
                Assert.assertTrue(true);
            }
        }
        if (passou) {
            System.out.println("Validou Estado");
        } else {
            Assert.fail("Não é um Estado válido");
        }
    }

    //      @Test // 16 - TELEFONE fixo válido SE conter apenas numeros e com formatação (XX)XXXX-XXXX)
//    public void TelefoneValido(){
//        Assert.assertTrue(pessoa.getTelefone().matches("^\\([1-9]{2}\\)[3]{0,1}[6-9]{1}[0-9]{3}\\-[0-9]{4}$"));
//        System.out.println("Telefone: Telefone válido");
//    }
    @Test // 17 - CELULAR é válido SE conter apenas numeros e com formatação (XX)X XXXX-XXXX)
    public void CelularValido() {
        Assert.assertTrue(pessoa.getCelular().matches("(^\\([1-9]{2}\\)(:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$)"));
        System.out.println("Celular: Celular válido");
    }


    @Test // 18 - CARACTERISTICAS FISICAS é valido SE o IMC da pessoa for saudável.
    public void ImcSaudavel() {

        double peso = Double.parseDouble(pessoa.getPeso());
        double altura = 1.70;
        double imc = peso / (altura * altura);

        if (imc <= 25 && imc >= 18.6) {
            Assert.assertTrue(true);
            System.out.println("Seu IMC é " + imc + " normal!");
        } else if (imc <= 18.5) {
            Assert.fail("Seu IMC é " + imc + "  abaixo do normal!");
        } else if ((imc > 25.0) && (imc <= 30.0)) {
            Assert.fail("Seu IMC é " + imc + "  acima do normal!");
        } else if (imc > 30) {
            Assert.fail("Seu IMC é " + imc + "  obesidade!");
        }
    }

//    @Test // 19 - SANGUE é valido se a pessoa pode doar para no mínimo duas pessoas (dois tipos de sangue)

    @Test // 20 - COR é valida SE for azul (da premier hehe)
    public void ValidaraCorAzul(){
        Assert.assertTrue(pessoa.getCor().matches("^(?!red|green|blue).*"));
        System.out.println("Cor: É a cor azul");
    }

}











