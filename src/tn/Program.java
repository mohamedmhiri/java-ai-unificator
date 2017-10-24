package tn.insat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	
	
public static void main(String args[])
{
	System.out.println("**********Debut Programme**********");
	Unification u=new Unification();
	List<String> expr1=new ArrayList<String>();
	List<String> expr2=new ArrayList<String>();
	Scanner sc=new Scanner(System.in);
	System.out.println("**********saisir la 1ere expression ********");
	String l1=sc.nextLine();
	System.out.println("**********saisir la 2eme expression ********");
	String l2=sc.nextLine();
	//String l1="P(?x, f(g(?x)), a)";
	//String l2="P(b,?y, ?z)";
	expr1.add(l1);
	expr2.add(l2);
	String ch=u.unifier(expr1,expr2);
	System.out.println(ch);
	System.out.println("**********fin Programme**********");
	
	
	

	

	
}
}
