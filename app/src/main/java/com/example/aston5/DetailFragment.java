package com.example.aston5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aston5.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;
    ListItem listItem;

    static DetailFragment newInstance(ListItem listItem) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("listItem", listItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        listItem = (ListItem) getArguments().getParcelable("listItem");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.firstName.setText(listItem.mFirstName);
        binding.lastName.setText(listItem.mLastName);
        binding.phone.setText(listItem.mPhone);

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListItem newListItem = new ListItem(
                        listItem.mId,
                        binding.firstName.getText().toString(),
                        binding.lastName.getText().toString(),
                        binding.phone.getText().toString());
                Bundle newItem = new Bundle();
                newItem.putParcelable("listItem", newListItem);
                getParentFragmentManager().setFragmentResult("listItem", newItem);
                getParentFragmentManager().popBackStack();
                getParentFragmentManager()
                        .beginTransaction()
                        .remove(DetailFragment.this)
                        .commit();

            }
        });
    }
}

