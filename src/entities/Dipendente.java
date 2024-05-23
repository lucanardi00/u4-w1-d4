package entities;

public abstract class Dipendente implements Checkable {
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
        if (dipartimento.equals("PRODUZIONE") || dipartimento.equals("AMMINISTRAZIONE") || dipartimento.equals("VENDITE")) {
            this.dipartimento = dipartimento;
        } else {
            throw new IllegalArgumentException("Dipartimento non valido");
        }
    }

    @Override
    public void checkIn() {
        System.out.println("Dipendente " + getMatricola() + " ha iniziato il suo turno di lavoro.");
    }

    public abstract double calculateSalary();
}