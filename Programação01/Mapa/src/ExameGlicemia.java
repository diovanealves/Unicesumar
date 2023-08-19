import javax.swing.*;

public class ExameGlicemia extends  Exame {
    int valorGlicemia;
    private String resultadoExame;

    @Override
    public void CadastrarPaciente() {
        super.CadastrarPaciente();
    }

    public void ResultadoExameGlicemia(){
        valorGlicemia = Integer.parseInt(JOptionPane.showInputDialog("Quantidade glicose por mg/dL? "));

        if(valorGlicemia < 100){
            resultadoExame = "Normoglicemia";
        } else if (valorGlicemia < 126){
            resultadoExame = "Pré-diabetes";
        } else {
            resultadoExame = "Diabetes estabelecido";
        }
    }

    @Override
    public void MostrarResultado() {
        this.ResultadoExameGlicemia();

        String resultado = """
                Nome do paciente: %s
                Resultado: %d
                Classificação: %s
                """ .formatted(getNome(), valorGlicemia, resultadoExame);

        JOptionPane.showMessageDialog(null, resultado);
    }
}
