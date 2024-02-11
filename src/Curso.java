import java.util.List;

public class Curso {
    public String Descricao;
    public List<Professor> Professores;

    public int cargaHoraria;

    public void progresso (){
        System.out.println("Aferindo progresso do curso.");
    }

    public void notas (){
        System.out.println("Computando notas dos alunos.");
    }

    public void participacao (){
        System.out.println("Computando nota de participação dos alunos");
    }
}
