package syntaxanalyzer;

public class Rule16 implements Node{
    Rule17 rule17;
    Rule19 rule19;
    Rule24 rule24;
    Rule18 rule18;
    Rule26 rule26;
    Token token1;
    
    public Rule16(Rule17 r17, Rule19 r19, Rule24 r24, Rule18 r18, Rule26 r26, Token t1)
    {
        this.rule17 = r17;
        this.rule19 = r19;
        this.rule24 = r24;
        this.rule18 = r18;
        this.rule26 = r26;
        this.token1 = t1;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 16");
    }
}
