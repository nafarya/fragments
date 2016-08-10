package ru.yandex.yamblz.tabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.yandex.yamblz.Model.Artist;
import ru.yandex.yamblz.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnArtistPreviewFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ArtistPreviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArtistPreviewFragment extends Fragment {
    private static final String ARG_ARTIST = "artist";

    @BindView(R.id.imageArtist)
    ImageView artistImageView;

    @OnClick(R.id.buttonMore)
    void onClick() {
        if (mListener != null) {
            mListener.onMoreClicked(artist);
        }
    }

    private Artist artist;

    private OnArtistPreviewFragmentInteractionListener mListener;

    public ArtistPreviewFragment() {
        // Required empty public constructor
    }

    public static ArtistPreviewFragment newInstance(Artist artist) {
        ArtistPreviewFragment fragment = new ArtistPreviewFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ARTIST, artist);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            artist = (Artist) getArguments().getSerializable(ARG_ARTIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artist_preview, container, false);
        ButterKnife.bind(this, view);

        Picasso
                .with(getActivity())
                .load(artist.getCover().getBigCoverImage())
                .into(artistImageView);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnArtistPreviewFragmentInteractionListener) {
            mListener = (OnArtistPreviewFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnArtistPreviewFragmentInteractionListener");
        }
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
    public interface OnArtistPreviewFragmentInteractionListener {
        void onMoreClicked(Artist artist);
    }
}
