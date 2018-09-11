package view.vichle.example.tusharlal.vichleviewexample.widget.cartypestate.state;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import view.vichle.example.tusharlal.vichleviewexample.R;
import view.vichle.example.tusharlal.vichleviewexample.widget.cartypestate.ICarType;
import view.vichle.example.tusharlal.vichleviewexample.widget.model.CarType;

/**
 * Created by : Tushar Lal
 * Date       : 11-09-2018
 */
public class CarTypeSedan implements ICarType {
    private static final int DOOR_ANIMATION_DURATION = 1500;
    private static final int ZERO_DEGREE = 0;
    private static final int LEFT_SIDE_OPEN_DEGREE = 45;
    private static final int RIGHT_SIDE_OPEN_DEGREE = -45;
    private static final float PIVOT_X_VALUE = 0.5F;
    private static final float PIVOT_Y_VALUE = 0;

    private Context context;

    public CarTypeSedan(Context context) {
        this.context = context;
    }

    @Override
    public CarType getCarTypeObject() {

        CarType carType = new CarType();
        carType.setCenterImageId(R.drawable.honda_base_center);

        carType.setDoorBLImageId(R.drawable.honda_base_bl);
        carType.setDoorBRImageId(R.drawable.honda_base_br);
        carType.setDoorFLImageId(R.drawable.honda_base_fl);
        carType.setDoorFRImageId(R.drawable.honda_base_fr);

        carType.setDoorOpenBLAnimation(getLeftSideDoorOpenAnimation());
        carType.setDoorOpenBRAnimation(getRightSideDooOpenAnimation());
        carType.setDoorOpenFLAnimation(getLeftSideDoorOpenAnimation());
        carType.setDoorOpenFRAnimation(getRightSideDooOpenAnimation());

        carType.setDoorCloseBLAnimation(getLeftSideDoorCloseAnimation());
        carType.setDoorCloseBRAnimation(getRightSideDoorCloseAnimation());
        carType.setDoorCloseFLAnimation(getLeftSideDoorCloseAnimation());
        carType.setDoorCloseFRAnimation(getRightSideDoorCloseAnimation());

        carType.setFrontOpenImageId(R.drawable.honda_base_front);
        carType.setFrontCloseImageId(R.drawable.honda_base_front);

        carType.setBackOpenImageId(R.drawable.honda_base_back);
        carType.setBackCloseImageId(R.drawable.honda_base_back);

        return carType;
    }

    private Animation getLeftSideDoorOpenAnimation() {
        RotateAnimation rotate = new RotateAnimation(ZERO_DEGREE, LEFT_SIDE_OPEN_DEGREE, Animation.RELATIVE_TO_SELF, PIVOT_X_VALUE, Animation.RELATIVE_TO_SELF, PIVOT_Y_VALUE);
        rotate.setDuration(DOOR_ANIMATION_DURATION);
        rotate.setFillAfter(true);
        rotate.setInterpolator(context, android.R.anim.decelerate_interpolator);
        return rotate;
    }

    private Animation getLeftSideDoorCloseAnimation() {
        RotateAnimation rotate = new RotateAnimation(LEFT_SIDE_OPEN_DEGREE, ZERO_DEGREE, Animation.RELATIVE_TO_SELF, PIVOT_X_VALUE, Animation.RELATIVE_TO_SELF, PIVOT_Y_VALUE);
        rotate.setDuration(DOOR_ANIMATION_DURATION);
        rotate.setFillAfter(true);
        rotate.setInterpolator(context, android.R.anim.decelerate_interpolator);
        return rotate;
    }

    private Animation getRightSideDooOpenAnimation() {
        RotateAnimation rotate = new RotateAnimation(0, RIGHT_SIDE_OPEN_DEGREE, Animation.RELATIVE_TO_SELF, PIVOT_X_VALUE, Animation.RELATIVE_TO_SELF, PIVOT_Y_VALUE);
        rotate.setDuration(DOOR_ANIMATION_DURATION);
        rotate.setFillAfter(true);
        rotate.setInterpolator(context, android.R.anim.decelerate_interpolator);
        return rotate;
    }

    private Animation getRightSideDoorCloseAnimation() {
        RotateAnimation rotate = new RotateAnimation(RIGHT_SIDE_OPEN_DEGREE, ZERO_DEGREE, Animation.RELATIVE_TO_SELF, PIVOT_X_VALUE, Animation.RELATIVE_TO_SELF, PIVOT_Y_VALUE);
        rotate.setDuration(DOOR_ANIMATION_DURATION);
        rotate.setFillAfter(true);
        rotate.setInterpolator(context, android.R.anim.decelerate_interpolator);
        return rotate;
    }
}
