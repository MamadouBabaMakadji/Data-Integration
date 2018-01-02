package data.integration.request;

public class Request {

    // Le nombre d'étudiants en provenance de France
    public static final String R1 = "select count (*) " +
            "from Etudiant " +
            "where Provenance = 'France' ";

    // Les étudiants inscrits au cours d'intégration de données (ID)
    public static final String R2 = "select Nom " +
            "from Etudiant E, Cours C, Inscription I " +
            "where E.ID-Etudiant = I.ID-Etudiant " +
            "and C.ID-Cours = I.ID-Cours " +
            "and C.Libele =  'ID' ";

    // Le nom des enseignants qui enseignent le cours de SGBD
    public static final String R3 = "select Nom " +
            "from Enseignant En, Cours C, Enseigne E " +
            "where EN.ID-Enseignant = E.ID-Enseignant " +
            "and C.ID-Cours = E.ID-Cours " +
            "and C.Libele = 'SGBD' ";

    // LES TRADUCTIONS POUR LA SOURCE 2
    public static final String S2_R1 = "select count(*) as result " +
            "from Etudiant " +
            "where Provenance = 'fr' ";

    public static final String S2_R2 = "select distinct E.nom as result " +
            "from etudiant E, cours C, inscription I " +
            "where E.ID_etudiant = I.NumEt " +
            "and C.NumCours = I.NumCours " +
            "and C.libele =  'ID' ";

    public static final String S2_R3 = "select distinct En.nom as result " +
            "from enseignant En, cours C, enseigne E " +
            "where EN.ID_ens = E.NumEns " +
            "and C.NumCours = E.NumCours " +
            "and C.libele = 'SGBD' ";
}
