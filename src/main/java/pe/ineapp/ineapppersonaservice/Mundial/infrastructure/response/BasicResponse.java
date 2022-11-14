package pe.ineapp.ineapppersonaservice.Mundial.infrastructure.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicResponse {
    private int code;
    private String mensaje;

    public static BasicResponse whenSuccess() {
        return BasicResponse.builder()
                .code(200)
                .mensaje("Success")
                .build();
    }

    public static BasicResponse whenPassNotMatch() {
        return BasicResponse.builder()
                .code(500)
                .mensaje("Incorrect password")
                .build();
    }

    public static BasicResponse whenError(String message) {
        return BasicResponse.builder()
                .code(500)
                .mensaje(message)
                .build();
    }

    public static BasicResponse whenNoDataFound(String resource) {
        return BasicResponse.builder()
                .code(404)
                .mensaje("No " + resource + " found")
                .build();
    }
}
