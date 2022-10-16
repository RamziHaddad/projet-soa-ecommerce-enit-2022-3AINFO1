package enit.group.SerDes;

import enit.group.events.Event;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
public class EventDeserializer extends ObjectMapperDeserializer<Event>{

    public EventDeserializer() {
        super(Event.class);
    }
    
}