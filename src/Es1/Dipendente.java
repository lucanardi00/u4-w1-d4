package Es1;

public class Dipendente {
    public static final String PRODUZIONE = "PRODUZIONE";
    public static final String AMMINISTRAZIONE = "AMMINISTRAZIONE";
    public static final String VENDITE = "VENDITE";
    private String matricola;
    private double stipendio;
    private String dipartimento;

    public Dipendente(String matricola, double stipendio, String dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        setDipartimento(dipartimento);
    }

    public static void main(String[] args) {
        Dipendente dipendente1 = new Dipendente("001", 2500.00, Dipendente.PRODUZIONE);
        Dipendente dipendente2 = new Dipendente("002", 3000.00, Dipendente.AMMINISTRAZIONE);
        Dipendente dipendente3 = new Dipendente("003", 2700.00, Dipendente.VENDITE);

        Dipendente[] dipendenti = {dipendente1, dipendente2, dipendente3};

        for (Dipendente dipendente : dipendenti) {
            System.out.println(dipendente.getMatricola());
        }
    }

    // Getter matricola
    public String getMatricola() {
        return matricola;
    }

    // Getter stipendio
    public double getStipendio() {
        return stipendio;
    }

    // Getter dipartimento
    public String getDipartimento() {
        return dipartimento;
    }

    // Setter dipartimento
    public void setDipartimento(String dipartimento) {
        if (dipartimento.equals(PRODUZIONE) || dipartimento.equals(AMMINISTRAZIONE) || dipartimento.equals(VENDITE)) {
            this.dipartimento = dipartimento;
        } else {
            throw new IllegalArgumentException("Dipartimento non valido");
        }
    }
}