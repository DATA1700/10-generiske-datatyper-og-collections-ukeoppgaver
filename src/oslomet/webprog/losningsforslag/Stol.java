package oslomet.webprog.losningsforslag;

// oppgave 4
public class Stol extends Mobel {

    public Stol(String navn, String type, int vekt, int pris, int nummer) {
        super(navn, type, vekt, pris, nummer);
    }

    public String toString() {
        return getNummer() + "_" + getNavn();
    }
}
