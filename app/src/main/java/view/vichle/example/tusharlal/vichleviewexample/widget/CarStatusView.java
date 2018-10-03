package view.vichle.example.tusharlal.vichleviewexample.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import view.vichle.example.tusharlal.vichleviewexample.R;
import view.vichle.example.tusharlal.vichleviewexample.widget.cartypestate.CarTypeFactory;
import view.vichle.example.tusharlal.vichleviewexample.widget.model.CarType;

public class CarStatusView extends LinearLayout {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private static final String DEFAULT_TYRE_PRESSURE = "31";

    public static final int TYPE_SEDAN = 0;
    public static final int TYPE_SUV = 1;
    public static final int TYPE_VAN = 2;

    private View view;

    private float minTypePressure = 28;
    private float maxTypePressure = 35;

    private TextView textViewTyrePressureFL;
    private TextView textViewTyrePressureBL;
    private TextView textViewTyrePressureFR;
    private TextView textViewTyrePressureBR;
    private TextView textViewLockStatus;
    private TextView textViewLastUpdated;

    private ImageView imageViewTyrePressureFL;
    private ImageView imageViewTyrePressureBL;
    private ImageView imageViewTyrePressureFR;
    private ImageView imageViewTyrePressureBR;
    private ImageView imageViewFront;
    private ImageView imageViewBack;
    private ImageView imageViewCenter;
    private ImageView imageViewDoorFL;
    private ImageView imageViewDoorBL;
    private ImageView imageViewDoorFR;
    private ImageView imageViewDoorBR;


    private CarType carType;

    public CarStatusView(Context context) {
        super(context);
        initializeViews(context, TYPE_VAN);
    }

