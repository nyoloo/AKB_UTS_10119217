package com.nyoloo.nyoloselfapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Nama                 : Tiyo Haryo Subaktiono
// NIM                  : 10119217
// Kelas                : IF-6
@Entity
public class Videos {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="videoid")
    public String videoid;

    public Videos(String videoid){
        this.videoid = videoid;
    }

    public static Videos[] isiVideo(){
        return new Videos[]{
                new Videos("nYn7Stbwjng"),
                new Videos("1kz6hNDlEEg"),
                new Videos("TIy3n2b7V9k"),
                new Videos("fenGmHuRFW8"),
                new Videos("BMTCXKePIbs"),
                new Videos("KagvExF"),
                new Videos("mgJ8BZi3vTA"),
                new Videos("qUL6yKvZgoM"),
                new Videos("y-MaaxgdUT4"),

        };
    }
}
