package syntaxanalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

public class SyntaxAnalyzer {

    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String targetCode = "";
        String line = "";
        while ((line = br.readLine()) != null) {
            targetCode += line + "\n";
        }
        br.close();
        AmbiguityRemoving obj = new AmbiguityRemoving();
        obj.leftRecursion();
        obj.leftFactoring();
        //Token t = new Token();
        //Queue<Token> queue =t.readTokens("input.txt"); 
        Parser p = new Parser();
        p.getTokens("input.txt");
        Rule1 root = p.program();
        root.printNode();
    }
}
