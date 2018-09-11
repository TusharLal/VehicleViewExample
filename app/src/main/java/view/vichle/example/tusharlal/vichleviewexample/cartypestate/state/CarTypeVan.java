package view.vichle.example.tusharlal.vichleviewexample.cartypestate.state;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

import view.vichle.example.tusharlal.vichleviewexample.R;
import view.vichle.example.tusharlal.vichleviewexample.cartypestate.ICarType;
import view.vichle.example.tusharlal.vichleviewexample.model.CarType;

/**
 * Created by : Tushar Lal
 * Date       : 11-09-2018
 */
public class CarTypeVan implements ICarType {
    private static final int DOOR_ROTATE_ANIMATION_DURATION = 2300;
    private static final int DOOR_POP_ANIMATION_DURATION = 500;
    private static final int DOOR_SLIDE_ANIMATION_DURATION = 1500;
    private static final int ZERO_DEGREE = 0;
    private static final int LEFT_SIDE_OPEN_DEGREE = 45;
    private static final int RIGHT_SIDE_OPEN_DEGREE = -45;
    private static final float PIVOT_X_VALUE = 0.5f;
    private static final float PIVOT_Y_VALUE = 0;
    private static final float START_POINT = 0.0f;
    private static final float LEFT_DOOR_POP_VALUE = -30.0f;
    private static final float RIGHT_DOOR_POP_VALUE = 30.0f;
    private static final float SLIDE_VALUE = 100.0f;

    private Context context;
    private View view;

    public CarTypeVan(Context context) {
        this.context = context;
        view = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
    }

    @Override
    public CarType getCarTypeObject() {
        CarType carType = new CarType();

        carType.setCenterImageId(R.drawable.honda_base_center);

        carType.setDoorBLImageId(R.drawable.honda_base_bl);
        carType.setDoorBRImageId(R.drawable.honda_base_br);
        carType.setDoorFLImageId(R.drawable.honda_base_fl);
        carType.setDoorFRImageId(R.drawable.honda_base_fr);

        carType.setDoorOpenBLAnimation(getBackLeftDoorOpenAnimation());
        carType.setDoorOpenBRAnimation(getBackRightDoorOpenAnimation());
        carType.setDoorOpenFLAnimation(getFrontLeftDoorOpenAnimation());
        carType.setDoorOpenFRAnimation(getFrontRightDooOpenAnimation());

        carType.setDoorCloseBLAnimation(getBackLeftDoorCloseAnimation());
        carType.setDoorCloseBRAnimation(getBackRightDoorCloseAnimation());
        carType.setDoorCloseFLAnimation(getFrontLeftDoorCloseAnimation());
        carType.setDoorCloseFRAnimation(getFrontRightDoorCloseAnimation());

        carType.setFrontOpenImageId(R.drawable.honda_base_front);
        carType.setFrontCloseImageId(R.drawable.honda_base_front);

        carType.setBackOpenImageId(R.drawable.honda_base_back);
        carType.setBackCloseImageId(R.drawable.honda_base_back);
        return carType;
    }

    private Animation getFrontLeftDoorOpenAnimation() {
        RotateAnimation rotate = new RotateAnimation(ZERO_DEGREE, LEFT_SIDE_OPEN_DEGREE, Animation.RELATIVE_TO_SELF, PIVOT_X_VALUE, Animation.RELATIVE_TO_SELF, PIVOT_Y_VALUE);
        rotate.setDuration(DOOR_ROTATE_ANIMATION_DURATION);
        rotate.setFillAfter(true);
        rotate.setInterpolator(context, android.R.anim.decelerate_interpolator);
        return rotate;
    }

    private Animation getFrontLeftDoorCloseAnimation() {
        RotateAnimation rotate = new RotateAnimation(LEFT_SIDE_OPEN_DEGREE, ZERO_DEGREE, Animation.RELATIVE_TO_SELF, PIVOT_X_VALUE, Animation.RELATIVE_TO_SELF, PIVOT_Y_VALUE);
        rotate.setDuration(DOOR_ROTATE_ANIMATION_DURATION);
        rotate.setFillAfter(true);
        rotate.setInterpolator(context, android.R.anim.decelerate_interpolator);
        return rotate;
    }

    private Animation getFrontRightDooOpenAnimation() {
        RotateAnimation rotate = new RotateAnimation(ZERO_DEGREE, RIGHT_SIDE_OPEN_DEGREE, Animation.RELATIVE_TO_SELF, PIVOT_X_VALUE, Animation.RELATIVE_TO_SELF, PIVOT_Y_VALUE);
        rotate.setDuration(DOOR_ROTATE_ANIMATION_DURATION);
        rotate.setFillAfter(true);
        rotate.setInterpolator(context, android.R.anim.decelerate_interpolator);
        return rotate;
    }

