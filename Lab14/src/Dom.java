import java.time.LocalDate;

public final class Dom extends Budynek {

    private double powierzchniaDzialki;

    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia, double cena,
               double powierzchniaDzialki, LocalDate dataObowiazywania) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.powierzchniaDzialki = powierzchniaDzialki;
        this.dataObowiazywania = dataObowiazywania;
    }

    public String getUlica() {
        return super.ulica;
    }

    public int getNumerDomu() {
        return super.numerDomu;
    }

    public String getMiejscowosc() {
        return super.miejscowosc;
    }

    public String getKodPocztowy() {
        return super.kodPocztowy;
    }

    public double getPowierzchnia() {
        return super.powierzchnia;
    }

    public double getCena() {
        return super.cena;
    }

    public double getPowierzchniaDzialki() {
        return this.powierzchniaDzialki;
    }

    public LocalDate getDataObowiazywania() {
        return super.dataObowiazywania;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ulica: " + this.ulica + "\n");
        builder.append("Numer domu: " + this.numerDomu + "\n");
        builder.append("Miejscowosc: " + this.miejscowosc + "\n");
        builder.append("Kod pocztowy: " + this.kodPocztowy + "\n");
        builder.append("Powierzchnia: " + this.powierzchnia + "\n");
        builder.append("Cena: " + this.cena + "\n");
        builder.append("Powierzchnia dzialki: " + this.powierzchniaDzialki + "\n");
        builder.append("Data obowiazywania oferty: " + this.dataObowiazywania.toString() + "\n");

        return builder.toString();
    }
}
