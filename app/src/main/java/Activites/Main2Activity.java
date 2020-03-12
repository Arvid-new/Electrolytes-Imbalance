package Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.graduatioapp.AboutUs;
import com.example.graduatioapp.R;

import Activites.Calculator.ElementsChoice;

public class Main2Activity extends AppCompatActivity {
ImageButton calculator;
ImageButton tree;
ImageButton aboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calculator=findViewById(R.id.calculatorID);
        tree=findViewById(R.id.treeID);
        aboutUs=findViewById(R.id.aboutusid);
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, AboutUs.class));
            }
        });
        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, ElementsChoice.class));

            }
        });
    }
}
