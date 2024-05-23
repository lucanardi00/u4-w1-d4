package Es2;

abstract class Dipendente {
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

    public String getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        if (dipartimento.equals(PRODUZIONE) || dipartimento.equals(AMMINISTRAZIONE) || dipartimento.equals(VENDITE)) {
            this.dipartimento = dipartimento;
        } else {
            throw new IllegalArgumentException("Dipartimento non valido");
        }
    }

    public abstract double calculateSalary();
}

class DipendenteFullTime extends Dipendente {
    public DipendenteFullTime(String matricola, double stipendio, String dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    @Override
    public double calculateSalary() {
        return getStipendio();
    }
}

class DipendentePartTime extends Dipendente {
    private int oreLavorate;
    private double pagaOraria;

    public DipendentePartTime(String matricola, double stipendio, String dipartimento, int oreLavorate, double pagaOraria) {
        super(matricola, stipendio, dipartimento);
        this.oreLavorate = oreLavorate;
        this.pagaOraria = pagaOraria;
    }

    @Override
    public double calculateSalary() {
        return oreLavorate * pagaOraria;
    }
}

class Dirigente extends Dipendente {
    private double bonus;

    public Dirigente(String matricola, double stipendio, String dipartimento, double bonus) {
        super(matricola, stipendio, dipartimento);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getStipendio() + bonus;
    }
}

public class Main {
    public static void main(String[] args) {
        Dipendente dipendente1 = new DipendenteFullTime("001", 2500.00, Dipendente.PRODUZIONE);
        Dipendente dipendente2 = new DipendentePartTime("002", 0, Dipendente.AMMINISTRAZIONE, 80, 20.00);
        Dipendente dipendente3 = new Dirigente("003", 2700.00, Dipendente.VENDITE, 1000.00);

        Dipendente[] dipendenti = {dipendente1, dipendente2, dipendente3};

        double totaleStipendi = 0.0;

        for (Dipendente dipendente : dipendenti) {
            double stipendio = dipendente.calculateSalary();
            totaleStipendi += stipendio;
            System.out.println("Matricola: " + dipendente.getMatricola() + ", Stipendio: " + stipendio);
        }

        System.out.println("Totale stipendi: " + totaleStipendi);
    }
}