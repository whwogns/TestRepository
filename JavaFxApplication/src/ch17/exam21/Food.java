package ch17.exam21;

public class Food {
    private String image;
    private String name;
    private int score;
    private String description;

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Food(String image, String name, int score, String description) {
        this.image = image;
        this.name = name;
        this.score = score;
        this.description=description;
    }
}
