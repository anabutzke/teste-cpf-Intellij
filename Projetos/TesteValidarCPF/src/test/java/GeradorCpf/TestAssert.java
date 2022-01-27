package GeradorCpf;

import TestAutomatizaPessoa.Pessoa;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

public class TestAssert {
    static Pessoa pessoa1 = new Pessoa();

    @BeforeClass
    public static void gerarPessoa() {
        pessoa1.setCpf("123.456.789-11");
          }

          //1 - Conferir se tem 11 caracteres numericos
    @Test
    public void validarQtdCaracteresCPF() {

        String cpf = pessoa1.getcpf().replace(".", "").replace("-", "").replace("/", "");

        if (cpf.length() == 11) {
            System.out.println("O CPF contém " + cpf.length() + " caracteres.");
            Assert.assertTrue(true);
        } else if (cpf.length() == 14) {
            Assert.fail("não é um CPF, é um CNPJ");
        } else Assert.fail("não deu certo!");
    }

    @Test
    //2 - verificar se veio pontuação/formatação do CPF
    public void validarSeCpfPossuiPontuacao() {
        if (pessoa1.getcpf().contains(".") && pessoa1.getcpf().contains("-")) {
            System.out.println(true + " 1 - Contém pontuação requirida");
            Assert.assertTrue(true);
        }else{
            Assert.fail("Não tem pontuação");
        }
        }

    @Test
    //3 - imprimir a palavra "CPF: " e concatenar ao número do CPF lido e armazenar em uma string
    public void validarSeImprimiAPalavracpf() {
        String frase = "CPF: ";
        String cpfconcat = frase.concat(pessoa1.getcpf());
        System.out.println(cpfconcat);


        //ou dessa orma
        if (cpfconcat.contains("CPF" + pessoa1.getcpf())){
             Assert.assertTrue(true);
        }else{
            Assert.fail("Não possui *");
        }
        //ou dessa
//        Assert.assertTrue(cpfconcat.contains("CPF" + cpf));
    }

    @Test
    //4 - reimprimir o passo 1 com um "*" no fim e guardar em uma string - Ver com a Le sobre essa questão do asterisco
    public void validarSeCpfPossuiasterisco() {
        String cpf = pessoa1.getcpf().replace(".", "").replace("-", "");
        String asterisco = "*";
         cpf = pessoa1.getcpf().concat(asterisco);
        if (cpf.contains("*")) {
            System.out.println(cpf);
            Assert.assertTrue(true);
        }else{
            Assert.fail("Não possui *");
        }
    }

    @Test
//5 - Verificar se tem o número 9
    public void verificarSeTemNumero9() {
        String verificarNumero = pessoa1.getcpf();
        if (verificarNumero.contains("9")) {
            System.out.println(true + "1 Contém nove");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Não tem numero 9");

        }
    }

    @Test
    //6 - verificar se tem algum numero que aparece mais de uma vez, se tiver guardar em uma variavel
    public void validarRepeticao(){
        String cpf = pessoa1.getcpf().replace(".", "");
        cpf = cpf.replace("-", "");
        String[] cpfArray = new String[cpf.length()];

        boolean
                numeroRepetido = false;

        for (int i = 0; i < cpf.length(); i++) {
            cpfArray[i] = String.valueOf(cpf.charAt(i));
        }

        for (int i = 0; i < cpfArray.length; i++) {
            for (int j = 0; j < cpfArray.length; j++) {
                if (cpfArray[i].equals(cpfArray[j])) {
                    if (i != j) {
                        numeroRepetido = true;
                    }
                }
            }
        }
        if (numeroRepetido == true) {
            System.out.println("Possui números repetidos");
            Assert.assertTrue( true);
        } else {
            Assert.fail("Não tem números repetidos");
        }
    }



 @Test
//7- Converta a string para um campo tipo Int
    public void converteParaDouble() {
         try {
             Double.parseDouble(pessoa1.getcpf().replace("-", ".").replace(",", ""));
           Assert.assertTrue(true);
        } catch (NumberFormatException e){
            Assert.fail("Não é double");
        }
    }


    @Test

    //8 - Verificar se é um CPF válido (desafio)
    public  void cpfValido() {
        String S1, S2, S3, S4, S5, S6, S7, S8, S9, confere = "";
        int N1, N2, N3, N4, N5, N6, N7, N8, N9, verificador1, verificador2;
        S1 = pessoa1.getcpf().substring(0, 1);
        N1 = Integer.parseInt(S1);
        S2 = pessoa1.getcpf().substring(1, 2);
        N2 = Integer.parseInt(S2);
        S3 = pessoa1.getcpf().substring(2, 3);
        N3 = Integer.parseInt(S3);
        S4 = pessoa1.getcpf().substring(4, 5);
        N4 = Integer.parseInt(S4);
        S5 = pessoa1.getcpf().substring(5, 6);
        N5 = Integer.parseInt(S5);
        S6 = pessoa1.getcpf().substring(6, 7);
        N6 = Integer.parseInt(S6);
        S7 = pessoa1.getcpf().substring(8, 9);
        N7 = Integer.parseInt(S7);
        S8 = pessoa1.getcpf().substring(9, 10);
        N8 = Integer.parseInt(S8);
        S9 = pessoa1.getcpf().substring(10, 11);
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

        if (confere.equals(pessoa1.getcpf()))
            JOptionPane.showMessageDialog(null, "CPF CORRETO =" + pessoa1 + " Confere" + confere);
        else
            JOptionPane.showMessageDialog(null, "CPF INCORRETO CPF =" + pessoa1 + "Confere" + confere);
    }
}



