package cl.aguzman.stressless.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.aguzman.stressless.R;
import cl.aguzman.stressless.adapters.PendingClickListener;
import cl.aguzman.stressless.adapters.PendingsAdapter;
import cl.aguzman.stressless.models.Pending;
import cl.aguzman.stressless.views.details.DetailsActivity;

public class PendingsFragment extends Fragment implements PendingClickListener {

    public static final String PENDING_ID = "cl.aguzman.stressless.WHAT_IT_DOES.PENDING_ID";
    private PendingsAdapter adapter;
    public PendingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pendingRv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PendingsAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void updateList(Pending pending) {
        adapter.update(pending);
    }

    @Override
    public void clikcedID(long id) {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra(PENDING_ID, id);
        startActivity(intent);
    }
}
