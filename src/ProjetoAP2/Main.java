package ProjetoAP2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Cadastro> usuario = new ArrayList();
        boolean onMenu;
        do{
            onMenu = true;
            System.out.println("-------------------------------");
            System.out.println("1 - Buscar Usu�rio");
            System.out.println("2 - Listar Usu�rios");
            System.out.println("3 - Cadastrar Usu�rio");
            System.out.println("4 - Editar Usu�rio");
            System.out.println("5 - Sair");
            System.out.println("-------------------------------");
            
            char op = input.next().charAt(0);
            
            switch(op){
                case '1':
                    if(usuario.isEmpty()){
                        System.out.println("N�o h� usu�rios cadastrados!");
                        break;
                    }
                    System.out.println("Digite o nome do usu�rio: ");
                    String buscar = input.next();
                    for(int i = 0; i < usuario.size(); i++){
                        Cadastro idCadastro = usuario.get(i);
                        if(idCadastro.getNome().equalsIgnoreCase(buscar)){
                            System.out.println("ID: " + idCadastro.getID());
                            System.out.println("Nome: " + idCadastro.getNome());
                            break;
                        }
                        if(i == usuario.size() - 1){
                            System.out.println("N�o h� nenhum usu�rio com o nome \"" + buscar + "\".");
                        }                     
                    }
                    break;
                case '2': 
                    if(usuario.isEmpty()){
                        System.out.println("N�o h� usu�rios cadastrados!");
                        break;
                    }
                    for(int i = 0; i < usuario.size(); i++){
                        Cadastro idCadastro = usuario.get(i);
                        System.out.println("ID: " + idCadastro.getID() + " Nome: " + idCadastro.getNome());
                    }
                    break;
                case '3':
                    System.out.println("Digite o nome do usu�rio a ser adicionado: ");
                    String nome = input.next();
                    usuario.add(new Cadastro(usuario.size(), nome));
                    System.out.println("Usu�rio " + nome + " adicionado com sucesso!");
                    break;
                case '4':
                    if(usuario.isEmpty()){
                        System.out.println("N�o h� usu�rios cadastrados!");
                        break;
                    }
                    System.out.println("Digite o nome do usu�rio: ");
                    buscar = input.next();
                    for(int i = 0; i < usuario.size(); i++){
                        Cadastro idCadastro = usuario.get(i);
                        if(idCadastro.getNome().equalsIgnoreCase(buscar)){
                            boolean subMenu = false;
                            do{
                                subMenu = true;
                                idCadastro = usuario.get(i);
                                System.out.println("ID: " + idCadastro.getID() + " Nome: " + idCadastro.getNome());
                                System.out.println("1 - Alterar dados");
                                System.out.println("2 - Deletar usu�rio");
                                System.out.println("3 - Sair");
                            
                                op = input.next().charAt(0);
                                switch(op){
                                    case '1':
                                        System.out.println("Digite o novo nome: ");
                                        String novoNome = input.next();                                        
                                        System.out.println("O nome ser� atualizado para: " + novoNome + ". Confirmar?");
                                        System.out.println("1 - Sim");
                                        System.out.println("2 - N�o");
                                        op = input.next().charAt(0);
                                        switch(op){
                                            case '1':
                                                idCadastro.setNome(novoNome);
                                                System.out.println("Usu�rio atualizado com sucesso!");
                                            case '2':
                                                System.out.println("Opera��o cancelada!");
                                                break;
                                        }
                                        break;
                                    case '2':
                                        System.out.println("Confirmar dele��o do usu�rio?");
                                        System.out.println("1 - Sim");
                                        System.out.println("2 - N�o");
                                        op = input.next().charAt(0);
                                        switch(op){
                                            case '1':
                                                usuario.remove(i);
                                                System.out.println("Usu�rio removido com sucesso!");
                                                subMenu = false;
                                            case '2':
                                                System.out.println("Opera��o cancelada!");                                                
                                        }
                                        break;
                                    case '3':
                                        System.out.println("Saindo do menu de edi��o...");
                                        subMenu = false;
                                        break;
                                }
                            } while(subMenu);
                        }
                    }
                    break;
                case '5':
                    System.out.println("Saindo do programa...");
                    onMenu = false;
                    break;
            }
        } while(onMenu);
    }
}