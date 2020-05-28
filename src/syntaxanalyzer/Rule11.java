package syntaxanalyzer;

public class Rule11 implements Node{
    Token token1;
    Rule12 rule12;
    Rule11 rule11;
    
    public Rule11(Token t1, Rule12 r12, Rule11 r11)
    {
        this.token1 = t1;
        this.rule12 = r12;
        this.rule11 = r11;
    }
    @Override
    public void printNode()
    {
     System.out.println("rule 11");   
    }
}
