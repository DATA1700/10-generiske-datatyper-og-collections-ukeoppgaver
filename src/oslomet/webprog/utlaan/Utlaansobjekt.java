package oslomet.webprog.utlaan;

//Utlaansobjekt.java
import java.util.Date;

//abstrakt klasse som inneholder datafelter og metoder
//som alle utlånsobjekter skal ha
abstract class Utlaansobjekt
{
    private Date inn; //definert i java.util
    private int laanetid;
    private boolean ute = false;
    private String tittel;

    public Utlaansobjekt(int tid, String t)
    {
        laanetid = tid;
        tittel = t;
    }

    //redefinerer som abstrakt toString-metode arvet fra klasse Object
    abstract public String toString(); //obs: ingen implementasjon.
//skal returnere relevante data.
//Må implementeres i ikke-abstrakte subklasser.

    //abstrakt metode for innlevering
    abstract public void returner();

    //abstrakt metode for utlån fra dato d
    abstract public void laanUt( Date d );

    //abstrakt metode for utskrift av info
    abstract public String ventetid();

    public String getTittel()
    {
        return tittel;
    }

//andre nødvendige set- og get-metoder

} //slutt på klasse Utlaansobjekt


//Klassedefinisjon for utlånsobjekt av type bok.
//Må implementere alle abstrakte metoder som blir
//arvet fra superklassen
class Bok extends Utlaansobjekt
{
    private String forfatter;

    public Bok( String f, String t, int p )
    {
        super( p, t );
        forfatter = f;
    }

    public String toString()
    {
        return forfatter + ": " + getTittel();
    }

    public void returner()
    {
//implementasjon av arvet abstrakt metode
    }

    public void laanUt( Date d )
{
//implementasjon av arvet abstrakt metode
}

    public String ventetid()
    {
        String output = "";
//implementasjon av arvet abstrakt metode
        return output;
    }
} //slutt på klasse Bok


//abstrakt klasse som inneholder det som alle utlånsobjekter
//av type cd og dvd skal ha felles i tillegg til
// det som blir arvet fra superklassen Utlaansobjekt
abstract class AV extends Utlaansobjekt
{
    private int spilletid;

    public AV( int t, int p, String tt )
    {
        super( p, tt );
        spilletid = t;
    }

    public String toString()
    {
        return "Tittel: " + getTittel() + "\nSpilletid: " + spilletid;
    }

    public void laanUt( Date d )
{
//implementasjon av arvet abstrakt metode
}

    public void returner()
    {
//implementasjon av arvet abstrakt metode
    }

//Arvet abstrakt metode ventetid er ikke implementert.
//AV er derfor en abstrakt klasse og må spesifiseres som
//abstrakt med nøkkelordet abstract.
} //slutt på klasse AV


//Klassedefinisjon for utlånsobjekt av type cd.
//Må implementere alle abstrakte metoder som den arver.
class CD extends AV
{
    private String artist;
    private String verk;

    public CD( String a, String v, int spt, int lt, String tt )
    {
        super( spt, lt, tt );
        artist = a;
        verk = v;
    }

    public String toString()
    {
        return artist + ": " + verk + " " + super.toString();
    }

    public String ventetid()
    {
        String output = "";
//implementasjon av arvet abstrakt metode
        return output;
    }
} //slutt på klasse CD


//Klassedefinisjon for utlånsobjekt av type dvd.
//Må implementere alle abstrakte metoder som den arver.
class DVD extends AV
{
    protected String produksjonsland;

    public DVD( String t, String land, int spt, int lt )
    {
        super( spt, lt, t );
        produksjonsland = land;
    }

    public String toString()
    {
        return super.toString() + "\nProduksjonsland: " + produksjonsland;
    }

    public String ventetid()
    {
        String output = "";
//implementasjon av arvet abstrakt metode
        return output;
    }
} //slutt på klasse DVD