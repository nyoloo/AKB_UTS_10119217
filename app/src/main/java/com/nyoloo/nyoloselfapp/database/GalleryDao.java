package com.nyoloo.nyoloselfapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface GalleryDao {
    @Query("SELECT * FROM Gallery")
    List<Gallery> getAllGallery();

    @Query("DELETE FROM Gallery")
    void deleteAllGallery();
    @Insert
    void insert(Gallery... galleries);
}