    private Animation getFrontRightDoorCloseAnimation() {
        RotateAnimation rotate = new RotateAnimation(RIGHT_SIDE_OPEN_DEGREE, ZERO_DEGREE, Animation.RELATIVE_TO_SELF, PIVOT_X_VALUE, Animation.RELATIVE_TO_SELF, PIVOT_Y_VALUE);
        rotate.setDuration(DOOR_ROTATE_ANIMATION_DURATION);
        rotate.setFillAfter(true);
        rotate.setInterpolator(context, android.R.anim.decelerate_interpolator);
        return rotate;
    }

    private Animation getBackLeftDoorOpenAnimation() {
        TranslateAnimation firstAnimation = new TranslateAnimation(Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, LEFT_DOOR_POP_VALUE, Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, START_POINT);
        firstAnimation.setFillAfter(true);
        firstAnimation.setInterpolator(context, android.R.anim.decelerate_interpolator);
        firstAnimation.setDuration(DOOR_POP_ANIMATION_DURATION);
        firstAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //Noting to implement.
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TranslateAnimation secondAnimation = new TranslateAnimation(Animation.ABSOLUTE, LEFT_DOOR_POP_VALUE, Animation.ABSOLUTE, LEFT_DOOR_POP_VALUE, Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, SLIDE_VALUE);
                secondAnimation.setFillAfter(true);
                secondAnimation.setInterpolator(context, android.R.anim.decelerate_interpolator);
                secondAnimation.setDuration(DOOR_SLIDE_ANIMATION_DURATION);
                view.findViewById(R.id.imageView_doorBL).startAnimation(secondAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //Noting to implement.
            }
        });
        return firstAnimation;
    }

    private Animation getBackRightDoorOpenAnimation() {
        TranslateAnimation firstAnimation = new TranslateAnimation(Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, RIGHT_DOOR_POP_VALUE, Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, START_POINT);
        firstAnimation.setFillAfter(true);
        firstAnimation.setInterpolator(context, android.R.anim.decelerate_interpolator);
        firstAnimation.setDuration(DOOR_POP_ANIMATION_DURATION);
        firstAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //Noting to implement.
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TranslateAnimation secondAnimation = new TranslateAnimation(Animation.ABSOLUTE, RIGHT_DOOR_POP_VALUE, Animation.ABSOLUTE, RIGHT_DOOR_POP_VALUE, Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, SLIDE_VALUE);
                secondAnimation.setFillAfter(true);
                secondAnimation.setInterpolator(context, android.R.anim.decelerate_interpolator);
                secondAnimation.setDuration(DOOR_SLIDE_ANIMATION_DURATION);
                view.findViewById(R.id.imageView_doorBR).startAnimation(secondAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //Noting to implement.
            }
        });
        return firstAnimation;
    }

    private Animation getBackLeftDoorCloseAnimation() {
        TranslateAnimation firstAnimation = new TranslateAnimation(Animation.ABSOLUTE, LEFT_DOOR_POP_VALUE, Animation.ABSOLUTE, LEFT_DOOR_POP_VALUE, Animation.ABSOLUTE, SLIDE_VALUE, Animation.ABSOLUTE, START_POINT);
        firstAnimation.setFillAfter(true);
        firstAnimation.setInterpolator(context, android.R.anim.decelerate_interpolator);
        firstAnimation.setDuration(DOOR_SLIDE_ANIMATION_DURATION);
        firstAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //Noting to implement.
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TranslateAnimation secondAnimation = new TranslateAnimation(Animation.ABSOLUTE, LEFT_DOOR_POP_VALUE, Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, START_POINT);
                secondAnimation.setFillAfter(true);
                secondAnimation.setInterpolator(context, android.R.anim.decelerate_interpolator);
                secondAnimation.setDuration(DOOR_POP_ANIMATION_DURATION);
                view.findViewById(R.id.imageView_doorBL).startAnimation(secondAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //Noting to implement.
            }
        });
        return firstAnimation;
    }

    private Animation getBackRightDoorCloseAnimation() {
        TranslateAnimation firstAnimation = new TranslateAnimation(Animation.ABSOLUTE, RIGHT_DOOR_POP_VALUE, Animation.ABSOLUTE, RIGHT_DOOR_POP_VALUE, Animation.ABSOLUTE, SLIDE_VALUE, Animation.ABSOLUTE, START_POINT);
        firstAnimation.setFillAfter(true);
        firstAnimation.setInterpolator(context, android.R.anim.decelerate_interpolator);
        firstAnimation.setDuration(DOOR_SLIDE_ANIMATION_DURATION);
        firstAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //Noting to implement.
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TranslateAnimation secondAnimation = new TranslateAnimation(Animation.ABSOLUTE, RIGHT_DOOR_POP_VALUE, Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, START_POINT, Animation.ABSOLUTE, START_POINT);
                secondAnimation.setFillAfter(true);
                secondAnimation.setInterpolator(context, android.R.anim.decelerate_interpolator);
                secondAnimation.setDuration(DOOR_POP_ANIMATION_DURATION);
                view.findViewById(R.id.imageView_doorBR).startAnimation(secondAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //Noting to implement.
            }
        });
        return firstAnimation;
    }
}
