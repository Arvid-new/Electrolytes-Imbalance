package Activites.Calculator.Calcium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class CalciumCalculator extends AppCompatActivity {
double result=0.0;
float measuredCa;
float serum;
EditText measuredB;
EditText serumB;
Button button;
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcium_calculator);
        measuredB=findViewById(R.id.measuredID);
        serumB=findViewById(R.id.serumID);
        button=findViewById(R.id.button);
        text=findViewById(R.id.resultID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(measuredB.getText().toString().equals("")||serumB.getText().toString().equals("")))
                    calculate();
            }
        });

    }
    public void calculate(){

            measuredCa=Float.parseFloat(measuredB.getText().toString());
            serum=Float.parseFloat(serumB.getText().toString());
           result=measuredCa+(0.8*(4-serum));
           String s="corrected calcium = "+String.format("%.2f",result)+" mg/dl";
            text.setText(s);


    }
}
