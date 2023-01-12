package otel_demo_server;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationListener;

@Log
@SpringBootApplication
@ConfigurationPropertiesScan
public class OtelDemoServer implements ApplicationListener<ApplicationReadyEvent> {
    private static final String INSTRUMENTATION_NAME = OtelDemoServer.class.getName();
    private Tracer tracer;
    static OpenTelemetry oTel;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        System.out.println("App ready.");
        start();
        System.out.println("Done.");
        return;
    }

    public void generateSpan() {
        Span span = this.tracer.spanBuilder("start Span").startSpan();
        span.addEvent("Event 0");
        addSpan();
        span.addEvent("Event 1");
        span.end();
    }

    private void addSpan() {
        Span span = this.tracer.spanBuilder("addSpan").startSpan();
        try {
            Thread.sleep(2000);
            // counter.add(1);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        } finally {
            span.end();
        }
    }

    public static void main(String[] args) {
        // initialize SDK as early as possible
        oTel = OtelConfig.initOpenTelemetry();
        SpringApplication.run(OtelDemoServer.class, args);
    }

    void start() {
        tracer = oTel.getTracer(INSTRUMENTATION_NAME);
        for (int i = 0; i < 5; i++) {
            this.generateSpan();
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}



