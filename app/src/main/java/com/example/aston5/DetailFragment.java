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
    String firstName, lastname, phone;

    static DetailFragment newInstance(String firstName, String lastName, String phone) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString("firstName", firstName);
        args.putString("lastName", lastName);
        args.putString("phone", phone);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        firstName = getArguments().getString("firstName");
        lastname = getArguments().getString("lastName");
        phone = getArguments().getString("phone");
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

        binding.firstName.setText(firstName);
        binding.lastName.setText(lastname);
        binding.phone.setText(phone);
    }
}