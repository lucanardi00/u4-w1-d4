import entities.*;

public class Main {
    public static void main(String[] args) {
        Dipendente dipendente1 = new DipendenteFullTime("001", 2500.00, "PRODUZIONE");
        Dipendente dipendente2 = new DipendentePartTime("002", 2000.00, "AMMINISTRAZIONE", 40, 15.00);
        Dirigente dipendente3 = new Dirigente("003", 3000.00, "VENDITE", 1000.00);
        Volontario volontario1 = new Volontario("Mario Rossi", 35, "CV di Mario Rossi");
        Volontario volontario2 = new Volontario("Luca Bianchi", 22, "CV di Luca Bianchi");

        Checkable[] persone = {dipendente1, dipendente2, dipendente3, volontario1, volontario2};

        for (Checkable persona : persone) {
            persona.checkIn();
        }
    }
}



