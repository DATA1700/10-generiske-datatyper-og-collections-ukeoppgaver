package oslomet.webprog.losningsforslag;

import java.util.Comparator;

// oppgave 4
public class BordComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        Bord m1 = (Bord) o1;
        Bord m2 = (Bord) o2;

        return m1.getBen() - m2.getBen();
    }
}
