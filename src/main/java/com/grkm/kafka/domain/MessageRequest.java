package com.grkm.kafka.domain;

import java.io.Serializable;

/**
 * @author Gorkem TANAGARDIGIL
 * @version 1.0.0
 * @since 10.02.2022 09:37
 */
public class MessageRequest implements Serializable {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
