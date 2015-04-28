/** 
 * Classe que implementa uma classe que vai servir
 * de generalização de qualquer tipo de cache
 * 
 * @version (2015.04.27)
 */

import java.util.TreeSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;

public class Cache
{
	// Variáveis de Instância

	private TreeSet<String> regBook;
	private ArrayList<String> treasures;
	private double latitude;
	private double longitude;


	/**
     * Construtores parameterizado, vazio e de copia
     */
	public Cache() { this(new TreeSet<String>(), new ArrayList<String>(), 0.0, 0.0); }

	public Cache(TreeSet<String> regBook, ArrayList<String> treasures, double latitude, double longitude)
	{
		this.setRegBook(regBook);
		this.setTreasures(treasures);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Cache(Cache c)
	{
		this.setRegBook(c.getRegBook());
		this.setTreasures(c.getTreasures());
		this.latitude = c.getLatitude();
		this.longitude = c.getLongitude();
	}


	// Getters e Setters

	/**
	 * Devolve o Livro de Registos da cache
	 *
	 * @return regBook o livro de registos da cache
	 */
	public Collection<String> getRegBook()
	{
		TreeSet<String> regBook = new TreeSet<String>();

		for (String s: this.regBook)
			regBook.add(s);

		return regBook;
	}

	/**
	 * Devolve os tesouros presentes na cache
	 *
	 * @return treasures a lista com os tesouros
	 */
	public Collection<String> getTreasures()
	{
		ArrayList<String> treasures = new ArrayList<String>();

		for (String s: this.treasures)
			treasures.add(s);

		return treasures;
	}

	/**
     * Devolve o valor de latitude da cache
     * 
     * @return a latitude da cache
     */
	public double getLatitude() { return this.latitude; }

	/**
     * Devolve o valor da longitude da cache
     *
     * @return a longitude da cache
     */
	public double getLongitude() { return this.longitude; }

	/**
     * Coloca na cache um livro de registos passado como parametro
     *
     * @param regBook o livro de registos a colocar na cache
     */
	public void setRegBook(Collection<String> regBook)
	{
		for (String s: regBook)
			this.regBook.add(s);
	}

	/**
     * Coloca na cache um conjunto de tesouros passado como parametro
     *
     * @param regBook o conjunto de tesouros a colocar na cache
     */
	public void setTreasures(Collection<String> treasures)
	{
		for (String s: treasures)
			this.treasures.add(s);
	}

	/**
     * Coloca na cache um valor para a latitude passado como parametro
     *
     * @param latitude o valor de latitude a colocar na cache
     */
	public void setLatitude(double latitude) { this.latitude = latitude; }

	/**
     * Coloca na cache um valor de latitude passado como parametro
     *
     * @param longitude o valor de longitude a colocar na cache
     */
	public void setLongitude(double longitude) { this.longitude = longitude; }


	// Métodos de Instância

	/**
     * Regista uma nova descoberta no livro de registos
     *
     * @param register o registo a colocar no livro de registos
     */
	public void registerDescovery(String register) { this.regBook.add(register); }

	/**
     * Remove um dado registo passado como 
     * parametro do livro de registos
     *
     * @param register o registo a remover do livro de registos
     */
	public void removeRegister(String register) { this.regBook.remove(register); }

	/**
     * Adiciona um tesouro à lista de tesouros da cache
     *
     * @param treaasure o tesouro a adicionar
     */
	public void addTreasure(String treasure) { this.treasures.add(treasure); }

	/**
     * Remove um tesouro da lista de tesouros da cache
     *
     * @param treasure o tesouro a remover
     */
	public void removeTreasure(String treasure) { this.treasures.remove(treasure); }

	/**
     * Muda a localização de uma cache
     *
     * @param latitude o novo valor da latitude
     * @param longitude o novo valor da longitude
     */
	public void changeLocation(double latitude, double longitude) 
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
     * Devolve um Iterator para que seja possível 
     * percorrer o livro de registos
     */
	public Iterator<String> checkRegisters()
	{
		Iterator<String> it = this.regBook.iterator();
		return it;
	}

	/**
     * Devolve um Iterator para que seja possível 
     * percorrer a lista de tesouros
     */
	public Iterator<String> checkTreasures()
	{
		Iterator<String> it = this.treasures.iterator();
		return it;
	}
}

