package org.ragecastle.firebasesample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;

/**
 * Created by jahall on 9/5/16.
 *
 *
 */
public class MainFragment extends Fragment {

    public MainFragment() { }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

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
