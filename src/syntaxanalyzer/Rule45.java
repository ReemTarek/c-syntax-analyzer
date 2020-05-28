package syntaxanalyzer;

class Rule45 implements Node{
    Token token1;
    Rule_expr rule_expr;
    Rule45 rule45;
    
    public Rule45(Token t1, Rule_expr re, Rule45 r45)
    {
        this.token1 = t1;
        this.rule_expr = re;
        this.rule45 = r45;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 45");
    }
}
