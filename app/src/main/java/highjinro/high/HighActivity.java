package highjinro.high;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HighActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high);

        Spinner startyear = (Spinner)findViewById(R.id.startyear);
        Spinner method = (Spinner)findViewById(R.id.method);
        Spinner later = (Spinner)findViewById(R.id.later);

        String[] syString = { "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008" };
        String[] mString = { "일반전형", "특별전형" };
        String[] lString = { "진학", "취업", "창업" };

        SpinnerAdapter syAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, syString);
        SpinnerAdapter mAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, mString);
        SpinnerAdapter lAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, lString);

        startyear.setAdapter(syAdapter);
        method.setAdapter(mAdapter);
        later.setAdapter(lAdapter);

    }

    public class SpinnerAdapter extends ArrayAdapter<String> {
        Context context;
        String[] items = new String[]{};

        public SpinnerAdapter(final Context context,
                              final int textViewResourceId, final String[] objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
            this.context = context;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_dropdown_item, parent, false);
            }

            TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
            tv.setText(items[position]);
            tv.setTextColor(Color.parseColor("#40c4ff"));
            tv.setTextSize(20);
            tv.setBackgroundColor(Color.parseColor("#ffffff"));
            return convertView;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if(convertView == null)
            {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_dropdown_item, parent, false);
            }

            TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
            tv.setText(items[position]);

            tv.setTextColor(Color.parseColor("#40c4ff"));
            tv.setTextSize(20);
            return convertView;
        }
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.high_search:
                Toast.makeText(this, "서버와의 연결이 끊겼습니다", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
