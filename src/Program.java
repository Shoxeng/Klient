

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Klient klient1 = new Klient("Janusz", "Cebula", "janusz123@wp.pl", "123456679");
        Klient klient2 = new Klient("Pawel", "Pol", "pablito123@wp.pl", "123456679");
        Klient klient3 = new Klient("Tomasz", "Kop", "tomek123@wp.pl", "123456679");
        Klient klient4 = new Klient("Beata", "Hala", "janusz123@wp.pl", "123456679");
        Klient klient5 = new Klient("Agata", "Gala", "janusz123@wp.pl", "123456679");

        Seans seans1 = new Seans("Gwiezdne Wojny", LocalDate.of(2022, 10, 30), LocalTime.of(20,0), 6, 10, 20);
        Seans seans2 = new Seans("Hobbit", LocalDate.of(2022, 10, 26), LocalTime.of(19,15), 12, 6, 15);

        System.out.println(klient1);
        System.out.println(seans1);

        klient1.kupBilet(seans1,'B', 2);
        klient1.kupBilet(seans1,'B', 2);
        klient1.kupBilet(seans1,'A', 2);
        klient1.kupBilet(seans1,'K', 2);
        klient1.kupBilet(seans1,'K', 2);
        klient1.kupBilet(seans2,'K', 2);
        klient1.kupBilet(seans2,'K', 2);
        klient1.kupBilet(seans2,'E', 10);
        klient1.kupBilet(seans2,'E', 11);

        klient2.kupBilet(seans1,'G', 9);
        klient2.kupBilet(seans1,'G', 10);
        klient2.kupBilet(seans1,'G', 11);
        klient2.kupBilet(seans2,'D', 1);
        klient2.kupBilet(seans2,'D', 4);
        klient2.kupBilet(seans2,'D', 15);

        klient3.kupBilet(seans2,'C', 7);
        klient3.kupBilet(seans2,'C', 7);
        klient3.kupBilet(seans2,'C', 8);
        klient3.kupBilet(seans2,'C', 9);
        klient3.kupBilet(seans2,'D', 1);

        klient4.kupBilet(seans1,'H', 10);
        klient4.kupBilet(seans1,'H', 9);
        klient4.kupBilet(seans2,'B', 1);
        klient4.kupBilet(seans2,'B', 3);

        klient5.kupBilet(seans2,'F', 4);
        klient5.kupBilet(seans1,'F', 4);

        System.out.println();
        seans1.pokazMiejsca();
        System.out.println();
        seans2.pokazMiejsca();

        System.out.println();
        klient1.pokazSeanse();

        System.out.println();
        klient1.pokazMiejsca();

        System.out.println();
        klient1.pokazMiejsca(seans1);

        ObjectOutputStream datOut = new ObjectOutputStream(new FileOutputStream(".\\dane.dat"));
        datOut.writeObject(klient1);
        datOut.writeObject(seans2);
        datOut.close();

        ObjectInputStream datIn = new ObjectInputStream(new FileInputStream(".\\dane.dat"));
        Klient klientZapisany = (Klient) datIn.readObject();
        Seans seansZapisany = (Seans) datIn.readObject();
        datIn.close();

        System.out.println(klientZapisany);
        System.out.println(seansZapisany);

        FileWriter fileOut = new FileWriter("output.txt");
        BufferedWriter txtOut = new BufferedWriter(fileOut);
        txtOut.write(klientZapisany.toString());
        txtOut.write("\n");
        txtOut.write(seansZapisany.toString());
        txtOut.close();

        FileInputStream fileIn = new FileInputStream("output.txt");
        DataInputStream txtIn = new DataInputStream(fileIn);
        BufferedReader read = new BufferedReader(new InputStreamReader(txtIn));
        String dane = "";
        String strLine = "";
        while ((strLine = read.readLine()) != null)
            dane += strLine + "\n";
        txtIn.close();

        System.out.println(dane);
    }
}