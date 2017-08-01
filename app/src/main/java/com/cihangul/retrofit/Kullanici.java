package com.cihangul.retrofit;

/**
 * Created by Cihan on 26.06.2017.
 */

public class Kullanici {
    private String resim;
    private String isim;

    public Kullanici() {
    }

    public Kullanici(String resim, String isim) {
        this.resim = resim;
        this.isim = isim;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
