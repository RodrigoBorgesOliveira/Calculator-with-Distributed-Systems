/*
	Carlos Sérgio Pereira Sobrinho
	Eliezer Marques da Silva Neto
	Humberto Leone Rodrigues Azevedo
	Robson Lima de Souza
	Rodrigo Borges de Oliveira
	Rodrigo da Silva Ribeiro
	Yago Magalhães Ávila
*/

import java.rmi.*;
import java.util.*;

public class Client2
{
	public static List<String> listaHosts = new ArrayList<String>(); //Fila de hosts.
	
	public static Calculos calcSoma;
	public static Calculos calcSubtracao;
	public static Calculos calcMultiplicacao;
	public static Calculos calcDivisao;
	
	public static float a = 0, b = 0, result = 0;
	public static	char operacao;
	
	public static void calcula(){
		try{
			//Verifica qual é a operação a ser realizada.
			if(operacao == '+'){					
				result = calcSoma.soma(a,b);
				a = result;
			}
			else{
				if(operacao == '-'){
					result = calcSubtracao.subtracao(a,b);
					a = result;
				}
				else{
					if(operacao == '*'){
						result = calcMultiplicacao.multiplicacao(a,b);
						a = result;
					}
					else{
						if(operacao == '/'){
							if(b != 0){
								result = calcDivisao.divisao(a,b);
								a = result;
							}
							else{
								System.out.println("Impossível fazer divisão por zero. Resultado infinito!");
							}
						}
					}
				}
			}
		}
		catch(Exception e){
			switch(operacao){
				case '+':
					try{
						calcSoma = (Calculos) Naming.lookup("//"+listaHosts.get(1)+"/ImplementaCalc");
						calcula();
					}
					catch(Exception eSoma1){
						try{
							calcSoma = (Calculos) Naming.lookup("//"+listaHosts.get(2)+"/ImplementaCalc");
							calcula();
						}
						catch(Exception eSoma2){
							try{
								calcSoma = (Calculos) Naming.lookup("//"+listaHosts.get(3)+"/ImplementaCalc");
								calcula();
							}
							catch(Exception eSoma3){
								try{
									calcSoma = (Calculos) Naming.lookup("//localhost/ImplementaCalc");
									calcula();
								}
								catch(Exception eSoma4){
									System.out.println("Client Exception " + eSoma4);	
								}
							}
						}
					}
				break;
				case '-':
					try{
						calcSubtracao = (Calculos) Naming.lookup("//"+listaHosts.get(0)+"/ImplementaCalc");
						calcula();
					}
					catch(Exception eSub1){
						try{
							calcSubtracao = (Calculos) Naming.lookup("//"+listaHosts.get(2)+"/ImplementaCalc");
							calcula();
						}
						catch(Exception eSub2){
							try{
								calcSubtracao = (Calculos) Naming.lookup("//"+listaHosts.get(3)+"/ImplementaCalc");
								calcula();
							}
							catch(Exception eSub3){
								try{
									calcSubtracao = (Calculos) Naming.lookup("//localhost/ImplementaCalc");
									calcula();
								}
								catch(Exception eSub4){
									System.out.println("Client Exception " + eSub4);	
								}
							}
						}
					}
				break;
				case '*':
					try{
						calcMultiplicacao = (Calculos) Naming.lookup("//"+listaHosts.get(0)+"/ImplementaCalc");
						calcula();
					}
					catch(Exception eMult1){
						try{
							calcMultiplicacao = (Calculos) Naming.lookup("//"+listaHosts.get(1)+"/ImplementaCalc");
							calcula();
						}
						catch(Exception eMult2){
							try{
								calcMultiplicacao = (Calculos) Naming.lookup("//"+listaHosts.get(3)+"/ImplementaCalc");
								calcula();
							}
							catch(Exception eMult3){
								try{
									calcMultiplicacao = (Calculos) Naming.lookup("//localhost/ImplementaCalc");
									calcula();
								}
								catch(Exception eMult4){
									System.out.println("Client Exception " + eMult4);	
								}
							}
						}
					}
				break;
				case '/':
					try{
						calcDivisao = (Calculos) Naming.lookup("//"+listaHosts.get(0)+"/ImplementaCalc");
						calcula();
					}
					catch(Exception eDiv1){
						try{
							calcDivisao = (Calculos) Naming.lookup("//"+listaHosts.get(1)+"/ImplementaCalc");
							calcula();
						}
						catch(Exception eDiv2){
							try{
								calcDivisao = (Calculos) Naming.lookup("//"+listaHosts.get(2)+"/ImplementaCalc");
								calcula();
							}
							catch(Exception eDiv3){
								try{
									calcDivisao = (Calculos) Naming.lookup("//localhost/ImplementaCalc");
									calcula();
								}
								catch(Exception eDiv4){
									System.out.println("Client Exception " + eDiv4);	
								}
							}
						}
					}
				break;
				default: System.out.println("Client Exception " + e);
			}
		}
	}
	
