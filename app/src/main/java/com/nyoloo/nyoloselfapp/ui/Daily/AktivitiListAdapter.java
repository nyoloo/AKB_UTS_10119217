//package com.nyoloo.nyoloselfapp.ui.Daily;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.res.Resources;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.nyoloo.nyoloselfapp.R;
//
//import java.util.List;
//
//public class AktivitiListAdapter extends RecyclerView.Adapter<AktivitiListAdapter.ActivityViewHolder> {
//    private final Context context;
//
//    @NonNull
//    @Override
//    public AktivitiListAdapter.ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.daily_tab,parent,false);
//        return new AktivitiListAdapter.ActivityViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AktivitiListAdapter.ActivityViewHolder holder, int position) {
//        holder.kegiatan.setText((this.activitiesList.get(position).kegiatan));
//        holder.imagename.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.activitiesList.get(position).imagename)));
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.activitiesList.size();
//    }
//    public class ActivityViewHolder extends RecyclerView.ViewHolder{
//        TextView kegiatan;
//        ImageView imagename;
//        public ActivityViewHolder (@NonNull View itemView) {
//            super(itemView);
//            kegiatan = itemView.findViewById(R.id.activity_recycle_activityname);
//            imagename =itemView.findViewById(R.id.activity_recycle_image);
//        }
//    }
//    private int getDrawableByName(String name){
//        Resources res = context.getResources();
//        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
//        return resId;
//    }
//
//}
