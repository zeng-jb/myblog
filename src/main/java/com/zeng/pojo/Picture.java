package com.zeng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture {

    private Long id;
    private String pictureaddress;
    private String picturedescription;
    private String picturename;
    private String picturetime;
}
