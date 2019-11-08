package com.example.volleyexample.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.volleyexample.Music;
import com.example.volleyexample.fragment.MusicFragment;

import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends FragmentStatePagerAdapter {

    private List<Music> musicList = new ArrayList<>();

    public MusicAdapter(FragmentManager fm, List<Music> musicList) {
        super(fm);
        this.musicList = musicList;
    }

    @Override
    public Fragment getItem(int position) {
        MusicFragment musicFragment = new MusicFragment();
        musicFragment.setArguments(MusicFragment.passingData(musicList.get(position)));
        return musicFragment;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }
}
