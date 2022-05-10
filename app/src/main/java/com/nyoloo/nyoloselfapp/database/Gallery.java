package com.nyoloo.nyoloselfapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Nama                 : Tiyo Haryo Subaktiono
// NIM                  : 10119217
// Kelas                : IF-6
@Entity
public class Gallery {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Gallery(String imagename){
        this.imagename = imagename;
    }
    public static Gallery[] isiFoto(){
        return new Gallery[]{
                new Gallery("gallery1"),
                new Gallery("gallery2"),
                new Gallery("gallery3"),
                new Gallery("gallery11"),
                new Gallery("gallery17"),
                new Gallery("gallery18"),
                new Gallery("gallery19"),
                new Gallery("gallery20"),
                new Gallery("gallery21"),
                new Gallery("gallery22"),
                new Gallery("gallery285"),
                new Gallery("gallery290"),
                new Gallery("gallery298"),
                new Gallery("gallery300"),
                new Gallery("gallery301"),
                new Gallery("gallery302"),
                new Gallery("gallery302"),
                new Gallery("gallery19"),

        };
    }
}
