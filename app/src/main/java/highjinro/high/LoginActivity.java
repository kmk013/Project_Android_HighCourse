package highjinro.high;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

import highjinro.high.model.DataManager;
import highjinro.high.search.Reg;
import highjinro.high.search.network;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {
    private BackPressCloseHandler backPressCloseHandler;
    private EditText id;
    private EditText pw;

    DataManager dataManager;

    Call<Reg> RegCall;

    public static final String API_URL = "http://iwin247.net:4000";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    network service = retrofit.create(network.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backPressCloseHandler = new BackPressCloseHandler(this);

        id = (EditText)findViewById(R.id.login_id);
        id.setFilters(new InputFilter[] {filterAlpha});

        pw = (EditText)findViewById(R.id.login_pw);
        pw.setFilters(new InputFilter[] {filterAlphaNum});


    }

    public void onClick(View v) {
        String getid = id.getText().toString();
        String pws = pw.getText().toString();
        dataManager = new DataManager(getApplicationContext());

        switch (v.getId()) {
            case R.id.register:
                if(getid.getBytes().length <= 0 || pws.getBytes().length <= 0) {
                    Toast login_error = Toast.makeText(this, "ID 또는 PW를 입력해주세요", Toast.LENGTH_SHORT);
                    login_error.show();
                }
                else {
                    RegCall = service.Reg(getid, pws);
                    RegCall.enqueue(new Callback<Reg>() {
                        @Override
                        public void onResponse(Call<Reg> call, Response<Reg> response) {
                            switch (response.code()) {
                                case 200:
                                    try {
                                        dataManager.saveNativeLoginUserInfo(new JSONObject(response.body().toString()));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    break;
                                case 302:
                                    break;
                            }
                        }

                        @Override
                        public void onFailure(Call<Reg> call, Throwable t) {

                        }


                    });

                    Intent intent = new Intent(this, Login2Activity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void onBackPressed()
    {
        backPressCloseHandler.onBackPressed();
    }

    protected InputFilter filterAlpha = new InputFilter()
    {
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend)
        {
            Pattern ps = Pattern.compile("^[a-zA-Z]+$");
            if(!ps.matcher(source).matches())
            {
                return "";
            }
            return null;
        }
    };

    protected InputFilter filterAlphaNum = new InputFilter()
    {
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend)
        {
            Pattern ps = Pattern.compile("^[a-zA-Z0-9]+$");
            if(!ps.matcher(source).matches())
            {
                return "";
            }
            return null;
        }
    };
}
