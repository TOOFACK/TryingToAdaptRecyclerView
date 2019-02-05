package com.example.paulr.tryingtoadaptrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.paulr.tryingtoadaptrecyclerview.enities.User;

public class Description extends AppCompatActivity {

    private ImageView albumImageV;
    private TextView UserNameV;
    private TextView UserIdV;
    private TextView UserUserNameV;
    private TextView emailV;
    private ListView addressV;
    private TextView phone;
    private TextView websiteV;
    private ListView company;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


       user = (User) getIntent().getSerializableExtra("musicObject");


        UserNameV = findViewById(R.id.UserId2);
        UserIdV = findViewById(R.id.UserId2);
        UserUserNameV = findViewById(R.id.UserUserName);
        emailV = findViewById(R.id.email);
        addressV = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        websiteV = findViewById(R.id.website);
        company = findViewById(R.id.company);


        UserNameV.setText(user.getName());

        UserIdV.setText(user.getId());

        UserUserNameV.setText(user.getUsername());

        emailV.setText(user.getEmail());

        String[] adres = new String[6];
        adres[0] = user.getAddress().getCity();
        adres[1] = user.getAddress().getStreet();
        adres[2] = user.getAddress().getSuite();
        adres[3] = user.getAddress().getZipcode();
        adres[4] = String.valueOf(user.getAddress().getGeo().getLng());
        adres[5] = String.valueOf(user.getAddress().getGeo().getLat());
        ArrayAdapter<String> adapterAdress = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, adres);
        addressV.setAdapter(adapterAdress);

        phone.setText(user.getPhone());

        websiteV.setText(user.getWebsite());

        String[] company = new String[2];
        company[0] = user.getCompany().getName();
        company[1] = user.getCompany().getBs();
        company[2] = user.getCompany().getCatchPhrase();
        ArrayAdapter<String> adapterCompany = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, adres);
        addressV.setAdapter(adapterCompany);



    }
}
