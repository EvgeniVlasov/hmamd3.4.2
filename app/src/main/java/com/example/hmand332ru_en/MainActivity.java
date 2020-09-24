package com.example.hmand332ru_en;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Spinner spinnerMargin;
    Button buttonOk;
    TextView txtView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.onActivityCreateSetTheme(this);
        spinner = findViewById(R.id.spinner);
        buttonOk = findViewById(R.id.buttonOk);
        txtView = findViewById(R.id.textView);
        spinnerMargin = findViewById(R.id.spinnerMargin);

        initView();
    }

    private void initView() {
        initSpinner();
        initMargin();
        initBtn(this,buttonOk);

    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.spinnerLang, android.R.layout.simple_spinner_item);
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterLang);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initMargin() {
        ArrayAdapter<CharSequence> adapterMerg = ArrayAdapter.createFromResource(this, R.array.spinnerMargin, android.R.layout.simple_spinner_item);
        adapterMerg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMargin.setAdapter(adapterMerg);
        spinnerMargin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initBtn(final Activity activity, Button button) {

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale;
                if (spinner.getSelectedItemPosition() == 0)
                    locale = new Locale("ru");
                else locale = new Locale("en");

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                int pos = spinnerMargin.getSelectedItemPosition();
                switch (pos) {
                    case 1:
                        Utils.changeToTheme(activity, Utils.THEME_MARGIN_MIDDLE);
                        break;
                    case 2:
                        Utils.changeToTheme(activity, Utils.THEME_MARGIN_SMALL);
                        break;
                    default:
                        Utils.changeToTheme(activity, Utils.THEME_DEFAULT);
                        break;
                }

            }
        };

        button.setOnClickListener(onClickListener);
    }



}
