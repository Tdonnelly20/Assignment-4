package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {
    
    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }
    
    //1. The following letters – M, C, X, and I – can each be repeated up to two times in a row.
    @Test
    public void test1_2Ms() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("MM");
        assertEquals(elbonianArabicConverter.toArabic(),2000);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test1_3Ms() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("MMM");
        int test = elbonianArabicConverter.toArabic();
    }
    
    @Test
    public void test1_2Cs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("CC");
        int test = elbonianArabicConverter.toArabic();
        assertEquals(test,200);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test1_3Cs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("CCC");
        int test = elbonianArabicConverter.toArabic();
    }
    
    @Test
    public void test1_2Xs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("XX");
        int test = elbonianArabicConverter.toArabic();
        assertEquals(test,20);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test1_3Xs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("XXX");
        int test = elbonianArabicConverter.toArabic();
    }
    
    @Test
    public void test1_2Is() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("II");
        int test = elbonianArabicConverter.toArabic();
        assertEquals(test,2);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test1_3Is() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("III");
        int test = elbonianArabicConverter.toArabic();
    }
    
    //2. The following letters – N, D, L, V – can each appear up to three times in a row
    @Test
    public void test2_3Ns() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("NNN");
        int test = elbonianArabicConverter.toArabic();
        assertEquals(test,9000);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test2_4Ns() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("NNNN");
        int test = elbonianArabicConverter.toArabic();
    }
    
    @Test
    public void test2_3Ds() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("DDD");
        int test = elbonianArabicConverter.toArabic();
        assertEquals(test,900);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test2_4Ds() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("DDDD");
        int test = elbonianArabicConverter.toArabic();
    }
    
    @Test
    public void test2_3Ls() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("LLL");
        int test = elbonianArabicConverter.toArabic();
        assertEquals(test,90);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test2_4Ls() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("LLLL");
        int test = elbonianArabicConverter.toArabic();
    }
    
    @Test
    public void test2_3Vs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("VVV");
        int test = elbonianArabicConverter.toArabic();
        assertEquals(test,9);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test2_4Vs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("VVVV");
        int test = elbonianArabicConverter.toArabic();
    }
    
    //3. If N appears three times, then M cannot appear.
    @Test(expected = MalformedNumberException.class)
    public void test3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("NNNM");
        int test = elbonianArabicConverter.toArabic();
    }
    
    //4. If D appears three times, then C cannot appear.
    @Test(expected = MalformedNumberException.class)
    public void test4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("DDDC");
        int test = elbonianArabicConverter.toArabic();
    }
    
    //5. If L appears three times, then X cannot appear.
    @Test(expected = MalformedNumberException.class)
    public void test5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter= new ElbonianArabicConverter("LLLX");
        int test = elbonianArabicConverter.toArabic();
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("VVVI");
        int test = elbonianArabicConverter.toArabic();
    }
    
   @Test
    public void test7() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("-V");
        assertEquals(elbonianArabicConverter.toArabic(), -3);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test7_2() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("--V");
        elbonianArabicConverter.toArabic();
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test7_3() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("--3");
        elbonianArabicConverter.toArabic();
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test8_1() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("-Z");
        elbonianArabicConverter.toArabic();
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test8_2() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("VZ");
        elbonianArabicConverter.toArabic();
    }
    
    @Test
    public void test8_3() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("Z");
        assertEquals(elbonianArabicConverter.toArabic(), 0);
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test9_1() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("NMDCXL");
        elbonianArabicConverter.toArabic();
    }
    
    @Test
    public void test9_2() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("NMDCLXVI");
        System.out.println();
        assertEquals(4444,elbonianArabicConverter.toArabic());
    }
    
    @Test(expected = ValueOutOfBoundsException.class)
    public void test10_1() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("10000");
        elbonianArabicConverter.toElbonian();
    }
    
    @Test(expected = ValueOutOfBoundsException.class)
    public void test10_2() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("-10000");
        elbonianArabicConverter.toElbonian();
    }
    
    @Test
    public void test10_3() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("9999");
        assertEquals("NNNDDDLLLVVV",elbonianArabicConverter.toElbonian());
    }
    
    @Test
    public void test10_4() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("-9999");
        assertEquals("-NNNDDDLLLVVV",elbonianArabicConverter.toElbonian());
    }
    
    @Test(expected = ValueOutOfBoundsException.class)
    public void test11_1() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("10000");
        elbonianArabicConverter.toArabic();
    
    }
    
    @Test
    public void test11_2() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9999");
        assertEquals(converter.toElbonian(), "NNNDDDLLLVVV");
        
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test11_3() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9");
        converter.toElbonian();
        
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test12_1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IlI");
        int test= converter.toArabic();
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test12_2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("m");
        int test= converter.toArabic();
    }

    @Test
    public void test13() throws MalformedNumberException, ValueOutOfBoundsException {
        for(int i = -9999; i <= 9999; i++){
            ElbonianArabicConverter converter = new ElbonianArabicConverter(String.valueOf(i));
            String elboNum = converter.toElbonian();
            converter = new ElbonianArabicConverter(elboNum);
            int arabicNum = converter.toArabic();
            converter = new ElbonianArabicConverter(String.valueOf(arabicNum));
            String elboFromArabic = converter.toElbonian();

            assertEquals(i, arabicNum);
            assertEquals(elboNum, elboFromArabic);
            System.out.println(i + " " + arabicNum + " ---- " + elboNum + " " + elboFromArabic);
        }
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test14() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("-0");
        elbonianArabicConverter.toArabic();
    }
    
    @Test(expected = MalformedNumberException.class)
    public void test15() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("");
        elbonianArabicConverter.toArabic();
    }
    
    @Test(expected = ValueOutOfBoundsException.class)
    public void test16() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("10000");
        elbonianArabicConverter.toArabic();
    }
    
    @Test(expected = ValueOutOfBoundsException.class)
    public void test17() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter elbonianArabicConverter = new ElbonianArabicConverter("-10000");
        elbonianArabicConverter.toArabic();
    }

    @Test
    public void test18() throws MalformedNumberException, ValueOutOfBoundsException {
        for(int i = -9999; i <= 9999; i++){
            System.out.println(i);
            ElbonianArabicConverter converter = new ElbonianArabicConverter(String.valueOf(i));
            int arabicNum = converter.toArabic();
            assertEquals(i, arabicNum);
        }
    }

    //
    @Test
    public void test19() throws MalformedNumberException, ValueOutOfBoundsException {
        for(int i = -9999; i <= 9999; i++){
            //Get our elbonian number
            ElbonianArabicConverter converter = new ElbonianArabicConverter(String.valueOf(i));
            String elbonianNumber = converter.toElbonian();
            //Convert our elbonian number again
            converter = new ElbonianArabicConverter(elbonianNumber);
            String secondElbonianNumber = converter.toElbonian();
            //Make sure they are both equal
            assertEquals(elbonianNumber, secondElbonianNumber);
        }
    }


}
