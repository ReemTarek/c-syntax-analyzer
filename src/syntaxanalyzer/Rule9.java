package syntaxanalyzer;

public class Rule9 implements Node{
    Rule10 rule10;
    Token token1;
    
    public Rule9(Rule10 r10, Token t1)
    {
        this.rule10 = r10;
        this.token1 = t1;
    }
    
    public void printNode()
    {
      System.out.println("rule 9");  
    }
}
