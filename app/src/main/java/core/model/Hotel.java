package core.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ary on 4/6/17.
 */

public class Hotel extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private int rating;
    private boolean isRecomendation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isRecomendation() {
        return isRecomendation;
    }

    public void setRecomendation(boolean recomendation) {
        isRecomendation = recomendation;
    }
}
