package android.example.com.fragment_replace_addtobackstack;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
/*import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;*/
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by tchl on 2016-06-15.
 */
public class FragmentOne extends Fragment implements View.OnClickListener {
    private Button mBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.e("TAG","Fragment one call onCreateView");
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mBtn = (Button) view.findViewById(R.id.first_btn);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        Log.e("TAG","Fragment on call onDestoryView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("TAG","Fragment one call onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v)
    {
        FragmentTwo fTwo = new FragmentTwo();
        FragmentManager fm =getFragmentManager();//this.getActivity().getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
     //   tx.remove(fTwo);
     //   tx.remove(fTwo);
        tx.replace(R.id.id_content, fTwo, "TWO");
        tx.addToBackStack(null);
        tx.commit();

    }
}
