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
import android.widget.Toast;

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        Spinner search = (Spinner)findViewById(R.id.parent_search);

        String[] sString = { "허용", "비허용" };

        SpinnerAdapter sAdapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, sString);



        search.setAdapter(sAdapter);
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

    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.parent_button:
                /*SharedPreferences pref = getSharedPreferences("Aa",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                EditText editText;
                editText = (EditText) findViewById(R.id.parent_search_school);
                editor.putString("school",editText.getText().toString());
                editor.commit();*/
                Toast.makeText(this, "서버와의 연결이 끊겼습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.parent_search_school:

                Intent intent1 = new Intent(this, SearchSchoolActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
