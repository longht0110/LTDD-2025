package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần từ giao diện
        EditText edtBirthDate = findViewById(R.id.edtBirthDate);
        TextView tvAge = findViewById(R.id.tvAge);
        Button btnGetAge = findViewById(R.id.btnGetAge);

        // Xử lý sự kiện nhấn nút
        btnGetAge.setOnClickListener(v -> {
            String birthDateStr = edtBirthDate.getText().toString();

            // Kiểm tra định dạng và tính tuổi
            if (!birthDateStr.isEmpty()) {
                try {
                    // Định dạng ngày tháng năm
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false); // Kiểm tra định dạng chính xác
                    Date birthDate = sdf.parse(birthDateStr);

                    // Lấy ngày, tháng, năm hiện tại
                    Calendar today = Calendar.getInstance();
                    int currentYear = today.get(Calendar.YEAR);
                    int currentMonth = today.get(Calendar.MONTH) + 1;
                    int currentDay = today.get(Calendar.DAY_OF_MONTH);

                    // Lấy ngày, tháng, năm từ ngày sinh
                    Calendar birth = Calendar.getInstance();
                    birth.setTime(birthDate);
                    int birthYear = birth.get(Calendar.YEAR);
                    int birthMonth = birth.get(Calendar.MONTH) + 1;
                    int birthDay = birth.get(Calendar.DAY_OF_MONTH);

                    // Tính tuổi
                    int age = currentYear - birthYear;
                    if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
                        age--;
                    }

                    // Hiển thị tuổi
                    tvAge.setText("Your age is: " + age);

                } catch (ParseException e) {
                    // Nếu định dạng sai
                    tvAge.setText("Invalid date format! Use dd/MM/yyyy.");
                }
            } else {
                tvAge.setText("Please enter your birth date!");
            }
        });
    }
}
