import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {

    private ArrayList<Budynek> listaOfert;

    public ListaOfert() {
        this.listaOfert = new ArrayList<>();
    }

    public void add(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia,
                    double cena, double powierzchniaDzialki, LocalDate dataObowiazywania) {
        this.listaOfert.add(new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, powierzchniaDzialki, dataObowiazywania));
    }

    public void add(String ulica, int numerDomu, int numerMieszkania, String miejscowosc, String kodPocztowy,
                    double powierzchnia, int numerPietra, double cena, LocalDate dataObowiazywania) {
        this.listaOfert.add(new Mieszkanie(ulica, numerDomu, numerMieszkania, miejscowosc, kodPocztowy, powierzchnia, numerPietra, cena, dataObowiazywania));
    }

    public ArrayList<Budynek> filter(Predicate<Budynek> pred) {
        ArrayList<Budynek> budynki = new ArrayList<>();
        for (Budynek budynek : this.listaOfert) {
            if (pred.test(budynek)) {
                budynki.add(budynek);
            }
        }

        return budynki;
    }

}
