import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo");

        Scanner entrada = new Scanner(System.in);
        List<String> professores = new ArrayList<>();
        List<String> cursos = new ArrayList<>();
        List<String> cursosConcluidos = new ArrayList<>();
        List<String> professoresConcluidos = new ArrayList<>();

        professores.add("Gustavo");
        professores.add("Gabriel");
        professores.add("Andre");
        professores.add("Adrian");
        cursos.add("Teste1");
        cursos.add("Teste2");
        cursos.add("Teste3");
        cursos.add("Teste4");

        menu(entrada, professores, cursos, cursosConcluidos, professoresConcluidos);
    }

    public static void menu (Scanner entrada, List<String> professores, List<String> cursos, List<String> cursosConcluidos, List<String> professoresConcluidos){
        int opcao;
        do{

            System.out.println("Digite a opção desejada \n" +
                    "0 - Sair \n" +
                    "1 - Listar \n" +
                    "2 - Cadastrar professores e cursos \n" +
                    "3 - Remover \n" +
                    "4 - Marcar como concluído \n" +
                    "5 - Listar concluídos");
            opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 0: //Sair
                case 1: //Listar
                    /*
                    * Metodos não serão utilizados em prol de uma listagem unificada considerando que a ordem de adição representa o vinculo docente-disciplina
                    * listarDocente(professores);
                    * listarDisciplina(cursos);
                    */
                    System.out.println("Lista de cursos.");
                    listarProfessorCurso(professores , cursos);
                    break;
                case 2: //Cadastrar
                    cadastrarProfessor(entrada, professores);
                    cadastrarCurso(entrada, cursos);
                    break;
                case 3: //Remover
                    removerItemLista(entrada, professores, cursos);
                    System.out.println("Curso removido com sucesso.");
                    break;
                case 4: //Marcar Concluido
                    marcarComoConcluido(entrada, professores, cursos, cursosConcluidos, professoresConcluidos);
                    System.out.println("Curso marcado como concluido.");
                    break;
                case 5: //Listar Concluidos
                    System.out.println("Lista de cursos concluidos.");
                    listarProfessorCurso(professoresConcluidos, cursosConcluidos);
                    break;
                default:
                    System.out.println("Opção incorreta.");
            }
        }while(opcao > 0);
    }

    public static void marcarComoConcluido(Scanner entrada, List<String> professores, List<String> cursos, List<String> cursosConcluidos, List<String> professoresConcluidos){
        int indice = listarPedirIndice(entrada, professores,cursos);
        cursosConcluidos.add(cursos.get(indice));
        professoresConcluidos.add(professores.get(indice));
        removerItem(professores, cursos, indice);
    }

    public static int listarPedirIndice(Scanner entrada, List<String> professores, List<String> cursos){
        listarProfessorCurso(professores , cursos);
        System.out.print("Informe o indice escolhido: ");
        return Integer.parseInt(entrada.nextLine());
    }

    public static void removerItem(List<String> professores, List<String> cursos, int indice){
        professores.remove(indice);
        cursos.remove(indice);
    }

    public static void removerItemLista(Scanner entrada, List<String> professores, List<String> cursos){
        int indice = listarPedirIndice(entrada, professores,cursos);
        removerItem(professores, cursos, indice);
    }

    public static void cadastrarProfessor(Scanner entrada, List<String> professores){
        System.out.println("Qual o nome do Docente? ");
        professores.add(entrada.nextLine());
    }

    public static void cadastrarCurso(Scanner entrada, List<String> cursos){
        System.out.println("Qual o nome do Curso? ");
        cursos.add(entrada.nextLine());
    }

    public static void listarProfessorCurso(List<String> professores, List<String> cursos){
        if(professores.isEmpty() && cursos.isEmpty()){
            System.out.println("Listas não podem estar vazias, adicione cursos e professores.");
        } else if (professores.size() != cursos.size()) {
            System.out.println("Listas possuem valores diferentes, favor reiniciar aplicação.");
        } else {
            for (int i = 0; i < professores.size(); i++) {
                String professor = professores.get(i);
                String curso = cursos.get(i);
                System.out.println("# " +i + " - Professor " + professor + " - Disciplina " + curso);
            }
        }
    }

    public static void listarDocente(List<String> professores){
        if (!professores.isEmpty()) {
            for (int i = 0; i < professores.size(); i++) {
                String professor = professores.get(i);
                System.out.println(i + " - Professor: " + professor);
            }
        }else{
            System.out.println("Lista de professores vazia");
        }

    }

    public static void listarDisciplina(List<String> disciplinas){
        if (!disciplinas.isEmpty()) {
            for (int i = 0; i < disciplinas.size(); i++) {
                String disciplina = disciplinas.get(i);
                System.out.println(i + " - Disciplina: " + disciplina);
            }
        }else{
            System.out.println("Lista de disciplinas vazia");
        }

    }

}