	public static void main(String args[])
	{
		try {
			String host1 = "localhost";
			String host2 = "localhost";
			String host3 = "localhost";
			String host4 = "localhost";
			
			int posicaoAnterior = 1; //Variável para saber se o caractere anterior é uma operação.
			String numero = "";
			
			String expressao;
						
			Queue<Float> n = new LinkedList<Float>(); //Fila de números.
			Queue<Character> o = new LinkedList<Character>(); //Fila de operações.
			
			Scanner teclado = new Scanner(System.in);
			
			Random gerador = new Random(); //Variável para atribuir um host à uma função aleatoriamente.
			
			if(args.length > 0){
				host1 = args[0];
				if(args.length > 1){
					host2 = args[1];
					if(args.length > 2){
						host3 = args[2];
						if(args.length > 3){
							host4 = args[3];
						}
					}					
				}			
			}
			
			//Coloca todos os hosts na listaHosts.
			listaHosts.add(host1);
			listaHosts.add(host2);
			listaHosts.add(host3);
			listaHosts.add(host4);
			
			Collections.shuffle(listaHosts); //Embaralha os hosts 
				
			//Atribui uma função a cada host da listaHosts.			
			calcSoma = (Calculos) Naming.lookup("//"+listaHosts.get(0)+"/ImplementaCalc");
			calcSubtracao = (Calculos) Naming.lookup("//"+listaHosts.get(1)+"/ImplementaCalc");
			calcMultiplicacao = (Calculos) Naming.lookup("//"+listaHosts.get(2)+"/ImplementaCalc");
			calcDivisao = (Calculos) Naming.lookup("//"+listaHosts.get(3)+"/ImplementaCalc");
						
			System.out.println("\nDigite a expressão: ");
			expressao = teclado.nextLine();
			
			expressao = expressao.replace(" ", "");		
			
			//Verifica caracteres indesejados no início ou final da expressão.
			if(expressao.charAt(0) == '*' || expressao.charAt(0) == '/' || expressao.charAt(expressao.length()-1) == '+' || expressao.charAt(expressao.length()-1) == '-' || expressao.charAt(expressao.length()-1) == '*' || expressao.charAt(expressao.length()-1) == '/'){
				System.out.println("Expressão inválida!");		
				System.exit(0);
			}
			
			//Separa os números das operações.			
			for(int i = 0; i < expressao.length(); i++){
				if(!Character.isDigit(expressao.charAt(i)) && expressao.charAt(i) != '+' && expressao.charAt(i) != '-' && expressao.charAt(i) != '*' && expressao.charAt(i) != '/' && expressao.charAt(i) != '.'){
					System.out.println("Expressão inválida!");
					System.out.println("Caractere inválido: " + expressao.charAt(i));
					System.exit(0);
				}
				else{
					//Verifica se o caractere atual é um sinal ou não. Caso seja um sinal, ainda verifica se ele é um sinal de negação de um número.
					if((posicaoAnterior == 1 && (expressao.charAt(i) == '-' || expressao.charAt(i) == '+') && Character.isDigit(expressao.charAt(i+1)))|| Character.isDigit(expressao.charAt(i)) || (Character.isDigit(expressao.charAt(i+1)) && expressao.charAt(i) == '.')){
						numero += expressao.charAt(i);
						posicaoAnterior = 0;
					}
					else{
						if(numero != ""){
							n.add(Float.parseFloat(numero));
							numero = "";
						}
						if(expressao.charAt(i) == '+' || expressao.charAt(i) == '-' || expressao.charAt(i) == '*' || expressao.charAt(i) == '/'){
							o.add(expressao.charAt(i));
							posicaoAnterior = 1; //Define que esta posição possui um sinal de operação.
						}						
					}
				}
			}
			n.add(Float.parseFloat(numero));
			
			//Se a quantidade de operadores for maior ou igual à quantidade de dígitos, a expressão é inválida!			
			if(n.size() <= o.size()){
				System.out.println("Expressão inválida!");
				System.exit(0);
			}
										
			//Faz os cálculos.
			a = n.remove();
			result = a;
			while(!n.isEmpty()){
				operacao = o.remove();
				b = n.remove();	
				calcula();
			}		
			
			//int contador = calc.getCont();
			System.out.println("Resultado: " + result);
		}
		catch(Exception e){
			System.out.println("Client Exception " + e);
		}
	}
}
