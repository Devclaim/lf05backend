package main;

import io.swagger.v3.core.util.PrimitiveType;
import io.swagger.v3.jaxrs2.Reader;
import io.swagger.v3.oas.integration.GenericOpenApiScanner;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.integration.api.OpenAPIConfiguration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import main.handlers.KundeHandler;
import org.openapitools.codegen.serializer.SerializerUtils;

import java.util.Set;

public class OpenApiGen {

    public static void main(String[] args) {

        System.out.println(OpenApiGen.apiDocGen());
    }


    private OpenApiGen() {
    }

    public static String apiDocGen() {
        GenericOpenApiScanner scanner = new GenericOpenApiScanner();
        OpenAPIConfiguration openApiConfiguration = createOpenAPIConfigurationForInboundRestServices();
        scanner.setConfiguration(openApiConfiguration);
        Reader reader = new Reader(openApiConfiguration.getOpenAPI());
        var openAPI = reader.read(scanner.classes());
        return SerializerUtils.toYamlString(openAPI);
    }

    public static OpenAPIConfiguration createOpenAPIConfigurationForInboundRestServices() {
        SwaggerConfiguration swaggerConfiguration = createSwaggerConfiguration();
        swaggerConfiguration.setResourceClasses(Set.of(
                KundeHandler.class.getName()
        ));
        return swaggerConfiguration;
    }

    private static SwaggerConfiguration createSwaggerConfiguration() {
        PrimitiveType.enablePartialTime();

        OpenAPI openAPI = createOpenAPI();

        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
        swaggerConfiguration.setOpenAPI(openAPI);
        swaggerConfiguration.setPrettyPrint(true);
        swaggerConfiguration.setIgnoredRoutes(Set.of("/application.wadl"));

        return swaggerConfiguration;
    }

    private static OpenAPI createOpenAPI() {
        OpenAPI openAPI = new OpenAPI();

        Info info = new Info();
        info.setTitle("Gemüse API");
        info.setVersion("0.5");
        info.setDescription("Gemüse API");
        info.setContact(new Contact());
        info.getContact().setName("Kilian Scheel, Gruppe 1");
        info.getContact().setEmail("kilian.scheel@scoop-software.de");
        openAPI.setInfo(info);

        Components components = new Components();
        openAPI.setComponents(components);
        return openAPI;
    }
}
