package ProjetoAP2;

/**
 *
 * @author Ygor
 */
public class Cadastro {
    private int posicaoArray;
    private int id;
    private String nome;
    
    public Cadastro(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    public Cadastro(int id, String nome, int posicaoArray){
        this.id = id;
        this.nome = nome;
        this.posicaoArray = posicaoArray;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int ID){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
         this.nome = nome;
    }
    
    public int getPosicaoArray(){
        return posicaoArray;
    }
    
    public void setPosicaoArray(){
        this.posicaoArray = posicaoArray;
    }

}