package view.vichle.example.tusharlal.vichleviewexample.widget.cartypestate;

import android.content.Context;

import view.vichle.example.tusharlal.vichleviewexample.widget.CarStatusView;
import view.vichle.example.tusharlal.vichleviewexample.widget.cartypestate.state.CarTypeSUV;
import view.vichle.example.tusharlal.vichleviewexample.widget.cartypestate.state.CarTypeSedan;
import view.vichle.example.tusharlal.vichleviewexample.widget.cartypestate.state.CarTypeVan;
import view.vichle.example.tusharlal.vichleviewexample.widget.model.CarType;

/**
 * Created by : Tushar Lal
 * Date       : 11-09-2018
 */
public class CarTypeFactory implements ICarType {

    private Context context;
    private CarType carType;

    public CarTypeFactory(Context context, int carTypeFlag) {
        this.context = context;
        setCarType(carTypeFlag);
    }

    @Override
    public CarType getCarTypeObject() {
        return carType;
    }

    private void setCarType(int carTypeFlag) {
        switch (carTypeFlag) {
            case CarStatusView.TYPE_SUV:
                carType = new CarTypeSUV(context).getCarTypeObject();
                break;

            case CarStatusView.TYPE_SEDAN:
                carType = new CarTypeSedan(context).getCarTypeObject();
                break;

            case CarStatusView.TYPE_VAN:
                carType = new CarTypeVan(context).getCarTypeObject();
                break;

            default:
                carType = new CarTypeSUV(context).getCarTypeObject();
                break;
        }
    }
}
