package syntaxanalyzer;

public class Rule24 implements Node{
    Token token1;
    Rule25 rule25;
    
    public Rule24(Token t1, Rule25 r25)
    {
        this.token1 = t1;
        this.rule25 = r25;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 24");
    }
}
