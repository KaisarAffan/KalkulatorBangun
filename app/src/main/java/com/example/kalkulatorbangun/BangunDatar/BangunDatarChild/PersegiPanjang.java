package com.example.kalkulatorbangun.BangunDatar.BangunDatarChild;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkulatorbangun.R;


public class PersegiPanjang extends AppCompatActivity {
    EditText inputUser1,inputUser2;
    Button buttonHitung;

    TextView textViewResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch_persegi_panjang);

        inputUser1 = findViewById(R.id.EtLebar);
        inputUser2 = findViewById(R.id.EtPanjang);
        buttonHitung = findViewById(R.id.sum);
        textViewResult = findViewById(R.id.tvHasil);


        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung();
            }
        });
    }
    private void hitung() {
        String panjangStr = inputUser2.getText().toString().trim();
        String lebarStr = inputUser1.getText().toString().trim();
        if (!panjangStr.isEmpty() && !lebarStr.isEmpty()) {
            double panjang = Double.parseDouble(panjangStr);
            double lebar = Double.parseDouble(lebarStr);
            if (panjang <= 0) {
                Toast.makeText(this, "Panjang harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }else if(lebar <= 0) {
                Toast.makeText(this, "Lebar harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }
            double luas = panjang * lebar;
            String hasil = String.format("%.2f", luas) + "cm";
            textViewResult.setText(hasil);
        } else {
            Toast.makeText(this, "Masukkan panjang dan lebar terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}