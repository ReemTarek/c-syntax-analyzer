package syntaxanalyzer;

class Rule29 implements Node{
    Token token1;
    Rule_expr rule_expr;
    Rule_expr_dash rule_expr_dash;
    
    public Rule29(Token t1, Rule_expr re, Rule_expr_dash red)
    {
        this.token1 = t1;
        this.rule_expr = re;
        this.rule_expr_dash = red;
    }
    
    @Override
    public void printNode()
    {
     System.out.println("rule 28");   
    }
}
