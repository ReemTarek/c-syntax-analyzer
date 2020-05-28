package syntaxanalyzer;

public class Rule17 implements Node{
    Rule_expr rule_expr;
    Token token1;
    
    public Rule17(Rule_expr re, Token t1)
    {
        this.rule_expr = re;
        this.token1 = t1;
    }
    
    @Override
    public void printNode()
    {
       System.out.println("rule 17"); 
    }
}
