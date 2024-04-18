package org.dive.factorybeantest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Data
public class MyService {
    private OffsetDateTime time;
}
