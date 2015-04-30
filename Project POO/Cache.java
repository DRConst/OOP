/** 
 * Classe que implementa uma classe que vai servir
 * de generalização de qualquer tipo de cache
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


	public String getCode() { return new String(this.code); }

	public String getDescription() { return new String(this.description); }

	public String getHints() { return new String(this.hints); }

	/**
	 * Devolve o Livro de Registos da cache
	 *
	 * @return o livro de registos da cache
	 */
	public Map<String,Register> getRegBook() { return new TreeMap<String,Register>(this.regBook); }

	/**
     * Devolve o valor de defaultLatitude da cache
     * 
     * @return a latitude inicial da cache
     */
	public double getDefaultLatitude() { return this.defaultLatitude; }

	/**
     * Devolve o valor da defaultLongitude da cache
     *
     * @return a longitude inicial da cache
     */
	public double getDefaultLongitude() { return this.defaultLongitude; }

	public double getCurrentLatitude() { return this.currentLatitude; }

	public double getCurrentLongitude() { return this.currentLongitude; }

	public int getYear() { return this.date.get(Calendar.YEAR); }

	public int getMonth() { return this.date.get(Calendar.MONTH); }

	public int getDayOfMonth() { return this.date.get(Calendar.DAY_OF_MONTH); }

	public GregorianCalendar getDate() { return new GregorianCalendar(this.getYear(), this.getMonth(), this.getDayOfMonth()); }

	public byte getDifficulty() { return this.difficulty; }


	public void setCode(String code) { this.code = code; }

	public void setDescription(String description) { this.description = description; }

	public void setHints(String hints) { this.hints = hints; }

	public void setRegBook(Map<String,Register> regBook) { this.regBook = new TreeMap<String,Register>(regBook); }

	private void setDefaultLatitude(double defaultLatitude) { this.defaultLatitude = defaultLatitude; }

	private void setDefaultLongitude(double defaultLongitude) { this.defaultLongitude = defaultLongitude; }

	public void setCurrentLatitude(double currentLatitude) { this.currentLatitude = currentLatitude; }  // adicionar verificador de distancia

	public void setCurrentLongitude(double currentLongitude) { this.currentLongitude = currentLongitude; }  // adicionar verificador de distancia

	private void setDate(int year, int month, int dayOfMonth) { this.date = new GregorianCalendar(year, month, dayOfMonth); }

	public void setDifficulty(byte difficulty) { this.difficulty = difficulty; }


	public void changeLocation(double latitude, double longitude) 
	{
		// adicionar verificador de distancia

		this.setCurrentLatitude(latitude);
		this.setCurrentLongitude(longitude);
	}

	public void addRegister(Register reg)
	{
		this.regBook.put(reg.getUser(), reg.clone());
	}

	public void removeRegister(Register reg)
	{
		this.regBook.remove(reg.getUser());
	}


	public Cache clone()
	{
		return new Cache(this);
	}
}

