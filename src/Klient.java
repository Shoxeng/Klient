

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Klient implements Serializable {
    private static final long serialVersionUID = -7887612267521882048L;
    private String imie;
    private String nazwisko;
    private String mail;
    private String telefon;
    private HashMap<Seans, ArrayList<Miejsce>> miejsca;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Klient(String imie, String nazwisko, String mail, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.telefon = telefon;
        miejsca = new HashMap<Seans, ArrayList<Miejsce>>();
    }
    public String toString() {
        return "\nImie: " + getImie() +
                "\nNazwisko: " + getNazwisko() +
                "\nMail: " + getMail() +
                "\nTelefon: " + getTelefon();
    }

    public void kupBilet(Seans s, char rzad, int kolumna) {
        if (s.getElement(rzad, kolumna) == true)
            System.out.println("\nMiejsce niedostepne");
        else {
            s.addElement(rzad, kolumna, true);
            System.out.println("\nKupiono bilet na seans " + s.getTytul() + ", w rzedzie " + rzad + ", nr. miejsca: " + kolumna);
            Miejsce n = new Miejsce(rzad, kolumna);
            if (!miejsca.containsKey(s)) {
                ArrayList<Miejsce> lista = new ArrayList<Miejsce>();
                miejsca.put(s, lista);
                miejsca.get(s).add(n);
            } else {
                miejsca.get(s).add(n);
            }
        }
    }

    public void pokazSeanse() {
        Set<Seans> seanse = miejsca.keySet();
        for (Seans s : seanse) {
            System.out.println(s.getTytul() + " " + s.getDzien() + " " + s.getGodzina() + " ");
        }
    }

    public void pokazMiejsca() {
        Set<Seans> seanse = miejsca.keySet();
        ArrayList<Miejsce> _miejsca;
        for (Seans s : seanse) {
            System.out.print(s.getTytul() + " " + s.getDzien() + " " + s.getGodzina() + " ");
            _miejsca = miejsca.get(s);
            for (Miejsce miejsce : _miejsca) {
                System.out.print(miejsce.toString() + " ");
            }
            System.out.print("\n");
        }
    }

    public void pokazMiejsca(Seans s) {
        System.out.print(s.getTytul() + " " + s.getDzien() + " " + s.getGodzina() + " ");
        ArrayList<Miejsce> _miejsca = new ArrayList<Miejsce>();
        _miejsca = miejsca.get(s);
        for (Miejsce miejsce : _miejsca) {
            System.out.print(miejsce.toString() + " ");
        }
        System.out.print("\n");
    }
}