package in.co.ingenieur.revere.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.co.ingenieur.revere.R;
import in.co.ingenieur.revere.models.VideoItem;

public class FollowingVideoAdapter extends RecyclerView.Adapter<FollowingVideoViewHolder> {

    private final static String TAG = "FollowingVideoAdapter";
    List<VideoItem> videoItems;

    public FollowingVideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public FollowingVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FollowingVideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.follow_video_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FollowingVideoViewHolder holder, int position) {
        holder.setFollowingVideoItemData(videoItems.get(position));
        holder.player.setPlayWhenReady(true);
        Log.i("FollowingVideoAdapter: ON BIND VIEW HOLDER => Video Played: ", holder.videoUserName.getText().toString());
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull FollowingVideoViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        Log.i("FollowingVideoAdapter: ON VIEW DETACHED FROM WINDOW => Video paused: ", holder.videoUserName.getText().toString());
        holder.player.setPlayWhenReady(false);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull FollowingVideoViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.player.setPlayWhenReady(true);
        Log.i("FollowingVideoAdapter: ON VIEW ATTACHED TO WINDOW: Video Resumed", holder.videoUserName.getText().toString());
    }


}
