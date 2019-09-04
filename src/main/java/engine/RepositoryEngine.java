package engine;

import annotation.Autowired;
import module.Application;
import utils.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class RepositoryEngine {
    Application context;

    public RepositoryEngine( Application context ) {
        this.context = context;
    }

    public void init() {
        autowireInit();
    }

    private void autowireInit() {
        Field[] fields = context.getClass().getDeclaredFields();
        for ( Field field : fields ) {
            Annotation[] a = field.getDeclaredAnnotations();
            for ( int i = 0; i < a.length; i++ ) {
                if ( a[i] instanceof Autowired ) {
                    // needs to be autowired by implementation
                    Class<?> tClass = field.getType();
                    repositoryInit( tClass );
                }
            }
        }
    }

    private void repositoryInit( Class<?> tClass ) {
        Type[] types = tClass.getGenericInterfaces();
        String name = ( ( ParameterizedType ) types[0] ).getActualTypeArguments()[0].getTypeName();
        Logger.log( "The generic class name for repository is %s", name );
    }
}
