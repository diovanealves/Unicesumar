import javax.swing.*;

public class ExameTriglicerideos extends Exame{
    private int idadePaciente;
    private int valorTriglicerideos;
    private String classificacao;

    @Override
    public void CadastrarPaciente() {
        super.CadastrarPaciente();
        idadePaciente = getIdadePaciente();
    }

    public void ResultadoExameTriglicerideos() {
        this.valorTriglicerideos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de triglicerideos por mg/dL? "));

        if(idadePaciente <= 9 && valorTriglicerideos < 75){
            classificacao = "Triglicerideos - Bom";
        } else if (idadePaciente >= 10 && idadePaciente <= 19 && valorTriglicerideos < 90){
            classificacao = "Triglicerideos - Bom";
        } else if(idadePaciente >= 20 && valorTriglicerideos < 150){
            classificacao = "Triglicerideos - Bom";
        } else {
            classificacao = "Triglicerideos - Ruim";
        }
    }

    @Override
    public void MostrarResultado() {
        this.ResultadoExameTriglicerideos();

        String resultado = """
                Nome do paciente: %s
                Resultado: %d
                Classificação: %s
                """ .formatted(getNome(), valorTriglicerideos, classificacao);

        JOptionPane.showMessageDialog(null, resultado);
    }
}
