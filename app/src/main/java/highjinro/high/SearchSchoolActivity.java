package highjinro.high;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchSchoolActivity extends AppCompatActivity
{
    static String[] schoolString = { "강서공업고등학교", "경기상업고등학교", "경기여자상업고등학교", "경복비즈니스고등학교", "고명경영고등학교",
            "광신정보산업고등학교", "광운전자공업고등학교", "단국공업고등학교", "대경상업고등학교", "대동세무고등학교",
            "대일관광고등학교", "대진디자인고등학교", "덕일전자공업고등학교", "동구마케팅고등학교", "동명여자정보산업고등학교",
            "동산정보산업고등학교", "동일여자상업고등학교", "리라아트고등학교", "미래산업과학고등학교", "미림여자정보과학고등학교",
            "상일미디어고등학교", "서서울생활과학고등학교", "서울공업고등학교", "서울관광고등학교", "서울금융고등학교",
            "서울도시과학기술고등학교", "서울디자인고등학교", "서울디지텍고등학교", "서울로봇고등학교", "서울문화고등학교",
            "서울방송고등학교", "서울아이티고등학교", "서울여자상업고등학교", "서울연희미용고등학교", "서울영상고등학교",
            "서울전자고등학교", "휘경공업고등학교", "화곡보건경영고등학교", "홍익디자인고등학교", "해성국제컨벤션고등학교",
            "한양공업고등학교", "한세사이버보안고등학교", "한강미디어고등학교", "정화여자상업고등학교", "정암미용고등학교",
            "일신여자상업고등학교", "인덕공업고등학교", "이화여자대학교병설미디어고등학교", "은평메디텍고등학교", "유한공업고등학교",
            "용산공업고등학교", "예일디자인고등학교", "영신간호비즈니스고등학교", "영락유헬스고등학교", "영등포공업고등학교",
            "서울컨벤션고등학교", "서일국제경영고등학교", "선린인터넷고등학교", "선일이비즈니스고등학교", "선정관광고등학교",
            "성동공업고등학교", "성동글로벌경영고등학교", "성수공업고등학교", "성암국제무역고등학교", "세그루패션디자인고등학교",
            "세명컴퓨터고등학교", "서울항공비즈니스고등학교", "송곡관광고등학교", "송파공업고등학교", "수도전기공업고등학교",
            "신동신정보산업고등학교", "신정여자상업고등학교", "신진자동차고등학교", "염광여자메디텍고등학교"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_school);

        ListView listView = (ListView)findViewById(R.id.search_school_list);

        ArrayList<ListViewItem> data = new ArrayList<>();
        for(int i = 0; i < 74; i++)
        {
            ListViewItem school = new ListViewItem(schoolString[i]);

            data.add(school);
        }

        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.listviewitem, data);
        listView.setAdapter(adapter);
    }

    public void onClick(View v)
    {
        Toast chk = Toast.makeText(this, "이 학교를 선택합니다", Toast.LENGTH_SHORT);
        chk.show();

        finish();
    }
}
