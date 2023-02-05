package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer {

    // Bu class'in amaci; TUM FAIL TEST CASE leri bir kez daha otomatik olarak XML FILE ILE RUN ETMEK
    // Bu sinif ListenersRetry sinifini xml de kullanabilmek icin olusturuldu
    // Cunku ListenersRetry sinifi interface oldugu icin xml de direkt kullanilamiyor

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        // Bu class ListenersRetry util class'ina baglidir
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}
