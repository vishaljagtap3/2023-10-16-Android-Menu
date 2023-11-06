package com.bitcodetech.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkSettings;
    private final int MENU_INFO = 1;
    private final int MENU_HELP = 2;
    private final int MENU_SETTINGS = 3;
    private final int MENU_EXIT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkSettings = findViewById(R.id.chkSettings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        mt("onCreateOptionsMenu");

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);

        /*MenuItem menuItem = menu.add(1, 1, 0, "Info");
        menuItem.setIcon(R.mipmap.ic_launcher);
        menuItem.setCheckable(true);
        menuItem.setChecked(true);
        menuItem.setNumericShortcut('9');
        menuItem.setAlphabeticShortcut('i');
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menuItem = menu.add(1, 2, 0, "Help");

        SubMenu subMenu =
                menu.addSubMenu(2, 3, 0, "Settings");
        subMenu.add(3, 11, 0, "Phone Settings");
        subMenu.add(3, 12, 0, "System Settings");

        menu.add(2, 4, 0, "Exit");*/

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mt("onPrepareOptionsMenu");
        //MenuItem menuItemSettings = menu.findItem(3);
        MenuItem menuItemSettings = menu.findItem(R.id.menuSettings);

        menuItemSettings.setEnabled(chkSettings.isChecked());

        /*if(chkSettings.isChecked()) {
            menuItemSettings.setEnabled(true);
        }
        else {
            menuItemSettings.setEnabled(false);
        }*/

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case MENU_INFO:
                mt("Info");
                break;
            case MENU_HELP:
                mt("Help");
                break;
            case MENU_SETTINGS:
                mt("Settings");
                break;
            case MENU_EXIT:
                mt("Exit");
                System.exit(0);
                break;
            case 11:
                mt("Phone Settings");
                break;
            case 12:
                mt("System Settings");
                break;
        }

        /*switch (item.getItemId()) {
            case MENU_INFO:
                mt("Info");
                break;
            case MENU_HELP:
                mt("Help");
                break;
            case MENU_SETTINGS:
                mt("Settings");
                break;
            case MENU_EXIT:
                mt("Exit");
                System.exit(0);
                break;
            case 11:
                mt("Phone Settings");
                break;
            case 12:
                mt("System Settings");
                break;
        }*/
        return super.onOptionsItemSelected(item);
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}