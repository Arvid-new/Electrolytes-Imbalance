package Activites;

import android.view.View;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class SimpleViewHolder extends de.blox.graphview.ViewHolder {
   public TextView textView;
    public SimpleViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }
}
