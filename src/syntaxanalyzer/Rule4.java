package syntaxanalyzer;

public class Rule4 implements Node{
    Rule5 rule5;
    Rule8 rule8;
    
    public Rule4(Rule5 r5, Rule8 r8)
    {
        this.rule5 = r5;
        this.rule8 = r8;
    }
    
    @Override
    public void printNode()
    {
       System.out.println("rule 4"); 
    }
}
