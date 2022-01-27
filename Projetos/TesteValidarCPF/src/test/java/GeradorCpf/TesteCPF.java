package GeradorCpf;

import javax.swing.*;

public class TesteCPF {

    //metodo que executa
    public static void main(String[] args) {
        String cpf = "012.345.678-90";

        validarQtdCaracteresCPFCNPJ(cpf);
        validarSeCpfPossuiPontuacao(cpf);
        validarSeCpfPossuiasterisco(cpf);
        verificarSeTemNumero9(cpf);
        validarSeImprimiAPalavracpf(cpf);
        validarRepeticao(cpf);
        StringInt(cpf);
        cpfValido(cpf);
    }

    //metodos
//1 - Conferir se tem 11 caracteres numericos
    public static void validarQtdCaracteresCPFCNPJ(String cpfCnpj) {

        cpfCnpj = cpfCnpj.replace(".", "");
        cpfCnpj = cpfCnpj.replace("-", "");

        if (cpfCnpj.length() == 11) {
            System.out.println(true + " O CPF contém " + cpfCnpj.length() + " caracteres.");
        } else if (cpfCnpj.length() == 14) {
            System.out.println(true + " O CNPJ contém " + cpfCnpj.length() + " caracteres.");
        } else {
            System.out.println(false + " O numero de documento recebido é inválido. Esperava-se um CPF ou CNPJ e foi recebido o documento " + cpfCnpj + " que contém " + cpfCnpj.length() + " caracteres");
        }
    }

    //2 - verificar se veio pontuação/formatação do CPF
    public static void validarSeCpfPossuiPontuacao(String cpf) {
        String validarSeCpfPossuiPontuacao = cpf;
        if (validarSeCpfPossuiPontuacao.contains(".") && validarSeCpfPossuiPontuacao.contains("-")) {
            System.out.println(true + " 1 - Contém pontuação requirida");
        } else {
            System.out.println(false + " 2 - Não contém pontuação");
        }


    }

    // charAT na posição tal, se essa é igual a um . ou um '
    public static void validarSePossuiPontuação3(String cpf) {
        if ("".charAt(3) >= '.')
            if ("".charAt(11) <= '-') {
            }
        System.out.println(cpf);
        validarSePossuiPontuação3(cpf);
    }

    //3 - imprimir a palavra "CPF: " e concatenar ao número do CPF lido e armazenar em uma string
    public static void validarSeImprimiAPalavracpf(String cpf) {
        String frase = "CPF: ";
        String cpfconcat = frase.concat(cpf);
        System.out.println(cpfconcat);

    }

    //4 - reimprimir o passo 1 com um "*" no fim e guardar em uma string
    public static void validarSeCpfPossuiasterisco(String cpf) {

        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        String asterisco = "*";
        cpf = cpf.concat(asterisco);
        System.out.println(cpf);
    }

    //5 - Verificar se tem o número 9

    public static void verificarSeTemNumero9(String cpf) {
        String verificarNumero = cpf;
        if (verificarNumero.contains("9")) {
            System.out.println(true + "1 Contém nove");
        } else {
            System.out.println(false + "2 Não contém nove");
        }


    }

    //6 - verificar se tem algum numero que aparece mais de uma vez, se tiver guardar em uma variavel
    public static void validarRepeticao(String cpf) {
        cpf = cpf.replace(".", "");
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
        } else {
            System.out.println("Não possui números repetidos");
        }
    }

    //7 - converta a string para um campo tipo int 🙂
    public static void StringInt(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        double convercao = Double.parseDouble(cpf);
        System.out.println(convercao);

    }

    //8 - Verificar se é um CPF válido (desafio)
    public static void cpfValido(String cpf) {
        String S1, S2, S3, S4, S5, S6, S7, S8, S9, confere = "";
        int N1, N2, N3, N4, N5, N6, N7, N8, N9, verificador1, verificador2;
        S1 = cpf.substring(0, 1);
        N1 = Integer.parseInt(S1);
        S2 = cpf.substring(1, 2);
        N2 = Integer.parseInt(S2);
        S3 = cpf.substring(2, 3);
        N3 = Integer.parseInt(S3);
        S4 = cpf.substring(4, 5);
        N4 = Integer.parseInt(S4);
        S5 = cpf.substring(5, 6);
        N5 = Integer.parseInt(S5);
        S6 = cpf.substring(6, 7);
        N6 = Integer.parseInt(S6);
        S7 = cpf.substring(8, 9);
        N7 = Integer.parseInt(S7);
        S8 = cpf.substring(9, 10);
        N8 = Integer.parseInt(S8);
        S9 = cpf.substring(10, 11);
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

        if (confere.equals(cpf))
            JOptionPane.showMessageDialog(null, "CPF CORRETO =" + cpf + " Confere" + confere);
        else
            JOptionPane.showMessageDialog(null, "CPF INCORRETO CPF =" + cpf + "Confere" + confere);
    }
}




