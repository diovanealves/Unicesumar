public class Main {
    public static void main(String[] args) {
        ExameGlicemia ExGlicemia = new ExameGlicemia();
        ExGlicemia.CadastrarPaciente();
        ExGlicemia.MostrarResultado();

        ExameColesterol ExColesterol = new ExameColesterol();
        ExColesterol.CadastrarPaciente();
        ExColesterol.MostrarResultado();

        ExameTriglicerideos ExTriglicerideos = new ExameTriglicerideos();
        ExTriglicerideos.CadastrarPaciente();
        ExTriglicerideos.MostrarResultado();
    }
}