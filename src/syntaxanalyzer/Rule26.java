package syntaxanalyzer;

public class Rule26 implements Node{
    Token token1;
    Token token2;
    Rule_expr rule_expr;
    
    public Rule26(Token t1, Token t2, Rule_expr re)
    {
        this.token1 = t1;
        this.token2 = t2;
        this.rule_expr = re;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 26");
    }
}
