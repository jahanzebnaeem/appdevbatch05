package com.example.android.recylcerwithcard;

public class Model {
    String albumTitle;
    String artistName;
    String albumUrl;
    String artistUrl;
    String btnUrl;

    public Model(){}

    public Model(String albumTitle, String artistName, String albumUrl, String artistUrl, String btnUrl) {
        this.albumTitle = albumTitle;
        this.artistName = artistName;
        this.albumUrl = albumUrl;
        this.artistUrl = artistUrl;
        this.btnUrl = btnUrl;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    public String getArtistUrl() {
        return artistUrl;
    }

    public void setArtistUrl(String artistUrl) {
        this.artistUrl = artistUrl;
    }

    public String getBtnUrl() {
        return btnUrl;
    }

    public void setBtnUrl(String btnUrl) {
        this.btnUrl = btnUrl;
    }
}
