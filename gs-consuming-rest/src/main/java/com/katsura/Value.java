package com.katsura;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Katsura on 2017/6/3.
 */
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    @Getter @Setter private Long id;
    @Getter @Setter private String quote;
}
