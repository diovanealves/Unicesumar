import javax.swing.*;

public class ExameColesterol extends Exame {
    private int idadePaciente;
    private int colesterolHDL;
    private int colesterolLDL;
    private String riscoPaciente;
    private String classificacao;

    @Override
    public void CadastrarPaciente() {
        super.CadastrarPaciente();
        this.idadePaciente = getIdadePaciente();
    }

    public void ResultadoExameColesterolHDL(){
        colesterolHDL = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de colesterol HDL por mg/dL? "));

        if(idadePaciente <= 19 && colesterolHDL > 45){
            classificacao = "Colesterol HDL - BOM";
        } else if ( idadePaciente >= 20 && colesterolHDL > 40){
            classificacao = "Colesterol HDL - BOM";
        } else {
            classificacao = "Colesterol HDL - Baixo";
        }
    }

    public void ResultadoExameColesterolLDL(){
        colesterolLDL = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de colesterol LDL por mg/dL"));
        riscoPaciente = JOptionPane.showInputDialog("Risco (A - Alto, M - Médio, B - Baixo)").toUpperCase();

        if(riscoPaciente.equals("B") && colesterolLDL < 100){
            classificacao += "\nColesterol LDL - BOM";
        } else if(riscoPaciente.equals("M") && colesterolLDL < 70){
            classificacao += "\nColesterol LDL - BOM";
        } else if(riscoPaciente.equals("A") && colesterolLDL < 50){
            classificacao += "\nColesterol LDL - BOM";
        } else {
            classificacao += "\nColesterol LDL - RUIM";
        }
    }

    @Override
    public void MostrarResultado() {
        this.ResultadoExameColesterolHDL();
        this.ResultadoExameColesterolLDL();

        String resultado = """
                Nome do paciente: %s
                Risco do Paciente: %s
                Resultado Colesterol HDL: %d
                Resultado Colesterol LDL: %d
                Classificação: %s
                """ .formatted(getNome(), riscoPaciente, colesterolHDL, colesterolLDL, classificacao);

        JOptionPane.showMessageDialog(null, resultado);
    }
}
