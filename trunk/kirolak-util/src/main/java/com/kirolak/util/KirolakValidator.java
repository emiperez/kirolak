package com.kirolak.util;

import java.util.regex.*;

public class KirolakValidator
{
	public static final Pattern SEO_NAME_PATTERN = Pattern.compile("[a-z\\d\\-]{3,25}");

	public static boolean validateSeoName(String seoName)
	{
		Matcher matcher = SEO_NAME_PATTERN.matcher(seoName);
		boolean value = matcher.matches();
		return value;
	}
}
