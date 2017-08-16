package cl.aguzman.stressless;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.aguzman.stressless.adapters.PendingsAdapter;
import cl.aguzman.stressless.models.Pending;

public class PendingsFragment extends Fragment implements PendingClickListener {

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
        Toast.makeText(getContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
    }
}
