package ProjetoAP2;
/**
 *
 * @author Ygor
 */
public class Consultas implements CadastroInterface{

    @Override
    public void cadastrofinalizado() {
        System.out.println("Cadastro finalizado com sucesso!");
    }

    @Override
    public void consultarcadastro() {
        System.out.println("Consulta realizada com sucesso!");
    }

    @Override
    public void excluircadastro() {
        System.out.println("Operação finalizada com sucesso!");
    }

    @Override
    public void consultartodoscadastros() {
        System.out.println("Consulta realizada com sucesso!");
    }
    
}
