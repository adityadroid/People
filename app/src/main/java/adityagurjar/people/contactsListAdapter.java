package adityagurjar.people;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adi on 28/8/16.
 */
public class contactsListAdapter extends RecyclerView.Adapter<contactsListAdapter.MyViewHolder> {

    private List<contactitem> contactsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, number;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            number = (TextView) view.findViewById(R.id.number_row);
        }
    }


    public contactsListAdapter(List<contactitem> contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        contactitem contact = contactsList.get(position);
        holder.title.setText(contact.getTitle());
        holder.number.setText(contact.getNumber());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }
}