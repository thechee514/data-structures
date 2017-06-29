public class ExpressionTests
{
    public static void main(String [] args) 
    {
        Testing.startTests();
        
        testOneOperator();
        testTwoOperators();
        testThreeOperators();
        testFourOperators();
        testFiveOperators();
	
        Testing.finishTests();
    }
	
    public static void testOneOperator()
    {
        Testing.testSection("Expressions with one operator");
	
        ExpressionTree e = new ExpressionTree("+56");
        Testing.assertEquals("+56 was input, prefix string should match", "+56", e.prefixString());
        Testing.assertEquals("+56 was input, infix string should be (5+6)", "(5+6)", e.infixString());
		
        e = new ExpressionTree("-23");
        Testing.assertEquals("-23 was input, prefix string should match", "-23", e.prefixString());
        Testing.assertEquals("-23 was input, infix string should be (2-3)", "(2-3)", e.infixString());
    }
	
    public static void testTwoOperators()
    {
        Testing.testSection("Expressions with two operators");
	
        ExpressionTree e = new ExpressionTree("/-123");
        Testing.assertEquals("/-123 was input, prefix string should match", "/-123", e.prefixString());
        Testing.assertEquals("/-123 was input, infix string should be ((1-2)/3)", "((1-2)/3)", e.infixString());
	
        e = new ExpressionTree("/1-23");
        Testing.assertEquals("/1-23 was input, prefix string should match", "/1-23", e.prefixString());
        Testing.assertEquals("/1-23 was input, infix string should be (1/(2-3))", "(1/(2-3))", e.infixString());
    }
    
    public static void testThreeOperators()
    {
        Testing.testSection("Expressions with three operators");
	
        ExpressionTree e = new ExpressionTree("*/-1234");
        Testing.assertEquals("*/-1234 was input, prefix string should match", "*/-1234", e.prefixString());
        Testing.assertEquals("*/-1234 was input, infix string should be (((1-2)/3)*4)", "(((1-2)/3)*4)", e.infixString());
	
        e = new ExpressionTree("*/1-234");
        Testing.assertEquals("*/1-234 was input, prefix string should match", "*/1-234", e.prefixString());
        Testing.assertEquals("*/1-234 was input, infix string should be ((1/(2-3))*4)", "((1/(2-3))*4)", e.infixString());
    }
    
    public static void testFourOperators()
    {
        Testing.testSection("Expressions with four operators");
	
        ExpressionTree e = new ExpressionTree("*/-+12345");
        Testing.assertEquals("*/-+12345 was input, prefix string should match", "*/-+12345", e.prefixString());
        Testing.assertEquals("*/-+12345 was input, infix string should be ((((1+2)-3)/4)*5)", "((((1+2)-3)/4)*5)", e.infixString());
	
        e = new ExpressionTree("*/-123+45");
        Testing.assertEquals("*/-123+45 was input, prefix string should match", "*/-123+45", e.prefixString());
        Testing.assertEquals("*/-123+45 was input, infix string should be (((1-2)/3)*(4+5))", "(((1-2)/3)*(4+5))", e.infixString());
    }
    
    public static void testFiveOperators()
    {
        Testing.testSection("Expressions with five operators");
	
        ExpressionTree e = new ExpressionTree("*/-+*123456");
        Testing.assertEquals("*/-+*123456 was input, prefix string should match", "*/-+*123456", e.prefixString());
        Testing.assertEquals("*/-+*123456 was input, infix string should be (((((1*2)+3)-4)/5)*6)", "(((((1*2)+3)-4)/5)*6)", e.infixString());
	
        e = new ExpressionTree("*/-12+34*56");
        Testing.assertEquals("*/-12+34*56 was input, prefix string should match", "*/-12+34*56", e.prefixString());
        Testing.assertEquals("*/-12+34*56 was input, infix string should be (((1-2)/(3+4))*(5*6))", "(((1-2)/(3+4))*(5*6))", e.infixString());
    }
}
