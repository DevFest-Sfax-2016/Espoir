package com.espoir.app;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 27/11/2016.
 */
@IgnoreExtraProperties
public class Gallery {

    String image;
    String titre;
    String idU;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Gallery() {
    }

    public Gallery(String image, String titre, String idU) {
        this.image = image;
        this.titre = titre;
        this.idU = idU;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIdU() {
        return idU;
    }

    public void setIdU(String idU) {
        this.idU = idU;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }



    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("idU", idU);
        result.put("image", image);
        result.put("titre", titre);
        result.put("starCount", starCount);
        result.put("stars", stars);

        return result;
    }
}
