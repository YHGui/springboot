package com.katsura;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Katsura on 2017/6/3.
 */
@NoArgsConstructor
@ToString
public class Quote {
    @Getter @Setter private String type;
    @Getter @Setter private Value value;
}
