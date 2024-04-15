package com.example.a9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Пример создания текстового файла в публичной директории "Documents"
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString());
        if (!storageDir.exists()) {
            storageDir.mkdirs(); // Создаем директорию, если она не существует
        }
        File file = new File(storageDir, "example.txt");
        try {
            if (!file.exists()) {
                boolean created = file.createNewFile(); // Создаем файл, если он не существует
                if (created) {
                    // Записываем данные в файл
                    FileWriter writer = new FileWriter(file);
                    writer.append("Hello, world!");
                    writer.flush();
                    writer.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        if (file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new
                        FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileContent = text.toString();
            // Используйте содержимое файла как необходимо
        }

    }
}