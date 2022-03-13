package oslomet.webprog.losningsforslag;

// oppgave 4
public class Bord extends Mobel {

    private int ben;

    public Bord(String navn, String type, int vekt, int pris, int nummer, int ben) {
        super(navn, type, vekt, pris, nummer);
        this.ben = ben;
    }

    public String toString() {
        return getNummer() + "_" + getNavn() + "_" + getBen();
    }

    public int getBen() {
        return ben;
    }

    public void setBen(int ben) {
        this.ben = ben;
    }
}
