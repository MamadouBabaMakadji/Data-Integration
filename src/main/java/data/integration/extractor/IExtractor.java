package data.integration.extractor;

import java.util.ArrayList;

public interface IExtractor {
    // Extrait le resultat de la premiere requete
    public int extractResultR1();
    // Extrait le resultat de la deuxieme requete
    public ArrayList<String> extractResultR2();
    // Extrait le resultat de la troisieme requete
    public ArrayList<String> extractResultR3();
}
