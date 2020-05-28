package syntaxanalyzer;

class Rule31 implements Node{
    Token token1;
    Rule_expr rule_expr;
    Rule_expr_dash rule_expr_dash;
    Token token2;
    public Rule31(Token t1, Rule_expr re, Rule_expr_dash red, Token t2)
    {
        this.token1 = t1;
        this.rule_expr = re;
        this.rule_expr_dash = red;
        this.token2 = t2;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 31");
    }    
}
