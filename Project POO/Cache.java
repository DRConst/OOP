/** 
 * Classe que implementa uma generalização de qualquer tipo de cache
 * Vai ser o topo da hierarquia de caches
 * 
 * @version (2015.04.30)
 */

import java.util.*;

public class Cache 
{
	private static final byte easy = 1, medium_easy = 2, medium = 3, medium_hard = 4, hard = 5;
	private String code, description, hints;
	private TreeMap<String,Register> regBook;
	private double defaultLatitude, defaultLongitude, currentLatitude, currentLongitude;
	private GregorianCalendar date;
	private byte difficulty;


	public Cache()
	{
		this.code = this.description = this.hints = "";
		this.regBook = new TreeMap<String,Register>();
		this.defaultLatitude = this.defaultLongitude = this.currentLatitude = this.currentLongitude = 0.0;
		this.date = new GregorianCalendar();
		this.difficulty = easy;
	}

	public Cache(String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, byte difficulty)
	{
		this.code = code;
		this.description = description;
		this.hints = hints;
		this.regBook = new TreeMap<String,Register>(regBook);
		this.defaultLatitude = this.currentLatitude = defaultLatitude;
		this.defaultLongitude = this.currentLongitude = defaultLongitude;
		this.date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
		this.difficulty = difficulty;
	}

	public Cache(String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, int year, int month, int dayOfMonth, byte difficulty)
	{
		this.code = code;
		this.description = description;
		this.hints = hints;
		this.regBook = new TreeMap<String,Register>(regBook);
		this.defaultLatitude = this.currentLatitude = defaultLatitude;
		this.defaultLongitude = this.currentLongitude = defaultLongitude;
		this.date = new GregorianCalendar(year, month, dayOfMonth);
		this.difficulty = difficulty;
	}

	public Cache(Cache c)
	{
		this.code = c.getCode();
		this.description = c.getDescription();
		this.hints = c.getHints();
		this.regBook = new TreeMap<String,Register>(c.getRegBook());
		this.defaultLatitude = c.getDefaultLatitude();
		this.defaultLongitude = c.getDefaultLongitude();
		this.currentLatitude = c.getCurrentLatitude();
		this.currentLongitude = c.getCurrentLongitude();
		this.date = c.getDate();
		this.difficulty = c.getDifficulty();
	}

	/**
	 * Retorna o codigo da cache
	 *
	 * @return o codigo
	 */
	public String getCode() { return new String(this.code); }

	/**
	 * Retorna a descrição da cache
	 *
	 * @return descrição
	 */
	public String getDescription() { return new String(this.description); }

	/**
	 * Retorna as dicas dadas na cache
	 *
	 * @return dicas
	 */
	public String getHints() { return new String(this.hints); }

	/**
	 * Devolve o Livro de Registos da cache
	 *
	 * @return o livro de registos da cache
	 */
	public Map<String,Register> getRegBook() { return new TreeMap<String,Register>(this.regBook); }

	/**
     * Devolve o valor de latitude inicial da cache
     * 
     * @return a latitude inicial da cache
     */
	public double getDefaultLatitude() { return this.defaultLatitude; }

	/**
     * Devolve o valor da longitude inicial da cache
     *
     * @return a longitude inicial da cache
     */
	public double getDefaultLongitude() { return this.defaultLongitude; }

	/**
     * Devolve o valor da latitude no momento da cache
     * Não pode estar distanciada mais de 10 metros da
     * localização inicial
     *
     * @return a latitude no momento da cache
     */
	public double getCurrentLatitude() { return this.currentLatitude; }

	/**
     * Devolve o valor da longitude no momento da cache
     * Não pode estar distanciada mais de 10 metros da
     * localização inicial
     *
     * @return a longitude no momento da cache
     */
	public double getCurrentLongitude() { return this.currentLongitude; }

	/**
	 * Devolve o ano da data que está na cache
	 *
	 * @return ano da data
	 */
	public int getYear() { return this.date.get(Calendar.YEAR); }

	/**
	 * Devolve o mes da data que está na cache
	 *
	 * @return mes da data
	 */
	public int getMonth() { return this.date.get(Calendar.MONTH); }

	/**
	 * Devolve o dia da data que está na cache
	 *
	 * @return dia da data
	 */
	public int getDayOfMonth() { return this.date.get(Calendar.DAY_OF_MONTH); }

	/**
	 * Devolve a data completa que está na cache
	 *
	 * @return data
	 */
	public GregorianCalendar getDate() { return new GregorianCalendar(this.getYear(), this.getMonth(), this.getDayOfMonth()); }

	/**
	 * Devolve a dificuldade da cache
	 * Usa as constantes definidas anteriormente 
	 * para a dificuldade
	 *
	 * @return a dificuldade da cache
	 */
	public byte getDifficulty() { return this.difficulty; }

	/**
	 * Muda o codigo da cache
	 *
	 * @param codigo para a cache
	 */
	public void setCode(String code) { this.code = code; }

