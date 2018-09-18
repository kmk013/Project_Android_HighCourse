package highjinro.high;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login2Activity extends AppCompatActivity
{
    private Intent intent;
    private Button login2_middle;
    private Button login2_high;
    private Button login2_parent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        intent = null;

        login2_middle = (Button)findViewById(R.id.login2_middle);
        login2_high = (Button)findViewById(R.id.login2_high);
        login2_parent = (Button)findViewById(R.id.login2_parent);
    }

    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.login2_middle:
                login2_middle.setBackgroundResource(R.drawable.un_middle);
                login2_high.setBackgroundResource(R.drawable.high);
                login2_parent.setBackgroundResource(R.drawable.parent);
                intent = new Intent(this, MiddleActivity.class);
                break;
            case R.id.login2_high:
                login2_middle.setBackgroundResource(R.drawable.middle);
                login2_high.setBackgroundResource(R.drawable.un_high);
                login2_parent.setBackgroundResource(R.drawable.parent);
                intent = new Intent(this, HighActivity.class);
                break;
            case R.id.login2_parent:
                login2_middle.setBackgroundResource(R.drawable.middle);
                login2_high.setBackgroundResource(R.drawable.high);
                login2_parent.setBackgroundResource(R.drawable.un_parent);
                intent = new Intent(this, ParentActivity.class);
                break;
            case R.id.register:
                if(intent == null)
                {
                    Toast error = Toast.makeText(this, "자신의 소속을 선택해주세요", Toast.LENGTH_SHORT);
                    error.show();
                }
                else
                {
                    login2_middle.setBackgroundResource(R.drawable.middle);
                    login2_high.setBackgroundResource(R.drawable.high);
                    login2_parent.setBackgroundResource(R.drawable.parent);
                    startActivity(intent);
                }
                break;
        }
    }
}
