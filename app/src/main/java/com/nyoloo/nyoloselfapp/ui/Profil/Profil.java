package com.nyoloo.nyoloselfapp.ui.Profil;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nyoloo.nyoloselfapp.databinding.ProfilFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class Profil extends Fragment implements OnMapReadyCallback {
    
    private ProfilFragmentBinding binding ;

    public static Profil newInstance() {
        return new Profil();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ProfilFragmentBinding.inflate(inflater, container, false);
        TextView igText = binding.profileContactIg;
        igText.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://instagram.com/_u/ha.ryoo");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://instagram.com/ha,ryoo")));
            }
        });

        TextView emailText = binding.profileContactEmail;
        emailText.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","tiyoharyos@gmail.com", null));
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });

        TextView waText = binding.profileContactNumber;
        waText.setOnClickListener(view -> {
            String url = "https://api.whatsapp.com/send?phone=+6289501990408";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        return binding.getRoot();
    }
    @Override
    public void onMapReady(GoogleMap googleMap){
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        List<Marker> markers = new ArrayList<>();
        markers.add(googleMap.addMarker(new MarkerOptions()
        .position(new LatLng(-6.859290108630597, 107.55214042646402))
        .title("Alama Rumah")));
        for (Marker m: markers){
            builder.include(m.getPosition());
        }
        LatLngBounds bounds = builder.build();

        int padding = 0;
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds,512,200,padding);

        googleMap.moveCamera(cu);
    }


}