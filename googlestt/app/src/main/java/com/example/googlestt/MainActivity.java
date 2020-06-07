package com.example.googlestt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.speech.SpeechRecognizer.ERROR_AUDIO;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    SpeechRecognizer Recognizer;
    Button sttBtn;
    TextView textView;
    final int PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 23 ){
            // 퍼미션 체크
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET,
                    Manifest.permission.RECORD_AUDIO},PERMISSION);
        }

        textView = findViewById(R.id.sttText);
        sttBtn = findViewById(R.id.sttStart);

        //사용자에게 음성 요구 후 음성 인식기를 통해 전송
        intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //음성 인식을 위한 음성 인식기에 사용되는 여분의 키
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName());
        //음성을 번역할 언어 설정
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");


        sttBtn.setOnClickListener(v ->{
            Recognizer=SpeechRecognizer.createSpeechRecognizer(this);
            Recognizer.setRecognitionListener(listener);
            Recognizer.startListening(intent);
        });
    }

    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getApplicationContext(),"음성인식 시작!.",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBeginningOfSpeech() {} //말하기 시작했을 때 호출

        @Override
        public void onRmsChanged(float rmsdB) {} //소리 크기

        @Override
        public void onBufferReceived(byte[] buffer) {} // 인식한 단어를 buffer에 담기

        @Override
        public void onEndOfSpeech() {} //말하기를 중지할 때 호출

        @Override
        public void onError(int error) {
            String message;

            switch (error) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "오디오 에러";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "클라이언트 에러";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "퍼미션 없음";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "네트워크 에러";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "네트웍 타임아웃";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "찾을 수 없음";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER가 바쁨";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "서버가 이상함";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "말하는 시간초과";
                    break;
                default:
                    message = "알 수 없는 오류임";
                    break;
            }

            Toast.makeText(getApplicationContext(), "에러가 발생하였습니다. : " + message,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResults(Bundle results) {
            ArrayList<String> matches =
                    results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            for(int i= 0 ; i<matches.size() ; i++){
                textView.setText(matches.get(i));
            }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {}

        @Override
        public void onEvent(int eventType, Bundle params) {}
    };
}