	/**
	 * Muda a descrição da cache
	 *
	 * @param description a string descrição da cache
	 */
	public void setDescription(String description) { this.description = description; }

	/**
	 * Muda as dicas dadas ao geochachers sobre a cache
	 *
	 * @param hints a string com as dicas sobre a cache
	 */
	public void setHints(String hints) { this.hints = hints; }

	/**
	 * Altera o livro de registos da cache
	 *
	 * @param regBook o livro de registos
	 */
	public void setRegBook(Map<String,Register> regBook) { this.regBook = new TreeMap<String,Register>(regBook); }

	/**
	 * Muda a latitude inicial da cache
	 * Como não se pode alterar a latitude inicial depois 
	 * de criada a cache, o método é privado
	 *
	 * @param defaultLatitude a latitude inicial da cache
	 */
	private void setDefaultLatitude(double defaultLatitude) { this.defaultLatitude = defaultLatitude; }

	/**
	 * Muda a longitude inicial da cache
	 * Como não se pode alterar a longitude inicial depois 
	 * de criada a cache, o método é privado
	 *
	 * @param defaultLongitude a latitude inicial da cache
	 */
	private void setDefaultLongitude(double defaultLongitude) { this.defaultLongitude = defaultLongitude; }

	/**
	 * Muda a latitude no momento da cache
	 *
	 * @param currentLatitude a latitude no momento da cache
	 */
	public void setCurrentLatitude(double currentLatitude) { this.currentLatitude = currentLatitude; }  // adicionar verificador de distancia

	/**
	 * Muda a longitude no momento da cache
	 *
	 * @param currentLongitude a longitude no momento da cache
	 */
	public void setCurrentLongitude(double currentLongitude) { this.currentLongitude = currentLongitude; }  // adicionar verificador de distancia

	/**
	 * Muda a data de criação da cache
	 *
	 * @param year o ano da data
	 * @param month o mes da data
	 * @param dayOfMonth o dia da data
	 */
	private void setDate(int year, int month, int dayOfMonth) { this.date = new GregorianCalendar(year, month, dayOfMonth); }

	/**
	 * Muda a dificuldade da cache
	 * Usa as constantes definidas anteriormente 
	 * para a dificuldade
	 *
	 * @param difficulty a dificuldade da cache
	 */
	public void setDifficulty(byte difficulty) { this.difficulty = difficulty; }


	/**
	 * Muda a localização no momento da cache
	 * Não pode estar distanciado mais de 10 metros
	 * da localização inicial da cache
	 *
	 * @param latitude a latitude no momento da cache
	 * @param longitude a longitude no momento da cache
	 */
	public void changeLocation(double latitude, double longitude)
	{
		// Adicionar verificador de distância

		this.setCurrentLatitude(latitude);
		this.setCurrentLongitude(longitude);
	}

	/**
	 * Adiciona um registo ao livro de registos da cache
	 *
	 * @param reg registo a adicionar
	 */
	public void addRegister(Register reg)
	{
		this.regBook.put(reg.getUser(), reg.clone());
	}

	/**
	 * Remove um registo ao livro de registos da cache
	 *
	 * @param reg registo a remover
	 */
	public void removeRegister(Register reg)
	{
		this.regBook.remove(reg.getUser());
	}

	/**
	 * Verifica se 2 cache são iguais
	 *
	 * @return true se iguais, false caso contrário
	 */
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		else
		{
			Cache c = (Cache) o;

			if (!this.code.equals(c.getCode()))
				return false;

			for (String s : c.getRegBook().keySet())
				if (!this.regBook.containsKey(s))
					return false;

			if (this.defaultLatitude != c.getDefaultLatitude() || this.defaultLongitude != c.getDefaultLongitude() || this.currentLatitude != c.getCurrentLatitude() || this.currentLongitude != c.getCurrentLongitude())
				return false;

			if (this.getYear() != c.getYear() || this.getMonth() != c.getMonth() || this.getDayOfMonth() != c.getDayOfMonth())
				return false;

			if (this.difficulty != c.getDifficulty())
				return false;

			return true;
		}
	}

	/**
	 * Passa a informação da cache toda para string
	 *
	 * @return string resultado
	 */
	public String toString()
	{
		StringBuilder s = new StringBuilder();

		s.append("-----------------Cache-----------------\n\n");
		s.append("\tCodigo: " + this.code);
		s.append("\n\tRegistos:\n");

		for (Register r : this.regBook.values())
			s.append(r.toString() + "\n\n");

		s.append("\tLocalização: (" + this.currentLatitude + "," + this.currentLongitude + ")\n");

		s.append("\tData: " + this.getYear() + "/" + this.getMonth() + "/" + this.getDayOfMonth() + "\n");
		s.append("\tDificuldade : " + this.difficulty);
		s.append("\n-------------------------------------");

		return s.toString();
	}

	/**
	 * Clona uma cache
	 *
	 * @return clone da cache
	 */
	public Cache clone()
	{
		return new Cache(this);
	}
}

