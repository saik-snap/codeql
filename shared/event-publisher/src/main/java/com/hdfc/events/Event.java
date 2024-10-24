package com.hdfc.events;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Event {

    private String id;
    private  String source;
    private OffsetDateTime time;
    private  String type;
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@modelClass")
    Object data;

    @Builder
    public Event(String source, String type, Object data) {
        this(UUID.randomUUID().toString(), source, OffsetDateTime.now(), type, data);
    }



}
