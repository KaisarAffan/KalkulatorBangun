package com.example.kalkulatorbangun.BangunRuang.BangunRuangChild;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkulatorbangun.R;

public class Kerucut extends AppCompatActivity {

    EditText inputUser1,inputUser2;
    Button buttonHitung;

    TextView textViewResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerucut);

        inputUser1 = findViewById(R.id.EtJari);
        inputUser2 = findViewById(R.id.EtGarisLukis);
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
        String garisLukisStr = inputUser2.getText().toString().trim();
        String lebarStr = inputUser1.getText().toString().trim();
        if (!garisLukisStr.isEmpty() && !lebarStr.isEmpty()) {
            double garisLukis = Double.parseDouble(garisLukisStr);
            double jari = Double.parseDouble(lebarStr);
            if (garisLukis <= 0) {
                Toast.makeText(this, "Garis Lukis harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }else if(jari <= 0) {
                Toast.makeText(this, "Jari jari harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }
            double phi = 3.14;
            double luas = phi * jari * (garisLukis + jari);
            String hasil = String.format("%.2f", luas) + "cm";
            textViewResult.setText(hasil);
        } else {
            Toast.makeText(this, "Masukkan panjang dan lebar terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}
