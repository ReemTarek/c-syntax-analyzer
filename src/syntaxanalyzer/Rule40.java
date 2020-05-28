package syntaxanalyzer;

class Rule40 implements Node{
    Token token1;
    Rule_expr rule_expr;
    Token token2;
    Token token3;
    
    public Rule40(Token t1, Rule_expr re, Token t2, Token t3)
    {
        this.token1 = t1;
        this.rule_expr = re;
        this.token2 = t2;
        this.token3 = t3;
    }
    
    @Override
    public void printNode()
    {
     System.out.println("rule 40");   
    }
}
