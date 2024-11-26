package com.example.sungoose;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int counter = 0;
    private String title = "";
    private String name = "Ударь Бебруда";
    private TextView textCounter;
    private TextView textTitle;
    private TextView textName;
    private ImageView image; // Добавили переменную для изображения
    private int[] drawables = {R.drawable.rudcry, R.drawable.rudfingal, R.drawable.rudfingal2, R.drawable.rudblood};
    private int currentDrawableIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Устанавливаем слушатель для нажатий на изображение
        image = findViewById(R.id.image);
        image.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textCounter = findViewById(R.id.text2);
        textTitle = findViewById(R.id.text1);
        textName = findViewById(R.id.text3);
        textTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textName.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    @Override
    public void onClick(View view) {
        counter += 1;
        updateTextAndColors();
        if (counter % 25 == 0 && counter< 101){
            updateImage();
        }


    }

    private void updateTextAndColors() {
        switch (counter) {
            case 10:
            case 11:
            case 12:
            case 13:
                title = "-ААА, за что?";
                textTitle.setTextColor(Color.YELLOW);
                break;
            case 21:
            case 22:
            case 23:
                title = "-Остановись, пожалуйста!";
                textTitle.setTextColor(Color.GREEN);
                break;
            case 30:
            case 31:
            case 32:
            case 33:
                title = "-Хватит бить меня!";
                textTitle.setTextColor(Color.RED);
                break;
            case 50:
            case 51:
            case 52:
                title = "-Да хватит!";
                textTitle.setTextColor(Color.RED);
                break;
            case 100:
            case 101:
                title = "-Ты вырубил бебруда.";
                textTitle.setTextColor(Color.RED);
                break;
            case 102:
            case 103:
                title = "-Свободный режим!!!";
                textTitle.setTextColor(Color.WHITE);
                break;
            case 313:
                title = "ВЛ";
                textTitle.setTextColor(Color.GREEN);
                break;
            case 432:
                title = "GY432";
                textTitle.setTextColor(Color.GREEN);
                break;
            case 1000: title = "легенда, дальше ничего нет";
                textTitle.setTextColor(Color.RED);
            case 1:
                name = "Играй";
                textName.setTextColor(Color.BLUE);
                break;
            default:
                title = "Бей его";
                textTitle.setTextColor(Color.MAGENTA);
        }

        int r = 257;
        int g = 57;
        int b = 22;
        float[] hsv = new float[3];
        Color.RGBToHSV(r, g, b, hsv);

        textTitle.setText(title);
        textName.setText(name);
        textCounter.setText(String.format("Ударил %d%s", counter, getCountEnding(counter)));
    }

    private String getCountEnding(int count) {
        if (count % 10 == 1 && count % 100 != 11) {
            return " раз";
        } else if ((count % 10 >= 2 && count % 10 <= 4) && !(count % 100 >= 12 && count % 100 <= 14)) {
            return " раза";
        } else {
            return " раз";
        }
    }

    private void updateImage() {
        currentDrawableIndex = (currentDrawableIndex +1) % drawables.length;
        image.setImageResource(drawables[currentDrawableIndex]);
    }
}