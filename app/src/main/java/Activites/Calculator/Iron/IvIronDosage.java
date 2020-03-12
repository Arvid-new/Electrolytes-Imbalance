package Activites.Calculator.Iron;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class IvIronDosage extends AppCompatActivity {
EditText targethbE;
EditText actualhbE;
EditText bodyweightE;
Button calc;
TextView resultText;
double targetHb,actualHb,result,bodyWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv_iron_dosage);
        targethbE=findViewById(R.id.targethbID);
        actualhbE=findViewById(R.id.actualhbID);
        bodyweightE=findViewById(R.id.bodyweightID);
        calc=findViewById(R.id.calcID);
        resultText=findViewById(R.id.resultID);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(targethbE.getText().toString().equals("")||bodyweightE.getText().toString().equals("")
                ||actualhbE.getText().toString().equals("")))
                calculate();
            }
        });


    }
    public void calculate(){
        targetHb=Double.parseDouble(targethbE.getText().toString());
        actualHb=Double.parseDouble(actualhbE.getText().toString());
        bodyWeight=Double.parseDouble(bodyweightE.getText().toString());
        result=((targetHb-actualHb)*2.4*bodyWeight)+500;
        String string="required IV Iron Dosage = "+String.format("%.2f",result)+" mg";
        resultText.setText(string);
    }

}
