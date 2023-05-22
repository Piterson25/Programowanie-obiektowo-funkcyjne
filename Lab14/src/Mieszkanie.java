import java.time.LocalDate;

public final class Mieszkanie extends Budynek {

    private int numerMieszkania;

    private int numerPietra;

    public Mieszkanie(String ulica, int numerDomu, int numerMieszkania, String miejscowosc, String kodPocztowy,
               double powierzchnia, int numerPietra, double cena, LocalDate dataObowiazywania) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.numerPietra = numerPietra;
        this.cena = cena;
        this.dataObowiazywania = dataObowiazywania;
    }

    public String getUlica() {
        return super.ulica;
    }

    public int getNumerDomu() {
        return super.numerDomu;
    }

    public int getNumerMieszkania() {
        return this.numerMieszkania;
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

    public int getNumerPietra() {
        return this.numerPietra;
    }

    public double getCena() {
        return super.cena;
    }

    public LocalDate getDataObowiazywania() {
        return super.dataObowiazywania;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ulica: " + this.ulica + "\n");
        builder.append("Numer domu: " + this.numerDomu + "\n");
        builder.append("Numer mieszkania: " + this.numerMieszkania + "\n");
        builder.append("Miejscowosc: " + this.miejscowosc + "\n");
        builder.append("Kod pocztowy: " + this.kodPocztowy + "\n");
        builder.append("Powierzchnia: " + this.powierzchnia + "\n");
        builder.append("Numer pietra: " + this.numerPietra + "\n");
        builder.append("Cena: " + this.cena + "\n");
        builder.append("Data obowiazywania oferty: " + this.dataObowiazywania.toString() + "\n");

        return builder.toString();
    }
}
