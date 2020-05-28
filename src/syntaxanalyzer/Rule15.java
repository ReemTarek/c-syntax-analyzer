package syntaxanalyzer;

public class Rule15 implements Node{
    Rule16 rule16;
    Rule15 rule15;
    
    public Rule15(Rule16 r16, Rule15 r15)
    {
        this.rule16 = r16;
        this.rule15 = r15;
    }
    
    @Override
    public void printNode()
    {
     System.out.println("rule 15");   
    }
}
