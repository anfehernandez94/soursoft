package co.secuenciauno.soursoft;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCategoria extends Fragment {

    Button btnCat1;
    Button btnCat2;
    Button btnCat3;
    Button btnCat4;
    Button btnCat5;
    Button btnCat6;


    public FragmentCategoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categoria, container, false);
        btnCat1 = (Button) view.findViewById(R.id.btn_cat1);
        btnCat2 = (Button) view.findViewById(R.id.btn_cat2);
        btnCat3 = (Button) view.findViewById(R.id.btn_cat3);
        btnCat4 = (Button) view.findViewById(R.id.btn_cat4);
        btnCat5 = (Button) view.findViewById(R.id.btn_cat5);
        btnCat6 = (Button) view.findViewById(R.id.btn_cat6);


        return view;
    }


}
