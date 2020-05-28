package syntaxanalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AmbiguityRemoving {

    private ArrayList<String> leftHandSide = new ArrayList();
    private ArrayList<String> rightHandSide = new ArrayList();

    private AmbiguityRemoving readGrammar(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        AmbiguityRemoving obj = new AmbiguityRemoving();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\-->");
            obj.leftHandSide.add(parts[0]);
            obj.rightHandSide.add(parts[1]);
        }
        br.close();
        return obj;
    }

    class RecursionState {

        boolean is_leftRecursion = false;
        String[] part;
    }

    class FactoringState {

        boolean is_leftFactoring = false;
        String[] part;
        int position = -1;
    }

    public void leftFactoring() throws IOException {
        File file = new File("finalGrammar.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        AmbiguityRemoving obj = readGrammar("editedGrammar.txt");
        for (int i = 0; i < obj.leftHandSide.size(); i++) {
            String newNonTerm = obj.leftHandSide.get(i) + "'";
            ArrayList<FactoringState> factoringState = checkFactoring(obj.leftHandSide.get(i), obj.rightHandSide.get(i));
            boolean is_lF = checkLineLF(factoringState);
            if (is_lF) {
                ArrayList<String> newGrammar = solveLeftFactoring(0, factoringState, newNonTerm, "", "");
                int position = factoringState.get(0).position;
                bw.write(obj.leftHandSide.get(i) + "-->" + factoringState.get(position).part[0] + " " + newNonTerm + newGrammar.get(1));
                bw.newLine();
                bw.write(newNonTerm + "-->" + newGrammar.get(0));
                bw.newLine();
                
//                factoringState = checkFactoring(newNonTerm, newGrammar.get(0));
//                is_lF = checkLineLF(factoringState);
//                
//                while(is_lF)
//                {
//                    newGrammar = solveLeftFactoring(0, factoringState, newNonTerm + "'", "", "");
//                    position = factoringState.get(0).position;
//                    bw.write(newNonTerm + "-->" + factoringState.get(position).part[0] + newNonTerm + "'" + newGrammar.get(1));
//                    bw.newLine();
//                    bw.write(newNonTerm + "'" + "-->" + newGrammar.get(0));
//                    bw.newLine();
//                    newNonTerm += "'";
//                    factoringState = checkFactoring(newNonTerm, newGrammar.get(0));
//                    is_lF = checkLineLF(factoringState);
//                }
            }
            if (!is_lF) {
                bw.write(obj.leftHandSide.get(i) + "-->" + obj.rightHandSide.get(i));
                bw.newLine();
            }
        }
        bw.close();
        //removeDuplicate("finalGrammar.txt");
    }

    public void leftRecursion() throws IOException {
        File file = new File("editedGrammar.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        AmbiguityRemoving obj = readGrammar("grammar.txt");
        for (int i = 0; i < obj.leftHandSide.size(); i++) {
            String newNonTerm = obj.leftHandSide.get(i) + "'";
            ArrayList<RecursionState> recursionState = checkRecursion(obj.leftHandSide.get(i), obj.rightHandSide.get(i));
            boolean is_lR = checkLineLR(recursionState);
            if (is_lR) {
                ArrayList<String> newGrammar = solveLeftRecursion(0, recursionState, newNonTerm, "", "");
                bw.write(obj.leftHandSide.get(i) + "-->" + newGrammar.get(0));
                bw.newLine();
                bw.write(newNonTerm + "-->" + newGrammar.get(1));
                bw.newLine();
            } else {
                bw.write(obj.leftHandSide.get(i) + "-->" + obj.rightHandSide.get(i));
                bw.newLine();
            }
        }
        bw.close();
    }

    private ArrayList<String> solveLeftFactoring(int i, ArrayList<FactoringState> factState, String newNT, String lF, String notLF) {
        if (i >= factState.size()) {
            if (notLF.length() > 0) {
                notLF = notLF.substring(0, notLF.length() - 1);
            }
            if (lF.length() > 0) {
                lF = lF.substring(0, lF.length() - 1);
            }

            ArrayList<String> newGrammar = new ArrayList();
            newGrammar.add(lF);
            newGrammar.add(notLF);
            return newGrammar;
        }
        if (factState.get(i).is_leftFactoring) {
            String p = concatenateString(factState.get(i).part, 1);
            lF += p + "|";
        } else {
            String p = concatenateString(factState.get(i).part, 0);
            notLF += p + "|";
        }
        i++;
        return solveLeftFactoring(i, factState, newNT, lF, notLF);
    }

    private ArrayList<String> solveLeftRecursion(int i, ArrayList<RecursionState> recState, String newNT, String lR, String notLR) {
        if (i >= recState.size()) {
            if (notLR.length() <= 0) {
                notLR += newNT;
            } else {
                notLR = notLR.substring(0, notLR.length() - 1);
            }
            if (lR.length() > 0) {
                lR += "e";
            }

            ArrayList<String> newGrammar = new ArrayList();
            newGrammar.add(notLR);
            newGrammar.add(lR);
            return newGrammar;
        }
        if (recState.get(i).is_leftRecursion) {
            String p = concatenateString(recState.get(i).part, 1);
            lR += p + newNT + "|";
        } else {
            String p = concatenateString(recState.get(i).part, 0);
            notLR += p + newNT + "|";
        }
        i++;
        return solveLeftRecursion(i, recState, newNT, lR, notLR);
    }

    private boolean checkLineLF(ArrayList<FactoringState> factState) {
        boolean is_lF = false;
        for (int i = 0; i < factState.size(); i++) {
            if (factState.get(i).is_leftFactoring) {
                is_lF = true;
                break;
            }
        }
        return is_lF;
    }

    private boolean checkLineLR(ArrayList<RecursionState> recState) {
        boolean is_lR = false;
        for (int i = 0; i < recState.size(); i++) {
            if (recState.get(i).is_leftRecursion) {
                is_lR = true;
                break;
            }
        }
        return is_lR;
    }

    private String concatenateString(String[] str, int index) {
        String p = "";
        while (index < str.length) {
            p += str[index] + " ";
            index++;
        }
        return p;
    }

    private ArrayList<FactoringState> checkFactoring(String left, String right) {
        ArrayList<FactoringState> factoringState = new ArrayList();
        ArrayList<String[]> splitedRight = splitRight(right);
        String common = "";
        for (int i = 0; i < splitedRight.size(); i++)
        {
            for(int j = i+1; j<splitedRight.size(); j++)
            {
                FactoringState obj = new FactoringState();
                obj.part = splitedRight.get(i);
                if (splitedRight.get(i)[0].equals(splitedRight.get(j)[0])) {
                    common = splitedRight.get(i)[0];
                    obj.is_leftFactoring = true;
                    obj.position++;
                }
                factoringState.add(obj);
            }
            if(i == splitedRight.size() - 1 && splitedRight.get(i)[0].equals(common))
            {
                FactoringState obj = new FactoringState();
                obj.part = splitedRight.get(i);
                obj.is_leftFactoring = true;
                    obj.position++;
                factoringState.add(obj);
            }
        }
        return factoringState;
    }

    private ArrayList<RecursionState> checkRecursion(String left, String right) {
        ArrayList<RecursionState> recursionState = new ArrayList();
        ArrayList<String[]> splitedRight = splitRight(right);

        for (int i = 0; i < splitedRight.size(); i++) {
            RecursionState obj = new RecursionState();
            obj.part = splitedRight.get(i);
            if (splitedRight.get(i)[0].equals(left)) {
                obj.is_leftRecursion = true;
            }
            recursionState.add(obj);
        }
        return recursionState;
    }

    private ArrayList<String[]> splitRight(String right) {
        String[] splitByOrArr = right.split("\\|");
        ArrayList<String[]> splitByOr = new ArrayList();
        for (int i = 0; i < splitByOrArr.length; i++) {
            splitByOr.add(splitByOrArr[i].split(" "));
        }
        return splitByOr;
    }
    
    private void removeDuplicate(String fileName) throws IOException
    {
        File file = new File(fileName);
        if(!file.exists())
            file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        ArrayList<String> data = new ArrayList();
        while((line = br.readLine()) != null)
        {
            data.add(line);
        }
        br.close();
        for(int i=0; i<data.size(); i++)
        {
            for(int j=i; j<data.size(); j++)
            {
                if(data.get(i).equals(data.get(j)))
                    data.remove(j);
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("");
        for(int i=0; i<data.size(); i++)
        {
            bw.write(data.get(i));
            bw.newLine();
        }
        bw.close();
    }
}