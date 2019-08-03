package com.mhasancse.youtubeapishowvideo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhasancse.youtubeapishowvideo.R;
import com.mhasancse.youtubeapishowvideo.models.YoutubeCommentModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Suman Dey(MONSTER TECHNO) on 1/4/18.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.YoutubeCommentHolder> {

    private ArrayList<YoutubeCommentModel> dataSet;
    private static Context mContext = null;

    public CommentAdapter(Context mContext, ArrayList<YoutubeCommentModel> data) {
        this.dataSet = data;
        this.mContext = mContext;
    }

    @Override
    public YoutubeCommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.youtube_comment_layout, parent, false);
        YoutubeCommentHolder postHolder = new YoutubeCommentHolder(view);
        return postHolder;
    }

    @Override
    public void onBindViewHolder(YoutubeCommentHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView feedback = holder.feedback;
        ImageView imageView = holder.imageViewIcon;
        YoutubeCommentModel object = dataSet.get(position);
        textViewName.setText(object.getTitle());
        feedback.setText(object.getComment());
        try {
            if (object.getThumbnail() != null) {
                if (object.getThumbnail().startsWith("http")) {
                    Picasso.with(mContext)
                            .load(object.getThumbnail())
                            .into(imageView);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class YoutubeCommentHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView feedback;
        ImageView imageViewIcon;

        public YoutubeCommentHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.profile_image);
            this.feedback = (TextView) itemView.findViewById(R.id.feedback);

        }

    }

}


