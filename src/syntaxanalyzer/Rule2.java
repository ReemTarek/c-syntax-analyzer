package syntaxanalyzer;

public class Rule2 implements Node{
    Rule3 rule3;
    Rule4 rule4;
    
    public Rule2(Rule3 r3, Rule4 r4)
    {
        this.rule3 = r3;
        this.rule4 = r4;
    }
    
    @Override
    public void printNode()
    {
       System.out.println("rule 2"); 
    }
}
