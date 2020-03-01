package com.example.layout.tabs;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.layout.R;
import com.example.layout.interfaces.NotaInteractionListener;
import com.example.layout.model.Nota;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Nota} and makes a call to the
 * specified {@link NotaInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private final List<Nota> mValues;
    private final NotaInteractionListener mListener;

    public MyNotaRecyclerViewAdapter(List<Nota> items, NotaInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nViewTitle.setText(holder.mItem.getTitulo());
        holder.nViewContenido.setText(holder.mItem.getContenido());

        if(holder.mItem.isFavorita()){
            holder.nImageFavorite.setImageResource(R.drawable.ic_favorite_notes_24dp);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.favoritaNotaClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nViewTitle;
        public final TextView nViewContenido;
        public final ImageView nImageFavorite;

        public Nota mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nViewTitle = (TextView) view.findViewById(R.id.textViewTitulo);
            nViewContenido = (TextView) view.findViewById(R.id.textViewContenido);
            nImageFavorite = (ImageView) view.findViewById(R.id.imageViewFavorita);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nViewTitle.getText() + "'";
        }
    }
}
