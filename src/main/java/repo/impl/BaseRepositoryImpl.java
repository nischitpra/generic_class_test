package repo.impl;

import repo.BaseRepository;
import utils.Logger;

public class BaseRepositoryImpl<T> implements BaseRepository<T> {
    @Override
    public void baseFunction( T t ) {
        Logger.log( t.toString() );
    }
}
