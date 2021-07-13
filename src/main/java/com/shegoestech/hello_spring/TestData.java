package com.shegoestech.hello_spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestData {
    private String key;
    private String value;

    //noArgs
    //setter
    //getter
    //requiredArgs
    //EqualAndHashCode
}
