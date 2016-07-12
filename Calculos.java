/*
	Carlos Sérgio Pereira Sobrinho
	Eliezer Marques da Silva Neto
	Humberto Leone Rodrigues Azevedo
	Robson Lima de Souza
	Rodrigo Borges de Oliveira
	Rodrigo da Silva Ribeiro
	Yago Magalhães Ávila
*/

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculos extends Remote
{
   public float soma(float a, float b) throws RemoteException;
   public float subtracao(float a, float b) throws RemoteException;
   public float multiplicacao(float a, float b) throws RemoteException;
   public float divisao(float a, float b) throws RemoteException;
   public int getCont() throws RemoteException;
}
