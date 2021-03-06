package com.wang.feature.search;

import org.springframework.data.jpa.domain.Specifications;

/**
 * Created by wangyongwei on 2017/8/21.
 */
public class SearchSpeDto {

    /** 类型，and或者or */
    private String type;

    private Specifications spes;

    public SearchSpeDto(String type, Specifications spes) {
        this.type = type;
        this.spes = spes;
    }

    public Specifications getSpes() {
        return spes;
    }

    public String getType() {
        return type;
    }

    public void setSpes(Specifications spes) {
        this.spes = spes;
    }

    public void setType(String type) {
        this.type = type;
    }
}
