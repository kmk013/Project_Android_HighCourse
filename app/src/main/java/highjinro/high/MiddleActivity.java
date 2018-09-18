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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MiddleActivity extends AppCompatActivity {

    private EditText middle_nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);

        Spinner favor = (Spinner)findViewById(R.id.favor);
        Spinner school = (Spinner)findViewById(R.id.school);

        String[] fString = { "공업", "경영사무", "가정보건복지", "산업", "정보통신산업", "디자인", "문화레저산업", "기타" };
        String[] sString = { "특성화고", "마이스터고" };

        SpinnerAdapter fAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, fString);
        SpinnerAdapter sAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, sString);

        favor.setAdapter(fAdapter);
        school.setAdapter(sAdapter);

        middle_nick = (EditText)findViewById(R.id.middle_nick);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.middle_check:
                if(middle_nick.getText().toString().equals("")) {
                    Toast.makeText(this, "서버와의 연결이 끊겼습니다", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(this, MiddleAboutActivity.class);
                    startActivity(intent);
                }
                break;
        }
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
}
