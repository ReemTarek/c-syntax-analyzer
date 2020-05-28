package syntaxanalyzer;

public class Rule3 implements Node{
    Rule4 rule4;
    Rule3 rule3;
    
    public Rule3(Rule4 r4, Rule3 r3)
    {
        this.rule4 = r4;
        this.rule3 = r3;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 3");
    }
}