    public CarStatusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context, TYPE_VAN);
    }

    public CarStatusView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context, TYPE_VAN);
    }

    /**
     * Inflates the views in the layout.
     *
     * @param context the current context for the view.
     */
    private void initializeViews(Context context, int carTypeFlag) {
        CarTypeFactory carTypeFactory = new CarTypeFactory(context, carTypeFlag);
        carType = carTypeFactory.getCarTypeObject();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.car_view, this);
        imageViewFront = view.findViewById(R.id.imageView_front);
        imageViewCenter = view.findViewById(R.id.imageView_center);
        imageViewBack = view.findViewById(R.id.imageView_back);
        imageViewDoorFL = view.findViewById(R.id.imageView_doorFL);
        imageViewDoorBL = view.findViewById(R.id.imageView_doorBL);
        imageViewDoorFR = view.findViewById(R.id.imageView_doorFR);
        imageViewDoorBR = view.findViewById(R.id.imageView_doorBR);
        setupCarBody();

        textViewTyrePressureFL = view.findViewById(R.id.textView_tyrePressureFL);
        textViewTyrePressureBL = view.findViewById(R.id.textView_tyrePressureBL);
        textViewTyrePressureFR = view.findViewById(R.id.textView_tyrePressureFR);
        textViewTyrePressureBR = view.findViewById(R.id.textView_tyrePressureBR);
        textViewLockStatus = view.findViewById(R.id.textView_lockStatus);
        textViewLastUpdated = view.findViewById(R.id.textView_lastUpdated);

        imageViewTyrePressureFL = view.findViewById(R.id.imageView_tyrePressureFL);
        imageViewTyrePressureBL = view.findViewById(R.id.imageView_tyrePressureBL);
        imageViewTyrePressureFR = view.findViewById(R.id.imageView_tyrePressureFR);
        imageViewTyrePressureBR = view.findViewById(R.id.imageView_tyrePressureBR);
    }

    public void setCarType(int carTypeFlag) {
        restView();
        CarTypeFactory carTypeFactory = new CarTypeFactory(this.getContext(), carTypeFlag);
        carType = carTypeFactory.getCarTypeObject();
        setupCarBody();
    }

    public void restView() {
        closeAllDoors();
        setTyrePressureFL(DEFAULT_TYRE_PRESSURE);
        setTyrePressureFR(DEFAULT_TYRE_PRESSURE);
        setTyrePressureBL(DEFAULT_TYRE_PRESSURE);
        setTyrePressureBR(DEFAULT_TYRE_PRESSURE);
    }

    private void setupCarBody() {
        imageViewFront.setImageResource(carType.getFrontCloseImageId());
        imageViewCenter.setImageResource(carType.getCenterImageId());
        imageViewBack.setImageResource(carType.getBackCloseImageId());
        imageViewDoorFL.setImageResource(carType.getDoorFLImageId());
        imageViewDoorFR.setImageResource(carType.getDoorFRImageId());
        imageViewDoorBL.setImageResource(carType.getDoorBLImageId());
        imageViewDoorBR.setImageResource(carType.getDoorBRImageId());

        imageViewDoorFL.setTag(false);
        imageViewDoorBL.setTag(false);
        imageViewDoorFR.setTag(false);
        imageViewDoorBR.setTag(false);
    }

    public void setTyrePressureFL(String pressure) {
        try {
            Float tyrePressure = Float.parseFloat(pressure);
            textViewTyrePressureFL.setText(pressure);
            if (tyrePressure <= minTypePressure) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViewTyrePressureFL.setImageDrawable(getResources().getDrawable(R
                            .drawable.fl_active, this.getContext().getTheme()));
                } else {
                    imageViewTyrePressureFL.setImageDrawable(getResources().getDrawable(R
                            .drawable.fl_active));
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViewTyrePressureFL.setImageDrawable(getResources().getDrawable(R
                            .drawable.fl_normal, this.getContext().getTheme()));
                } else {
                    imageViewTyrePressureFL.setImageDrawable(getResources().getDrawable(R
                            .drawable.fl_normal));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTyrePressureFL() {
        return textViewTyrePressureFL.getText().toString();
    }

    public void setTyrePressureBL(String pressure) {
        try {
            Float tyrePressure = Float.parseFloat(pressure);
            textViewTyrePressureBL.setText(pressure);
            if (tyrePressure <= minTypePressure) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViewTyrePressureBL.setImageDrawable(getResources().getDrawable(R
                            .drawable.bl_active, this.getContext().getTheme()));
                } else {
                    imageViewTyrePressureBL.setImageDrawable(getResources().getDrawable(R
                            .drawable.bl_active));
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViewTyrePressureBL.setImageDrawable(getResources().getDrawable(R
                            .drawable.bl_normal, this.getContext().getTheme()));
                } else {
                    imageViewTyrePressureBL.setImageDrawable(getResources().getDrawable(R
                            .drawable.bl_normal));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTyrePressureBL() {
        return textViewTyrePressureBL.getText().toString();
    }

    public void setTyrePressureFR(String pressure) {
        try {
            Float tyrePressure = Float.parseFloat(pressure);
            textViewTyrePressureFR.setText(pressure);
            if (tyrePressure <= minTypePressure) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViewTyrePressureFR.setImageDrawable(getResources().getDrawable(R
                            .drawable.fr_active, this.getContext().getTheme()));
                } else {
                    imageViewTyrePressureFR.setImageDrawable(getResources().getDrawable(R
                            .drawable.fr_active));
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViewTyrePressureFR.setImageDrawable(getResources().getDrawable(R
                            .drawable.fr_normal, this.getContext().getTheme()));
                } else {
                    imageViewTyrePressureFR.setImageDrawable(getResources().getDrawable(R
                            .drawable.fr_normal));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTyrePressureFR() {
        return textViewTyrePressureFR.getText().toString();
    }

    public void setTyrePressureBR(String pressure) {
        try {
            Float tyrePressure = Float.parseFloat(pressure);
            textViewTyrePressureBR.setText(pressure);
            if (tyrePressure <= minTypePressure) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViewTyrePressureBR.setImageDrawable(getResources().getDrawable(R
                            .drawable.br_active, this.getContext().getTheme()));
                } else {
                    imageViewTyrePressureBR.setImageDrawable(getResources().getDrawable(R
                            .drawable.br_active));
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViewTyrePressureBR.setImageDrawable(getResources().getDrawable(R
                            .drawable.br_normal, this.getContext().getTheme()));
                } else {
                    imageViewTyrePressureBR.setImageDrawable(getResources().getDrawable(R
                            .drawable.br_normal));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTyrePressureBR() {
        return textViewTyrePressureBR.getText().toString();
    }

    public void setLastUpdateMessage(String message) {
        textViewLastUpdated.setText(message);
    }

    public void setLastUpdateMessage(int messageId) {
        textViewLastUpdated.setText(messageId);
    }

    public void openFLDoor() {
        imageViewDoorFL.setTag(true);
        imageViewDoorFL.startAnimation(carType.getDoorOpenFLAnimation());
        setLockStatus();
    }

    public void openBLDoor() {
        imageViewDoorBL.setTag(true);
        imageViewDoorBL.startAnimation(carType.getDoorOpenBLAnimation());
        setLockStatus();
    }

    public void openFRDoor() {
        imageViewDoorFR.setTag(true);
        imageViewDoorFR.startAnimation(carType.getDoorOpenFRAnimation());
        setLockStatus();
    }

    public void openBRDoor() {
        imageViewDoorBR.setTag(true);
        imageViewDoorBR.startAnimation(carType.getDoorOpenBRAnimation());
        setLockStatus();
    }

    public void closeFLDoor() {
        imageViewDoorFL.setTag(false);
        imageViewDoorFL.startAnimation(carType.getDoorCloseFLAnimation());
        setLockStatus();
    }

    public void closeBLDoor() {
        imageViewDoorBL.setTag(false);
        imageViewDoorBL.startAnimation(carType.getDoorCloseBLAnimation());
        setLockStatus();
    }

    public void closeFRDoor() {
        imageViewDoorFR.setTag(false);
        imageViewDoorFR.startAnimation(carType.getDoorCloseFRAnimation());
        setLockStatus();
    }

    public void closeBRDoor() {
        imageViewDoorBR.setTag(false);
        imageViewDoorBR.startAnimation(carType.getDoorCloseBRAnimation());
        setLockStatus();
    }

    public boolean getFLDoorStatus() {
        if (imageViewDoorFL.getTag() == null) {
            imageViewDoorFL.setTag(false);
            closeFLDoor();
        }
        return (Boolean) imageViewDoorFL.getTag();
    }

    public boolean getBLDoorStatus() {
        if (imageViewDoorBL.getTag() == null) {
            imageViewDoorBL.setTag(false);
            closeBLDoor();
        }
        return (Boolean) imageViewDoorBL.getTag();
    }

    public boolean getFRDoorStatus() {
        if (imageViewDoorFR.getTag() == null) {
            imageViewDoorFR.setTag(false);
            closeFRDoor();
        }
        return (Boolean) imageViewDoorFR.getTag();
    }

    public boolean getBRDoorStatus() {
        if (imageViewDoorBR.getTag() == null) {
            imageViewDoorBR.setTag(false);
            closeBRDoor();
        }
        return (Boolean) imageViewDoorBR.getTag();
    }

    public void openAllDoors() {
        if (!getFLDoorStatus()) openFLDoor();
        if (!getFRDoorStatus()) openFRDoor();
        if (!getBLDoorStatus()) openBLDoor();
        if (!getBRDoorStatus()) openBRDoor();
    }

    public void closeAllDoors() {
        if (getFLDoorStatus()) closeFLDoor();
        if (getFRDoorStatus()) closeFRDoor();
        if (getBLDoorStatus()) closeBLDoor();
        if (getBRDoorStatus()) closeBRDoor();
    }

    private void setLockStatus() {
        if (getFLDoorStatus() || getFRDoorStatus() || getBLDoorStatus() || getBRDoorStatus()) {
            textViewLockStatus.setText("UNLOCKED");
        } else {
            textViewLockStatus.setText("LOCKED");
        }
    }

    public void setTyresVisibility(int visibility) {
        view.findViewById(R.id.linearLayout_fl).setVisibility(visibility);
        view.findViewById(R.id.linearLayout_fr).setVisibility(visibility);
        view.findViewById(R.id.linearLayout_bl).setVisibility(visibility);
        view.findViewById(R.id.linearLayout_br).setVisibility(visibility);
    }

    public int getTyresVisibility() {
        return view.findViewById(R.id.linearLayout_fl).getVisibility();
    }

    public void turnOnHeadLight() {

    }

    public void turnOffHeadLight() {

    }

    public boolean isHeadLightOn() {
        boolean flag = false;

        return flag;
    }

    public void setTyrePressureLimit(float pressureMin, float pressureMax) throws
            IncorrectPressureLimitException {
        if (pressureMax <= 0)
            throw new IncorrectPressureLimitException("Maximum pressure can't be 0");
        else if (pressureMin <= 0)
            throw new IncorrectPressureLimitException("Minimum pressure can't be 0");
        else if (pressureMin > pressureMax)
            throw new IncorrectPressureLimitException("Minimum pressure can't be greater than " +
                    "Maximum pressure");
        minTypePressure = pressureMin;
        maxTypePressure = pressureMax;
        checkTyrePressureWithNewLimits();
    }

    private void checkTyrePressureWithNewLimits() {
        setTyrePressureFL(textViewTyrePressureFL.getText().toString());
        setTyrePressureFR(textViewTyrePressureFR.getText().toString());
        setTyrePressureBL(textViewTyrePressureBL.getText().toString());
        setTyrePressureBR(textViewTyrePressureBR.getText().toString());
    }

    class IncorrectPressureLimitException extends Exception {
        public IncorrectPressureLimitException(String message) {
            super(message);
        }
    }
}