package ProjetoAP2;

/**
 *
 * @author André Aragão
 */
public class Cadastro {
    int id;
    String nome;
    
    public Cadastro(int id, String nome){
        this.id = id;
        this.nome = nome;
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

}