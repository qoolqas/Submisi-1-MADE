package com.example.moviecatalog;

import android.os.Parcel;
import android.os.Parcelable;

public class Res implements Parcelable {
    private  int photo;
    private String film;
    private String description;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.film);
        dest.writeString(this.description);
    }

    public Res() {
    }

    protected Res(Parcel in) {
        this.photo = in.readInt();
        this.film = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Res> CREATOR = new Parcelable.Creator<Res>() {
        @Override
        public Res createFromParcel(Parcel source) {
            return new Res(source);
        }

        @Override
        public Res[] newArray(int size) {
            return new Res[size];
        }
    };
}
