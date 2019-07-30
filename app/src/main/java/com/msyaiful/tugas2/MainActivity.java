package com.msyaiful.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int req_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button keltra = findViewById(R.id.keltra);
        keltra.setOnClickListener(this);
        Button kelbeke = findViewById(R.id.kelbeke);
        kelbeke.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.keltra:
                Intent intent1 = new Intent(MainActivity.this, KelilingTrapesium.class);
                startActivity(intent1);
                break;
            case R.id.kelbeke:
                Intent intent2 = new Intent(MainActivity.this, KelilingBelahKetupat.class);
                startActivityForResult(intent2, req_code);
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                TextView hasilnama = findViewById(R.id.view1);
                hasilnama.setText(data.getData().toString());
            }
        }
    }
}
