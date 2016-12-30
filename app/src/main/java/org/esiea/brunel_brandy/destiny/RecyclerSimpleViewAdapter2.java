package org.esiea.brunel_brandy.destiny;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import android.R.color;
import android.widget.Toast;


/**
 * Created by Benjamin on 28/12/2016.
 */

public class RecyclerSimpleViewAdapter2 extends RecyclerView.Adapter<RecyclerSimpleViewAdapter2.ViewHolder> {

    /**
     * List items
     */
    private List<String> items;
    /**
     * the resource id of item Layout
     */
    private int itemLayout;


    /**
     * Constructor RecyclerSimpleViewAdapter2
     *
     * @param items      : the list items
     * @param itemLayout : the resource id of itemView
     */
    public RecyclerSimpleViewAdapter2(List<String> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;

    }

    /**
     * Create View Holder by Type
     *
     * @param parent,  the view parent
     * @param viewType : the type of View
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // get inflater and get view by resource id itemLayout
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        // return ViewHolder with View
        return new ViewHolder(v);
    }

    /**
     * Get the size of items in adapter
     *
     * @return the size of items in adapter
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Bind View Holder with Items
     *
     * @param holder:  the view holder
     * @param position : the current position
     */
    @Override
    public void onBindViewHolder(RecyclerSimpleViewAdapter2.ViewHolder holder, int position) {
        // find item by position
        String item = items.get(position);
        // save information in holder, we have one type in this adapter
        holder.primaryText.setText(item);
        holder.itemView.setTag(item);
        if ((position % 2) == 0) {
            holder.itemView.setBackgroundResource(color.holo_green_dark);
        } else {
            holder.itemView.setBackgroundResource(color.holo_green_light);
        }
    }

    /**
     * @author florian
     *         Class viewHolder
     *         Hold an textView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // TextViex
        public TextView primaryText;

        /**
         * Constructor ViewHolder
         *
         * @param itemView: the itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);


            // link primaryText
            primaryText = (TextView) itemView.findViewById(android.R.id.text1);
            final Context context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Ce bar a bien été enregistré", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}

