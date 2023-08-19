import javax.swing.*;
import java.time.LocalDate;

public abstract class Exame {
    private  String nome;
    private String tipoSanguineo;
    private int anoNascimento;

    public void CadastrarPaciente(){
        this.nome = JOptionPane.showInputDialog("Qual o nome do paciente? ");
        this.tipoSanguineo = JOptionPane.showInputDialog("Qual o tipo sanguineo do paciente? ");
        this.anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano de nascimento do paciente? "));
    }

    public abstract void MostrarResultado();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getIdadePaciente(){
        int anoAtual = LocalDate.now().getYear();
        return anoAtual - anoNascimento;
    }
}
