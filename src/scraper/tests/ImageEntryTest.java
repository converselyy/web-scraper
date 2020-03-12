// COURSE: CSCI1620
// TERM: Spring 2020
// 
// NAME: Nate Tyler, Brandon Cline
// RESOURCES: We referred to no outside materials when
//            writing the code in this file.

package scraper.tests;

import scraper.base.ImageEntry;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Tests the ImageEntry class
 * @author ntyler, bcline
 */
public class ImageEntryTest {

	@Test
	public void testConstructorVaild()
	{
		ImageEntry i = new ImageEntry("hi", "Nate");
		
		assertEquals("hi", i.getPageLocation());
		assertEquals("Nate", i.getImgLocation());
	}
	
	@Test
	public void testEquals()
	{
		ImageEntry i1 = new ImageEntry("123", "Nate");
		ImageEntry i2 = new ImageEntry("hi", "Nate");
		ImageEntry i3 = new ImageEntry("hi", "12");
		Object o = new Object();
		
		assertEquals(true, i1.equals(i2));
		assertEquals(false, i2.equals(i3));
		assertEquals(false, i2.equals(o));
	}
}
