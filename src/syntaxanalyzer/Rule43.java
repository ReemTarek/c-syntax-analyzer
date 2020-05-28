package syntaxanalyzer;

class Rule43 implements Node{
    Token token1;
    Token token2;
    Token token3;
    Token token4;
    Token token5;
    Token token6;
    Rule_expr rule_expr;
    Token token7;
    
    public Rule43(Token t1, Token t2, Token t3, Token t4, Token t5, Token t6, Rule_expr re, Token t7)
    {
        this.token1 = t1;
        this.token2 = t2;
        this.token3 = t3;
        this.token4 = t4;
        this.token5 = t5;
        this.token6 = t6;
        this.rule_expr = re;
        this.token7 = t7;
    }
        
    @Override
    public void printNode()
    {
        System.out.println("rule 43");
    }
}   
