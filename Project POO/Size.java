/**
 * Classe que enumera constantes para o tamanho de uma cache
 *
 * @version (version number or date here)
 */

public enum Size 
{
    MICRO(0), SMALL(3), REGULAR(7), LARGE(12), OTHER();

    private static final int maxSize = 20;
    private int value;

    private Size() {
        this.value = maxSize;
    }

    private Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

