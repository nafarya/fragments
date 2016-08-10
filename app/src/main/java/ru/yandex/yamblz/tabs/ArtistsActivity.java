package ru.yandex.yamblz.tabs;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.yandex.yamblz.Model.Artist;
import ru.yandex.yamblz.R;
import ru.yandex.yamblz.database.ArtistDataSource;

public class ArtistsActivity extends AppCompatActivity implements ArtistPreviewFragment.OnArtistPreviewFragmentInteractionListener {

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;


    private ArtistsPagerAdapter adapter;
    private ArtistDataSource db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        db = new ArtistDataSource(this);
        db.open();

        adapter = new ArtistsPagerAdapter(getSupportFragmentManager(), db.getAllArtists());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
    }

    @Override
    public void onMoreClicked(Artist artist) {
        //TODO: start detail activity with fragment
    }
}
