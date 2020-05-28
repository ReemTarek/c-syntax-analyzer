package syntaxanalyzer;

public class Rule10 implements Node{
    Rule12 rule12;
    Rule11 rule11;
    
    public Rule10(Rule12 r12, Rule11 r11)
    {
        this.rule12 = r12;
        this.rule11 = r11;
    }
    
    @Override
    public void printNode()
    {
     System.out.println("rule 10");   
    }
}
