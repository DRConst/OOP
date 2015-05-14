/**
 * Classe que enumera constantes para a dificuldade de uma cache
 * 
 * @version (2015.05.01)
 */
public enum Difficulty
{
    EASY(1), MEDIUM_EASY(2), MEDIUM(3), MEDIUM_HARD(4), HARD(5);

    private int value;

    private Difficulty(int value) 
    {
		this.value = value;
    }

    public int getValue() { return this.value; }
}

