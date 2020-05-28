package syntaxanalyzer;

public class Rule28 implements Node{
    Rule_expr_dash rule_expr_dash;
    
    public Rule28(Rule_expr_dash red)
    {
        this.rule_expr_dash = red;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 28");
    }
}
