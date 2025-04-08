package com.example.baitap_03;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout bg;
    private Switch sw;
    private ArrayList<Integer> backgrounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        bg = findViewById(R.id.bg);
        sw = findViewById(R.id.switch1);

        // Danh sách hình nền
        backgrounds = new ArrayList<>();
        backgrounds.add(R.drawable.bg1);
        backgrounds.add(R.drawable.bg2);
        backgrounds.add(R.drawable.bg3);
        backgrounds.add(R.drawable.bg4);

        // Tự động thay đổi hình nền khi mở app
        changeBackground();

        // Xử lý sự kiện khi bấm vào Switch
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Hình nền thay đổi", Toast.LENGTH_SHORT).show();
                    changeBackground();
                }
            }
        });
    }

    private void changeBackground() {
        Random random = new Random();
        int vitri = random.nextInt(backgrounds.size());
        bg.setBackgroundResource(backgrounds.get(vitri));
    }
}
