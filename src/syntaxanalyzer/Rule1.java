package syntaxanalyzer;

public class Rule1 implements Node{
    Rule2 rule2;
    
    public Rule1(Rule2 r2)
    {
        this.rule2 = r2;
    }
    
    @Override
    public void printNode()
    {
     System.out.println("rule 1");   
    }
}
