package one.android.com.one.http.rxschedulers;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class RxSchedulersHelper  {
    private  static  final Observable.Transformer ioTransformer= new Observable.Transformer() {
        @Override
        public Object call(Object o) {
            return ((Observable)o).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    };
    public  static <T> Observable.Transformer<T,T>applyIoTransformer(){
        return ioTransformer;
    }
  /*  private  static  final rx.Observable.Transformer ioTransformer = new rx.Observable.Transformer(){

        @Override
        public Object call(Object o) {
            return (Observable)o
        }
    };

  *//*  private  static  final Observable.Transformer ioTransformer= new Observable.Transformer () {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }

    };*//*
    public  static <T> ObservableTransformer<T,T> applyIoTransformer(){
        return ioTransformer;
    }*/
 }
