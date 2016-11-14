package com.sendbird.android.sample.vibratetalk;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sendbird.android.SendBird;


public class MainActivity extends FragmentActivity {

    private enum State {DISCONNECTED, CONNECTING, CONNECTED}
    /**
     * To test push notifications with your own appId, you should replace google-services.json with yours.
     * Also you need to set Server API Token and Sender ID in SendBird dashboard.
     * Please carefully read "Push notifications" section in SendBird Android documentation
     */
    private static final String appId = "65A822BC-2764-4395-BBBC-F1CBBBBF0662"; /* Sample SendBird Application */
    public static String sUserId;
    private String mNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sUserId = getPreferences(Context.MODE_PRIVATE).getString("user_id", "");
        mNickname = getPreferences(Context.MODE_PRIVATE).getString("nickname", "");

        SendBird.init(appId, this);

        //view item setup
        ((EditText) findViewById(R.id.etxt_user_id)).setText(sUserId);
        ((EditText) findViewById(R.id.etxt_user_id)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                sUserId = s.toString();
            }
        });

        ((EditText) findViewById(R.id.etxt_nickname)).setText(mNickname);
        ((EditText) findViewById(R.id.etxt_nickname)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mNickname = s.toString();
            }
        });

        findViewById(R.id.btn_connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                if (btn.getText().equals("Connect")) {
                    connect();
                } else {
                    disconnect();
                }

                Helper.hideKeyboard(MainActivity.this);
            }
        });
    }

    private void connect() {

    }

    private void disconnect() {

    }
}
