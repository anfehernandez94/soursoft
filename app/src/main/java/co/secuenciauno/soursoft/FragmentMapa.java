package co.secuenciauno.soursoft;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.google.android.gms.maps.GoogleMapOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMapa extends Fragment {


    public FragmentMapa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        //GoogleMapOptions options = new GoogleMapOptions().liteMode(true);


        return view;
    }


}
