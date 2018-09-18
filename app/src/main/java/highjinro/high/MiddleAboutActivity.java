package highjinro.high;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MiddleAboutActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_about);

        Spinner interest = (Spinner)findViewById(R.id.interest);
        Spinner live = (Spinner)findViewById(R.id.live);
        Spinner gender = (Spinner)findViewById(R.id.gender);

        String[] iString = { "공업", "상업", "가사" };
        String[] lString = { "강남구", "강동구", "강북구", "강서구", "관악구",
                "광진구", "구로구", "금천구", "노원구", "도봉구",
                "동대문구", "동작구", "마포구", "서대문구", "서초구",
                "성동구", "성북구", "송파구", "양천구", "영등포구",
                "용산구", "은평구", "종로구", "중구", "중랑구" };
        String[] gString = { "남여공학", "남", "여" };

        SpinnerAdapter iAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, iString);
        SpinnerAdapter lAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, lString);
        SpinnerAdapter gAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, gString);

        interest.setAdapter(iAdapter);
        live.setAdapter(lAdapter);
        gender.setAdapter(gAdapter);
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
            if (convertView == null)
            {
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
        public View getView(int position, View convertView, ViewGroup parent) {
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
            case R.id.middle_about_check:
                Intent intent = new Intent(this, BoardActivity.class);
                startActivity(intent);
                break;
        }
    }
}
