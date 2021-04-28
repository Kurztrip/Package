package com.kurztrip.packages.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Package")
public class Package implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "weight")
    private float weight;

    @NotNull
    @Column(name = "volume")
    private float volume;

    @NotNull
    @Column(name = "longitude")
    private float latitude;

    @NotNull
    @Column(name = "latitude")
    private float longitude;

    @NotNull
    @Column(name = "storeId")
    private int storeId;

    public Package() {
    }

    public int getId(){
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }


}
