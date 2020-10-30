package ch.brandon.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfAtomsTest {

    NumberOfAtoms subject = new NumberOfAtoms();

    @Test
    public void countOfAtomsTest() {
        Assert.assertEquals("test H2O", "H2O", subject.countOfAtoms("H2O"));
        Assert.assertEquals("test HO", "HO", subject.countOfAtoms("HO"));
        Assert.assertEquals("test ABC2D4E", "ABC2D4E", subject.countOfAtoms("EABC2D4"));
        Assert.assertEquals("test AMgTHe2", "AHe2MgT", subject.countOfAtoms("AMgTHe2"));
    }

    @Test
    public void countOfAtomsTest_Parenthesis() {
        Assert.assertEquals("test (H2O)", "H2O", subject.countOfAtoms("(H2O)"));
        Assert.assertEquals("test (H2O)2", "H4O2", subject.countOfAtoms("(H2O)2"));
        Assert.assertEquals("test (H2O)4", "H8O4", subject.countOfAtoms("(H2O)4"));
    }

    @Test
    public void countOfAtomsTest_Multiple() {
        Assert.assertEquals("test (ON(SO3)2)2", "N2O14S4", subject.countOfAtoms("(ON(SO3)2)2"));
        Assert.assertEquals("test Be32", "Be32", subject.countOfAtoms("Be32"));

        Assert.assertEquals("test hard", "B18900Be18984C4200H5446He1386Li33894N50106O22638",
                subject.countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
    }
}