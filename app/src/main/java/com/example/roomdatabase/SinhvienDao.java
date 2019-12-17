package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Query;

import io.reactivex.Observable;

import java.util.List;

@Dao
public interface SinhvienDao {
    @Query("SELECT * FROM Sinhvien")
    Observable<List<Sinhvien>> getAllSinhVien();
}
