package syntaxanalyzer;

public class Rule_expr_dash implements Node{
    Rule29 rule29;
    Rule31 rule31;
    Rule33 rule33;
    Rule35 rule35;
    Rule37 rule37;
    Rule39 rule39;
    
    public Rule_expr_dash(Rule29 r29, Rule31 r31, Rule33 r33, Rule35 r35, Rule37 r37, Rule39 r39)
    {
        this.rule29 = r29;
        this.rule31 = r31;
        this.rule33 = r33;
        this.rule35 = r35;
        this.rule37 = r37;
        this.rule39 = r39;
    }
    @Override
    public void printNode()
    {
        
    }
}
