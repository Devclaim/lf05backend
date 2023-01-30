package main;

import database.data.KuRDatabase;
import database.data.PGWriter;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;

public class RunJooqGen {
    public static void main(String[] args) throws Exception {
        var dataSource = KuRDatabase.create();
        var connection = dataSource.getConnection();

        PGWriter.initalizeTables(connection);
        PGWriter.writeResource(connection);

        Configuration configuration = new Configuration()
                .withGenerator(new Generator()
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.postgres.PostgresDatabase")
                                .withIncludes(".*")
                                .withExcludes("")
                                .withInputSchema("public"))
                        .withTarget(new Target()
                                .withPackageName("jooq_gen")
                                .withDirectory("/src/main/java"))
                        .withGenerate(new Generate().withFluentSetters(true)));

        GenerationTool generationTool = new GenerationTool();

        generationTool.setConnection(connection);

        generationTool.run(configuration);
    }
}
