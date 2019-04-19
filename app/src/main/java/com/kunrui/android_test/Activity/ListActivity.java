/* Created by hyx
 * In 2019.3.26
 * Touch on ListView
 */

package com.kunrui.android_test.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kunrui.android_test.ListView.Fruit;
import com.kunrui.android_test.ListView.FruitAdapter;
import com.kunrui.android_test.Presenter.PersenterURL;
import com.kunrui.android_test.R;
import com.kunrui.android_test.qrdemo.QRScannerActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity{
    private List<Fruit> fruitList = new ArrayList<>();
    private PersenterURL persenterURL = new PersenterURL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        persenterURL.checkPermission(ListActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(ListActivity.this, R.layout.fruit_item, fruitList);
        final ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("position:" + position);
                Log.d("position", String.valueOf(position));

                TextView view_text = view.findViewById(R.id.fruit_name);
                Toast.makeText(getApplicationContext(), view_text.getText(), Toast.LENGTH_SHORT).show();

                Intent intent;
                switch (String.valueOf(view_text.getText())) {
                    case "Service":
                        intent = new Intent(ListActivity.this, ServiceActivity.class);
                        startActivity(intent);
                        break;
                    case "RecyclerView":
                        intent = new Intent(ListActivity.this, RecyclerActivity.class);
                        startActivity(intent);
                        break;
                    case "Executors":
                        intent = new Intent(ListActivity.this, ExecutorsHttps.class);
                        startActivity(intent);
                        break;
                    case "lte":
                        intent = new Intent(ListActivity.this, LteMsg.class);
                        startActivity(intent);
                        break;
                    case "CustomView":
                        intent = new Intent(ListActivity.this, CustomView.class);
                        startActivity(intent);
                        break;
                    case "QRCode":
                        intent = new Intent(ListActivity.this, QRScannerActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });
    }

    private void initFruits() {
        fruitList.add(new Fruit("Service", R.drawable.ic_action_globe));
        fruitList.add(new Fruit("Content Provider", R.drawable.ic_action_globe));
        fruitList.add(new Fruit("RecyclerView", R.drawable.ic_action_globe));
        fruitList.add(new Fruit("Executors", R.drawable.ic_action_globe));
        fruitList.add(new Fruit("lte", R.drawable.ic_action_globe));
        fruitList.add(new Fruit("CustomView", R.drawable.ic_action_globe));
        fruitList.add(new Fruit("QRCode", R.drawable.ic_action_globe));
    }
}