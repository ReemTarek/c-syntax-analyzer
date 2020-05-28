package syntaxanalyzer;

public class Rule25 implements Node{
    Token token1;
    Rule28 rule28;
    Token token2;
    Rule16 rule16;
    Token token3;
    
    public Rule25(Token t1, Rule28 r28, Token t2, Rule16 r16, Token t3)
    {
        this.token1 = t1;
        this.rule28 = r28;
        this.token2 = t2;
        this.rule16 = r16;
        this.token3 = t3;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 25");
    }
    
}
