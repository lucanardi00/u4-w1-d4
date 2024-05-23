// Definizione dell'interfaccia Checkable
interface Checkable {
    void checkIn();
}

// Classe astratta Dipendente che implementa Checkable
abstract class Dipendente implements Checkable {
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

    @Override
    public void checkIn() {
        System.out.println("Dipendente " + matricola + " ha iniziato il suo turno di lavoro.");
    }
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

// Classe Volontario che implementa Checkable
class Volontario implements Checkable {
    private String nome;
    private int eta;
    private String cv;

    public Volontario(String nome, int eta, String cv) {
        this.nome = nome;
        this.eta = eta;
        this.cv = cv;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public String getCv() {
        return cv;
    }

    @Override
    public void checkIn() {
        System.out.println("Volontario " + nome + " ha iniziato il suo servizio.");
    }
}

public class Es3 {
    public static void main(String[] args) {
        Dipendente dipendente1 = new DipendenteFullTime("001", 2500.00, Dipendente.PRODUZIONE);
        Dipendente dipendente2 = new DipendentePartTime("002", 0, Dipendente.AMMINISTRAZIONE, 80, 20.00);
        Dipendente dipendente3 = new Dirigente("003", 2700.00, Dipendente.VENDITE, 1000.00);
        Volontario volontario1 = new Volontario("Mario Rossi", 35, "CV di Mario Rossi");
        Volontario volontario2 = new Volontario("Luca Bianchi", 22, "CV di Luca Bianchi");

        Checkable[] persone = {dipendente1, dipendente2, dipendente3, volontario1, volontario2};

        for (Checkable persona : persone) {
            persona.checkIn();
        }
    }
}