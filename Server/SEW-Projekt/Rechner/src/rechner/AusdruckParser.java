/** AusdruckParser.java
 * Algorithmus zum Berechnen den Wert eines arithmetischen Ausdrucks mit Klammern und Operatorpr�zedenz
	@author Prof. Dr. Andreas Solymosi, (c) 2000-2011: APSIS GmbH
	@version: 22. April 2008
        
        modified by Andreas Kucher for educational purpose
        
*/
package rechner;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AusdruckParser {
	private static Stack<Double> operanden = new Stack<Double>();
	private static Stack<Integer> operatoren = new Stack<Integer>();


        
public static double berechnen(String s) {
       
        s = s.replaceAll("\\+", " + ");
        s = s.replaceAll("\\-", " - ");
        s = s.replaceAll("\\^", " ^ ");
        s = s.replaceAll("\\*", " * ");
        s = s.replaceAll("\\/", " / ");
        s = s.replaceAll("\\(", " ( ");
        s = s.replaceAll("\\)", " ) ");
        s = s.replaceAll(" {2,}", " ");
        if(s.charAt(0) == ' ') s = s.substring(1);
        if(s.charAt(s.length()-1) == ' ') s = s.substring(0,s.length()-2);
        
        System.out.println(s);
        Iterable<String> exp = Arrays.asList(s.split(" ")); 
        
        return auswertung(exp);
}
/** Methode zum Berechnen den Wert eines arithmetischen Ausdrucks mit Klammern und Operatorpr�zedenz
	@param ausdruck Bruchzahlen und Operatoren +, -, /, *, (, )
	@return Wert des Ausdrucks
*/
private static double auswertung(Iterable<String> ausdruck) { // Alternative: String[] ausdruck
	final String oper = "(+-*/^)"; // Operatoren
	final String prior = "3112240"; // Pr�zedenz der Operatoren
	final int klammerAuf = oper.indexOf('('), klammerZu = oper.indexOf(')');

	operanden.push(0.);
	operatoren.push(klammerAuf); // Boden markieren

	for (String element : ausdruck) {
		char zeichen = element.charAt(0);
		if (Character.isDigit(zeichen))
			operanden.push(Double.parseDouble(element));
		else
			for (int op = 0; op < oper.length(); op++) // Operator suchen
				if (zeichen == oper.charAt(op)) { // Operator gefunden
					while (prior.charAt(op) <= prior.charAt(operatoren.peek()) && operatoren.peek() != klammerAuf) // Stapel leeren
						rechnen(operatoren.pop());
					if (op != klammerZu)
						operatoren.push(op);
					if (op == klammerZu && operatoren.peek() == klammerAuf) 
						operatoren.pop();
				}
	}

	while (!operatoren.isEmpty())
		rechnen(operatoren.pop());

	return operanden.pop();
}

private static void rechnen(int operator) {
	switch (operator) {
		case 1: operanden.push(operanden.pop() + operanden.pop()); break; // '+'
		case 2: operanden.push(-(operanden.pop() - operanden.pop())); break; // '-'
		case 3: operanden.push(operanden.pop() * operanden.pop()); break; // '*'
		case 4: operanden.push(1/(operanden.pop() / operanden.pop())); break; // '/'
                case 5: double y = operanden.pop(); double x = operanden.pop();
                    operanden.push(Math.pow(x, y)); break; // '/'
	}
}


}