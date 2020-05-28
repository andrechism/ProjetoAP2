/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoAP2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ygor
 */
public class CadastroFamilia{
        
    public ArrayList<Pessoa> familia = new ArrayList();
    
        public void cadastrarFamilia(int usuarioSelecionado) {
        
        Scanner entrada = new Scanner(System.in);
        Consultas c1 = new Consultas();
        


        int ct = 0;
        do {
            System.out.println("=========CADASTRO FAMILIAR==========");
            System.out.println("1 - Realizar Cadastro");
            System.out.println("2 - Buscar Cadastro");
            System.out.println("3 - Excluir Cadastro");
            System.out.println("4 - Imprimir todos os Cadastros");
            System.out.println("5 - Sair");
            
            System.out.println("====================================");
            
            int menu = entrada.nextInt();
            
            switch(menu){
                case 1:
                    System.out.print("Nome: "); 
                    String nome = entrada.next();
                    System.out.print("Sobrenome: ");
                    String sobrenome = entrada.next();
                    System.out.print("CPF: "); 
                    int cpf = entrada.nextInt();
                    System.out.print("Data de Nascimento");
                    System.out.println("");
                    System.out.print("Dia: ");
                    int dia = entrada.nextInt();
                    System.out.print("M�s: ");
                    int mes = entrada.nextInt();
                    System.out.print("Ano: ");
                    int ano = entrada.nextInt();
                    System.out.println("");

                    familia.add(new Pessoa(nome,cpf,dia,mes,ano,sobrenome, usuarioSelecionado));
                    
                    c1.cadastrofinalizado();
                    System.out.println("====================================");
                    
                break;
                case 2:
                    if(familia.size() == 1){
                    System.out.println("Tem "+familia.size()+" cadastro no sistema");
                    }else {
                    System.out.println("Tem "+familia.size()+" cadastros no sistema");
                    }
                    
                    if (familia.isEmpty()) {
                        System.out.println("...");
                    }else{
                    
                        System.out.print("Qual cadastro você deseja buscar? "); 
                        String buscar = entrada.next();
                        
                        for (int i = 0; i <familia.size(); i++) {
                            Pessoa idPessoa =  familia.get(i);
                            if (idPessoa.getNome().equalsIgnoreCase(buscar)) {
                                familia.get(i);
    System.out.println("Nome: " +idPessoa.getNome()+ " CPF: "+idPessoa.getCpf()+" Data Nascimento: "+idPessoa.getDia()+"/"
    +idPessoa.getMes()+"/"+idPessoa.getAno());
                            }
                        }
                    }
                    System.out.println("");
                    c1.consultarcadastro();
                    System.out.println("====================================");
 
                break;
                case 3:
                    
                    System.out.print("Qual cadastro deseja remover: ");
                    String rem= entrada.next();
                   
                    for (int i = 0; i <familia.size(); i++) {
                        Pessoa idCadastro =  familia.get(i);
                        if (idCadastro.getNome().equalsIgnoreCase(rem)) {
                            familia.remove(i);
                            System.out.println("O cadastro de " +idCadastro.getNome()+" "+idCadastro.getSobrenome()+" foi removido.");
                        }
                    }
                    System.out.println("");
                    c1.excluircadastro();
                    System.out.println("====================================");
                    
                break;
                case 4:

                    System.out.println("====================================");
                    System.out.println("Nº     Nome    CPF    Data Nascimento");
                    int n = 0;
                   
                    for(Pessoa p : familia){
                        n++;
System.out.println(n+" "+p.getNome()+"     "+p.getCpf()+"     "+p.getDia()+"/"
    +p.getMes()+"/"+p.getAno());
                    }
                    System.out.println("");
                    c1.consultartodoscadastros();
                    System.out.println("====================================");
                    
                break;
                case 5:
                    ct = 5;
                break;
                default:
                    ct = 0;
                break;
            }
            
        } while (ct<5);
    }
        
    public void returnFamilia(){
        
    }
}
