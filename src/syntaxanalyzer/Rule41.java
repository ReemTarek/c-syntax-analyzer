package syntaxanalyzer;

class Rule41 implements Node{
    Token token1;
    Rule_expr rule_expr;
    Token token2;
    
    public Rule41(Token t1, Rule_expr re, Token t2)
    {
        this.token1 = t1;
        this.rule_expr = re;
        this.token2 = t2;
    }
    
    public void printNode()
    {
       System.out.println("rule 41"); 
    }
}
