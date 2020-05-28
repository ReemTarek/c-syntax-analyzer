package syntaxanalyzer;

public class Rule8 implements Node{
    Token token1;
    Token token2;
    Token token3;
    Rule9 rule9;
    Token token4;
    Rule19 rule19;
    
    public Rule8(Token t1, Token t2, Token t3, Rule9 r9, Token t4, Rule19 r19)
    {
        this.token1 = t1;
        this.token2 = t2;
        this.token3 = t3;
        this.rule9 = r9;
        this.token4 = t4;
        this.rule19 = r19;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 8");
    }
}
