package ru.gb.gbjmsmart.model;


import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldMessage implements Serializable {

    static final long serialVersionUID = 2774026152353505028L;

    private String message;


}
