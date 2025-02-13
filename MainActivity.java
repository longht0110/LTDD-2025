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

        EditText edtBirthDate = findViewById(R.id.edtBirthDate);
        TextView tvAge = findViewById(R.id.tvAge);
        Button btnGetAge = findViewById(R.id.btnGetAge);

        btnGetAge.setOnClickListener(v -> {
            String birthDateStr = edtBirthDate.getText().toString();


            if (!birthDateStr.isEmpty()) {
                try {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false); 
                    Date birthDate = sdf.parse(birthDateStr);

                    Calendar today = Calendar.getInstance();
                    int currentYear = today.get(Calendar.YEAR);
                    int currentMonth = today.get(Calendar.MONTH) + 1;
                    int currentDay = today.get(Calendar.DAY_OF_MONTH);

                    Calendar birth = Calendar.getInstance();
                    birth.setTime(birthDate);
                    int birthYear = birth.get(Calendar.YEAR);
                    int birthMonth = birth.get(Calendar.MONTH) + 1;
                    int birthDay = birth.get(Calendar.DAY_OF_MONTH);

                    int age = currentYear - birthYear;
                    if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
                        age--;
                    }

                    tvAge.setText("Your age is: " + age);

                } catch (ParseException e) {

                    tvAge.setText("Invalid date format! Use dd/MM/yyyy.");
                }
            } else {
                tvAge.setText("Please enter your birth date!");
            }
        });
    }
}
