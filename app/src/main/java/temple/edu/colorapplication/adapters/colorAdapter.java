package temple.edu.colorapplication.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import temple.edu.colorapplication.R;

public class colorAdapter extends BaseAdapter{

    Context context;
    String[] colors;
    String[] names; //second array for regional text

    public colorAdapter(Context context, String[] colors, String[] names) {
        this.context = context;
        this.colors = colors;
        this.names = names;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);

        //returns translated text
        textView.setText(names[position]);

        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        //returns translated text
        textView.setText(names[position]);
        textView.setBackgroundColor(Color.parseColor(colors[position]));

        return textView;
    }
}
