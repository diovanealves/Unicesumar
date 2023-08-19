import javax.swing.*;

public class Rota {
    public void PlanejarDia(){
        double distanciaTotal = 0.0;

        int totalRotas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de rotas? "));

        for(int i = 1; i <= totalRotas; i++){
            double distanciaRota = Double.parseDouble(JOptionPane.showInputDialog("Digite a distância da rota %s em KM" .formatted(i)));
            distanciaTotal += distanciaRota;
        }

        double valorOleoDiesel = Double.parseDouble(JOptionPane.showInputDialog("Qual é o valor do óleo diesel? "));

        double combustivelNecessario = distanciaTotal / 2.5;
        double custoTotal = combustivelNecessario * valorOleoDiesel;

        String resultado = """
                Total de km que serão rodados %.2f KM
                Total de combustível necessário %.2f KM/L
                Valor desembolsado R$ %.2f
                """ .formatted(distanciaTotal, combustivelNecessario, custoTotal);

        JOptionPane.showMessageDialog(null, resultado);
    }
}
