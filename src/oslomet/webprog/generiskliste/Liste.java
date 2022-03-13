package oslomet.webprog.generiskliste;

import java.io.Serializable;

public interface Liste<E extends Comparable<E> & Serializable>
{
    public E finn(E e);

    public boolean fjern(E e);

    public void settInnForrest(E e);

    public void settInnBakerst(E e);

    public void settInnSortert(E e);

    public void sorter();

    public void dubliser();

    public void slett();

    public Liste<E> reversertKopi();

    public void reverser();

    public E[] tilArray(E[] a);
}

