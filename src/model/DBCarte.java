package model;

import java.util.HashMap;
import java.util.Set;
import java.io.Serializable;

@SuppressWarnings("unchecked")
public class DBCarte implements Serializable {

    private static final long serialVersionUID = 1L; // Versione della serializzazione

    public static final String DATABASE_PATH = "log/carteDatabase.dat";

    private static HashMap<String, Carta> carte;

    static {
        // Inizializza il database al caricamento della classe
        carte = (HashMap<String, Carta>) GestioneFile.caricaDB(DATABASE_PATH);
        if (carte == null) {
            carte = new HashMap<String, Carta>();
        }
    }

    public static void aggiornaDB() {
        GestioneFile.salvaDB(carte, DATABASE_PATH);
    }

    public static Set<String> getCarte() {
        return carte.keySet();
    }

    public static HashMap<String, Carta> Carte() {
        return carte;
    }

    public static Carta getCarta(String nomeCarta) {
        return carte.get(nomeCarta);
    }

    public static void aggiungiCarta(Carta carta) {
        carte.put(carta.getNome(), carta);
        aggiornaDB();
    }

    public static void eliminaCarta(String nomeCarta) {
        carte.remove(nomeCarta);
        aggiornaDB();
    }
}
