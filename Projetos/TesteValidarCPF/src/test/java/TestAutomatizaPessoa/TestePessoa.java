package TestAutomatizaPessoa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestePessoa {

    static Pessoa pessoa = new Pessoa();
    static Endereco endereco = new Endereco();

    @BeforeClass
    public static void gerarPessoa() throws InterruptedException {
        //1 - setar a url
        Navegador.getNavegadorAberto().setUrl("https://www.4devs.com.br/gerador_de_pessoas");
        //2 - acessar o site
        Navegador.getNavegadorAberto().acessarSite();
        Thread.sleep(2000);
        // gerar a pessoa
        Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("bt_gerar_pessoa")).click();
        Thread.sleep(3000);

        // pegar os elementos da tela e colocar na variavel de pessoa
        pessoa.setNome(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("nome")).getText());
        pessoa.setCpf(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("cpf")).getText());
        pessoa.setRg(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("rg")).getText());
        pessoa.setDataNasc(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("data_nasc")).getText());
        pessoa.setSexo(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("sexo")).getText());
        pessoa.setSigno(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("signo")).getText());
        pessoa.setMae(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("mae")).getText());
        pessoa.setPai(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("pai")).getText());
        pessoa.setEmail(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("email")).getText());
        pessoa.setSenha(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("senha")).getText());
        pessoa.setTelefone(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("telefone_fixo")).getText());
        pessoa.setCelular(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("celular")).getText());
        pessoa.setAltura(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("altura")).getText());
        pessoa.setPeso(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("peso")).getText());
        pessoa.setTipoSanguineo(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("tipo_sanguineo")).getText());
        pessoa.setCor(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("cor")).getText());
        endereco.setCep(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("cep")).getText());
        endereco.setNumero(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("numero")).getText());
        endereco.setBairro(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("bairro")).getText());
        endereco.setCidade(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("cidade")).getText());
        endereco.setEstado(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("estado")).getText());

    }

    @Test
    public void teste(){
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getcpf());
        System.out.println(pessoa.getRg());
        System.out.println(pessoa.getDataNasc());
        System.out.println(pessoa.getSexo());
        System.out.println(pessoa.getSigno());
        System.out.println(pessoa.getMae());
        System.out.println(pessoa.getPai());
        System.out.println(pessoa.getEmail());
        System.out.println(pessoa.getSenha());
        System.out.println(pessoa.getTelefone());
        System.out.println(pessoa.getCelular());
        System.out.println(pessoa.getAltura());
        System.out.println(pessoa.getPeso());
        System.out.println(pessoa.getTipoSanguineo());
        System.out.println(pessoa.getCor());
        System.out.println(endereco.getCep());
        System.out.println(endereco.getNumero());
        System.out.println(endereco.getBairro());
        System.out.println(endereco.getCidade());
        System.out.println(endereco.getEstado());
          }
}

