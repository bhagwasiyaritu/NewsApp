package com.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);

        tabLayout.setupWithViewPager(viewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),0);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.bookmark:
                Toast.makeText(this,"Opps Functionality is not define....!!!",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.setting:
                Intent setting = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(setting);
                return true;

            case R.id.help:
                Intent help = new Intent(MainActivity.this,HelpActivity.class);
                startActivity(help);
                return true;

            case R.id.shareapp:
                Intent shareApp = new Intent();
                shareApp.setAction(Intent.ACTION_SEND);
                shareApp.putExtra(Intent.EXTRA_TEXT,"SORRY,This app is not at Store");
                shareApp.setType("text/*");
                Intent shareIntent = Intent.createChooser(shareApp, "SHARE");
                startActivity(shareApp);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}