package syntaxanalyzer;

public class Rule20 implements Node{
    Rule21 rule21;
    
    public Rule20(Rule21 r21)
    {
        this.rule21 = r21;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 20");
    }
}
