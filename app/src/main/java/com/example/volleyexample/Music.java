package com.example.volleyexample;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {
    String artistName, id, name, url;

    public Music(String artistName, String id, String name, String url){
        this.artistName = artistName;
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getArtistName() {
        return artistName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Music(Parcel parcel) {
        this.artistName = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.url = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(artistName);
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(url);
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel parcel) {
            return new Music(parcel);
        }

        @Override
        public Music[] newArray(int i) {
            return new Music[i];
        }
    };

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
