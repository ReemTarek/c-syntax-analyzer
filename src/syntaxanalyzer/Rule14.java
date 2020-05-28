package syntaxanalyzer;

public class Rule14 implements Node{
    Rule15 rule15;
    
    public Rule14(Rule15 r15)
    {
        this.rule15 = r15;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 14");
    }
}
