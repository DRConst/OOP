/** 
 * Classe que implementa uma cache tradicional
 * 
 * @version (2015.04.30)
 */

import java.util.*;

public class TraditionalCache extends Cache
{
	private int maxTreasures;
	private TreeSet<String> treasures;

	public TraditionalCache() 
	{ 
		super();
		this.maxTreasures = 0;
		this.treasures = new TreeSet<String>();
	}

	public TraditionalCache(String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, Difficulty difficulty, int maxTreasures, Collection<String> treasures)
	{
		super(code, description, hints, regBook, defaultLatitude, defaultLongitude, date, difficulty);
		this.maxTreasures = maxTreasures;
		this.treasures = new TreeSet<String>(treasures);
	}

	public TraditionalCache(TraditionalCache c)
	{
		super(c);
		this.maxTreasures = maxTreasures;
		this.treasures = new TreeSet<String>(c.getTreasures());
	}

	/**
	 * Devolve o máximo de tesouros permitidos na cache
	 *
	 * @return treasures a lista com os tesouros
	 */
	public int getMaxTreasures() { return this.maxTreasures; }

	/**
	 * Devolve os tesouros presentes na cache
	 *
	 * @return treasures a lista com os tesouros
	 */
	public Collection<String> getTreasures() { return new TreeSet<String>(this.treasures); }

	/**
	 * Coloca na cache o máximo de tesouros permitidos na cache
	 *
	 * @return treasures a lista com os tesouros
	 */
	public void setMaxTreasures(int maxTreasures) { this.maxTreasures = maxTreasures; }

	/**
     * Coloca na cache um conjunto de tesouros passado como parametro
     *
     * @param treasures o conjunto de tesouros a colocar na cache
     */
	public void setTreasures(Collection<String> treasures)
	{
		if (treasures.size() <= this.maxTreasures)
			this.treasures = new TreeSet<String>(treasures);
	}

	/**
     * Adiciona um tesouro à lista de tesouros da cache
     *
     * @param treasure o tesouro a adicionar
     */
	public void addTreasure(String treasure) { this.treasures.add(treasure); }

	/**
     * Remove um tesouro da lista de tesouros da cache
     *
     * @param treasure o tesouro a remover
     */
	public void removeTreasure(String treasure) { this.treasures.remove(treasure); }

	/**
     * Verifica se 2 caches são iguais
     * 
     * @param o objeto que queremos comparar
     * @return true caso iguais, false caso contrário
     */
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o==null || this.getClass() != o.getClass())
			return false;
		else
		{
			TraditionalCache c = (TraditionalCache) o;

			if (!this.getCode().equals(c.getCode()))
				return false;

			for (String s : c.getRegBook().keySet())
				if (!this.getRegBook().containsKey(s))
					return false;

			if (this.getDefaultLatitude() != c.getDefaultLatitude() || this.getDefaultLongitude() != c.getDefaultLongitude() || this.getCurrentLatitude() != c.getCurrentLatitude() || this.getCurrentLongitude() != c.getCurrentLongitude())
				return false;

			if (this.getYear() != c.getYear() || this.getMonth() != c.getMonth() || this.getDayOfMonth() != c.getDayOfMonth())
				return false;

			if (this.getDifficulty() != c.getDifficulty())
				return false;

			for (String s : this.treasures)
				if (!c.treasures.contains(s))
					return false;

			return true;
		}
	}

	/**
	 * Passa o objeto para String
	 *
	 * @return String resultado
	 */
	public String toString()
	{
		StringBuilder s = new StringBuilder();

		s.append("-----------------Cache Tradicional-----------------\n\n");
		s.append("Conteúdo do livro de Registos:\n");

		for (Register r : this.getRegBook().values())
			s.append("\t" + r.toString() + "\n");

		s.append("\nTesouros:\n");

		for (String r : this.treasures)
			s.append("\t" + r + "\n");

		s.append("Localização:\n");
		s.append("\tLatitude: " + this.getCurrentLatitude());
		s.append("\tLongitude: " + this.getCurrentLongitude());
		s.append("--------------------------------------------------");

		return s.toString();
	}

	/**
	 * Clona a cache
	 *
	 * @return novo clone
	 */	
	public TraditionalCache clone()
	{
		return new TraditionalCache(this);
	}
}

