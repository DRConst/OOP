
import java.util.TreeMap;

public class Statistics {

    TreeMap<Integer, TreeMap<Month, Integer>> nOC; //numero de caches por mes e ano criadas
    TreeMap<Integer, TreeMap<Month, Integer>> nDC; //numero de caches por mes e ano realizadas
    TreeMap<String, Integer> nOCT; //numero de caches por tipo criadas
    TreeMap<String, Integer> nDCT; //numero de caches por tipo realizadas
    int nDays; //numero de dias desde a ultima vez que o utilizador fez uma cache

    public Statistics() {
        this.nOC = new TreeMap<>();
        this.nDC = new TreeMap<>();
        this.nOCT = new TreeMap<>();
        this.nDCT = new TreeMap<>();
        this.nDays = 0;
    }

    public Statistics(TreeMap<Integer, TreeMap<Month, Integer>> nOC, TreeMap<Integer, TreeMap<Month, Integer>> nDC, TreeMap<String, Integer> nOCT, TreeMap<String, Integer> nDCT, int nDays) {
        this.nOC = new TreeMap<>(nOC);
        this.nDC = new TreeMap<>(nDC);
        this.nOCT = new TreeMap<>(nOCT);
        this.nDCT = new TreeMap<>(nDCT);
        this.nDays = nDays;
    }

    public Statistics(Statistics s) {
        this.nOC = new TreeMap<>(s.getNOC());
        this.nDC = new TreeMap<>(s.getNDC());
        this.nOCT = new TreeMap<>(s.getNOCT());
        this.nDCT = new TreeMap<>(s.getNDCT());
        this.nDays = s.getNDays();
    }

    public TreeMap<Integer, TreeMap<Month, Integer>> getNOC() {
        return new TreeMap<>(this.nOC);
    }

    public TreeMap<Integer, TreeMap<Month, Integer>> getNDC() {
        return new TreeMap<>(this.nDC);
    }

    public TreeMap<String, Integer> getNOCT() {
        return new TreeMap<>(this.nOCT);
    }

    public TreeMap<String, Integer> getNDCT() {
        return new TreeMap<>(this.nDCT);
    }

    public int getNDays() {
        return this.nDays;
    }

    public void setNOC(TreeMap<Integer, TreeMap<Month, Integer>> nOC) {
        this.nOC = nOC;
    }

    public void setNDC(TreeMap<Integer, TreeMap<Month, Integer>> nDC) {
        this.nDC = nDC;
    }

    public void setNOCT(TreeMap<String, Integer> nOCT) {
        this.nOCT = nOCT;
    }

    public void setNDCT(TreeMap<String, Integer> nDCT) {
        this.nDCT = nDCT;
    }

    public void setNDays(int nDays) {
        this.nDays = nDays;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Statistics-----------------\n\n");

        s.append("Nº de Atividades ao longo do ano:\n");

        return s.toString();
    }
}
