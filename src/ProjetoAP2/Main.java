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
            System.out.println("-------------------------------");                          //menu de cadastro do usuário
            System.out.println("1 - Buscar Usuário");
            System.out.println("2 - Acessar Usuário");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Editar Usuário");
            System.out.println("5 - Listar Usuários");
            System.out.println("6 - Sair");
            System.out.println("-------------------------------");
            
            char op = input.next().charAt(0);
            
            switch(op){
                case '1':                                                                   //1 - Buscar Usuário
                    if(usuario.isEmpty()){
                        System.out.println("Não há usuários cadastrados!");
                        break;
                    }
                    System.out.println("Digite o nome do usuário: ");
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
                            System.out.println("Não há nenhum usuário com o nome \"" + buscar + "\".");
                        }                     
                    }
                    break;
                case '2':                                                                   //2 - Acessar Usuário
                    if(usuario.isEmpty()){
                        System.out.println("Não há usuários cadastrados!");
                        break;
                    }
                    for(int i = 0; i < usuario.size(); i++){
                        Cadastro idCadastro = usuario.get(i);
                        System.out.println("ID: " + idCadastro.getID() + " Nome: " + idCadastro.getNome());
                    }
                    System.out.println("Selecione o Usuário:");
                    
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
                        System.out.println("Utilize o ID para selecionar o usuário.");
                        break;
                    }
                    
                    System.out.println("Usuário não existente!");
                    break;
                case '3':                                                                   //3 - Cadastrar Usuário
                    System.out.print("Digite o nome do usuário a ser adicionado: ");
                    String nome = input.next();
                    System.out.print("Digite o número de identificação: ");
                    int id = input.nextInt();
                    usuario.add(new Cadastro(id, nome, usuario.size()));
                    System.out.println("Usuário " + nome + " adicionado com sucesso!");
                    break;
                case '4':                                                                   //4 - Editar Usuário
                    if(usuario.isEmpty()){
                        System.out.println("Não há usuários cadastrados!");
                        break;
                    }
                    System.out.println("Digite o nome do usuário: ");
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
                                System.out.println("2 - Deletar usuário");
                                System.out.println("3 - Sair");
                            
                                op = input.next().charAt(0);
                                switch(op){
                                    case '1':
                                        System.out.println("Digite o novo nome: ");
                                        String novoNome = input.next();                                        
                                        System.out.println("O nome será atualizado para: " + novoNome + ". Confirmar?");
                                        System.out.println("1 - Sim");
                                        System.out.println("2 - Não");
                                        op = input.next().charAt(0);
                                        switch(op){
                                            case '1':
                                                idCadastro.setNome(novoNome);
                                                System.out.println("Usuário atualizado com sucesso!");
                                            case '2':
                                                System.out.println("Operação cancelada!");
                                                break;
                                        }
                                        break;
                                    case '2':
                                        System.out.println("Confirmar remoção do usuário?");
                                        System.out.println("1 - Sim");
                                        System.out.println("2 - Não");
                                        op = input.next().charAt(0);
                                        switch(op){
                                            case '1':
                                                usuario.remove(i);
                                                System.out.println("Usuário removido com sucesso!");
                                                subMenu = false;
                                            case '2':
                                                System.out.println("Operação cancelada!");                                                
                                        }
                                        break;
                                    case '3':
                                        System.out.println("Saindo do menu de edição...");
                                        subMenu = false;
                                        break;
                                }
                            } while(subMenu);
                            
                        }else{
                            System.out.println("Usuário não existente!");
                            break;
                        }
                    }
                    
                    break;
                case '5':                                                                   //5 - Listar Usuários
                    if(usuario.isEmpty()){
                        System.out.println("Não há usuários cadastrados!");
                        break;
                    }
                    for(int i = 0; i < usuario.size(); i++){
                        Cadastro idCadastro = usuario.get(i);
                        System.out.println("ID: " + idCadastro.getID() + " Nome: " + idCadastro.getNome() + " Posição: " + idCadastro.getPosicaoArray());
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