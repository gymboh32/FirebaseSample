package org.ragecastle.firebasesample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

/**
 * Created by jahall on 9/5/16.
 *
 *
 */
public class MainFragment extends Fragment {

    private static final String LOG_TAG = MainFragment.class.getSimpleName();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseListAdapter<Item> firebaseListAdapter;
    public MainFragment() { }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        ListView listView = (ListView) rootView.findViewById(R.id.listview_main);

        firebaseListAdapter =
                new FirebaseListAdapter<Item>(getActivity(),
                    Item.class,
                    R.layout.listview_main,
                    databaseReference) {
            @Override
            protected void populateView(View v, Item model, int position) {
                if (model.name()!=null)
                    ((TextView) v.findViewById(R.id.item)).setText(model.name);
            }
        };

        listView.setAdapter(firebaseListAdapter);

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        firebaseListAdapter.cleanup();
    }
}
