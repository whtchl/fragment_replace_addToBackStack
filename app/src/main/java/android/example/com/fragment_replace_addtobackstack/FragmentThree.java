package android.example.com.fragment_replace_addtobackstack;

import android.app.Fragment;
import android.os.Bundle;
/*import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;*/
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

/**
 * Created by tchl on 2016-06-15.
 */
public class FragmentThree extends Fragment implements View.OnClickListener {
    private Button mBtn;
    private Snackbar mSnackBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.e("TAG","Fragment three call onCreateView");
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        mBtn = (Button) view.findViewById(R.id.three_btn);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        Log.e("TAG","Fragment three call onDestoryView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("TAG","Fragment three call onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v)
    {
      /*  mSnackBar = new Snackbar.Builder(this)
                .withMessage("提示信息")
                .withDuration(Snackbar.LONG_SNACK)
                .show();*/
        Snackbar.make(v, "你好啊", Snackbar.LENGTH_LONG)
                .setAction("delete", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "delete", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
       }
    }

