

import java.io.Serializable;

public class Miejsce implements Serializable {
    private static final long serialVersionUID = 2906642554793891381L;
    char rzad;
    int kolumna;

    Miejsce(char rzad, int kolumna){
        this.rzad = rzad;
        this.kolumna = kolumna;
    }

    public String toString() {
        return "[" + rzad + kolumna + "]";
    }
}