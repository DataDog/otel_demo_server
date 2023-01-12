package otel_demo_server;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;

public final class OtelConfig {

    /**
     * Initializes an OpenTelemetry SDK with a logging exporter and a SimpleSpanProcessor.
     *
     * @return A {@link OpenTelemetry} instance.
     */
    public static OpenTelemetry initOpenTelemetry() {
        return GlobalOpenTelemetry.get();
//        // Tracer provider configured to export spans with SimpleSpanProcessor using
//        // the logging exporter.
//        SdkTracerProvider tracerProvider =
//                SdkTracerProvider.builder()
//                        .addSpanProcessor(SimpleSpanProcessor.create(LoggingSpanExporter.create()))
//                        .build();
//
//        return OpenTelemetrySdk.builder()
//                .setTracerProvider(tracerProvider)
//                .buildAndRegisterGlobal();
    }
}
