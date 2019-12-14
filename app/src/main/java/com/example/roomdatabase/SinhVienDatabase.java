package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Sinhvien.class}, version = 1, exportSchema = false)
public abstract class SinhVienDatabase extends RoomDatabase { //dùng abstract
    private static SinhVienDatabase sinhVienDatabase = null;

    private SinhVienDatabase() {

    }

    public static SinhVienDatabase getInstance(Context context) {
        if (sinhVienDatabase == null) {
            sinhVienDatabase = Room.databaseBuilder(context, SinhVienDatabase.class, "Quanlysinhvien")
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return sinhVienDatabase;
    }
}
