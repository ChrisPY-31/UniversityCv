package com.chris.userporfiles.Exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Mensaje {

    private String mensaje;
    private Object object;

}
