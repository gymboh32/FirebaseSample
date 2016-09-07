package org.ragecastle.firebasesample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
    public MainFragment() { }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        Item item = new Item("Item_2");
        databaseReference.push().setValue(item);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Item item1 = dataSnapshot1.getValue(Item.class);
                    Log.e(LOG_TAG, item1.name());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e (LOG_TAG, "Shits Broke: " + databaseError.getDetails());
            }
        });

        String [] itemsList = {
                "Item_1",
                "Item_2",
                "Item_3",
                "Item_4",
                "Item_5"};

        ItemAdapter itemAdapter = new ItemAdapter(getActivity(), Arrays.asList(itemsList));

        ListView listViewBars = (ListView) rootView.findViewById(R.id.listview_main);

        listViewBars.setAdapter(itemAdapter);

        return rootView;
    }
}
