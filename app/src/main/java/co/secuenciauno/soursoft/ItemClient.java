package co.secuenciauno.soursoft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrés Felipe on 9/05/2016.
 */
public class ItemClient extends BaseAdapter{
    private Context context;
    private ArrayList<Client> clients;

    public ItemClient(Context context, ArrayList<Client> clients) {
        this.context = context;
        this.clients = clients;
    }

    @Override
    public int getCount() {
        return this.clients.size();
    }

    @Override
    public Object getItem(int position) {
        return this.clients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_client, parent, false);
        }

        // Set data into the view.
        ImageView ivClientLogo = (ImageView) rowView.findViewById(R.id.iv_client_logo);
        TextView tvClientName = (TextView) rowView.findViewById(R.id.tv_client_name);
        TextView tvClientDescription = (TextView) rowView.findViewById(R.id.tv_client_description);

        Client client = this.clients.get(position);
        //Todo Mirar la forma de manejar las imágenes
//        ivClientLogo.setImageResource(55);
        tvClientName.setText(client.name);
        tvClientDescription.setText(client.description);

        return rowView;
    }
}
