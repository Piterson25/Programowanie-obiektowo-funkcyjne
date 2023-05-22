import java.time.LocalDate;

public abstract sealed class Budynek permits Dom, Mieszkanie {
    protected String ulica;

    protected int numerDomu;

    protected String miejscowosc;

    protected String kodPocztowy;

    protected double powierzchnia;

    protected double cena;

    protected LocalDate dataObowiazywania;

    protected abstract String getUlica();

    protected abstract int getNumerDomu();

    protected abstract String getMiejscowosc();

    protected abstract String getKodPocztowy();

    protected abstract double getPowierzchnia();

    protected abstract double getCena();

    protected abstract LocalDate getDataObowiazywania();
}

