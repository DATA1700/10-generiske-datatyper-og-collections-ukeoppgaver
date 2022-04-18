package oslomet.webprog.losningsforslag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// oppgave 3 og 6
//public class MobelRegister <T extends Bord> {
public class MobelRegister <T extends Mobel> {

    private List<T> mobler;

    public MobelRegister() {
        mobler = new ArrayList<>();
    }

    public void addMobel(T mobel) {
        mobler.add(mobel);
    }

    public T getMobel(int nummer) {
        for(T mobel : mobler) {
            if(mobel.getNummer() == nummer)d
                return mobel;
        }
        return null;
    }

    // FIXME! Fjerner element i listen underveis i itereringen. Dette fører til problemer.
    public void slettMobel(int nummer) {
        for(T mobel : mobler) {
            if(mobel.getNummer() == nummer)
                mobler.remove(mobel);
        }
    }

    public void skrivUtAlle() {
        for(Mobel mobel : mobler) {
            System.out.println(mobel);
        }
    }

    public void sorter() {
        Collections.sort(mobler);
    }

    public void sorterMedComparator() {
        Collections.sort(mobler, new MobelComparator());
    }

    public void sorterBordMedComparator() {
        BordComparator bordComparator = new BordComparator();
        Collections.sort(mobler, bordComparator);
    }
}
