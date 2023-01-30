package database.data;

import com.opentable.db.postgres.embedded.PreparedDbProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class KuRDatabase {
    private KuRDatabase() {
    }

    public static DataSource create() throws SQLException {

        var provider = PreparedDbProvider.forPreparer(ds -> {
        }, List.of(b -> {
            b.setPort(5432);
        }));

        return provider.createDataSource();
    }
}
