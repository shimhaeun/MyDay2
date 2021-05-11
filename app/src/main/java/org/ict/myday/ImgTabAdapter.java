package org.ict.myday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImgTabAdapter extends RecyclerView.Adapter<ImgTabAdapter.ViewHolder> {

    private List<Object> mImageList;

    public ImgTabAdapter(ArrayList<Object> imageList) { mImageList = imageList; }

    public void setImageList(List<Object> imageList) {
        mImageList = imageList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemImageView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new ViewHolder(itemImageView);
    }

//    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem();
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgZone;

        public ViewHolder( View itemView) {
            super(itemView);
            imgZone = itemView.findViewById(R.id.imgZone);
        }

        public void setItem(){
//            imgZone.setImageResource();
        }
    }
}
