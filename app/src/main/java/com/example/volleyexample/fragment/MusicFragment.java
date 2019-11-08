package com.example.volleyexample.fragment;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.volleyexample.Music;
import com.example.volleyexample.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MusicFragment extends Fragment {

    private ImageView imageView;
    private TextView artistName, songTitle;
    private Button btnPlay, btnPrev, btnNext;
    private SeekBar seekBar;

    public static Bundle passingData(Music music) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", music);
        return bundle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadView(view);
        loadData();
    }

    private void loadData() {
        Music music = getArguments().getParcelable("data");

        artistName.setText(music.getArtistName());
        songTitle.setText(music.getName());
//        ImageLoader imageLoader = ImageLoader.getInstance();
//        imageLoader.displayImage(music.getUrl(), imageView);
    }

    private void loadView(View view) {
        imageView = view.findViewById(R.id.imageView);
        artistName = view.findViewById(R.id.artistName);
        songTitle = view.findViewById(R.id.songTitle);
        btnNext = view.findViewById(R.id.btnNext);
        btnPlay = view.findViewById(R.id.btnPlay);
        btnPrev = view.findViewById(R.id.btnPrev);
        seekBar = view.findViewById(R.id.seekBar);
    }
}
