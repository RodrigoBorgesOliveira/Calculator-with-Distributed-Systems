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

public class Server
{
	public static void main(String args[])
	{
		try
		{
			if(args.length > 0){	
				System.setProperty("java.rmi.server.hostname", args[0]);
			}
			Naming.rebind("ImplementaCalc",new ImplementaCalc());
			System.out.println("O servidor esta' rodando");
		}
		catch(Exception e)
		{
			System.out.println("Problemas!!!");
			e.printStackTrace();
		}
	}
	
}
