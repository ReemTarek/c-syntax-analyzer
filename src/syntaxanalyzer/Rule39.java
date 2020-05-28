package syntaxanalyzer;

class Rule39 implements Node{
    Token token1;
    Rule_expr rule_expr;
    Rule_expr_dash rule_expr_dash;
    Token token2;
    Token token3;
    
    public Rule39(Token t1, Rule_expr re, Rule_expr_dash red, Token t2, Token t3)
    {
        this.token1 = t1;
        this.rule_expr = re;
        this.rule_expr_dash = red;
        this.token2 = t2;
        this.token3 = t3;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 39");
    }        
}
