package view.vichle.example.tusharlal.vichleviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import view.vichle.example.tusharlal.vichleviewexample.model.CarType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CarStatusView carStatusView;

    EditText editText_fl;
    EditText editText_fr;
    EditText editText_bl;
    EditText editText_br;

    Button button_setTyrePressure;
    Button button_flDoor;
    Button button_frDoor;
    Button button_blDoor;
    Button button_brDoor;
    Button button_door;
    Button button_tyres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    void initView() {
        carStatusView = findViewById(R.id.carStatusView);

        editText_fl = findViewById(R.id.editText_fl);
        editText_fr = findViewById(R.id.editText_fr);
        editText_bl = findViewById(R.id.editText_bl);
        editText_br = findViewById(R.id.editText_br);

        button_setTyrePressure = findViewById(R.id.button_setTyrePressure);
        button_door = findViewById(R.id.button_door);
        button_tyres = findViewById(R.id.button_tyres);
        button_flDoor = findViewById(R.id.button_flDoor);
        button_frDoor = findViewById(R.id.button_frDoor);
        button_blDoor = findViewById(R.id.button_blDoor);
        button_brDoor = findViewById(R.id.button_brDoor);

        button_setTyrePressure.setOnClickListener(this);
        button_door.setOnClickListener(this);
        button_tyres.setOnClickListener(this);
        button_flDoor.setOnClickListener(this);
        button_frDoor.setOnClickListener(this);
        button_blDoor.setOnClickListener(this);
        button_brDoor.setOnClickListener(this);
        setTyrePressure();
    }

    boolean allDoorsOpen = false;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_setTyrePressure:
                setTyrePressure();
                break;
            case R.id.button_door:
                if (allDoorsOpen) {
                    carStatusView.closeAllDoors();
                    allDoorsOpen = false;
                    button_door.setText("OPEN ALL DOORS");
                } else {
                    carStatusView.openAllDoors();
                    allDoorsOpen = true;
                    button_door.setText("CLOSE ALL DOORS");
                }
                break;
            case R.id.button_tyres:
                if (carStatusView.getTyresVisibility() == View.VISIBLE) {
                    carStatusView.setTyresVisibility(View.INVISIBLE);
                    button_tyres.setText("SHOW ALL TYRES");
                } else {
                    carStatusView.setTyresVisibility(View.VISIBLE);
                    button_tyres.setText("HIDE ALL TYRES");
                }
                break;
            case R.id.button_flDoor:
                if (carStatusView.getFLDoorStatus()) {
                    carStatusView.closeFLDoor();
                    button_flDoor.setText("OPEN FL DOOR");
                } else {
                    carStatusView.openFLDoor();
                    button_flDoor.setText("CLOSE FL DOOR");
                }
                break;
            case R.id.button_frDoor:
                if (carStatusView.getFRDoorStatus()) {
                    carStatusView.closeFRDoor();
                    button_frDoor.setText("OPEN FR DOOR");
                } else {
                    carStatusView.openFRDoor();
                    button_frDoor.setText("CLOSE FR DOOR");
                }
                break;
            case R.id.button_blDoor:
                if (carStatusView.getBLDoorStatus()) {
                    carStatusView.closeBLDoor();
                    button_blDoor.setText("OPEN BL DOOR");
                } else {
                    carStatusView.openBLDoor();
                    button_blDoor.setText("CLOSE BL DOOR");
                }
                break;
            case R.id.button_brDoor:
                if (carStatusView.getBRDoorStatus()) {
                    carStatusView.closeBRDoor();
                    button_brDoor.setText("OPEN BR DOOR");
                } else {
                    carStatusView.openBRDoor();
                    button_brDoor.setText("CLOSE BR DOOR");
                }
                break;
        }
    }

    private void setTyrePressure() {
        carStatusView.setTyrePressureFL(editText_fl.getText().toString());
        carStatusView.setTyrePressureFR(editText_fr.getText().toString());
        carStatusView.setTyrePressureBL(editText_bl.getText().toString());
        carStatusView.setTyrePressureBR(editText_br.getText().toString());
    }
}
