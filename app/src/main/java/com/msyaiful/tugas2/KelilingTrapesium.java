package com.msyaiful.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KelilingTrapesium extends AppCompatActivity implements View.OnClickListener {
    private EditText sisi1;
    private EditText sisi2;
    private EditText sisi3;
    private EditText sisi4;
    private Button hasil1;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keliling_trapesium);

        sisi1 = findViewById(R.id.asisi1);
        sisi2 = findViewById(R.id.asisi2);
        sisi3 = findViewById(R.id.asisi3);
        sisi4 = findViewById(R.id.asisi4);
        hasil1 = findViewById(R.id.ahasil1);
        total = findViewById(R.id.kelhal);

        hasil1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ahasil1)
        {
            String inputsisi1 = sisi1.getText().toString().trim();
            String inputsisi2 = sisi2.getText().toString().trim();
            String inputsisi3 = sisi3.getText().toString().trim();
            String inputsisi4 = sisi4.getText().toString().trim();

            boolean isInvalidInput = false;

            Double bsisi1 = toDouble(inputsisi1);
            Double bsisi2 = toDouble(inputsisi2);
            Double bsisi3 = toDouble(inputsisi3);
            Double bsisi4 = toDouble(inputsisi4);

            if (bsisi1 == null) {
                isInvalidInput = true;
                sisi1.setError("Tolong Diisi");
            }
            if (bsisi2 == null) {
                isInvalidInput = true;
                sisi2.setError("Tolong Diisi");
            }
            if (bsisi3 == null) {
                isInvalidInput = true;
                sisi3.setError("Tolong Diisi");
            }
            if (bsisi4 == null) {
                isInvalidInput = true;
                sisi4.setError("Tolong Diisi");
            }
            if (!isInvalidInput) {
                double kel = bsisi1 + bsisi2 + bsisi3 + bsisi4;
                total.setText(String.valueOf(kel));
            }
        }
    }

    private Double toDouble(String string) {
        try {
            return Double.valueOf(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
