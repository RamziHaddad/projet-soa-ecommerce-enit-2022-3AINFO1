package enit.group.SerDes;

import enit.group.events.Event;
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;
public class EventSerializer extends ObjectMapperSerializer<Event> {
       
}
