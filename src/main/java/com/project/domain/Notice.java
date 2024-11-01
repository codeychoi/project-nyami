package com.project.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("Notice")
public class Notice {
    private int id;
    private String category;
    private String title;
    private String content;
    private Date date;
    private String status;
    private String noticeImage;
    private int kinds;
}