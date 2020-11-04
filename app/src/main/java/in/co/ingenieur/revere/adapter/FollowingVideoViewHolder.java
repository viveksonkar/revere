package in.co.ingenieur.revere.adapter;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import in.co.ingenieur.revere.R;
import in.co.ingenieur.revere.models.VideoItem;

public class FollowingVideoViewHolder extends RecyclerView.ViewHolder{

    private final static String TAG = "VideoViewHolder";

    PlayerView videoView;
    TextView videoUserName;
    TextView videoCaption;
    ProgressBar videoProgressBar;
    SimpleExoPlayer player;

    public FollowingVideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoView = itemView.findViewById(R.id.videoContainer);
        videoUserName = itemView.findViewById(R.id.videoUserName);
        videoCaption = itemView.findViewById(R.id.videoCaption);
        videoProgressBar = itemView.findViewById(R.id.videoProgressBar);
    }

    void setFollowingVideoItemData(VideoItem videoItemData){

        Log.i(TAG, "setFollowingVideoItemData: "+videoItemData.videoUrl
                +", " + videoItemData.videoTitle + ", "+ videoItemData.videoDescription);

        videoUserName.setText(videoItemData.userName);
        videoCaption.setText(videoItemData.videoDescription);

        player = new SimpleExoPlayer.Builder(itemView.getContext()).build();
        videoView.setPlayer(player);
        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(itemView.getContext(),
                Util.getUserAgent(itemView.getContext(), "Revere"));
        // This is the MediaSource representing the media to be played.
        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(videoItemData.videoUrl));
        LoopingMediaSource loopingMediaSource = new LoopingMediaSource(videoSource);
        // Prepare the player with the source.
        videoView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);
        player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
        player.prepare(loopingMediaSource);
        videoProgressBar.setVisibility(View.GONE);
        //player.setPlayWhenReady(false);

    }
}