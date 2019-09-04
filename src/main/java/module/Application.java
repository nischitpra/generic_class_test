package module;

import annotation.Autowired;
import engine.RepositoryEngine;
import repo.TestRepository;
import utils.Logger;

public class Application {
    @Autowired
    TestRepository testRepository;
    RepositoryEngine repositoryEngine;

    public Application() {
        init();
    }

    public void init() {
        repositoryEngine = new RepositoryEngine( this );
        repositoryEngine.init();
        Logger.log( "application started" );
    }

    public void dispose() {
        Logger.log( "application disposed" );
    }
}
