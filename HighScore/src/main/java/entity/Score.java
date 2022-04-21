package entity;

public class Score {
    private String intials;
    private int score;

    public Score() {
    }

    public Score(String intials, int score) {
        this.intials = intials;
        this.score = score;
    }

    public String getIntials() {
        return intials;
    }

    public void setIntials(String intials) {
        this.intials = intials;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
