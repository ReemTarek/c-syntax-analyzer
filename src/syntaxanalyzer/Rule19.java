package syntaxanalyzer;

public class Rule19 implements Node{
    Token token1;
    Rule20 rule20;
    Rule14 rule14;
    Token token2;
    
    public Rule19(Token t1, Rule20 r20, Rule14 r14, Token t2)
    {
        this.token1 = t1;
        this.rule20 = r20;
        this.rule14 = r14;
        this.token2 = t2;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 19");
    }
}
