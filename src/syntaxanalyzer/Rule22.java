package syntaxanalyzer;

public class Rule22 implements Node{
    Token token1;
    Token token2;
    
    public Rule22(Token t1, Token t2)
    {
        this.token1 = t1;
        this.token2 = t2;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 22");
    }
}
