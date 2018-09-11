package view.vichle.example.tusharlal.vichleviewexample.widget.model;

import android.view.animation.Animation;

/**
 * Created by : Tushar Lal
 * Date       : 11-09-2018
 */
public class CarType {

    //  Center image id
    private int center;

    //  All components for car door
    private int doorFL;
    private int doorFR;
    private int doorBL;
    private int doorBR;

    private Animation doorOpenFL;
    private Animation doorOpenFR;
    private Animation doorOpenBL;
    private Animation doorOpenBR;

    private Animation doorCloseFL;
    private Animation doorCloseFR;
    private Animation doorCloseBL;
    private Animation doorCloseBR;

    //  Bonnet and Trunk components for car
    private int frontOpen;
    private int frontClose;
    private int backOpen;
    private int backClose;

    //  All Light components of car
    private int headLightLeftOff;
    private int headLightLeftOnLowBeam;
    private int headLightLeftOnHighBeam;

    private int headLightRightOff;
    private int headLightRightOnLowBeam;
    private int headLightRightOnHighBeam;

    private int tailLightLeftOff;
    private int tailLightLeftOn;

    private int tailLightRightOff;
    private int tailLightRightOn;

    public int getCenterImageId() {
        return center;
    }

    public void setCenterImageId(int center) {
        this.center = center;
    }

    public int getDoorFLImageId() {
        return doorFL;
    }

    public void setDoorFLImageId(int doorFL) {
        this.doorFL = doorFL;
    }

    public int getDoorFRImageId() {
        return doorFR;
    }

    public void setDoorFRImageId(int doorFR) {
        this.doorFR = doorFR;
    }

    public int getDoorBLImageId() {
        return doorBL;
    }

    public void setDoorBLImageId(int doorBL) {
        this.doorBL = doorBL;
    }

    public int getDoorBRImageId() {
        return doorBR;
    }

    public void setDoorBRImageId(int doorBR) {
        this.doorBR = doorBR;
    }

    public Animation getDoorOpenFLAnimation() {
        return doorOpenFL;
    }

    public void setDoorOpenFLAnimation(Animation doorOpenFL) {
        this.doorOpenFL = doorOpenFL;
    }

    public Animation getDoorOpenFRAnimation() {
        return doorOpenFR;
    }

    public void setDoorOpenFRAnimation(Animation doorOpenFR) {
        this.doorOpenFR = doorOpenFR;
    }

    public Animation getDoorOpenBLAnimation() {
        return doorOpenBL;
    }

    public void setDoorOpenBLAnimation(Animation doorOpenBL) {
        this.doorOpenBL = doorOpenBL;
    }

    public Animation getDoorOpenBRAnimation() {
        return doorOpenBR;
    }

    public void setDoorOpenBRAnimation(Animation doorOpenBR) {
        this.doorOpenBR = doorOpenBR;
    }

    public Animation getDoorCloseFLAnimation() {
        return doorCloseFL;
    }

    public void setDoorCloseFLAnimation(Animation doorCloseFL) {
        this.doorCloseFL = doorCloseFL;
    }

    public Animation getDoorCloseFRAnimation() {
        return doorCloseFR;
    }

    public void setDoorCloseFRAnimation(Animation doorCloseFR) {
        this.doorCloseFR = doorCloseFR;
    }

    public Animation getDoorCloseBLAnimation() {
        return doorCloseBL;
    }

    public void setDoorCloseBLAnimation(Animation doorCloseBL) {
        this.doorCloseBL = doorCloseBL;
    }

    public Animation getDoorCloseBRAnimation() {
        return doorCloseBR;
    }

    public void setDoorCloseBRAnimation(Animation doorCloseBR) {
        this.doorCloseBR = doorCloseBR;
    }

    public int getFrontOpenImageId() {
        return frontOpen;
    }

    public void setFrontOpenImageId(int frontOpen) {
        this.frontOpen = frontOpen;
    }

    public int getFrontCloseImageId() {
        return frontClose;
    }

    public void setFrontCloseImageId(int frontClose) {
        this.frontClose = frontClose;
    }

    public int getBackOpenImageId() {
        return backOpen;
    }

    public void setBackOpenImageId(int backOpen) {
        this.backOpen = backOpen;
    }

    public int getBackCloseImageId() {
        return backClose;
    }

    public void setBackCloseImageId(int backClose) {
        this.backClose = backClose;
    }

    public int getHeadLightLeftOffImageId() {
        return headLightLeftOff;
    }

    public void setHeadLightLeftOffImageId(int headLightLeftOff) {
        this.headLightLeftOff = headLightLeftOff;
    }

    public int getHeadLightLeftOnLowBeamImageId() {
        return headLightLeftOnLowBeam;
    }

    public void setHeadLightLeftOnLowBeamImageId(int headLightLeftOnLowBeam) {
        this.headLightLeftOnLowBeam = headLightLeftOnLowBeam;
    }

    public int getHeadLightLeftOnHighBeamImageId() {
        return headLightLeftOnHighBeam;
    }

    public void setHeadLightLeftOnHighBeamImageId(int headLightLeftOnHighBeam) {
        this.headLightLeftOnHighBeam = headLightLeftOnHighBeam;
    }

    public int getHeadLightRightOffImageId() {
        return headLightRightOff;
    }

    public void setHeadLightRightOffImageId(int headLightRightOff) {
        this.headLightRightOff = headLightRightOff;
    }

    public int getHeadLightRightOnLowBeamImageId() {
        return headLightRightOnLowBeam;
    }

    public void setHeadLightRightOnLowBeamImageId(int headLightRightOnLowBeam) {
        this.headLightRightOnLowBeam = headLightRightOnLowBeam;
    }

    public int getHeadLightRightOnHighBeamImageId() {
        return headLightRightOnHighBeam;
    }

    public void setHeadLightRightOnHighBeamImageId(int headLightRightOnHighBeam) {
        this.headLightRightOnHighBeam = headLightRightOnHighBeam;
    }

    public int getTailLightLeftOffImageId() {
        return tailLightLeftOff;
    }

    public void setTailLightLeftOffImageId(int tailLightLeftOff) {
        this.tailLightLeftOff = tailLightLeftOff;
    }

    public int getTailLightLeftOnImageId() {
        return tailLightLeftOn;
    }

    public void setTailLightLeftOnImageId(int tailLightLeftOn) {
        this.tailLightLeftOn = tailLightLeftOn;
    }

    public int getTailLightRightOffImageId() {
        return tailLightRightOff;
    }

    public void setTailLightRightOffImageId(int tailLightRightOff) {
        this.tailLightRightOff = tailLightRightOff;
    }

    public int getTailLightRightOnImageId() {
        return tailLightRightOn;
    }

    public void setTailLightRightOnImageId(int tailLightRightOn) {
        this.tailLightRightOn = tailLightRightOn;
    }
}
