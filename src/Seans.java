

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Seans implements Serializable {
    private static final long serialVersionUID = 2906642554793891381L;
    private String tytul;
    private LocalDate dzien;
    private LocalTime godzina;
    private int ograniczeniaWiekowe;
    private HashMap<Character,HashMap<Integer,Boolean>> liczbaMiejsc;

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public LocalDate getDzien() {
        return dzien;
    }

    public void setDzien(LocalDate dzien) {
        this.dzien = dzien;
    }

    public LocalTime getGodzina() {
        return godzina;
    }

    public void setGodzina(LocalTime godzina) {
        this.godzina = godzina;
    }

    public int getOgraniczeniaWiekowe() {
        return ograniczeniaWiekowe;
    }

    public void setOgraniczeniaWiekowe(int ograniczeniaWiekowe) {
        this.ograniczeniaWiekowe = ograniczeniaWiekowe;
    }

    public HashMap<Character, HashMap<Integer, Boolean>> getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public Seans(String tytul, LocalDate dzien, LocalTime godzina, int ograniczeniaWiekowe, int rzedy, int kolumny) {
        this.tytul = tytul;
        this.dzien = dzien;
        this.godzina = godzina;
        this.ograniczeniaWiekowe = ograniczeniaWiekowe;
        liczbaMiejsc = new HashMap<>();

        for(char c = 'A'; c <= 64 + rzedy; c++) {
            for(int i = 1; i <= kolumny;i++) {
                addElement(c, i, false);
            }
        }
    }

    public String toString() {
        return "\nTytul: " + getTytul() +
                "\nDzien: " + getDzien() +
                "\nGodzina: " + getGodzina() +
                "\nOgraniczenia wiekowe: od " + getOgraniczeniaWiekowe() + " lat" +
                "\nLiczba miejsc na sali: " + liczbaMiejsc.size() * liczbaMiejsc.get('A').size();
    }
    public void pokazMiejsca () {
        boolean key;
        System.out.print("   ");
        for(int i = 1; i <= liczbaMiejsc.get('A').size();i++) {
            System.out.print("{"+i+"}");
        }
        System.out.print("\n");
        for(char i = 'A'; i <= liczbaMiejsc.size() + 64; i++) {
            System.out.print("{"+i+"}");
            for (int j = 1; j <= liczbaMiejsc.get(i).size(); j++) {
                key = getElement(i,j);
                if(key) {
                    System.out.print("[X]");
                }
                else {
                    System.out.print("[ ]");
                }
            }
            System.out.print("\n");
        }
    }

    public void addElement(Character key1, int key2, boolean value) {
        HashMap<Integer, Boolean> miejsce;
        miejsce=liczbaMiejsc.get(key1);
        if (miejsce==null) {
            miejsce = new HashMap<Integer, Boolean>();
            liczbaMiejsc.put(key1,miejsce);
        }
        miejsce.put(key2, value);
    }
    public boolean getElement(char key1, int key2) {
        HashMap<Integer, Boolean> miejsce;
        miejsce = liczbaMiejsc.get(key1);
        if (miejsce==null) {
            return true;
        }
        return miejsce.get(key2);
    }
}