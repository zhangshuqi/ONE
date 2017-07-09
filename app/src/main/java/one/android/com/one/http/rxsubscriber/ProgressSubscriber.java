package one.android.com.one.http.rxsubscriber;


import one.android.com.one.http.rxexception.DefaultErrorBundle;
import one.android.com.one.http.rxexception.ErrorManager;
import rx.Subscriber;


/**
 * Created by Administrator on 2016/11/24 0024.
 */
public abstract class ProgressSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {
     /*   if (System.currentTimeMillis()-dialogStartTime<1000){
            try {
                Thread.sleep(1000-(System.currentTimeMillis()-dialogStartTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {

            }

        }*/
        _onCompleted();
    }

    @Override
    public void onStart() {
        super.onStart();
        _onStart();
    }

    @Override
    public void onError(Throwable e) {
        _onError(ErrorManager.handleError(new DefaultErrorBundle((Exception) e)));

    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    public void _onStart() {

    }

    public abstract void _onError(String message);

    public abstract void _onNext(T t);

    public abstract void _onCompleted();
}
