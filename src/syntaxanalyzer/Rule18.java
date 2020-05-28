package syntaxanalyzer;

public class Rule18 implements Node{
    Token token1;
    Token token2;
    Rule28 rule28;
    Token token3;
    Rule16 rule16;
    
    public Rule18(Token t1, Token t2, Rule28 r28, Token t3, Rule16 r16)
    {
        this.token1 = t1;
        this.token2 = t2;
        this.rule28 = r28;
        this.token3 = t3;
        this.rule16 = r16;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 18");
    }
}
