package com.katsura.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Katsura on 2017/2/17.
 */
@Component
@Data
public class BlogProperties {

    @Value("${com.katsura.blog.name}")
    private String name;
    @Value("${com.katsura.blog.title}")
    private String title;
}
