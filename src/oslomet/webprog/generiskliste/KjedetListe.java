package oslomet.webprog.generiskliste;

import java.io.Serializable;
import java.lang.reflect.Array;

public class KjedetListe<E extends Comparable<E> & Serializable>
        implements Liste<E>, Serializable
{
    private Node<E> hode;

    public KjedetListe()
    {
        hode = null;
    }

    //Returnerer første forekomst av e
    public E finn(E e)
    {
        Node<E> hjelp = hode;
        while (hjelp != null && !hjelp.element.equals(e))
            hjelp = hjelp.neste;
        return hjelp.element;
    }

    //Fjerner første forekomst av e
    public boolean fjern(E e)
    {
        if (hode == null) //tom liste
            return false;
        if (hode.element.equals(e))
        {
            hode = hode.neste;
            return true;
        }
        Node<E> hjelp = hode;
        while (hjelp.neste != null)
        {
            if (hjelp.neste.element.equals(e))
            {
                hjelp.neste = hjelp.neste.neste;
                return true;
            }
            hjelp = hjelp.neste;
        }
        return false;
    }

    //setter inn forrest ny node med mottatt verdi
    public void settInnForrest(E e)
    {
        Node<E> ny = new Node(e);
        ny.neste = hode;
        hode = ny;
    }

    //setter inn bakerst ny node med mottatt verdi
    public void settInnBakerst(E e)
    {
        Node<E> ny = new Node(e);
        if (hode == null) //tom liste
            hode = ny;
        else
        {
            Node<E> hjelp = hode;
            while (hjelp.neste != null) //plasserer hjelp på siste node
                hjelp = hjelp.neste;

            hjelp.neste = ny;
        }
    }

    //setter inn mottatt verdi i ny node som plasseres
//på riktig plass i sortert liste
    public void settInnSortert(E e)
    {
        Node<E> ny = new Node(e);
        if ( hode == null ) //tom liste
            hode = ny;
        else if(hode.element.compareTo(e) > 0)
            settInnForrest(e);
        else
        {
            Node<E> hjelp = hode;
            while (hjelp.neste != null &&
                    hjelp.neste.element.compareTo(e) < 0)
                hjelp = hjelp.neste;

            ny.neste = hjelp.neste;
            hjelp.neste = ny;
        }
    }

    // sorterer lista
    public void sorter()
    {
        Node<E> hjelp = hode;
        KjedetListe<E> l = new KjedetListe<>();

        while(hjelp != null)
        {
            l.settInnSortert(hjelp.element);
            hjelp = hjelp.neste;
        }
        hode = l.hode;
    }

    //setter inn en kopi av hver node i lista
    public void dubliser()
    {
        Node<E> hjelp = hode;
        while (hjelp != null)
        {
            Node<E> ny = new Node(hjelp.element);
            ny.neste = hjelp.neste;
            hjelp.neste = ny;
            hjelp = hjelp.neste.neste;
        }
    }

    //sletter alle nodene i lista
    public void slett()
    {
        hode = null;
    }

    //returnerer et listeobjekt som er en kopi
//av denne liste, men med nodene i reversert rekkefølge
    public Liste<E> reversertKopi()
    {
        KjedetListe<E> kopi = new KjedetListe<>();
        Node<E> hjelp = hode;
        while (hjelp != null)
        {
            kopi.settInnForrest(hjelp.element);
            hjelp = hjelp.neste;
        }
        return kopi;
    }

    //reverserer nodenes rekkefølge
    public void reverser()
    {
        hode = ((KjedetListe) reversertKopi()).hode;
    }

    //returnerer en array som inneholder alle elementene i lista,
//i samme rekkefølge som de har i lista
    public E[] tilArray(E[] resultat)
    {
        int antall = 0;
        Node<E> hjelp = hode;
        while (hjelp != null)
        {
            antall++;
            hjelp = hjelp.neste;
        }
        E[] array = (E[]) Array.newInstance(
                resultat.getClass().getComponentType(), antall);
        hjelp = hode;
        int indeks = 0;
        while (hjelp != null)
        {
            array[indeks++] = hjelp.element;
            hjelp = hjelp.neste;
        }
        return array;
    }

    private static class Node<E> implements Serializable
    {
        E element;
        Node<E> neste;

        public Node(E e)
        {
            element = e;
        }
    }
}
