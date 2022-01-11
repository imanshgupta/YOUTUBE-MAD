package com.example.madyoutubeapi.adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madyoutubeapi.R;
import com.example.madyoutubeapi.models.VideoID;
import com.example.madyoutubeapi.models.VideoYT;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<VideoYT> videoList;

    public AdapterHome(Context context, List<VideoYT> videos) {
        this.context = context;
        this.videoList = videos;
    }

    class YoutubeHolder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView title,description;

        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail=itemView.findViewById(R.id.iv_thumbnail);
            title=itemView.findViewById(R.id.vidName);
            description=itemView.findViewById(R.id.vidDiscrip);

        }

        public void setData(VideoYT videoYT) {

            String getTitle = videoYT.getSnippet().getTitle();
            String getTgl = videoYT.getSnippet().getPublishedAt();
            String getThumb = videoYT.getSnippet().getThumbnails().getMedium().getUrl();

            title.setText(getTitle);
            description.setText(getTgl);
            Picasso.get()
                    .load(getThumb)
                    .placeholder(R.mipmap.ic_launcher)
                    .fit()
                    .centerCrop()
                    .into(thumbnail, new Callback() {
                        @Override
                        public void onSuccess() {
                            Log.d(TAG, "THUMBNAIL SUCCESFULLY COMMING");
                                    

                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d(TAG, " THUMBNAIL NOT COMMING");
                        }
                    });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //using layout inflater to populate into the row_item_home file when there is items not known how many

        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item_home,parent,false);
        return new YoutubeHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideoYT videoYT = videoList.get(position);
        YoutubeHolder yth=(YoutubeHolder) holder;
        yth.setData(videoYT);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
