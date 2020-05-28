package ProjetoAP2;
/**
 *
 * @author Ygor
 */
public class Pessoa extends Familia{
    
    public String nome;
    private int cpf;
    private int dia,mes,ano;

    public Pessoa(String nome, int cpf, int dia, int mes, int ano, String sobrenome, int usuarioSelecionado) {
        super(sobrenome, usuarioSelecionado);
        this.nome = nome;
        this.cpf = cpf;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
}
