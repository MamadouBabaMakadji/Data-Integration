package data.integration.main;

import data.integration.mediator.Mediator;
import data.integration.request.Request;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static void execute(){
        Mediator mediator = new Mediator();
        ArrayList<String> result = null;
        int nombre = 0;
        System.out.println("1 - Le nombre d'étudiants en provenance de France");
        System.out.println(Request.R1);
        System.out.println("2 - Nom des étudiants inscrits au cours d'intégration de données (ID)");
        System.out.println(Request.R2);
        System.out.println("3 - Nom des enseignants qui enseignent le cours de SGBD");
        System.out.println(Request.R3);
        System.out.println("*** Veuillez choisir la requête à exécuter ***");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        if(choix == 1){
            System.out.println("**** Le nombre d'étudiants en provenance de France ****");
            nombre = mediator.globalResultR1();
            System.out.println("* " + nombre);
        }
        if(choix == 2){
            System.out.println("**** Le Nom des étudiants inscrits au cours d'intégration de données (ID) ****");
            result = mediator.globalResultR2();
            for (int i = 0; i < result.size(); i++){
                System.out.println("* " + result.get(i));
            }
        }
        if(choix == 3){
            System.out.println("**** Le Nom des enseignants qui enseignent le cours de SGBD ****");
            result = mediator.globalResultR3();
            for (int i = 0; i < result.size(); i++){
                System.out.println("* " + result.get(i));
            }
        }
    }

    private static String choix(){
        System.out.println("\n Voulez-vous exécuter une requête ? OUI/NON");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();

        return choix;
    }

    public static void main(String[] args) {
        execute();
        String choix = choix();
        while("OUI".equalsIgnoreCase(choix)){
            execute();
            choix = choix();
        }
        System.exit(0);
    }
}
