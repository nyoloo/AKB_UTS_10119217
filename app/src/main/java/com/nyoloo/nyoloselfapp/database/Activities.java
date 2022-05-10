package com.nyoloo.nyoloselfapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Tanggal Pengerjaan   : 4 Mei 2022
// Nama                 : Tiyo Haryo Subaktiono
// NIM                  : 10119217
// Kelas                : IF-6
@Entity
public class Activities {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="kegiatan")
    public String kegiatan;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Activities(String kegiatan,String imagename){
        this.kegiatan = kegiatan;
        this.imagename = imagename;
    }

    public static Activities[] isiAktifitas(){
        return new Activities[]{
                new Activities("Play COC","ceoce"),
                new Activities("Play Bar Bar Q","barbarq"),
                new Activities("Play SAMP","gallery278"),
                new Activities("Watch Youtube","youtube"),
                new Activities("Listen Music","music"),
        };
    }
}
