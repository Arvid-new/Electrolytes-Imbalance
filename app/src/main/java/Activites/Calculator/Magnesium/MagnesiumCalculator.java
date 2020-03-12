package Activites.Calculator.Magnesium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class MagnesiumCalculator extends AppCompatActivity {
EditText mgs;
EditText mgu;
EditText cru;
EditText crs;
Button calculateB;
TextView resultText;
float mguN,mgsN,cruN,crsN;
double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnesium_calculator);
        mgs=findViewById(R.id.mgs);
        mgu=findViewById(R.id.mgu);
        cru=findViewById(R.id.crs);
        crs=findViewById(R.id.cru);
        calculateB=findViewById(R.id.calculateID);
        resultText=findViewById(R.id.resultID);
        calculateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(cru.getText().toString().equals("") || crs.getText().toString().equals("") ||
                        mgu.getText().toString().equals("") || mgs.getText().toString().equals("")))
                    calculate();
            }
        });


    }


    public void calculate(){
        mgsN=Float.parseFloat(mgs.getText().toString());
        mguN=Float.parseFloat(mgu.getText().toString());
        cruN=Float.parseFloat(cru.getText().toString());
        crsN=Float.parseFloat(crs.getText().toString());
        result=((mguN*crsN)*1.0/(mgsN*cruN)*1.0)*100;
        String string="FEMg = "+ String.format("%.2f",result)+" %"    ;
        resultText.setText(string);


    }
}
