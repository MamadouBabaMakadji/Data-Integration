package data.integration.mediator;

import data.integration.extractor.Source1ExtractorImpl;
import data.integration.extractor.Source2ExtractorImpl;
import data.integration.extractor.Source3ExtractorImpl;

import java.util.ArrayList;

public class Mediator {

    Source1ExtractorImpl extractorS1 = new Source1ExtractorImpl();
    Source2ExtractorImpl extractorS2 = new Source2ExtractorImpl();
    Source3ExtractorImpl extractorS3 = new Source3ExtractorImpl();

    public int globalResultR1(){
        int resultOfS1 = extractorS1.extractResultR1();
        int resultOfS2 = extractorS2.extractResultR1();
        int resultOfS3 = extractorS3.extractResultR1();
        int globalResult = resultOfS1 + resultOfS2 + resultOfS3;

        return  globalResult;
    }

    public ArrayList<String> globalResultR2(){
        ArrayList<String> globalResult = new ArrayList<String>();
        ArrayList<String> resultOfS1 = extractorS1.extractResultR2();
        ArrayList<String> resultOfS2 = extractorS2.extractResultR2();
        //ArrayList<String> resultOfS3 = extractorS3.extractResultR2();
        for (int i = 0; i<resultOfS1.size(); i++){
            globalResult.add(resultOfS1.get(i));
        }
        for (int j = 0; j<resultOfS2.size(); j++){
            globalResult.add(resultOfS2.get(j));
        }
        /*for (int k = 0; k<resultOfS3.size(); k++){
            globalResult.add(resultOfS3.get(k));
        }*/
        if(globalResult.isEmpty()){
            globalResult.add("La requête renvoie un résultat vide");
            return globalResult;
        }else {
            return globalResult;
        }
    }

    public ArrayList<String> globalResultR3(){
        ArrayList<String> globalResult = new ArrayList<String>();
        ArrayList<String> resultOfS1 = extractorS1.extractResultR3();
        ArrayList<String> resultOfS2 = extractorS2.extractResultR3();
        //ArrayList<String> resultOfS3 = extractorS3.extractResultR3();
        for (int i = 0; i<resultOfS1.size(); i++){
            globalResult.add(resultOfS1.get(i));
        }
        for (int j = 0; j<resultOfS2.size(); j++){
            globalResult.add(resultOfS2.get(j));
        }
        /*for (int k = 0; k<resultOfS3.size(); k++){
            globalResult.add(resultOfS3.get(k));
        }*/
        if(globalResult.isEmpty()){
            globalResult.add("La requête renvoie un résultat vide");
            return globalResult;
        }else {
            return globalResult;
        }
    }
}
