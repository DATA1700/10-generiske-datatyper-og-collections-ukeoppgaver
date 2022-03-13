package oslomet.webprog.losningsforslag;

import java.util.Comparator;

// oppgave 3
public class MobelComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        Mobel m1 = (Mobel) o1;
        Mobel m2 = (Mobel) o2;

        return m1.getNavn().compareTo(m2.getNavn());
    }
}
