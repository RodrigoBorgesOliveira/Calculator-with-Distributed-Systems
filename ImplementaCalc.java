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
import java.rmi.server.*;

public class  ImplementaCalc extends UnicastRemoteObject implements Calculos
{
	public int cont = 0;
	
	public ImplementaCalc() throws RemoteException
	{   
      //construtor vazio   		
	}
   
	public float soma(float a, float b) throws RemoteException
	{
		cont++;
		System.out.println("Calculo " + cont + ": " + a + " + " + b + " = " + (a+b));
		return a + b;
	}
	
	public float subtracao(float a, float b) throws RemoteException{
		cont++;
		System.out.println("Calculo " + cont + ": " + a + " - " + b + " = " + (a-b));
		return a - b;
	}
	
	public float multiplicacao(float a, float b) throws RemoteException{
		cont++;
		System.out.println("Calculo " + cont + ": " + a + " * " + b + " = " + (a*b));
		return a * b;
	}
	
	public float divisao(float a, float b) throws RemoteException{
		cont++;
		System.out.println("Calculo " + cont + ": " + a + " / " + b + " = " + (a/b));
		return a / b;
	}
	
	public int getCont() throws RemoteException
	{
		return cont;
	}
}
