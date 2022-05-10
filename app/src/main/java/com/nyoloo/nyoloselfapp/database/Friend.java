package com.nyoloo.nyoloselfapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Nama                 : Tiyo Haryo Subaktiono
// NIM                  : 10119217
// Kelas                : IF-6
@Entity
public class Friend {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="friend_name")
    public String friendName;

    @ColumnInfo(name ="code_name")
    public String codeName;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Friend(String friendName,String codeName,String imagename){
        this.friendName = friendName;
        this.codeName = codeName;
        this.imagename = imagename;
    }

    public static Friend[] isiData(){
        return new Friend[]{
                new Friend("Denden Triana","Codename : Sakura","friendimage1"),
                new Friend("Joyson Sitorus","Codename : TheBijiMan","friendimage2"),
                new Friend("Najib Raffi Irdhana","Codename : MrDeath","friendimage3"),
                new Friend("Rheza Pramana Putra D","Codename : PrimeOfPram","friendimage4"),
                new Friend("Tri Taftradi","Codename : Nyolo","gallery7"),
                new Friend("Moch Wandika Yusgiar","Codename : Kusa","friendimage7"),
                new Friend("M Akbar Attamimi","Codename : Akrab","friendimage8"),
                new Friend("Muhammad Ridwan","Codename : Lyxiie","friendimage9"),
        };
    }


}
