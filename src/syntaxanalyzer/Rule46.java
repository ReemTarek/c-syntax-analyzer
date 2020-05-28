package syntaxanalyzer;

class Rule46 implements Node{
    Rule44 rule44;
    
    public Rule46(Rule44 r44)
    {
        this.rule44 = r44;
    }
    
    @Override
    public void printNode()
    {
        System.out.println("rule 46");
    }
}
