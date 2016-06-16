package android.example.com.fragment_replace_addtobackstack;


/*import android.support.v4.app.FragmentManager;*/
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
/*import android.support.v4.app.FragmentTransaction;*/
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*    FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction tx=fm.beginTransaction();
        tx.add(R.id.id_content,new FragmentOne(),"One");*/
        if(savedInstanceState == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction tx = fm.beginTransaction();
            tx.add(R.id.id_content, new FragmentOne(), "ONE");
            tx.commit();
        }



    }
}
