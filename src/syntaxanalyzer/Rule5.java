package syntaxanalyzer;

public class Rule5 implements Node{
    Token token1;
    Token token2;
    
    public Rule5(Token t1, Token t2)
    {
        this.token1 = t1;
        this.token2 = t2;
    }
    
    @Override
    public void printNode()
    {System.out.println("rule 5");
        
    }
}
