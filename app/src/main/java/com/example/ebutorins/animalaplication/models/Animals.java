package com.example.ebutorins.animalaplication.models;

/**
 * Created by ebutorins on 5/11/2016.
 */
public class Animals {

    private int animalId;
    private int imageId;
    private String kindOfAnimal;
    private String habitat;
    private int quantityTines;
    private boolean horns;
    private int weight;

    public Animals() {

    }

    public Animals(int animalId, int imageId, String kindOfAnimal, String habitat, int quantityTines, boolean horns, int weight) {
        this.animalId = animalId;
        this.imageId = imageId;
        this.kindOfAnimal = kindOfAnimal;
        this.habitat = habitat;
        this.quantityTines = quantityTines;
        this.horns = horns;
        this.weight = weight;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getQuantityTines() {
        return quantityTines;
    }

    public void setQuantityTines(int quantityTines) {
        this.quantityTines = quantityTines;
    }

    public boolean isHorns() {
        return horns;
    }

    public void setHorns(boolean horns) {
        this.horns = horns;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
