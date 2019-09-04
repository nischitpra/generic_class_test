package repo;

import annotation.Repository;
import pojo.User;

@Repository
public interface TestRepository extends BaseRepository<User> {
}
