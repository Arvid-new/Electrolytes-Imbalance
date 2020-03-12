package Activites.Calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.graduatioapp.R;

import Activites.Calculator.Calcium.CalciumCalculator;
import Activites.Calculator.Carbonate.HighP.HighBiCarbonate;
import Activites.Calculator.Carbonate.Low;
import Activites.Calculator.Iron.IvIronDosage;
import Activites.Calculator.Iron.TranseferrinSaturation;
import Activites.Calculator.Magnesium.MagnesiumCalculator;
import Activites.Calculator.Potassium.PottasiumCalculator;
import Activites.Calculator.Sodium.HighS.ArdogueFormula;
import Activites.Calculator.Sodium.HighS.TotalWterDeficit;
import Activites.Calculator.Sodium.LowS.LowS;

public class ElementsChoice extends AppCompatActivity implements View.OnClickListener {
    private Button ironB;
    private Button calciumB;
    private Button magnesiumB;
    private Button sodiumB;
    private Button biB;
    private Button potassiumB;
    AlertDialog.Builder builder;
    AlertDialog.Builder builder2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elements_choice);
        builder=new AlertDialog.Builder(ElementsChoice.this);
        ironB=findViewById(R.id.ironID);
        calciumB=findViewById(R.id.calciumID);
        magnesiumB=findViewById(R.id.magnesiumID);
        sodiumB=findViewById(R.id.sodiumID);
        biB=findViewById(R.id.biID);
        potassiumB=findViewById(R.id.potassiumID);


        ironB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Choice");
                builder.setCancelable(true);
                builder.setMessage("1. equation of IV iron dosage\n2. equation of Transeferrin Saturation");
                builder.setPositiveButton("choice 2", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ElementsChoice.this, TranseferrinSaturation.class));
                    }
                });
                builder.setNegativeButton("choice 1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ElementsChoice.this, IvIronDosage.class));
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        biB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Choice");
                builder.setCancelable(true);
                builder.setMessage("1. equations for High HCO3\n2. equations for low HCO3");
                builder.setPositiveButton("High", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hco3Builder();
                    }
                });
                builder.setNegativeButton("Low", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ElementsChoice.this, Low.class));
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }

        });
        calciumB.setOnClickListener(this);
        magnesiumB.setOnClickListener(this);
        sodiumB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Choice");
                builder.setCancelable(true);
                builder.setMessage("1. equations for High Sodium\n2. equations for low Sodium");
                builder.setPositiveButton("High", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                  //      startActivity(new Intent(ElementsChoice.this, HighBiCarbonate.class));
                        dialog.cancel();
                        setNewBuilder();

                    }
                });
                builder.setNegativeButton("Low", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ElementsChoice.this, LowS.class));
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        potassiumB.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.calciumID:{
        calciumBuilder();
    }
    break;
    case R.id.magnesiumID:{
        magnesiumBuilder();
    }
    break;
    case R.id.potassiumID:{
        potassiumBuilder();
    }
    break;

}
    }


    public void setNewBuilder(){
        builder2=new AlertDialog.Builder(ElementsChoice.this);
        builder2.setTitle("choice");
        builder2.setMessage("1.Total Water Deficit\n2.Ardogue Formula");
        builder2.setPositiveButton("choice 2", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(ElementsChoice.this, ArdogueFormula.class));
            }
        });
        builder2.setNegativeButton("choice 1", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(ElementsChoice.this,TotalWterDeficit.class));

            }
        });

        AlertDialog dialog=builder2.create();
        dialog.show();
    }


    public void magnesiumBuilder(){
        builder2=new AlertDialog.Builder(ElementsChoice.this);
        builder2.setTitle("Name of Equation");
        builder2.setMessage("Fractional Excretion of Magnesium %");
        builder2.setCancelable(false);
        builder2.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(ElementsChoice.this, MagnesiumCalculator.class));
            }
        });
        builder2.setNegativeButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        AlertDialog dialog=builder2.create();
        dialog.show();
    }

    public void calciumBuilder(){
        builder2=new AlertDialog.Builder(ElementsChoice.this);
        builder2.setTitle("Name of Equation");
        builder2.setMessage("Corrected Calcium (mg/dl)");
        builder2.setCancelable(false);
        builder2.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(ElementsChoice.this, CalciumCalculator.class));
            }
        });
        builder2.setNegativeButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        AlertDialog dialog=builder2.create();
        dialog.show();
    }

    public void potassiumBuilder(){
        builder2=new AlertDialog.Builder(ElementsChoice.this);
        builder2.setTitle("Name of Equation");
        builder2.setMessage("Potassium Deficit (mmol)");
        builder2.setCancelable(false);
        builder2.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(ElementsChoice.this, PottasiumCalculator.class));
            }
        });
        builder2.setNegativeButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        AlertDialog dialog=builder2.create();
        dialog.show();
    }


public void hco3Builder(){
    builder2=new AlertDialog.Builder(ElementsChoice.this);
    builder2.setTitle("Name of Equation");
    builder2.setMessage("Volume of Isotonic saline needed to correct chloride deficit (L)");
    builder2.setCancelable(false);
    builder2.setPositiveButton("Go", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            startActivity(new Intent(ElementsChoice.this, HighBiCarbonate.class));
        }
    });
    builder2.setNegativeButton("Return", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();

        }
    });

    AlertDialog dialog=builder2.create();
    dialog.show();
}



}



