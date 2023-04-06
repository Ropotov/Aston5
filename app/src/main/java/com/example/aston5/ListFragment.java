package com.example.aston5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.aston5.databinding.FragmentListBinding;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    FragmentListBinding binding;
    Repository repository = Repository.getInstance();
    ArrayList<ListItem> list = repository.getList();
    ListItem listItem;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("listItem", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                listItem = (ListItem) result.getParcelable("listItem");
                for (ListItem item : list) {
                    if (item.mId == listItem.mId) {
                        int index = list.indexOf(item);
                        list.set(index, listItem);
                        repository.setList(list);
                        setContent();
                    }
                }
            }
        });

        Navigator navigator = (Navigator) getActivity();

        setContent();

        binding.contact1.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.NavigateToDetailFragment(list.get(0));
            }
        });
        binding.contact2.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.NavigateToDetailFragment(list.get(1));
            }
        });
        binding.contact3.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.NavigateToDetailFragment(list.get(2));
            }
        });
    }

    @SuppressLint("SetTextI18n")
    void setContent() {
        binding.contact1.name.setText(list.get(0).mFirstName + " " + list.get(0).mLastName);
        binding.contact1.phone.setText(list.get(0).mPhone);
        binding.contact2.name.setText(list.get(1).mFirstName + " " + list.get(1).mLastName);
        binding.contact2.phone.setText(list.get(1).mPhone);
        binding.contact3.name.setText(list.get(2).mFirstName + " " + list.get(2).mLastName);
        binding.contact3.phone.setText(list.get(2).mPhone);
    }
}


interface Navigator {
    void NavigateToDetailFragment(ListItem listItem);
}