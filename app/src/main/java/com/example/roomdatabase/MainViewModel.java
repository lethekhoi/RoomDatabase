package com.example.roomdatabase;

import android.content.Context;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel implements LifecycleObserver {
    private MutableLiveData<List<Sinhvien>> listSinhvien = new MutableLiveData<>();

    public LiveData<List<Sinhvien>> getListSinhvien(Context context) {

        DatabaseRepository
                .getInstance(context)
                .getAllSinhVien()
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<List<Sinhvien>>() {
                    @Override
                    public void accept(List<Sinhvien> sinhviens) throws Exception {
                        listSinhvien.setValue(sinhviens);
                    }
                });
        return listSinhvien;
    }
}
