package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.roomdatabase.SinhVienDatabase.getInstance;

public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ViewModelProviders
        mainViewModel = new MainViewModel();
        getLifecycle().addObserver(mainViewModel);
        SinhVienDatabase
                .getInstance(this)
                .sinhvienDao()
                .getAllSinhVien()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Sinhvien>>() {
                    @Override
                    public void accept(List<Sinhvien> sinhviens) throws Exception {
                        Log.d("BBB", sinhviens.size() + "");
                    }
                });
    }
}
