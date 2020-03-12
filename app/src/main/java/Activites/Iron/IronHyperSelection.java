package Activites.Iron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.graduatioapp.R;

public class IronHyperSelection extends AppCompatActivity {
public ImageButton hemoB;
public ImageButton chelatingB;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_hyper_selection);
        hemoB=findViewById(R.id.hemoID);
        chelatingB=findViewById(R.id.chelatingID);
         intent=new Intent(IronHyperSelection.this, IronHyperTree.class);

        hemoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","hemo");
                startActivity(intent);
            }
        });
        chelatingB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","chelating");
                startActivity(intent);
            }
        });
    }
}
