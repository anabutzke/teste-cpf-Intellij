import org.junit.Assert;
import org.junit.Test;

public class TestAssert {
        String cpf = "120.345.678-90";

    //metodos
//1 - Conferir se tem 11 caracteres numericos

    @Test
    public void validarQtdCaracteresCPF() {

       String cpf = this.cpf.replace(".", "").replace("-", "").replace("/", "");
        if (cpf.length() == 11) {
            System.out.println(" O CPF contém " + cpf.length() + " caracteres.");
            Assert.assertTrue(true);
        }else if(cpf.length() == 14){
            Assert.fail("não é um CPF, é um CNPJ");
        }else {
            Assert.fail("não deu certo!");

        }


    }



   // @Test
//7- Converta a string para um campo tipo Int

   // public void converteParaInt() {
   //     cpf = cpf.replace("-", ".").replace(",", "");
   //     double convertido = Double.parseDouble(cpf);
   //     Assert.assertNotEquals(cpf, convertido);
   // }
}

