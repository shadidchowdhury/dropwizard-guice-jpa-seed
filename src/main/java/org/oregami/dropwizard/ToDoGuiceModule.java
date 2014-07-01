package org.oregami.dropwizard;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.bus.config.BusConfiguration;
import net.engio.mbassy.listener.Handler;
import org.oregami.messages.ToDoMessage;

public class ToDoGuiceModule extends AbstractModule {

    private final MBassador<ToDoMessage> bus = new MBassador<ToDoMessage>(BusConfiguration.Default());

    @Override
    protected void configure() {
        bindListener(Matchers.any(), new TypeListener() {
            public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
                typeEncounter.bindInterceptor(Matchers.annotatedWith(Handler.class));
                typeEncounter.register(new InjectionListener<I>() {
                    public void afterInjection(I i) {
                        bus.subscribe(i);
                    }
                });
            }
        });
    }


    @Provides
    @Singleton
    public MBassador<ToDoMessage> providesEventBus() {

        return bus;
    }

}
