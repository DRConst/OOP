/**
 * Exceção que indica que um evento está arquivado
 *
 * @version (2015.06.03)
 */

public class NotActiveEventException extends Exception
{
	public NotActiveEventException() { super (); }

	public NotActiveEventException(String s) { super(s); }
}

