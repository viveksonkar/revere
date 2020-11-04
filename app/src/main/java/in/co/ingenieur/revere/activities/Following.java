package in.co.ingenieur.revere.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import in.co.ingenieur.revere.R;
import in.co.ingenieur.revere.adapter.FollowingVideoAdapter;
import in.co.ingenieur.revere.models.VideoItem;
import in.co.ingenieur.revere.service.BottomNavigationMenuService;

public class Following extends AppCompatActivity {

    private final static String TAG = "Following";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        final ViewPager2 videosViewPager = findViewById(R.id.following);

        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem videoItem1 = new VideoItem();
        videoItem1.userName = "@annemlouis";
        videoItem1.videoUrl = "https://infinityandroid.com/videos/video1.mp4";
        videoItem1.videoTitle = "Celebration";
        videoItem1.videoDescription = "Celebrate who you are in  you deepest heart. #joy #celebrate #light #newbegining";

        VideoItem videoItemLove = new VideoItem();
        videoItemLove.userName = "@jeffreyM";
        videoItemLove.videoUrl = "https://infinityandroid.com/videos/video7.mp4";
        videoItemLove.videoTitle = "Love";
        videoItemLove.videoDescription = "The best thing to hold on to is each other. #love #onesoul #madeforeachother";

        VideoItem videoItem2 = new VideoItem();
        videoItem2.userName = "@cristalbrose";
        videoItem2.videoUrl = "https://infinityandroid.com/videos/video2.mp4";
        videoItem2.videoTitle = "Party";
        videoItem2.videoDescription = "You gotta have life. #newlyf #party #partyharder #weekend";

        VideoItem videoItem3 = new VideoItem();
        videoItem3.userName = "@ruthlgagnanon";
        videoItem3.videoUrl = "https://infinityandroid.com/videos/video3.mp4";
        videoItem3.videoTitle = "Exercise";
        videoItem3.videoDescription = "Whenever I feel the need to exercise. I lie down until it goes away. #stayHealty #stayfit #health #peace";

        VideoItem videoItem4 = new VideoItem();
        videoItem4.userName = "@yolandmwilliams";
        videoItem4.videoUrl = "https://infinityandroid.com/videos/video4.mp4";
        videoItem4.videoTitle = "Nature";
        videoItem4.videoDescription = "In every walk with nature one receives far more than he seeks. #nature #innersoul #peace";

        VideoItem videoItem5 = new VideoItem();
        videoItem5.userName = "@yolandmwilliams";
        videoItem5.videoUrl = "https://infinityandroid.com/videos/video5.mp4";
        videoItem5.videoTitle = "Travel";
        videoItem5.videoDescription = "It is better to travel well than to arrive. #travel #travelislyf #traveldiaries #exploring";

        VideoItem videoItem6 = new VideoItem();
        videoItem6.userName = "@andrewcarton";
        videoItem6.videoUrl = "https://infinityandroid.com/videos/video6.mp4";
        videoItem6.videoTitle = "Chill";
        videoItem6.videoDescription = "Lyf is so much easier when you just chill out. #peace #chill #donothing";

        //videoItems.add(videoItem);
        videoItems.add(videoItemLove);
        videoItems.add(videoItem1);
        videoItems.add(videoItem2);
        videoItems.add(videoItem3);
        //videoItems.add(videoItem4);
        //videoItems.add(videoItem5);
        videoItems.add(videoItem6);

        videosViewPager.setAdapter(new FollowingVideoAdapter(videoItems));
        BottomNavigationMenuService.handleNavigation(bottomNavigationView, this);

    }
}