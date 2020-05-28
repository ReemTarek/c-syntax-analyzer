package syntaxanalyzer;

class Rule27 implements Node{
    Token token1;
    Token token2;
    Rule_expr rule_expr;
    Token token3;
    Token token4;
    public Rule27(Token t1, Token t2, Rule_expr re, Token t3, Token t4)
    {
        this.token1 = t1;
        this.token2 = t2;
        this.rule_expr = re;
        this.token3 = t3;
        this.token4 = t4;
    }
    @Override
    public void printNode()
    {
     System.out.println("rule 27");   
    }
}
