package com.nyoloo.nyoloselfapp.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


// Nama                 : Tiyo Haryo Subaktiono
// NIM                  : 10119217
// Kelas                : IF-6
@Entity
public class Song {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="imagename")
    public String imagename;

    @ColumnInfo(name ="titlesong")
    public String titlesong;

    @ColumnInfo(name ="artistname")
    public String artistname;

    public Song(String imagename,String titlesong,String artistname){
        this.imagename = imagename;
        this.titlesong = titlesong;
        this.artistname = artistname;
    }

    public static Song[] isiLagu(){
        return new Song[]{
                new Song("albumparamore","Pressure","Paramore"),
                new Song("albumparamore","CrushCrushCrush","Paramore"),
                new Song("albumparamore","Caught In The Middle","Paramore"),
                new Song("albumparamore","Last Hope","Paramore"),
                new Song("albumparamore","Misery Business","Paramore"),
                new Song("albumparamore","Decode","Paramore"),
                new Song("albumparamore","Turn in Off","Paramore"),
                new Song("albumparamore","Brighter","Paramore"),
                new Song("albumparamore","Part II","Paramore"),
                new Song("albumparamore","26","Paramore"),


        };
    }
}
