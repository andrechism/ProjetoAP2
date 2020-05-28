package ProjetoAP2;
/**
 *
 * @author Ygor
 */
public abstract class Familia  {
    public String sobrenome;
    public int usuarioSelecionado;

    public Familia(String sobrenome, int usuarioSelecionado) {
        this.sobrenome = sobrenome;
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public int getUsuarioSelecionado(){
        return usuarioSelecionado;
    }
    
    public void setUsuarioSelecionado(){
        this.usuarioSelecionado = usuarioSelecionado;
    }
   
}
