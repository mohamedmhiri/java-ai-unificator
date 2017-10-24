package tn.insat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unification {
	public String unifier(List<String> expr1,List<String> expr2) {
			//Tester si l'une des expressions est un atome
			if (estAtome(expr1) || estAtome(expr2)) {
			return unifierAtomes(expr1, expr2);
			}
			//récupérer le premier element de la première expression
			String f1 = expr1.get(0);
			//sauvegarder les termes non traités de la première expression
			expr1.remove(0);
			List<String> t1 = expr1;
			//récupérer le premier element de la deuxième expression
			String f2 = expr2.get(0);
			//sauvegarder les termes non traités de la deuxième expression
			expr2.remove(0);
			List<String> t2 = expr2;
			List<String> e1 = new ArrayList<String>();
			e1.add(f1);
			List<String> e2 = new ArrayList<String>();
			e2.add(f2);
			//unifier les têtes de deux expressions
			String z1 = unifier(e1, e2);
			//echec d'unification
			if(z1.equalsIgnoreCase("echec"))
			return "echec";
			//Application des changements sur les termes non traités des expressions
			List<String> g1 = changer(t1, z1);
			List<String> g2 = changer(t2, z1);
			//unifier les termes non traités de deux expressions
			String z2 = unifier(g1, g2);
			//echec d'unification
			if (z2.equalsIgnoreCase("echec"))
			return "echec";
			return z1 + " " + z2;
			}
			
	
	private List<String> changer(List<String> t1,String z1) {
			String[] chg = z1.trim().split("\\s+");
			List<String> b = new ArrayList<String>();
			for (int i = 0; i < chg.length; i++) {
			b.addAll(Arrays.asList(chg[i].split("/")));
			}
			if (!z1.equalsIgnoreCase("")) {
			for (int i = 0; i < t1.size(); i++) {
			// if(t1.get(i).equalsIgnoreCase(b[0]))
			for (int j = 0; j < b.size(); j += 2)
			t1.set(i,
			t1.get(i).replaceAll("\\" + b.get(j), b.get(j
			+ 1)));
			}
			}
			return t1;
			}
	
	private String unifierAtomes(List<String> expr1, List<String> expr2) {
	String e1 = expr1.get(0);
	String e2 = expr2.get(0);
	//e1 et e2 sont identiques
	if (e1.equalsIgnoreCase(e2))
	return "";
	//e1 est une variable
	if (e1.charAt(0) == '?') 
	{
		if (e2.contains(e1))
		return "echec";
		else
		return e1 + "/" + e2;
		}

		//e2 est un variable
		if (e2.charAt(0) == '?')
		return e2 + "/" + e1;
		//e1 et e2 sont des fonctions
		if (e1.contains("(") && e2.contains("(")) {
		List<String> l1 = extractExpression(e1);
		List<String> l2 = extractExpression(e2);
		return unifier(l1, l2);
		}
		//echec
	return "echec";
	}
	
	public boolean estAtome(List<String> expr){
		if(expr.size()==1)
			return true;
		else
			return false;
		
	}
	
	/*public List<String> extractExpression(String e)
	{	String e1 = e.substring(e.indexOf("(") + 1, e.lastIndexOf(")")).replaceAll("\\s", "");
		List l=new ArrayList<String>();
		//nombre de parenthese ouvrante
		int nbParentheseOuv=0;
		int nbParentheseFerm=0;
		
		
		
		int premierParenth=0;
		int dernierParenth=0;
		//on va pas comptablisier le premier et dernier parenthese 
				//ex p(x) nbParentheseFerm=0 nbParentheseOuv=0
		int i=0;
		while ( i!=e1.length()-1)
		{String c = Character.toString(e1.charAt(i));
			if(c.equals("("))
				{
				if(premierParenth==0)
				premierParenth=i;
				nbParentheseOuv++;
				
				}
			else 
				if(c.equals(")"))
				{
					nbParentheseFerm++;
					if(nbParentheseOuv==nbParentheseFerm)
					{dernierParenth=i;
					l.add(e1.substring(premierParenth-1, dernierParenth));
					}
					
					i++;
					
				}
			
			else
				//une variable
				if(c.equals("?"))
					{l.add(e1.substring(i, i+1));
					i=i+2;}
			
				else
					if(c.equals(","))
						i++;
			else	
				//une constante
			if(Character.toString(e1.charAt(i+1)).equals(","))
				{
				l.add(c);
				i++;
			}
			//nom de fonction
			else
				i++;
					}
	
				
				return l;
	}*/
public List<String> extractExpression(String e) {
		
		List<String> liste= new ArrayList<String>();
		//on va pas comptablisier le premier et dernier parenthese 
		                   String expression = e.substring(e.indexOf("(") + 1, e.lastIndexOf(")")).replaceAll("\\s", "");


		while (!(expression.equals(""))) {

			// il y a un seul élément  soit une constante soit une variable
			if (!(expression.contains(","))) {
				liste.add(expression);
				System.out.println("ajout d'une constante ou variable "+expression);
				expression = "";
			} else {
				// Si le premier element de la liste est une constante ou une variable	
				if (!(expression.substring(0, expression.indexOf(",")).contains("("))) {
					// On ajoute l'élément dans la liste
					liste.add(expression.substring(0, expression.indexOf(",")));
					//System.out.println("ajout d'une constante ou variable");
					System.out.println("expression ajouté dans la liste "+expression.substring(0, expression.indexOf(",")));
				
				 // on enlève l element ajoute de la chaine
					expression = expression.substring(expression.indexOf(",") + 1);
				}
				// Si le premier element de l'expression est une fonction
				else {
					int nombreParenthesesOuvrantes = 0;
					int nombreParenthesesFermantes = 0;
					int indexDebut = 0;
					int indexFin = 0;
					boolean endOfElement = false;
					int i = 0;
					while ((!endOfElement)) {
						String c = Character.toString(expression.charAt(i));
						if (c.equals("(")) {
							if (indexDebut == 0) {
								indexDebut = i;
							}
							nombreParenthesesOuvrantes++;
						}

						else if (c.equals(")")) {
							nombreParenthesesFermantes++;
							if ((nombreParenthesesOuvrantes == nombreParenthesesFermantes)
									&& (nombreParenthesesOuvrantes > 0)) {
								indexFin = i;
								endOfElement = true;
								i = 0;
							}

						}
						i++;

					}
				
					liste.add(expression.substring(indexDebut - 1, indexFin + 1));
					System.out.println("ajout d'une fonction "+expression);
					//Le cas où le dernier élément de la liste est une fonction 
					if (indexFin == expression.length() - 1) {
						expression = "";
					}
					//Enlever la fonction et à continuer à examiner l'expression
					else {
						expression = expression.substring(indexFin + 2);

					}
				}
			}

		}

		return liste;
	}
}
