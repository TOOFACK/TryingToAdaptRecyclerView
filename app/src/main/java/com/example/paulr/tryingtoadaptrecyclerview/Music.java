package com.example.paulr.tryingtoadaptrecyclerview;

import java.io.Serializable;

public class Music implements Serializable {

    private String artist;
    private String music;
    private int albunImageId;

    public Music(String artist, String music, int albunImageId) {
        this.artist = artist;
        this.music = music;
        this.albunImageId = albunImageId;
    }

    public Music(Object name) {

    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public int getAlbunImageId() {
        return albunImageId;
    }

    public void setAlbunImageId(int albunImageId) {
        this.albunImageId = albunImageId;
    }
}
