import static org.junit.Assert.*;

import org.junit.Test;

import com.kirolak.util.KirolakValidator;


import junit.framework.JUnit4TestAdapter;


public class RegexTest
{

	@Test
	public void ValidateSeoName()
	{
		assertEquals("Uppercase is prohibited for a seo name.",false,KirolakValidator.validateSeoName("BBB"));
		assertEquals("Spanish characters are prohibited for a seo name.",false,KirolakValidator.validateSeoName("bÑb"));
		assertEquals("Tildes are prohibited for a seo name.",false,KirolakValidator.validateSeoName("báb"));
		assertEquals("Blanks are prohibited in a seo name.",false,KirolakValidator.validateSeoName("a a"));
		assertEquals("A sea name must have at least 3 characters.",false,KirolakValidator.validateSeoName("bb"));
		assertEquals("A sea name's maximum length is 15.",false,KirolakValidator.validateSeoName("1234567890123456"));
		assertEquals("Downcase is permitted for a seo name.",true,KirolakValidator.validateSeoName("bbb"));
		assertEquals("numbers are permitted for a seo name.",true,KirolakValidator.validateSeoName("123"));
		assertEquals("Dashes are permitted for a seo name.",true,KirolakValidator.validateSeoName("b-1"));
		assertEquals("A sea name's maximum length is 15.",true,KirolakValidator.validateSeoName("123456789012345"));
	}
	
	public static junit.framework.Test suite()
	{
		return new JUnit4TestAdapter (RegexTest.class);
	}

}
