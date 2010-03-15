package org.coode.oppl.test;

import java.util.List;
import java.util.regex.Pattern;

import org.coode.oppl.variablemansyntax.generated.RegExpGeneratedValue;

public class DumbTest {
	public static void main(String[] args) {
		Pattern regExpression = Pattern.compile("test my (([a-zA-Z]+))");
		String candidate = "test my cibo";
		List<String> group = RegExpGeneratedValue.actualMatch(regExpression,
				candidate);
		System.out.println("DumbTest.main() " + candidate + " " + group);
	}
}
