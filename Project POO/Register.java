/** 
 * Classe que implementa um registo de que
 * uma pessoa completou uma cache
 * 
 * @version (2015.04.30)
 */

import java.util.*;

public class Register
{
	private String user;
	private String comment;
	private GregorianCalendar date;


	public Register()
	{
		this.user = "";
		this.comment = "";
		this.date = new GregorianCalendar();
	}

	public Register(String comment, String user, boolean found, int year, int month, int dayOfMonth)
	{
		this.user = user;
		this.comment = comment;
		this.date = new GregorianCalendar(year, month, dayOfMonth);
	}

	public Register(Register reg)
	{
		this.user = reg.getUser();
		this.comment = reg.getComment();
		this.date = reg.getDate();
	}


	public String getUser() { return this.user; }

	public String getComment() { return this.comment; }

	public int getYear() { return this.date.get(Calendar.YEAR); }

	public int getMonth() { return this.date.get(Calendar.MONTH); }

	public int getDayOfMonth() { return this.date.get(Calendar.DAY_OF_MONTH); }

	public GregorianCalendar getDate() { return new GregorianCalendar(this.getYear(), this.getMonth(), this.getDayOfMonth()); }


	private void setUser(String user) { this.user = user; }

	public void setComment(String comment) { this.comment = comment; }

	public void setDate(int year, int month, int dayOfMonth) { this.date = new GregorianCalendar(year, month, dayOfMonth); }


	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		else
		{
			Register r = (Register) o;

			return (this.user.equals(r.getUser()) && this.comment.equals(r.getComment()) && this.getYear() == r.getYear() && this.getMonth() == r.getMonth() && this.getDayOfMonth() == r.getDayOfMonth());
		}
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();

		s.append("---------------Registo---------------\n\n");
		s.append("\tUtilizador: " + this.user);
		s.append("\tData: " + this.getYear() + "/" + this.getMonth() + "/" + this.getDayOfMonth() + "\n");
		s.append("\tComentário:\n\n\t" + this.comment);
		s.append("-------------------------------------");

		return s.toString();
	}

	public Register clone()
	{
		return new Register(this);
	}
}

