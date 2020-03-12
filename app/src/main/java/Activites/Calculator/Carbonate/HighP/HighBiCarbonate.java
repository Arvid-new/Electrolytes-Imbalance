package Activites.Calculator.Carbonate.HighP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class HighBiCarbonate extends AppCompatActivity {
EditText plasmaCl;
EditText bodyWeight;
TextView res;
float pc,bw;
double result=0.0;
Button calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_bi_carbonate);
        plasmaCl=findViewById(R.id.plasmaCLID);
        bodyWeight=findViewById(R.id.bwID);
        res=findViewById(R.id.resID);
        calc =findViewById(R.id.calcuID);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(plasmaCl.getText().toString().equals("")||bodyWeight.getText().toString().equals("")))
                    calculate();

            }
        });

    }
    public void calculate(){
        pc=Float.parseFloat(plasmaCl.getText().toString());
        bw=Float.parseFloat(bodyWeight.getText().toString());
        result=((0.2*bw)*(100-pc)/154);
        String string="Vol = "+String.format("%.2f",result)+ " L";
        res.setText(string);
        

    }
}
