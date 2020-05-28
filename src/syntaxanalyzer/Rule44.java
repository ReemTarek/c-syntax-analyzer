package syntaxanalyzer;

class Rule44 implements Node{
    Rule_expr rule_expr;
    Rule45 rule45;
    
    public Rule44(Rule_expr re, Rule45 r45)
    {
        this.rule_expr = re;
        this.rule45 = r45;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 44");
    }
    
}
