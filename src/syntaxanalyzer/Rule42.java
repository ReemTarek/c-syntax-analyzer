package syntaxanalyzer;

class Rule42 implements Node{
    Token token1;
    Token token2;
    Rule_expr rule_expr;
    Token token3;
    Token token4;
    Rule46 rule46;
    Token token5;
    Token token6;
    Token token7;
    
    public Rule42(Token t1, Token t2, Rule_expr re, Token t3, Token t4, Rule46 r46, Token t5, Token t6, Token t7)
    {
        this.token1 = t1;
        this.token2 = t2;
        this.rule_expr = re;
        this.token3 = t3;
        this.token4 = t4;
        this.rule46 = r46;
        this.token5 = t5;
        this.token6 = t6;
        this.token7 = t7;        
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 42");
    }
}
