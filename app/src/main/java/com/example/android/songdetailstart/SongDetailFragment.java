package com.example.android.songdetailstart;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.songdetailstart.content.SongUtils;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SongDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SongDetailFragment extends Fragment {

    public SongUtils.Song mSong;


    private OnFragmentInteractionListener mListener;

    public SongDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(SongUtils.SONG_ID_KEY)) {
            mSong = SongUtils.SONG_ITEMS.get(getArguments().getInt(SongUtils.SONG_ID_KEY));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.song_detail, container, false);
        if (mSong != null) {
            ((TextView) rootView.findViewById(R.id.song_detail))
                    .setText(mSong.details);
        }

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public static SongDetailFragment newInstance(int position) {
        SongDetailFragment songDetailFragment = new SongDetailFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(SongUtils.SONG_ID_KEY, position);
        songDetailFragment.setArguments(arguments);
        return songDetailFragment;
    }
}
