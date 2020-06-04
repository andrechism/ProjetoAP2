package ProjetoAP2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Cadastro> usuario = new ArrayList();
        CadastroFamilia CF = new CadastroFamilia();
        
        
        boolean onMenu = false;
        do{
            if(onMenu) input.nextLine(); //limpar teclado
            
            onMenu = true;
            System.out.println("-------------------------------");                          //menu de cadastro do usu�rio
            System.out.println("1 - Buscar Usu�rio");
            System.out.println("2 - Acessar Usu�rio");
            System.out.println("3 - Cadastrar Usu�rio");
            System.out.println("4 - Editar Usu�rio");
            System.out.println("5 - Listar Usu�rios");
            System.out.println("6 - Sair");
            System.out.println("-------------------------------");
            
            char op = input.next().charAt(0);
            
            switch(op){
                case '1':                                                                   //1 - Buscar Usu�rio
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
                            for(int j = 0; j < CF.familia.size(); j++){
                                Pessoa idPessoa = CF.familia.get(j);
                                if(idPessoa.getUsuarioSelecionado() == idCadastro.getID()){
                                    System.out.println("\n________________________________");
                                    System.out.println("Nome: " + idPessoa.getNome() + " " + idPessoa.getSobrenome());
                                    System.out.println("Data de Nascimento: " + idPessoa.getDia() + "/" + idPessoa.getMes() + "/" + idPessoa.getAno());
                                    System.out.println("CPF: " + idPessoa.getCpf());
                                }
                            }
                            break;
                        }
                        if(i == usuario.size() - 1){
                            System.out.println("N�o h� nenhum usu�rio com o nome \"" + buscar + "\".");
                        }                     
                    }
                    break;
                case '2':                                                                   //2 - Acessar Usu�rio
                    if(usuario.isEmpty()){
                        System.out.println("N�o h� usu�rios cadastrados!");
                        break;
                    }
                    for(int i = 0; i < usuario.size(); i++){
                        Cadastro idCadastro = usuario.get(i);
                        System.out.println("ID: " + idCadastro.getID() + " Nome: " + idCadastro.getNome());
                    }
                    System.out.println("Selecione o Usu�rio:");
                    
                    try{
                        int usuarioSelecionado = input.nextInt();
                        for(int i = 0; i < usuario.size(); i++){
                            Cadastro idCadastro = usuario.get(i);
                            if(idCadastro.getID() == usuarioSelecionado){
                                CF.cadastrarFamilia(usuarioSelecionado);
                                //break;
                            }
                        }
                    } catch(InputMismatchException e) {
                        System.out.println("Utilize o ID para selecionar o usu�rio.");
                        break;
                    }
                    
                    System.out.println("Usu�rio n�o existente!");
                    break;
                case '3':                                                                   //3 - Cadastrar Usu�rio
                    System.out.print("Digite o nome do usu�rio a ser adicionado: ");
                    String nome = input.next();
                    System.out.print("Digite o n�mero de identifica��o: ");
                    int id = input.nextInt();
                    usuario.add(new Cadastro(id, nome, usuario.size()));
                    System.out.println("Usu�rio " + nome + " adicionado com sucesso!");
                    break;
                case '4':                                                                   //4 - Editar Usu�rio
                    if(usuario.isEmpty()){
                        System.out.println("N�o h� usu�rios cadastrados!");
                        break;
                    }
                    System.out.println("Digite o nome do usu�rio: ");
                    buscar = input.next();
                    for(int i = 0; i < usuario.size(); i++){
                        Cadastro idCadastro = usuario.get(i);
                        if(idCadastro.getNome().equalsIgnoreCase(buscar)){
                            boolean subMenu;
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
                                        System.out.println("Confirmar remo��o do usu�rio?");
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
                            
                        }else{
                            System.out.println("Usu�rio n�o existente!");
                            break;
                        }
                    }
                    
                    break;
                case '5':                                                                   //5 - Listar Usu�rios
                    if(usuario.isEmpty()){
                        System.out.println("N�o h� usu�rios cadastrados!");
                        break;
                    }
                    for(int i = 0; i < usuario.size(); i++){
                        Cadastro idCadastro = usuario.get(i);
                        System.out.println("ID: " + idCadastro.getID() + " Nome: " + idCadastro.getNome() + " Posi��o: " + idCadastro.getPosicaoArray());
                    }
                    break;
                case '6':                                                                   //6 - Sair
                    System.out.println("Saindo do programa...");
                    onMenu = false;
                    break;
            }
        } while(onMenu);
    }
}