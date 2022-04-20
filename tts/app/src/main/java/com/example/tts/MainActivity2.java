package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    EditText editText;
    Button button;
    TextToSpeech toSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String country = getIntent().getStringExtra("country");

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                {
                    int lang = toSpeech.setLanguage(mapLanguage(country));
                    Toast.makeText(MainActivity2.this, lang, Toast.LENGTH_SHORT).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString().trim();
                int speech = toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public Locale mapLanguage(String country)
    {
        Locale l;

        switch(country)
        {
            case "US": l = new Locale("en", "rUS"); break;
            case "Germany": l = new Locale("de", "rDE"); break;
            case "PRC": l = new Locale("zh", "rCN"); break;
            case "Taiwan": l = new Locale("zh", "rTW"); break;
            case "Czech Republic": l = new Locale("cs", "rCZ"); break;
            case "Belgium": l = new Locale("nl", "rBE"); break;
            case "Netherlands": l = new Locale("nl", "rNL"); break;
            case "Australia": l = new Locale("en", "rAU"); break;
            case "Britain": l = new Locale("en", "rGB"); break;
            case "Canada": l = new Locale("en", "rCA"); break;
            case "New Zealand": l = new Locale("en", "rNZ"); break;
            case "Singapore": l = new Locale("en", "rSG"); break;
            case "France": l = new Locale("fr", "rFR"); break;
            case "Switzerland": l = new Locale("fr", "rCH"); break;
            case "Austria": l = new Locale("de", "rAT"); break;
            case "Italy": l = new Locale("it", "rIT"); break;
            case "Japanese": l = new Locale("ja", "rJP"); break;
            case "Korean": l = new Locale("ko", "rKR"); break;
            case "Polish": l = new Locale("pl", "rPL"); break;
            case "Russian": l = new Locale("ru", "rRU"); break;
            case "Spain": l = new Locale("es", "rES"); break;
            case "Egypt": l = new Locale("ar", "rEG"); break;
            case "Denmark": l = new Locale("da", "rDK"); break;
            case "India": l = new Locale("hi", "rIN"); break;
            case "Ireland": l = new Locale("en", "rIE"); break;
            case "Portugal": l = new Locale("pt", "rPT"); break;
            case "Sweden": l = new Locale("sv", "rSE"); break;
            case "Ukraine": l = new Locale("uk", "rUA"); break;
            default: l = new Locale("en", "rUS");
        }

        return l;
    }

}