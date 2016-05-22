package co.secuenciauno.soursoft;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCategoria extends Fragment {

    ListView lvClient;

    public FragmentCategoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_client, container, false);
        lvClient = (ListView) view.findViewById(R.id.lv_client);

        Client c1 = new Client("1","a");
        Client c2 = new Client("2","b");
        Client c3 = new Client("3","c");

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(c1);
        clients.add(c2);
        clients.add(c3);

        lvClient.setAdapter(new ItemClient(getActivity(), clients));


        return view;
    }


}
