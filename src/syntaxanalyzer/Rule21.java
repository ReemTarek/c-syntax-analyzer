package syntaxanalyzer;

public class Rule21 implements Node{
    Rule22 rule22;
    Rule21 rule21;
    
    public Rule21(Rule22 r22, Rule21 r21)
    {
        this.rule22 = r22;
        this.rule21 = r21;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 21");
    }
}
