package highjinro.high.search;

/**
 * Created by Kimmingyu on 2016. 10. 31..
 */
public class Reg {
    private String id, pw, token;


    public Reg(String id, String pw){
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
