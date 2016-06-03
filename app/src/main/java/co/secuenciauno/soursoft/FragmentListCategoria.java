package co.secuenciauno.soursoft;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListCategoria extends Fragment {

    ListView lv;
    Context context;

    ArrayList prgmName;
    //public static int [] prgmImages={R.drawable.images,R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6,R.drawable.images7,R.drawable.images8};
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};

    public FragmentListCategoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_categoria, container, false);
        //setContentView(R.layout.activity_main);

        context=getActivity();

        lv=(ListView) view.findViewById(R.id.lv_client);
        lv.setAdapter(new AdapterListCategoria(context, prgmNameList/*,prgmImages*/));

        return inflater.inflate(R.layout.fragment_list_categoria, container, false);
    }

}
