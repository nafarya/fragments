package ru.yandex.yamblz.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import ru.yandex.yamblz.Model.Artist;
import ru.yandex.yamblz.ui.fragments.ArtistFragment;

/**
 * Created by dan on 10.08.16.
 */

public class TabAdapter extends FragmentStatePagerAdapter {
    private List<Artist> artists;

    public TabAdapter(FragmentManager fm, List<Artist> artists) {
        super(fm);
        this.artists = artists;
    }

    @Override
    public Fragment getItem(int position) {
        Artist artist = artists.get(position);
        return ArtistFragment.newInstance(artist);
    }

    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return artists.get(position).getName();
    }
}
