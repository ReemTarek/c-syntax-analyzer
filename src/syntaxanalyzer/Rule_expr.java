package syntaxanalyzer;

public class Rule_expr implements Node{
    Rule27 rule27;
    Rule28 rule28;
    Rule40 rule40;
    Rule41 rule41;
    Rule42 rule42;
    Rule43 rule43;

    public Rule_expr(Rule27 r27, Rule28 r28, Rule40 r40, Rule41 r41, Rule42 r42, Rule43 r43)
    {
        this.rule27 = r27;
        this.rule28 = r28;
        this.rule40 = r40;
        this.rule41 = r41;
        this.rule42 = r42;
        this.rule43 = r43;
    }
    
    @Override
    public void printNode()
    {
        
    }
}
