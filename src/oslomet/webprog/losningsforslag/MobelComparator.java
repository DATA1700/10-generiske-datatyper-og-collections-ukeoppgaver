package oslomet.webprog.losningsforslag;

import java.util.Comparator;

// oppgave 3
public class MobelComparator implements Comparator<Mobel> {

    public int compare(Mobel m1, Mobel m2) {
        return m1.getNavn().compareTo(m2.getNavn());
    }
}
